package com.tracker.croquy.v1.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

import static com.tracker.croquy.v1.utils.ErrorMessagesConstants.WRONG_ATTRIBUTE_TYPE;

@Getter
@RequiredArgsConstructor
public enum MediaType {
    TXT,
    PDF,
    WORD,
    EXCEL,
    ZIP,
    IMAGE,
    AUDIO,
    VIDEO;

    public static MediaType getEnumFromString(String str) {
        if(Objects.equals(str, TXT.toString())) return TXT;
        else if(Objects.equals(str, PDF.toString())) return PDF;
        else if(Objects.equals(str, WORD.toString())) return WORD;
        else if(Objects.equals(str, EXCEL.toString())) return EXCEL;
        else if(Objects.equals(str, ZIP.toString())) return ZIP;
        else if(Objects.equals(str, IMAGE.toString())) return IMAGE;
        else if(Objects.equals(str, AUDIO.toString())) return AUDIO;
        else if(Objects.equals(str, VIDEO.toString())) return VIDEO;

        throw new IllegalArgumentException(WRONG_ATTRIBUTE_TYPE);
    }
}
