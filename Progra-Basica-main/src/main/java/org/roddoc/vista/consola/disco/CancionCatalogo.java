package org.roddoc.vista.consola.disco;

import org.roddoc.jdbc.GenericJdbc;
import org.roddoc.jdbc.impl.CancionJdbcImpl;
import org.roddoc.jdbc.impl.DiscoJdbcImpl;
import org.roddoc.model.*;
import org.roddoc.util.ReadUtil;
import org.roddoc.vista.consola.GestorCatalogos;
import java.io.File;

public class CancionCatalogo extends GestorCatalogos<Cancion>
{
    private static CancionCatalogo cancionCatalogo;
    private static final GenericJdbc<Cancion> cancionJdbc = CancionJdbcImpl.getInstance();

    private CancionCatalogo()
    {
        super(CancionJdbcImpl.getInstance());
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
    public boolean processNewT(Cancion cancion) {
        System.out.print("> Ingrese el título de la canción: ");
        cancion.setTituloCancion( ReadUtil.read() );
        System.out.print("> Ingrese la duración de la canción en minutos: ");
        cancion.setDuracion( ReadUtil.readDouble() );

        System.out.print("> Ingrese el ID del disco al que pertenece: ");
        Disco disco = DiscoJdbcImpl.getInstance().findById( ReadUtil.readInt() );
        if(disco==null) { return false; }
        else { cancion.setDisco( disco ); }

        cancionJdbc.save(cancion);
        return true;
    }

    @Override
    public void edit(Cancion cancion) {
        System.out.print("> Ingrese el ID de la canción a editar: ");
        cancion.setId( ReadUtil.readInt() );
        System.out.print("> Ingrese el nuevo título de la canción: ");
        cancion.setTituloCancion( ReadUtil.read() );

        cancionJdbc.update(cancion);
    }

}