package ru.litvak.likesservice.service;

import ru.litvak.likesservice.model.response.LikeInfoResponse;

public interface LikeService {
    LikeInfoResponse getLikeInfo(String authHeader, String giftId);

    void like(String authHeader, String giftId);

    void unlike(String authHeader, String giftId);
}
