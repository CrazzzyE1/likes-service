package ru.litvak.likesservice.manager;

import ru.litvak.likesservice.model.response.LikeInfoResponse;

import java.util.UUID;

public interface LikeManager {
    LikeInfoResponse info(UUID me, String giftId);

    void like(UUID me, String giftId);

    void unlike(UUID me, String giftId);
}
