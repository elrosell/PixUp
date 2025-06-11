package org.roddoc.sql.hibernateimpl;

import org.junit.jupiter.api.Test;
import org.roddoc.model.Disco;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiscoHiberImplTest {

    @Test
    void getInstance()
    {
        assertNotNull( DiscoHiberImpl.getInstance());
        //assertNull( DiscoHiberImpl.getInstance());
    }

    @Test
    void findAll()
    {
        DiscoHiberImpl discoHiber = DiscoHiberImpl.getInstance();
        List<Disco> list = discoHiber.findAll();
        assertNotNull( list );
        assertTrue(list.size()>=1);
        list.stream().forEach(System.out::println);
    }

    @Test
    void save()
    {
        DiscoHiberImpl discoHiber = DiscoHiberImpl.getInstance();
        Disco disco = new Disco();
        disco.setTituloDisco("EDOMEX");
        disco.setId(1);
        assertTrue( discoHiber.save(disco));
    }

    @Test
    void update()
    {
        DiscoHiberImpl discoHiber = DiscoHiberImpl.getInstance();
        Disco disco = new Disco();
        disco.setTituloDisco("CIUDAD DE MEXICO");
        disco.setId(1);
        assertTrue( discoHiber.update(disco));
    }

    @Test
    void delete()
    {
        DiscoHiberImpl discoHiber = DiscoHiberImpl.getInstance();
        Disco disco = new Disco();
        disco.setId(1);
        assertTrue( discoHiber.delete(disco));
    }

    @Test
    void findById()
    {
        DiscoHiberImpl discoHiber = DiscoHiberImpl.getInstance();
        Disco disco = null;
        disco = discoHiber.findById(2);
        assertNotNull(disco);
        assertEquals( "EDOMEX", disco.getTituloDisco() );
        assertEquals( 2, disco.getId());
    }
}