package com.example.serverlab9.Entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JuegoHasImageneId implements Serializable {
    private static final long serialVersionUID = 695521285541183530L;
    @Column(name = "idjuego", nullable = false)
    private Integer idjuego;

    @Column(name = "idimagenes", nullable = false)
    private Integer idimagenes;

    public Integer getIdjuego() {
        return idjuego;
    }

    public void setIdjuego(Integer idjuego) {
        this.idjuego = idjuego;
    }

    public Integer getIdimagenes() {
        return idimagenes;
    }

    public void setIdimagenes(Integer idimagenes) {
        this.idimagenes = idimagenes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        JuegoHasImageneId entity = (JuegoHasImageneId) o;
        return Objects.equals(this.idimagenes, entity.idimagenes) &&
                Objects.equals(this.idjuego, entity.idjuego);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idimagenes, idjuego);
    }

}