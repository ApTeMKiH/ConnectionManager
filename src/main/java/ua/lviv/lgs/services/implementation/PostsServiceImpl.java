package ua.lviv.lgs.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.entity.Posts;
import ua.lviv.lgs.entity.PostsComments;
import ua.lviv.lgs.entity.User;
import ua.lviv.lgs.repositories.PostsRepo;
import ua.lviv.lgs.services.PostsCommentsService;
import ua.lviv.lgs.services.PostsService;

import java.util.Date;
import java.util.List;

/**
 * Created by Артем on 5/14/2017.
 */
@Service
public class PostsServiceImpl implements PostsService{

    @Autowired
    private PostsRepo postsRepo;

    @Autowired
    private PostsCommentsService postsCommentsService;

    @Override
    public void add(Posts posts, User user) {
        posts.setDate(new Date());
        posts.setAuthor(user);
        posts.setUser(user);
        postsRepo.save(posts);

    }

    @Override
    public void add(Posts posts, User currentUser, User user) {
        posts.setDate(new Date());
        posts.setAuthor(currentUser);
        posts.setUser(user);
        postsRepo.save(posts);
    }

    @Override
    public void edit(Posts posts) {
        posts.setDate(new Date());
        postsRepo.save(posts);
    }

    @Override
    public List<Posts> findAllForUser(User user) {
        List<Posts> postsList = postsRepo.findByUser(user);
        for (Posts posts : postsList) {
            List<PostsComments> postsCommentsList = postsCommentsService.findAllForPost(posts);
            posts.setComents(postsCommentsList.size());
        }
        return postsList;
    }

    @Override
    public Posts findOne(int id) {
        return postsRepo.findOne(id);
    }

    @Override
    public void delete(int id) {
        postsRepo.delete(id);
    }
}
