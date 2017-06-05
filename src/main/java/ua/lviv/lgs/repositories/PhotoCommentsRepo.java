package ua.lviv.lgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.entity.PhotoComments;

/**
 * Created by Артем on 5/7/2017.
 */
public interface PhotoCommentsRepo extends JpaRepository<PhotoComments, Integer> {
}
