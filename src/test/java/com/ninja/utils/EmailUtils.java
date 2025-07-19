package com.ninja.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmailUtils {

    // Generates a unique email each time
    public static String generateUniqueEmail() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return "revant" + LocalDateTime.now().format(dtf) + "@gmail.com";
    }
}
