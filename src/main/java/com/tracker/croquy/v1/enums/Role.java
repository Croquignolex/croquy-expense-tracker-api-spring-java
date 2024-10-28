package com.tracker.croquy.v1.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

import static com.tracker.croquy.v1.utils.ErrorMessagesConstants.WRONG_ATTRIBUTE_TYPE;

@Getter
@RequiredArgsConstructor
public enum Role {
    OWNER,
    WATCHER,
    USER;

    public static Role getEnumFromString(String str) {
        if(Objects.equals(str, OWNER.toString())) return OWNER;
        else if(Objects.equals(str, WATCHER.toString())) return WATCHER;
        else if(Objects.equals(str, USER.toString())) return USER;

        throw new IllegalArgumentException(WRONG_ATTRIBUTE_TYPE);
    }
}