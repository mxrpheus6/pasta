package com.me.pasta.api.response;

import com.me.pasta.model.Status;
import lombok.Data;

@Data
public class PasteBoxResponse {
    private String data;
    private Status status;
}
