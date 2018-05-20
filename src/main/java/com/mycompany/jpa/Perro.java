package com.mycompany.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Nicolas Chicuazuque
 */
@Entity
@Table(name = "perro")
public class Perro implements Serializable {

    @Id
    @Column(name = "perro_id", unique = true)
    private int id;

    @Column(name = "raza", nullable = false)
    private String raza;

    @Column(name = "personalidad", nullable = false)
    private String personalidad;

    @Column(name = "energia", nullable = false)
    private String energia;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getPersonalidad() {
        return personalidad;
    }

    public void setPersonalidad(String personalidad) {
        this.personalidad = personalidad;
    }

    public String getEnergia() {
        return energia;
    }

    public void setEnergia(String energia) {
        this.energia = energia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return id + "\t" + raza + "\t" + personalidad +"\t" + energia + "\t" + descripcion;
    }

}
