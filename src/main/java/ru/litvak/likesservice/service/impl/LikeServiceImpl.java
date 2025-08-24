package ru.litvak.likesservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.litvak.likesservice.manager.LikeManager;
import ru.litvak.likesservice.model.response.LikeInfoResponse;
import ru.litvak.likesservice.service.LikeService;
import ru.litvak.likesservice.util.JwtTokenMapper;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeManager likeManager;

    @Override
    public LikeInfoResponse getLikeInfo(String authHeader, String giftId) {
        UUID me = JwtTokenMapper.parseUserId(authHeader);
        return likeManager.info(me, giftId);
    }

    @Override
    public void like(String authHeader, String giftId) {
        UUID me = JwtTokenMapper.parseUserId(authHeader);
        likeManager.like(me, giftId);
    }

    @Override
    @Transactional
    public void unlike(String authHeader, String giftId) {
        UUID me = JwtTokenMapper.parseUserId(authHeader);
        likeManager.unlike(me, giftId);
    }
}
