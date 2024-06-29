package de.htwberlin.webtech.controller;

import de.htwberlin.webtech.MedicationEntry;
import org.springframework.http.ResponseEntity;
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
        System.out.println(medicationEntityRepository.findAll());
        return medicationEntityRepository.findAll();
    }

    @CrossOrigin
    @PostMapping
    public MedicationEntry addMedication(@RequestBody MedicationEntry medication) {
        return medicationEntityRepository.save(medication);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void deleteMedication(@PathVariable Long id) {
        medicationEntityRepository.deleteById(id);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public MedicationEntry updateMedication(@PathVariable Long id, @RequestBody MedicationEntry updatedMedication) {
        return medicationEntityRepository.findById(id)
                .map(medication -> {
                    medication.setName(updatedMedication.getName());
                    medication.setQuantity(updatedMedication.getQuantity());
                    medication.setDose(updatedMedication.getDose());
                    medication.setPeriod(updatedMedication.getPeriod());
                    return medicationEntityRepository.save(medication);
                })
                .orElseGet(() -> {
                    updatedMedication.setId(id);
                    return medicationEntityRepository.save(updatedMedication);
                });
    }

}