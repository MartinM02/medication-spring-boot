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
        MedicationEntry entry = new MedicationEntry("Ibuprofen", "1 per day", 250, 7);
        MedicationEntry entry1 = new MedicationEntry("Paracetamol", "2 per day ", 500, 3);


        return List.of(entry, entry1);
    }




}