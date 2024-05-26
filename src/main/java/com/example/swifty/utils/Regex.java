package com.example.swifty.utils;

import lombok.Getter;

/**
 * Class containing regular expressions for validating various input types.
 */
@Getter
public class Regex {
    /**
     * Regular expression for validating email addresses.
     * Allows for alphanumeric characters, periods, underscores, percent signs, plus signs, and hyphens before the @ symbol.
     * Allows for alphanumeric characters and hyphens after the @ symbol and before the domain extension.
     * Requires a two-letter or longer top-level domain (e.g., .com, .org, .edu).
     */
    public static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";

    /**
     * Regular expression for validating names containing only letters and with a maximum length of 45 characters.
     */
    public static final String LETTERS_REGEX = "^[A-Za-z]{1,45}$";

    /**
     * Regular expression for validating birthdates in the format YYYY-MM-DD.
     */
    public static final String BIRTHDATE_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";

    /**
     * Regular expression for validating strings with a maximum length of 45 characters.
     */
    public static final String MAX_100 = "^.{1,100}$";
}
