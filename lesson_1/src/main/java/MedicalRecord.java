import java.util.Arrays;

public class MedicalRecord {

    private MedicalHistory medicalHistory;

    public void setMedicalHistory(MedicalHistory medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public void check() {
        System.out.println("Записи из медицинской карты: " + Arrays.toString(medicalHistory.getHistory()));
    }
}
