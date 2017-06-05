package ua.lviv.lgs.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.entity.Posts;
import ua.lviv.lgs.entity.PostsComments;
import ua.lviv.lgs.repositories.PostsCommentsRepo;
import ua.lviv.lgs.services.PostsCommentsService;

import java.util.Date;
import java.util.List;

/**
 * Created by Артем on 5/14/2017.
 */
@Service
public class PostsCommentsServiceImpl implements PostsCommentsService{

    @Autowired
    private PostsCommentsRepo postsCommentsRepo;

    @Override
    public void add(PostsComments postsComments, Posts posts) {
        postsComments.setDate(new Date());
        postsComments.setPosts(posts);
        postsCommentsRepo.save(postsComments);
    }

    @Override
    public PostsComments findOne(int id) {
        return postsCommentsRepo.findOne(id);
    }

    @Override
    public void edit(PostsComments postsComments) {
        postsComments.setDate(new Date());
        postsCommentsRepo.save(postsComments);
    }

    @Override
    public List<PostsComments> findAllForPost(Posts posts) {
        return postsCommentsRepo.findByPosts(posts);
    }

    @Override
    public void delete(int id) {
        postsCommentsRepo.delete(id);
    }
}
