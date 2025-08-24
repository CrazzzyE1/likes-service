package ru.litvak.likesservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.litvak.likesservice.model.response.LikeInfoResponse;
import ru.litvak.likesservice.service.LikeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("likes")
public class LikeController {

    private final LikeService likeService;

    @GetMapping("gift/{giftId}")
    public LikeInfoResponse getLikeInfo(@RequestHeader(value = "Authorization") String authHeader,
                                        @PathVariable String giftId) {
        return likeService.getLikeInfo(authHeader, giftId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("gift/{giftId}")
    public void like(@RequestHeader(value = "Authorization") String authHeader,
                     @PathVariable String giftId) {
        likeService.like(authHeader, giftId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("gift/{giftId}")
    public void unlike(@RequestHeader(value = "Authorization") String authHeader,
                       @PathVariable String giftId) {
        likeService.unlike(authHeader, giftId);
    }
}
