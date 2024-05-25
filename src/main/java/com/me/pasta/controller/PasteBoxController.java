package com.me.pasta.controller;

import com.me.pasta.api.request.PasteBoxRequest;
import com.me.pasta.entity.PasteBox;
import com.me.pasta.util.HashUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("pastebox-api")
public class PasteBoxController {

    @GetMapping
    public List<String> getPublicPasteList() {
        return Collections.emptyList();
    }

    @GetMapping("/{hash}")
    public String getByHash(@PathVariable String hash) {
        return hash;
    }

    @PostMapping("/create")
    public String createPaste(@RequestBody PasteBoxRequest pasteBox) {
        return HashUtil.generateHash(pasteBox);
    }
}
