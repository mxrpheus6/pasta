package com.me.pasta.entity;

import com.me.pasta.model.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "paste")
@Getter
@Setter
public class PasteBox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String data;

    private Status status;

    private Long expirationTimeSeconds;
}
