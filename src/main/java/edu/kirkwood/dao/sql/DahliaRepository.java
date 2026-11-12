package edu.kirkwood.dao.sql;

import edu.kirkwood.model.sql.DahliaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DahliaRepository extends JpaRepository<DahliaEntity, Integer> {

    /**
     * Finds dahlia varieties whose variety name contains the given text, ignoring case
     * @param varietyName The text to look for in the variety name
     * @return A list of matching dahlia varieties
     */
    List<DahliaEntity> findByVarietyNameContainingIgnoreCase(String varietyName);
}
