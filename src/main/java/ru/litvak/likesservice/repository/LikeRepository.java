package ru.litvak.likesservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.litvak.likesservice.model.entity.Like;

import java.util.List;
import java.util.UUID;

@Repository
public interface LikeRepository extends JpaRepository<Like, UUID> {

    List<Like> findAllByGiftId(String giftId);

    void deleteByUserIdAndGiftId(UUID userId, String giftId);

}
