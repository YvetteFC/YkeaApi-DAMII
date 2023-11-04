package com.ykeas.ykeasmsprincipal.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_plato")
public class Plate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_plato", nullable = false)
    private String name;

    @Column(name = "precio_plato", nullable = false)
    private Double price;

    @Column(name = "stock_plato", nullable = false)
    private Integer stock;

    @Column(name = "descripcion_plato", nullable = false)
    private String description;

    @Column(name = "imagen_plato")
    private String imageUrl;

    @Column(name = "habilitado", nullable = false)
    private Boolean enabled = Boolean.TRUE;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Category category;
}
