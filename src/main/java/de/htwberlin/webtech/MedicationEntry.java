package de.htwberlin.webtech;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "medicationentry")
public class MedicationEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String quantity;
    private int dose;
    private int period;

    public MedicationEntry() {
    }

    public MedicationEntry(String name, String quantity, int dose, int period) {
        this.name = name;
        this.quantity = quantity;
        this.dose = dose;
        this.period = period;
    }
}