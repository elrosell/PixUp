package org.roddoc.sql.hibernateimpl;

import org.junit.jupiter.api.Test;
import org.roddoc.model.Disquera;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DisqueraHiberImplTest {

    @Test
    void getInstance()
    {
        assertNotNull( DisqueraHiberImpl.getInstance());
        //assertNull( DiscoHiberImpl.getInstance());
    }

    @Test
    void findAll()
    {
        DisqueraHiberImpl disqueraHiber = DisqueraHiberImpl.getInstance();
        List<Disquera> list = disqueraHiber.findAll();
        assertNotNull( list );
        assertTrue(list.size()>=1);
        list.stream().forEach(System.out::println);
    }

    @Test
    void save()
    {
        DisqueraHiberImpl disqueraHiber = DisqueraHiberImpl.getInstance();
        Disquera disquera = new Disquera();
        disquera.setDisquera("EDOMEX");
        disquera.setId(1);
        assertTrue( disqueraHiber.save(disquera));
    }

    @Test
    void update()
    {
        DisqueraHiberImpl disqueraHiber = DisqueraHiberImpl.getInstance();
        Disquera disquera = new Disquera();
        disquera.setDisquera("CIUDAD DE MEXICO");
        disquera.setId(1);
        assertTrue( disqueraHiber.update(disquera));
    }

    @Test
    void delete()
    {
        DisqueraHiberImpl disqueraHiber = DisqueraHiberImpl.getInstance();
        Disquera disquera = new Disquera();
        disquera.setId(1);
        assertTrue( disqueraHiber.delete(disquera));
    }

    @Test
    void findById()
    {
        DisqueraHiberImpl disqueraHiber = DisqueraHiberImpl.getInstance();
        Disquera disquera = null;
        disquera = disqueraHiber.findById(2);
        assertNotNull(disquera);
        assertEquals( "EDOMEX", disquera.getDisquera() );
        assertEquals( 2, disquera.getId());
    }
}