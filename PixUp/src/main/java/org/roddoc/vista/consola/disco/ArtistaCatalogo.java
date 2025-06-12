package org.roddoc.vista.consola.disco;

import org.roddoc.sql.GenericSql;
import org.roddoc.model.Artista;
import org.roddoc.sql.hibernateimpl.ArtistaHiberImpl;
import org.roddoc.util.ReadUtil;
import org.roddoc.vista.consola.GestorCatalogos;

public class ArtistaCatalogo extends GestorCatalogos<Artista>
{
    private static ArtistaCatalogo artistaCatalogo;
    private static final GenericSql<Artista> artistaSql = ArtistaHiberImpl.getInstance();

    private ArtistaCatalogo()
    {
        super(ArtistaHiberImpl.getInstance());
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
        System.out.print("Nombre del artista: ");
        artista.setArtista( ReadUtil.read() );
        artistaSql.save(artista);
        return true;
    }

    @Override
    public boolean processEditT(Artista artista)
    {
        System.out.print("Nuevo nombre del artista: ");
        artista.setArtista( ReadUtil.read() );

        artistaSql.update(artista);
        return true;
    }

}
