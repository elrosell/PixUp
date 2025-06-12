package org.roddoc.sql.hibernateimpl;

import org.junit.jupiter.api.Test;
import org.roddoc.model.Artista;
import org.roddoc.model.Disco;
import org.roddoc.model.Disquera;
import org.roddoc.sql.GenericSql;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class DisqueraHiberImplTest {

    @Test
    void getInstance()
    {
        GenericSql<Disquera> disqueraHiber = DisqueraHiberImpl.getInstance();
        assertNotNull(disqueraHiber);
    }

    @Test
    void findAll()
    {
        GenericSql<Disquera> disqueraHiber = DisqueraHiberImpl.getInstance();
        List<Disquera> list = disqueraHiber.findAll();

        assertNotNull(list);
        list.forEach(System.out::println);
    }

    @Test
    void save()
    {
        GenericSql<Disquera> disqueraHiber = DisqueraHiberImpl.getInstance();

        Disquera disquera = new Disquera();
        disquera.setId(1);
        disquera.setDisquera("Disquera Prueba");

        assertNotNull( disquera );

        assertNotNull(disquera);
        disqueraHiber.save(disquera);

    }

    @Test
    void update()
    {
        GenericSql<Disquera> disqueraHiber = DisqueraHiberImpl.getInstance();

        Disquera disquera = new Disquera();
        disquera.setId(1);
        disquera.setDisquera("Disquera Prueba");

        assertNotNull( disquera );
        disqueraHiber.update( disquera );
    }

    @Test
    void delete()
    {
        GenericSql<Disquera> disqueraHiber = DisqueraHiberImpl.getInstance();

        Disquera disquera = disqueraHiber.findById(2);

        assertNotNull(disquera);
        disqueraHiber.delete(disquera);
    }

    @Test
    void findById()
    {
        GenericSql<Disquera> disqueraHiber = DisqueraHiberImpl.getInstance();
        Disquera disquera = disqueraHiber.findById(1);

        assertNotNull(disquera);
        System.out.println(disquera);
    }
}