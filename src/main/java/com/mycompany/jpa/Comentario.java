/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author TORRE
 */
@Entity
@Table(name = "comentario")
public class Comentario implements Serializable {

    @Id
    @Column(name = "comentario_id", unique = true)
    private int id;

    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "fecha", nullable = false)
    private String fecha;

    @Column(name = "contenido", nullable = false)
    private String contenido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    @Override
    public String toString() {
        return id + "\t" + autor + "\t" + fecha +"\t" + contenido;
    }

}
