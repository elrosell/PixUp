package org.roddoc.jdbc.impl;

import org.roddoc.jdbc.Conexion;
import org.roddoc.jdbc.GenericJdbc;
import org.roddoc.model.Colonia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ColoniaJdbcImpl extends Conexion implements GenericJdbc<Colonia>
{
    @Override
    public List<Colonia> findAll()
    {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Colonia colonia = null;
        List<Colonia> list = null;
        String sql = "SELECT tbl_colonia.*," +
                "tbl_municipio.nombre as MUNICIPIO " +
                "FROM tbl_colonia " +
                "INNER JOIN " +
                "tbl_municipio ON tbl_colonia.tbl_municipio_id = tbl_municipio.id" +
                ";";

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
                colonia = new Colonia();
                colonia.setId( resultSet.getInt(1) );
                colonia.setNombre( resultSet.getString(2) );
                colonia.setCp( resultSet.getString(3) );
                list.add(colonia);
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
