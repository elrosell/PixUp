package org.roddoc.sql.hibernateimpl;

import org.junit.jupiter.api.Test;
import org.roddoc.model.Estado;
import org.roddoc.model.Municipio;
import org.roddoc.sql.GenericSql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MunicipioHiberImplTest
{

    @Test
    void getInstance()
    {
        GenericSql<Municipio> municipioHiber = MunicipioHiberImpl.getInstance();
        assertNotNull( municipioHiber );
    }

    @Test
    void findAll()
    {
        GenericSql<Municipio> municipioHiber = MunicipioHiberImpl.getInstance();
        List<Municipio> list = municipioHiber.findAll();

        assertNotNull(list);
        list.forEach(System.out::println);
    }

    @Test
    void save()
    {
        GenericSql<Municipio> municipioHiber = MunicipioHiberImpl.getInstance();
        GenericSql<Estado> estadoHiber = EstadoHiberImpl.getInstance();

            Estado estado = estadoHiber.findById(1);

            Municipio municipio = new Municipio();
            municipio.setMunicipio( " Municipio de Prueba "+1);
            municipio.setEstado( estado );

            assertNotNull( municipioHiber );
            municipioHiber.save(municipio);

    }

    @Test
    void update()
    {
        GenericSql<Municipio> municipioHiber = MunicipioHiberImpl.getInstance();
        GenericSql<Estado> estadoHiber = EstadoHiberImpl.getInstance();

        Estado estado = estadoHiber.findById(1);

        Municipio municipio = new Municipio();
        municipio.setId(1);
        municipio.setMunicipio( "Municipio " + municipio.getId() + " nuevo");
        municipio.setEstado( estado );

        assertNotNull( municipio );
        municipioHiber.update( municipio );
    }

    @Test
    void delete()
    {
        GenericSql<Municipio> municipioHiber = MunicipioHiberImpl.getInstance();

        Municipio municipio = municipioHiber.findById(1);

        assertNotNull( municipio );
        municipioHiber.delete( municipio );
    }

    @Test
    void findById()
    {
        GenericSql<Municipio> municipioHiber = MunicipioHiberImpl.getInstance();
        Municipio municipio = municipioHiber.findById(2);

        assertNotNull( municipio );
        System.out.println(municipio);
    }
}