package org.roddoc.sql.hibernateimpl;

import org.junit.jupiter.api.Test;
import org.roddoc.model.Genero_Musical;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeneroMusicalHiberImplTest {

    @Test
    void getInstance()
    {
        assertNotNull( GeneroMusicalHiberImpl.getInstance());
        //assertNull( GeneroMusicalHiberImpl.getInstance());
    }

    @Test
    void findAll()
    {
        GeneroMusicalHiberImpl generoMusicalHiber = GeneroMusicalHiberImpl.getInstance();
        List<Genero_Musical> list = generoMusicalHiber.findAll();
        assertNotNull( list );
        assertTrue(list.size()>=1);
        list.stream().forEach(System.out::println);
    }

    @Test
    void save()
    {
        GeneroMusicalHiberImpl generoMusicalHiber = GeneroMusicalHiberImpl.getInstance();
        Genero_Musical generoMusical = new Genero_Musical();
        generoMusical.setGenero("EDOMEX");
        generoMusical.setId(1);
        assertTrue( generoMusicalHiber.save(generoMusical));
    }

    @Test
    void update()
    {
        GeneroMusicalHiberImpl generoMusicalHiber = GeneroMusicalHiberImpl.getInstance();
        Genero_Musical generoMusical = new Genero_Musical();
        generoMusical.setGenero("CIUDAD DE MEXICO");
        generoMusical.setId(1);
        assertTrue( generoMusicalHiber.update(generoMusical));
    }

    @Test
    void delete()
    {
        GeneroMusicalHiberImpl generoMusicalHiber = GeneroMusicalHiberImpl.getInstance();
        Genero_Musical generoMusical = new Genero_Musical();
        generoMusical.setId(1);
        assertTrue( generoMusicalHiber.delete(generoMusical));
    }

    @Test
    void findById()
    {
        GeneroMusicalHiberImpl generoMusicalHiber = GeneroMusicalHiberImpl.getInstance();
        Genero_Musical generoMusical = null;
        generoMusical = generoMusicalHiber.findById(2);
        assertNotNull(generoMusical);
        assertEquals( "EDOMEX", generoMusical.getGenero() );
        assertEquals( 2, generoMusical.getId());
    }
}