package Lesson_1;

public class Room implements IRoom {

    private int roomNumber;

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void visit() {
        System.out.println("Врач посещён в кабинете " + roomNumber);
    }

    public void setDoctor(IDoctor doctor) {
        setRoomNumber(doctor.getRoomNumber());
    }
}
