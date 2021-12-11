import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Patient {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
//        Room room = context.getBean("room", Room.class);
//        MedicalRecord medicalRecord = context.getBean("medicalRecord", MedicalRecord.class);
//        medicalRecord.check();
//        room.visit();

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Room room = context.getBean("room", Room.class);
        MedicalRecord medicalRecord = context.getBean("medicalRecord", MedicalRecord.class);
        medicalRecord.check();
        room.visit();
    }
}
