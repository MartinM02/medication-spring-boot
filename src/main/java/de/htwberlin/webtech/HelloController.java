package de.htwberlin.webtech;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"https://medication-frontend.onrender.com"})

public class HelloController {

    @GetMapping("/medication")
    public List<MedicationEntry> greeting() {
        MedicationEntry entry = new MedicationEntry("Ibuprofen", "1", 250, 7);


        return List.of(entry);
    }




}