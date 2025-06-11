package org.roddoc.sql.hibernateimpl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CancionHiberImplTest {

    @Test
    void getInstance()
    {
        assertNotNull( EstadoHiberImpl.getInstance());
        //assertNull( EstadoJdbcImpl.getInstance());
    }

    @Test
    void findAll()
    {
        EstadoHiberImpl estadoHiber = EstadoHiberImpl.getInstance();
        List<Estado> list = estadoHiber.findAll();
        assertNotNull( list );
        assertTrue(list.size()>=1);
        list.stream().forEach(System.out::println);
    }

    @Test
    void save()
    {
        EstadoHiberImpl estadoHiber = EstadoHiberImpl.getInstance();
        Estado estado = new Estado();
        estado.setEstado("EDOMEX");
        estado.setId(1);
        assertTrue( estadoHiber.save(estado));
    }

    @Test
    void update()
    {
        EstadoHiberImpl estadoHiber = EstadoHiberImpl.getInstance();
        Estado estado = new Estado();
        estado.setEstado("CIUDAD DE MEXICO");
        estado.setId(1);
        assertTrue( estadoHiber.update(estado));
    }

    @Test
    void delete()
    {
        EstadoHiberImpl estadoHiber = EstadoHiberImpl.getInstance();
        Estado estado = new Estado();
        estado.setId(1);
        assertTrue( estadoHiber.delete(estado));
    }

    @Test
    void findById()
    {
        EstadoHiberImpl estadoHiber = EstadoHiberImpl.getInstance();
        Estado estado = null;
        estado = estadoHiber.findById(2);
        assertNotNull( estado );
        assertEquals( "EDOMEX", estado.getEstado() );
        assertEquals( 2, estado.getId());
    }
}