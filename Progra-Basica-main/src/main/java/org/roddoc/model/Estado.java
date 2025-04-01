package org.roddoc.model;
import java.io.Serializable;

public class Estado extends Vivienda implements Serializable
{
    public Estado() {
    }

    @Override
    public String toString()
    {
        return "Estado {"+
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                "}";
    }
}