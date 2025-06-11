package org.roddoc.sql.hibernateimpl;

import org.junit.jupiter.api.Test;
import org.roddoc.model.Municipio;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MunicipioHiberImplTest {

    @Test
    void getInstance()
    {
        assertNotNull( MunicipioHiberImpl.getInstance());
        //assertNull( MunicipioHiberImpl.getInstance());
    }

    @Test
    void findAll()
    {
        MunicipioHiberImpl municipioHiber = MunicipioHiberImpl.getInstance();
        List<Municipio> list = municipioHiber.findAll();
        assertNotNull( list );
        assertTrue(list.size()>=1);
        list.stream().forEach(System.out::println);
    }

    @Test
    void save()
    {
        MunicipioHiberImpl municipioHiber = MunicipioHiberImpl.getInstance();
        Municipio municipio = new Municipio();
        municipio.setMunicipio("EDOMEX");
        municipio.setId(1);
        assertTrue( municipioHiber.save(municipio));
    }

    @Test
    void update()
    {
        MunicipioHiberImpl municipioHiber = MunicipioHiberImpl.getInstance();
        Municipio municipio = new Municipio();
        municipio.setMunicipio("CIUDAD DE MEXICO");
        municipio.setId(1);
        assertTrue( municipioHiber.update(municipio));
    }

    @Test
    void delete()
    {
        MunicipioHiberImpl municipioHiber = MunicipioHiberImpl.getInstance();
        Municipio municipio = new Municipio();
        municipio.setId(1);
        assertTrue( municipioHiber.delete(municipio));
    }

    @Test
    void findById()
    {
        MunicipioHiberImpl municipioHiber = MunicipioHiberImpl.getInstance();
        Municipio municipio= null;
        municipio = municipioHiber.findById(2);
        assertNotNull( municipio );
        assertEquals( "EDOMEX", municipio.getEstado() );
        assertEquals( 2, municipio.getId());
    }
}