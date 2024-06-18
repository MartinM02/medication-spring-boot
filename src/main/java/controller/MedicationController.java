package controller;

import de.htwberlin.webtech.MedicationEntry;
import repository.MedicationEntityRepository;
import org.springframework.web.bind.annotation.*;
import repository.MedicationEntityRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5175","https://medication-frontend.onrender.com","http://localhost:5176" })
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
        System.out.println(medication.getName() + " " + medication.getQuantity() + " " + medication.getDose() + " " + medication.getPeriod());
        return medicationEntityRepository.save(medication);
    }
}