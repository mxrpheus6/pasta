package com.me.pasta.api.request;

import com.me.pasta.model.Status;
import lombok.Data;

@Data
public class PasteBoxRequest {
    private String data;
    private Status status;
    private Long expirationTimeSeconds;
}
