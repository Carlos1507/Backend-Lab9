package com.example.serverlab9.Entities;

import javax.persistence.*;

@Entity
@Table(name = "juego_has_imagenes")
public class JuegoHasImagene {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private JuegoHasImageneId id;

    @MapsId("idjuego")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idjuego", nullable = false)
    private Juego idjuego;

    @MapsId("idimagenes")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idimagenes", nullable = false)
    private Imagenes idimagenes;

    @Column(name = "posicion", nullable = false, length = 45)
    private String posicion;

    public JuegoHasImageneId getId() {
        return id;
    }

    public void setId(JuegoHasImageneId id) {
        this.id = id;
    }

    public Juego getIdjuego() {
        return idjuego;
    }

    public void setIdjuego(Juego idjuego) {
        this.idjuego = idjuego;
    }

    public Imagenes getIdimagenes() {
        return idimagenes;
    }

    public void setIdimagenes(Imagenes idimagenes) {
        this.idimagenes = idimagenes;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

}