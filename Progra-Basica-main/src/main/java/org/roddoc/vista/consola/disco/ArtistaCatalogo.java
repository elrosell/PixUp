package org.roddoc.vista.consola.disco;

import org.roddoc.jdbc.GenericJdbc;
import org.roddoc.jdbc.impl.ArtistaJdbcImpl;
import org.roddoc.model.Artista;
import org.roddoc.util.ReadUtil;
import org.roddoc.vista.consola.GestorCatalogos;


public class ArtistaCatalogo extends GestorCatalogos<Artista>
{
    private static ArtistaCatalogo artistaCatalogo;
    private static final GenericJdbc<Artista> artistaJdbc = ArtistaJdbcImpl.getInstance();

    private ArtistaCatalogo()
    {
        super(ArtistaJdbcImpl.getInstance());
    }

    public static ArtistaCatalogo getInstance()
    {
        if(artistaCatalogo==null)
        {
            artistaCatalogo = new ArtistaCatalogo();
        }
        return artistaCatalogo;
    }

    @Override
    public Artista newT()
    {
        return new Artista();
    }

    @Override
    public boolean processNewT(Artista artista)
    {
        System.out.print("> Ingrese el nombre del artista: ");
        artista.setArtista( ReadUtil.read() );
        artistaJdbc.save(artista);
        return true;
    }

    @Override
    public void edit(Artista artista)
    {
        System.out.print("> Ingrese el ID del estado a editar: ");
        artista.setId( ReadUtil.readInt() );
        System.out.print("> Ingrese el nuevo nombre del estado: ");
        artista.setArtista( ReadUtil.read() );

        artistaJdbc.update(artista);
    }

}
