package com.me.pasta.service;

import com.me.pasta.api.request.PasteBoxRequest;
import com.me.pasta.api.response.PasteBoxResponse;
import com.me.pasta.entity.PasteBox;
import com.me.pasta.repository.PasteBoxRepository;
import com.me.pasta.util.HashUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PasteBoxService {

    private final PasteBoxRepository pasteBoxRepository;

    public PasteBoxResponse createPaste(PasteBoxRequest request) {
        String hash;
        do {
            hash = HashUtil.generateHash(request);
        } while (pasteBoxRepository.findPasteByHash(hash).isPresent());

        PasteBox pasteBox = new PasteBox();
        pasteBox.setData(request.getData());
        pasteBox.setHash(hash);
        pasteBox.setPublic(request.isPublic());
        pasteBox.setCreationTime(LocalDateTime.now());
        pasteBox.setLifetime(LocalDateTime.now().plusMinutes(request.getExpirationTimeMin()));

        pasteBoxRepository.save(pasteBox);

        return pasteBox.toResponse();
    }

    public PasteBoxResponse getByHash(String hash) {
        return pasteBoxRepository.findPasteByHash(hash)
                .map(PasteBox::toResponse)
                .orElse(null);
    }

    public List<PasteBoxResponse> getPublicPasteList(Long size) {
        if (size < 1) {
            return Collections.emptyList();
        }
        return pasteBoxRepository.findLastPasteList(size)
                .orElse(Collections.emptyList())
                .stream()
                .map(PasteBox::toResponse)
                .toList();
    }

    @Scheduled(fixedRate = 1000)
    public void deleteExpiredPasteBoxes() {
        LocalDateTime current = LocalDateTime.now();

        List<PasteBox> expired = pasteBoxRepository.findByLifetimeBefore(current).orElse(Collections.emptyList());

        pasteBoxRepository.deleteAll(expired);
    }
}
