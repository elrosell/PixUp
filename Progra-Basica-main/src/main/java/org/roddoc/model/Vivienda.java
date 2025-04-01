package org.roddoc.model;

import java.io.Serializable;

public abstract class Vivienda implements Serializable
{
    protected Integer id;
    protected String nombre;

    public Vivienda()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString()
    {
        return "Vivienda{" +
                "id=" + id +
                '}';
    }
}