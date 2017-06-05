package ua.lviv.lgs.utill;

/**
 * Created by Артем on 5/7/2017.
 */
public interface ValidationMessages {

    String AVATAR_DEFAULT_PATH = "/resources/images/defaultImg/1.png";

    String ACCOUNT_ALREADY_EXIST = "User with same email is already registered!";

    String INVALID_USER_NAME = "User name is invalid!";
    String INVALID_USER_SECOND_NAME = "User second name is invalid!";
    String INVALID_USER_EMAIL = "User email is invalid!";
    String INVALID_USER_PASSWORD = "User password is invalid!" +
            " Must have min one char and number!" +
            " Min size 6 symbol max 16 without space!";

    String INVALID_PHOTO = "You can add only images: .jpg, .jpeg, .gif, .bmp, .png";
    String INVALID_AUDIO = "You can add only .mp3 audio files";
}
