package com.me.pasta.repository;

import com.me.pasta.entity.PasteBox;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PasteBoxRepository extends CrudRepository<PasteBox, Long> {
    Optional<PasteBox> findPasteByHash(String hash);

    @Query(value = "SELECT * FROM paste ORDER BY id DESC LIMIT :size", nativeQuery = true)
    Optional<List<PasteBox>> findLastPasteList(@Param("size") Long size);

    Optional<List<PasteBox>> findByLifetimeBefore(LocalDateTime current);
}
