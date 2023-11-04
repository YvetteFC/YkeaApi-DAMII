package com.ykeas.ykeasmsprincipal.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_completo", nullable = false)
    private String name;

    @Column(name = "telefono_usuario", length = 9, nullable = false)
    private String phone;

    @Column(name = "correo_usuario", nullable = false)
    private String email;

    @Column(name = "usuario", nullable = false)
    private String user;

    @Column(name = "clave", nullable = false)
    private String password;

}
