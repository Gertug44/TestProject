package org.example.hibernateHelper;

import java.util.stream.Stream;

public interface EntityDbWorker<T> {
    Stream<T> getAll();
    Stream<T> getAll(String orderBy, String sortDirection);
    Stream<T> getAllWithCondition(String condition);
    Stream<T> getAllWithCondition(String condition, String orderBy, String sortDirection);
    T getFirst();
    T getFirst(String orderBy, String sortDirection);
    T getOne(String condition);
    T getOne(String condition, String orderBy, String sortDirection);
    int getNumberOfResults();
    int getNumberOfResultsWithCondition(String condition);
    boolean isDeleted(String condition) throws InterruptedException;
}
