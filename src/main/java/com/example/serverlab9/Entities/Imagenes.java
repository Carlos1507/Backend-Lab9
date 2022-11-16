package com.example.serverlab9.Entities;

import javax.persistence.*;

@Entity
@Table(name = "imagenes")
public class Imagenes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idimagenes", nullable = false)
    private Integer id;

    @Column(name = "imagen", nullable = false)
    private byte[] imagen;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

}