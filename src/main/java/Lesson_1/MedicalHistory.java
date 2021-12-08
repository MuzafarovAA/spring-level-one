package Lesson_1;

import org.springframework.stereotype.Component;

@Component("medicalHistory")
public class MedicalHistory {
    private String[] history = {"1. Больничный от 01.12.21", "2. Назначен прием 08.12.21"};

    public String[] getHistory() {
        return history;
    }

}
