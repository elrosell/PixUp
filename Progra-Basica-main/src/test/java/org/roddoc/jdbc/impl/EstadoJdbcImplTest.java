package org.roddoc.jdbc.impl;

import org.junit.jupiter.api.Test;
import org.roddoc.model.Estado;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class EstadoJdbcImplTest {

    @Test
    void getInstance()
    {
        assertNotNull( EstadoJdbcImpl.getInstance());
        //assertNull( EstadoJdbcImpl.getInstance());
    }

    @Test
    void findAll()
    {
        EstadoJdbcImpl estadoJdbc = EstadoJdbcImpl.getInstance();
        List<Estado> list = estadoJdbc.findAll();
        assertNotNull( list );
        assertTrue(list.size()>=1);
        list.stream().forEach(System.out::println);
    }

    @Test
    void save()
    {
        EstadoJdbcImpl estadoJdbc = EstadoJdbcImpl.getInstance();
        Estado estado = new Estado();
        estado.setNombre("EDOMEX");
        estado.setId(1);
        assertTrue( estadoJdbc.save(estado));
    }

    @Test
    void update()
    {
        EstadoJdbcImpl estadoJdbc = EstadoJdbcImpl.getInstance();
        Estado estado = new Estado();
        estado.setNombre("CIUDAD DE MEXICO");
        estado.setId(1);
        assertTrue( estadoJdbc.update(estado));
    }

    @Test
    void delete()
    {
        EstadoJdbcImpl estadoJdbc = EstadoJdbcImpl.getInstance();
        Estado estado = new Estado();
        estado.setId(1);
        assertTrue( estadoJdbc.delete(estado));
    }

    @Test
    void findById()
    {
        EstadoJdbcImpl estadoJdbc = EstadoJdbcImpl.getInstance();
        Estado estado = null;
        estado = estadoJdbc.findById(2);
        assertNotNull( estado );
        assertEquals( "EDOMEX", estado.getNombre() );
        assertEquals( 2, estado.getId());
    }
}