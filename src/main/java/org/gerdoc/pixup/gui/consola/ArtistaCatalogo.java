package org.gerdoc.pixup.gui.consola;

import org.gerdoc.pixup.model.Artista;
import org.gerdoc.pixup.util.ReadUtil;

import java.io.File;

public class ArtistaCatalogo extends Catalogos<Artista>{
    private static ArtistaCatalogo artistaCatalogo;

    private ArtistaCatalogo() {
    }

    public static ArtistaCatalogo getInstance(){
        if(artistaCatalogo == null){
            artistaCatalogo = new ArtistaCatalogo();
        }
        return artistaCatalogo;
    }
    @Override
    public Artista newT() {
        return new Artista();
    }

    @Override
    public boolean processNewT(Artista artista) {
        System.out.println("Escriba el nombre del Artista");
        artista.setArtista(ReadUtil.read());
        return true;
    }

    @Override
    public void processEditT(Artista artista) {
        System.out.println("Id del Artista " + artista.getId( ) );
        System.out.println("Artista a editar: " + artista.getArtista( ));
        System.out.println("Teclee el valor nuevo del Artyista" );
        artista.setArtista( ReadUtil.read( ) );
    }

    @Override
    public File getFile() {
        return new File("Artista.list");
    }
}
