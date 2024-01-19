package com.example.swifty.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegexUtils {
    public static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
    public static final String LETTERS_REGEX = "^[A-Za-z]{1,45}$";
    public static final String BIRTHDATE_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";
    public static final String MAX_45 = "^.{1,45}$";
}
