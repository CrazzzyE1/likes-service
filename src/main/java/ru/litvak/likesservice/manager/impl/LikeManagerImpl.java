package ru.litvak.likesservice.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.litvak.likesservice.manager.LikeManager;
import ru.litvak.likesservice.model.entity.Like;
import ru.litvak.likesservice.model.response.LikeInfoResponse;
import ru.litvak.likesservice.repository.LikeRepository;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class LikeManagerImpl implements LikeManager {

    private final LikeRepository likeRepository;

    @Override
    public LikeInfoResponse info(UUID me, String giftId) {
        List<Like> likes = likeRepository.findAllByGiftId(giftId);
        List<UUID> members = likes.stream()
                .map(Like::getUserId)
                .toList();
        boolean hasMyLike = members.stream()
                .anyMatch(me::equals);

        return new LikeInfoResponse(
                giftId,
                likes.size(),
                hasMyLike,
                members);
    }

    @Override
    public void like(UUID me, String giftId) {
        Like toSave = new Like();
        toSave.setGiftId(giftId);
        toSave.setUserId(me);
        likeRepository.save(toSave);
    }

    @Override
    public void unlike(UUID me, String giftId) {
        likeRepository.deleteByUserIdAndGiftId(me, giftId);
    }
}
