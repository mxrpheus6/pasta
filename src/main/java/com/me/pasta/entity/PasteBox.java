package com.me.pasta.entity;

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

    private String data;
    private String hash;
    private LocalDateTime lifetime;
    boolean isPublic;
}
