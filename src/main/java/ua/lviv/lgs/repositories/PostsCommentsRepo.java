package ua.lviv.lgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.entity.Posts;
import ua.lviv.lgs.entity.PostsComments;

import java.util.List;

/**
 * Created by Артем on 5/7/2017.
 */
public interface PostsCommentsRepo extends JpaRepository<PostsComments, Integer> {

    List<PostsComments> findByPosts(Posts posts);
}
