package edu.kirkwood.dao.sql;

import edu.kirkwood.dao.DahliaDAO;
import edu.kirkwood.model.sql.DahliaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SQLDahliaDAO implements DahliaDAO<DahliaEntity> {

    private final DahliaRepository dahliaRepository;

    public SQLDahliaDAO(DahliaRepository dahliaRepository) {
        this.dahliaRepository = dahliaRepository;
    }

    /**
     * Retrieves all dahlia varieties from the data source that match the variety name
     * @param varietyName The name of the dahlia variety
     * @return A list of all dahlia varieties that match the variety name
     */
    @Override
    public List<DahliaEntity> search(String varietyName) {
        return dahliaRepository.findByVarietyNameContainingIgnoreCase(varietyName);
    }
}
