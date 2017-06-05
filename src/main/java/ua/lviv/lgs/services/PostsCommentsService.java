package ua.lviv.lgs.services;

import ua.lviv.lgs.entity.Posts;
import ua.lviv.lgs.entity.PostsComments;

import java.util.List;

/**
 * Created by Артем on 5/14/2017.
 */
public interface PostsCommentsService {

    void add(PostsComments postsComments, Posts posts);

    void edit(PostsComments postsComments);

    PostsComments findOne(int id);

    List<PostsComments> findAllForPost(Posts posts);

    void delete(int id);
}
