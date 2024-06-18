package de.htwberlin.webtech;

import jakarta.persistence.*;

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

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    public int getDose() {
        return dose;
    }

    public int getPeriod() {
        return period;
    }
}