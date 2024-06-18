package controller;

import de.htwberlin.webtech.MedicationEntry;
import repository.MedicationEntityRepository;
import org.springframework.web.bind.annotation.*;
import repository.MedicationEntityRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173","https://medication-frontend.onrender.com"})
@RequestMapping("/api/medication")
public class MedicationController {

    private final MedicationEntityRepository medicationEntityRepository;

    public MedicationController(MedicationEntityRepository medicationRepository) {
        this.medicationEntityRepository = medicationRepository;
    }

    @GetMapping
    public List<MedicationEntry> getAllMedications() {
        return medicationEntityRepository.findAll();
    }

    @PostMapping
    public MedicationEntry addMedication(@RequestBody MedicationEntry medication) {
        System.out.println(medication.getName());
        return medicationEntityRepository.save(medication);
    }
}