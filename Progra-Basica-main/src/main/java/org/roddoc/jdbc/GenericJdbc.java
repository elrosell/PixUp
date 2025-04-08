package org.roddoc.jdbc;

import java.util.List;

public interface GenericJdbc<T>
{
    List<T> findAll();
}
