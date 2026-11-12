package edu.kirkwood.model.sql;

import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.math.BigDecimal;

@Entity
@Table(name = "dahlia_varieties")
public class DahliaEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "variety_id")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String varietyName;

    @Column(name = "color", nullable = false, length = 50)
    private String color;

    @Column(name = "bloom_form", nullable = false, length = 50)
    private String bloomForm;

    @Column(name = "plant_height", nullable = false)
    private double plantHeight;

    @Column(name = "bloom_size", nullable = false)
    private double bloomSize;

    // The unit price of the dahlia variety, represented as a BigDecimal for precision
    @Column(name = "unit_price", nullable = false, precision = 9, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "description", nullable = true, length = 1024)
    private String description;

    @Column(name = "active", nullable = false)
    private boolean active;

    public DahliaEntity() {
    }

    public Integer getId() {
        return id;
    }

    public String getVarietyName() {
        return varietyName;
    }

    public String getColor() {
        return color;
    }

    public String getBloomForm() {
        return bloomForm;
    }

    public double getPlantHeight() {
        return plantHeight;
    }

    public double getBloomSize() {
        return bloomSize;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "DahliaEntity{" +
                "id=" + id +
                ", varietyName='" + varietyName + '\'' +
                ", color='" + color + '\'' +
                ", bloomForm='" + bloomForm + '\'' +
                ", plantHeight=" + plantHeight +
                ", bloomSize=" + bloomSize +
                ", unitPrice=" + unitPrice +
                ", description='" + description + '\'' +
                ", active=" + active +
                '}';
    }
}
