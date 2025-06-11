package org.roddoc.vista.consola.disco;

import org.roddoc.sql.GenericSql;
import org.roddoc.model.*;
import org.roddoc.sql.hibernateimpl.CancionHiberImpl;
import org.roddoc.sql.hibernateimpl.DiscoHiberImpl;
import org.roddoc.util.ReadUtil;
import org.roddoc.vista.consola.GestorCatalogos;

import java.time.LocalTime;
import java.util.List;

public class CancionCatalogo extends GestorCatalogos<Cancion>
{
    private static CancionCatalogo cancionCatalogo;
    private static final GenericSql<Cancion> cancionSql = CancionHiberImpl.getInstance();

    private CancionCatalogo()
    {
        super(CancionHiberImpl.getInstance());
    }

    public static CancionCatalogo getInstance()
    {
        if(cancionCatalogo==null)
        {
            cancionCatalogo = new CancionCatalogo();
        }
        return cancionCatalogo;
    }

    @Override
    public Cancion newT() {
        return new Cancion();
    }

    @Override
    public boolean processNewT(Cancion cancion)
    {
        System.out.print("Título de la canción: ");
        cancion.setTituloCancion( ReadUtil.read() );
        System.out.print("Duración de la canción (HH:MM:SS) :");
        String duracionStr = ReadUtil.read();

        try
        {
            String[] partes = duracionStr.split(":"); // Separa los minutos y los segundos
            int minutos = Integer.parseInt(partes[0]);
            int segundos = Integer.parseInt(partes[1]);

            LocalTime duracion = LocalTime.of(0, minutos, segundos); // HH:MM:SS
            cancion.setDuracion(duracion);
        }
        catch (Exception e)
        {
            System.out.println("❌ Duración inválida.");
        }

        DiscoHiberImpl discoHiber = DiscoHiberImpl.getInstance();
        List<Disco> discoList = discoHiber.findAll();
        discoList.forEach(System.out::println);

        System.out.print(" ID del disco al que pertenece: ");
        Disco disco = discoHiber.findById( ReadUtil.readInt() );
        if(disco==null)
        {
            System.out.println("❌ No encontrado.");
            return false;
        }
        else
        {
            cancion.setDisco( disco );
        }

        cancionSql.save(cancion);
        return true;
    }

    @Override
    public boolean processEditT(Cancion cancion)
    {
        System.out.print("Nuevo título de la canción: ");
        cancion.setTituloCancion( ReadUtil.read() );

        System.out.print("Nueva duración de la canción (HH:MM:SS) : ");
        cancion.setTituloCancion( ReadUtil.read() );

        cancionSql.update(cancion);
        return true;
    }
}

