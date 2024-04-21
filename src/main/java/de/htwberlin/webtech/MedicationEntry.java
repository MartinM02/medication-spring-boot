package de.htwberlin.webtech;

public class MedicationEntry {


    private String name;
    private String quantity;
    private int dose;

    private int period;

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