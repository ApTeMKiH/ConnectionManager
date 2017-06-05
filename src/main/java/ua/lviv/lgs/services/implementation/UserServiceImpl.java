package ua.lviv.lgs.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.entity.User;
import ua.lviv.lgs.entity.UserConfig;
import ua.lviv.lgs.mail.MailConfig;
import ua.lviv.lgs.repositories.UserRepo;
import ua.lviv.lgs.services.UserConfigService;
import ua.lviv.lgs.services.UserService;
import ua.lviv.lgs.validation.implementation.UserValidation;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

/**
 * Created by Артем on 5/1/2017.
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserConfigService userConfigService;

    @Autowired
    private UserValidation userValidation;

    public void add(User user) {
        userValidation.validate(user);
        UserConfig userConfig = new UserConfig();
        try{
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
            props.put("mail.smtp.port", "587"); //TLS Port
            props.put("mail.smtp.auth", "true"); //enable authentication
            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

            //create Authenticator object to pass in Session.getInstance argument
            Authenticator auth = new Authenticator() {
                //override the getPasswordAuthentication method
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(MailConfig.USER_NAME, MailConfig.USER_PASSWORD);
                }
            };
            Session session = Session.getInstance(props, auth);

            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
            message.setFrom(MailConfig.USER_NAME);
            message.setSubject("Activate your account");
            message.setText("For activate your account follow the link below\n" +
                    "http://localhost:8080/activate/"+userConfig.getActivationCode());

            Transport.send(message);
            System.out.println("Done");
        }catch(Exception ex){
            System.out.println("Mail fail");
            System.out.println(ex);
        }
        userConfigService.add(userConfig);
        user.setUserConfig(userConfig);
        userRepo.save(user);
        userConfig.setUser(user);
        userConfigService.edit(userConfig);
    }

    @Override
    public void activate(int activationKey) {
        UserConfig userConfig = userConfigService.findByActivationCode(activationKey);
        User user = userRepo.findOne(userConfig.getUser().getId());
        userConfig.setActivated(true);
        userConfigService.edit(userConfig);
    }


    @Override
    public List<User> searchPeople(String name) {
        return userRepo.searchPeople(name);
    }

    public void edit(User user) {
        userRepo.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    public User findByEmail(String email){
        return userRepo.findByEmail(email);
    }

    public User findById(int id) {
        return userRepo.findOne(id);
    }

    public void delete(int id) {
        userRepo.delete(id);
    }

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(login);
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getUserConfig().isActivated(), true, true, user.getUserConfig().isBlock(), authorities);
    }

}
