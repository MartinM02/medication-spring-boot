package de.htwberlin.webtech.controller;

import de.htwberlin.webtech.MedicationEntry;
import org.springframework.web.bind.annotation.*;
import de.htwberlin.webtech.repository.MedicationEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/api/medication")
public class MedicationController {

    private final MedicationEntityRepository medicationEntityRepository;

    public MedicationController(MedicationEntityRepository medicationRepository) {
        this.medicationEntityRepository = medicationRepository;
    }
    @CrossOrigin
    @GetMapping
    public List<MedicationEntry> getAllMedications() {
        return medicationEntityRepository.findAll();
    }
    @CrossOrigin
    @PostMapping
    public MedicationEntry addMedication(@RequestBody MedicationEntry medication) {
        return medicationEntityRepository.save(medication);
    }
}