package org.roddoc.vista.consola.disco;

import org.roddoc.jdbc.GenericJdbc;
import org.roddoc.jdbc.impl.DisqueraJdbcImpl;
import org.roddoc.model.*;
import org.roddoc.util.ReadUtil;
import org.roddoc.vista.consola.GestorCatalogos;


public class DisqueraCatalogo extends GestorCatalogos<Disquera>
{
    private static DisqueraCatalogo disqueraCatalogo;
    private static final GenericJdbc<Disquera> disqueraJdbc = DisqueraJdbcImpl.getInstance();

    private DisqueraCatalogo()
    {
        super(DisqueraJdbcImpl.getInstance());
    }

    public static DisqueraCatalogo getInstance()
    {
        if(disqueraCatalogo==null)
        {
            disqueraCatalogo = new DisqueraCatalogo();
        }
        return disqueraCatalogo;
    }

    @Override
    public Disquera newT() {
        return new Disquera();
    }

    @Override
    public boolean processNewT(Disquera disquera)
    {
        System.out.print("> Ingrese el nombre de la disquera: ");
        disquera.setDisquera( ReadUtil.read() );
        disqueraJdbc.save(disquera);
        return true;
    }

    @Override
    public void edit(Disquera disquera)
    {
        System.out.print("> Ingrese el ID de la disquera a editar: ");
        disquera.setId( ReadUtil.readInt() );
        System.out.print("> Ingrese el nuevo nombre de la disquera: ");
        disquera.setDisquera( ReadUtil.read() );

        disqueraJdbc.update(disquera);
    }

}