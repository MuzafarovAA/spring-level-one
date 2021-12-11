import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan
public class AppConfig {

    @Bean(name = "doctor")
    public IDoctor doctor() {
        return new PhysicianDoctor();
    }

    @Bean(name = "room")
    public IRoom room(IDoctor doctor) {
        Room room = new Room();
        room.setDoctor(doctor);
        return room;
    }

    @Bean(name = "medicalHistory")
    public MedicalHistory medicalHistory() {
        return new MedicalHistory();
    }
//
    @Bean(name = "medicalRecord")
    public MedicalRecord medicalRecord(MedicalHistory medicalHistory) {
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setMedicalHistory(medicalHistory);
        return medicalRecord;
    }
}
