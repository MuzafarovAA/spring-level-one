package Lesson_1;

public class PhysicianDoctor implements IDoctor {

    private int room = 512;

    @Override
    public int getRoomNumber() {
        return room;
    }

}
