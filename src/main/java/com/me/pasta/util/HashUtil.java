package com.me.pasta.util;

import com.me.pasta.api.request.PasteBoxRequest;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Base64;

public class HashUtil {

    public static String generateHash(PasteBoxRequest request) {
        String input = request.getData() + request.getStatus().toString() + LocalDateTime.now();
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            return Base64.getUrlEncoder().encodeToString(hash).substring(0, 8);
        //TODO: do something...
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating hash", e);
        }
    }

}
