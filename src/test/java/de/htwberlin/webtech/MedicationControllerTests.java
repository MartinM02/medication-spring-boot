package de.htwberlin.webtech;

import de.htwberlin.webtech.controller.MedicationController;
import de.htwberlin.webtech.repository.MedicationEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(MedicationController.class)
public class MedicationControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MedicationEntityRepository medicationEntityRepository;

    @Test
    void shouldReturnAllMedications() throws Exception {
        MedicationEntry medication = new MedicationEntry();
        medication.setId(1L);
        medication.setName("Test Medication");

        when(medicationEntityRepository.findAll()).thenReturn(List.of(medication));

        mockMvc.perform(get("/api/medication"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name").value("Test Medication"));
    }

    @Test
    void shouldAddMedication() throws Exception {
        MedicationEntry medication = new MedicationEntry();
        medication.setName("Test Medication");
        medication.setQuantity("10");
        medication.setDose(2);
        medication.setPeriod("daily");

        MedicationEntry savedMedication = new MedicationEntry();
        savedMedication.setId(1L);  // Manuell eine ID setzen
        savedMedication.setName("Test Medication");
        savedMedication.setQuantity("10");
        savedMedication.setDose(2);
        savedMedication.setPeriod("daily");

        when(medicationEntityRepository.save(any(MedicationEntry.class))).thenReturn(savedMedication);

        MvcResult result = mockMvc.perform(post("/api/medication")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Test Medication\", \"quantity\": \"10\", \"dose\": 2, \"period\": \"daily\"}"))
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        System.out.println("Response Content: " + responseContent);

        mockMvc.perform(post("/api/medication")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Test Medication\", \"quantity\": \"10\", \"dose\": 2, \"period\": \"daily\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Test Medication")))
                .andExpect(jsonPath("$.quantity", is("10")))
                .andExpect(jsonPath("$.dose", is(2)))
                .andExpect(jsonPath("$.period", is("daily")))
                .andExpect(jsonPath("$.id", is(1)));  // Überprüfen Sie, ob die ID gesetzt wurde
    }

    @Test
    void shouldDeleteMedication() throws Exception {
        Long medicationId = 1L;

        doNothing().when(medicationEntityRepository).deleteById(medicationId);

        mockMvc.perform(delete("/api/medication/{id}", medicationId))
                .andExpect(status().isOk());
    }

    @Test
    void shouldAllowCors() throws Exception {
        mockMvc.perform(get("/api/medication")
                        .header("Origin", "http://localhost:3000"))
                .andExpect(status().isOk());
    }

}
