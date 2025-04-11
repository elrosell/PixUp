package org.roddoc.vista.consola.usuario;

import org.roddoc.jdbc.GenericJdbc;
import org.roddoc.jdbc.impl.EstadoJdbcImpl;
import org.roddoc.jdbc.impl.MunicipioJdbcImpl;
import org.roddoc.model.Estado;
import org.roddoc.model.Municipio;
import org.roddoc.util.ReadUtil;
import org.roddoc.vista.consola.GestorCatalogos;

public class MunicipioCatalogo extends GestorCatalogos<Municipio>
{
    private static MunicipioCatalogo municipioCatalogo;
    private static final GenericJdbc<Municipio> municipioJdbc = MunicipioJdbcImpl.getInstance();

    public static MunicipioCatalogo getInstance( )
    {
        if(municipioCatalogo==null)
        {
            municipioCatalogo = new MunicipioCatalogo();
        }
        return municipioCatalogo;
    }

    private MunicipioCatalogo( )
    {
        super(MunicipioJdbcImpl.getInstance());
    }

    @Override
    public Municipio newT()
    {
        return new Municipio();
    }

    @Override
    public boolean processNewT(Municipio municipio)
    {
        System.out.print("> Teclee el nombre del municipio: ");
        municipio.setNombre( ReadUtil.read() );

        System.out.print("> Teclee el ID del estado al que pertenece: ");
        Estado estado = EstadoJdbcImpl.getInstance().findById(ReadUtil.readInt());

        if(estado==null)
        {
            return false;
        }
        municipio.setEstado(estado);

        municipioJdbc.save(municipio);
        return true;
    }

    @Override
    public void edit(Municipio municipio)
    {
        System.out.print("> Ingrese el ID del municipio a editar: ");
        municipio.setId( ReadUtil.readInt() );
        System.out.print("> Ingrese el nuevo nombre del municipio: ");
        municipio.setNombre( ReadUtil.read() );

        municipioJdbc.update(municipio);
    }

}