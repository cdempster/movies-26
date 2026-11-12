package edu.kirkwood.dao;

import java.util.List;

public interface DahliaDAO<V> {

    /**
     * Retrieves all dahlia varieties from the data source that match the variety name
     * @param varietyName The name of the dahlia variety
     * @return A list of all dahlia varieties that match the variety name
     */
    List<V> search(String varietyName);
}
