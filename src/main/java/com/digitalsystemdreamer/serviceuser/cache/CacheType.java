package com.digitalsystemdreamer.serviceuser.cache;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CacheType {

    FACILITIES("Facilties"),
    MEMBERSHIP("Membership"),
    GOALS("Goals"),
    QUESTIONNAIRE("Questionnaire");


    private final String value;

}
