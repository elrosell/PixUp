package org.roddoc.sql.hibernateimpl;

import org.junit.jupiter.api.Test;
import org.roddoc.model.Cancion;
import org.roddoc.model.Disco;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class CancionHiberImplTest {

    @Test
    void getInstance()
    {
        assertNotNull( CancionHiberImpl.getInstance());
        //assertNull( CancionHiberImpl.getInstance());
    }

    @Test
    void findAll()
    {
        CancionHiberImpl cancionHiber = CancionHiberImpl.getInstance();
        List<Cancion> list = cancionHiber.findAll();
        assertNotNull( list );
        assertTrue(list.size()>=1);
        list.stream().forEach(System.out::println);
    }

    @Test
    void save()
    {
        CancionHiberImpl cancionHiber = CancionHiberImpl.getInstance();
        Cancion cancion = new Cancion();
        cancion.setTituloCancion("Astros");
        cancion.setId(2);
        cancion.setDisco(new Disco());
        cancion.setDuracion(LocalTime.parse("20:20"));
        assertTrue( cancionHiber.save(cancion));
    }

    @Test
    void update()
    {
        DiscoHiberImpl discoHiber = DiscoHiberImpl.getInstance();
        CancionHiberImpl cancionHiber = CancionHiberImpl.getInstance();
        Disco disco = new Disco();
        Cancion cancion = new Cancion();
        cancion.setTituloCancion("Amor de Cine");
        cancion.setId(2);
        cancion.setDuracion(LocalTime.parse("20:20"));
        disco.setId(1);
        assertTrue( cancionHiber.update(cancion));
    }

    @Test
    void delete()
    {
        CancionHiberImpl cancionHiber = CancionHiberImpl.getInstance();
        Cancion cancion = new Cancion();
        cancion.setId(2);
        assertTrue( cancionHiber.delete(cancion));
    }

    @Test
    void findById()
    {
        CancionHiberImpl cancionHiber = CancionHiberImpl.getInstance();
        Cancion cancion = null;
        cancion = cancionHiber.findById(2);
        assertNotNull(cancion);
        assertEquals( "Amor de Cine", cancion.getTituloCancion() );
        assertEquals( 2, cancion.getId());
    }
}