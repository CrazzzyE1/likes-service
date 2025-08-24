package ru.litvak.likesservice.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class LikeInfoResponse {
    private String giftId;
    private int likesCount;
    private boolean hasMyLike;
    private List<UUID> members;
}
