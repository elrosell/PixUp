package org.roddoc.sql.hibernateimpl;

import org.junit.jupiter.api.Test;
import org.roddoc.model.Colonia;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ColoniaHiberImplTest {

    @Test
    void getInstance()
    {
        assertNotNull( ColoniaHiberImpl.getInstance());
        assertNull( ColoniaHiberImpl.getInstance());
    }

    @Test
    void findAll()
    {
        ColoniaHiberImpl coloniaHiber = ColoniaHiberImpl.getInstance();
        List<Colonia> list = coloniaHiber.findAll();
        assertNotNull( list );
        assertTrue(list.size()>=1);
        list.stream().forEach(System.out::println);
    }

    @Test
    void save()
    {
        ColoniaHiberImpl coloniaHiber = ColoniaHiberImpl.getInstance();
        Colonia colonia = new Colonia();
        colonia.setColonia("EDOMEX");
        colonia.setId(1);
        assertTrue( coloniaHiber.save(colonia));
    }

    @Test
    void update()
    {
        ColoniaHiberImpl coloniaHiber = ColoniaHiberImpl.getInstance();
        Colonia colonia = new Colonia();
        colonia.setColonia("CIUDAD DE MEXICO");
        colonia.setId(1);
        assertTrue( coloniaHiber.update(colonia));
    }

    @Test
    void delete()
    {
        ColoniaHiberImpl coloniaHiber = ColoniaHiberImpl.getInstance();
        Colonia colonia = new Colonia();
        colonia.setId(1);
        assertTrue( coloniaHiber.delete(colonia));
    }

    @Test
    void findById()
    {
        ColoniaHiberImpl coloniaHiber = ColoniaHiberImpl.getInstance();
        Colonia colonia = null;
        colonia = coloniaHiber.findById(2);
        assertNotNull(colonia);
        assertEquals( "EDOMEX", colonia.getColonia() );
        assertEquals( 2, colonia.getId());
    }
}