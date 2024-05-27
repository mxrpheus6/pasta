package com.me.pasta.api.request;

import lombok.Data;

@Data
public class PasteBoxRequest {
    private String data;
    private Long expirationTimeMin;
    boolean isPublic;
}
