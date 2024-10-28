package com.tracker.croquy.v1.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

import static com.tracker.croquy.v1.utils.ErrorMessagesConstants.WRONG_ATTRIBUTE_TYPE;

@Getter
@RequiredArgsConstructor
public enum AddressType {
    BILLING,
    SHIPPING,
    DEFAULT;

    public static AddressType getEnumFromString(String str) {
        if(Objects.equals(str, BILLING.toString())) return BILLING;
        else if(Objects.equals(str, SHIPPING.toString())) return SHIPPING;
        else if(Objects.equals(str, DEFAULT.toString())) return DEFAULT;

        throw new IllegalArgumentException(WRONG_ATTRIBUTE_TYPE);
    }
}