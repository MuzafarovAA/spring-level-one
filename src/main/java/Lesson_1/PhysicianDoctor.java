package Lesson_1;

import org.springframework.stereotype.Component;

@Component ("doctor")
public class PhysicianDoctor implements IDoctor {

    private int room = 512;

    @Override
    public int getRoomNumber() {
        return room;
    }

}
