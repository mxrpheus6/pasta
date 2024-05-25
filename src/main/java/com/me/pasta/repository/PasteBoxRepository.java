package com.me.pasta.repository;

import com.me.pasta.entity.PasteBox;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PasteBoxRepository extends CrudRepository<PasteBox, Long> {
    Optional<PasteBox> findByHash(String hash);
}
