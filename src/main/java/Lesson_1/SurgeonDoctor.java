package Lesson_1;

public class SurgeonDoctor implements IDoctor {

    private int room = 123;

    @Override
    public int getRoomNumber() {
        return room;
    }

}
