package com.ykeas.ykeasmsprincipal.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_pedido")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cliente")
    private String clientName;

    @Column(name = "precio")
    private Double platePrice;

    @Column(name = "cantidad")
    private Integer quantity;

    @Column(name = "importe")
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_plate")
    private Plate plate;

}
