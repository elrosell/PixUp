package org.roddoc.vista.consola.usuario;

import org.roddoc.sql.GenericSql;
import org.roddoc.sql.hibernateimpl.EstadoHiberImpl;
import org.roddoc.model.Estado;
import org.roddoc.util.ReadUtil;
import org.roddoc.vista.consola.GestorCatalogos;

public class EstadoCatalogo extends GestorCatalogos<Estado>
{
    private static EstadoCatalogo estadoCatalogo;
    private static final GenericSql<Estado> estadoSql = EstadoHiberImpl.getInstance();

    public static EstadoCatalogo getInstance( )
    {
        if(estadoCatalogo==null)
        {
            estadoCatalogo = new EstadoCatalogo();
        }
        return estadoCatalogo;
    }

    private EstadoCatalogo( )
    {
        super(EstadoHiberImpl.getInstance());
    }

    @Override
    public Estado newT()
    {
        return new Estado();
    }

    @Override
    public boolean processNewT(Estado estado)
    {
        System.out.print("Nombre del estado: ");
        estado.setEstado( ReadUtil.read() );
        estadoSql.save(estado);
        return true;
    }

    @Override
    public boolean processEditT(Estado estado)
    {
        System.out.print("Nuevo nombre del estado: ");
        estado.setEstado( ReadUtil.read() );

        estadoSql.update(estado);
        return true;
    }
}


