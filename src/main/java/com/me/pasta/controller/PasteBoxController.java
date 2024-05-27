package com.me.pasta.controller;

import com.me.pasta.api.request.PasteBoxRequest;
import com.me.pasta.api.response.PasteBoxResponse;
import com.me.pasta.service.PasteBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("pastebox-api")
public class PasteBoxController {

    private final PasteBoxService pasteBoxService;

    @PostMapping("/create")
    public PasteBoxResponse createPaste(@RequestBody PasteBoxRequest pasteBox) {
        return pasteBoxService.createPaste(pasteBox);
    }

    @GetMapping("/{hash}")
    public PasteBoxResponse getByHash(@PathVariable String hash) {
        return pasteBoxService.getByHash(hash);
    }

    @GetMapping("/public/{size}")
    public List<PasteBoxResponse> getPublicPasteList(@PathVariable Long size) {
        return pasteBoxService.getPublicPasteList(size);
    }
}
