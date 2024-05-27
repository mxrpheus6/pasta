package com.me.pasta.api.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data
public class PasteBoxResponse {
    private String url;
    private String data;
    private String lifetime;
    private boolean isPublic;

    public PasteBoxResponse(String url, String data, LocalDateTime lifetime, boolean isPublic) {
        this.url = url;
        this.data = data;
        this.isPublic = isPublic;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss | dd.MM.yyyy", Locale.ENGLISH);
        this.lifetime = lifetime.format(formatter);
    }
}
