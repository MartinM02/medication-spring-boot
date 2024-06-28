package de.htwberlin.webtech.controller;

import de.htwberlin.webtech.MedicationEntry;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"https://medication-frontend.onrender.com"})

public class HelloController {

    @GetMapping("/medication")
    public List<MedicationEntry> greeting() {
        MedicationEntry entry = new MedicationEntry("Ibuprofen", "1 x Täglich", 250, "2 Wochen");
        MedicationEntry entry1 = new MedicationEntry("Paracetamol", "2 x Täglich", 500, " 1 Woche");


        return List.of(entry, entry1);
    }




}