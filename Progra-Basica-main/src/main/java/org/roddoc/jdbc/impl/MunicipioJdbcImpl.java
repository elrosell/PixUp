package org.roddoc.jdbc.impl;

import org.roddoc.jdbc.Conexion;
import org.roddoc.jdbc.GenericJdbc;
import org.roddoc.model.Estado;
import org.roddoc.model.Municipio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MunicipioJdbcImpl extends Conexion implements GenericJdbc<Municipio>
{
    @Override
    public List<Municipio> findAll()
    {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Municipio municipio = null;
        List<Municipio> list = null;
        String sql = "SELECT tbl_municipio.*," +
                "tbl_estado.nombre as ESTADO " +
                "FROM tbl_municipio " +
                "INNER JOIN " +
                "tbl_estado ON tbl_municipio.tbl_estado_id = tbl_estado.id;";

        try
        {
            connection = getConnection();
            if (connection==null)
            {
                return null;
            }
            statement = connection.createStatement( );
            resultSet = statement.executeQuery( sql );
            if (resultSet==null)
            {
                return null;
            }

            list = new ArrayList<>( );

            while( resultSet.next() )
            {
                municipio = new Municipio();
                municipio.setId( resultSet.getInt(1) );
                municipio.setNombre( resultSet.getString(2) );
                municipio.setEstado( new Estado( resultSet.getString(4 )) );

                list.add(municipio);
            }

            resultSet.close();
            statement.close();
            connection.close();

            return list;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
