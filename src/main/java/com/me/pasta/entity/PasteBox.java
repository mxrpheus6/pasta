package com.me.pasta.entity;

import com.me.pasta.api.response.PasteBoxResponse;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "paste")
@Getter
@Setter
public class PasteBox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hash;
    private String data;
    private LocalDateTime creationTime;
    private LocalDateTime lifetime;
    boolean isPublic;

    public PasteBoxResponse toResponse() {
        return new PasteBoxResponse(this.hash, this.getData(), this.creationTime, this.lifetime, this.isPublic());
    }
}
