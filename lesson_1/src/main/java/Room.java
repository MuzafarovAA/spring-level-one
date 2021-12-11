public class Room implements IRoom {

    private IDoctor doctor;

    public void visit() {
        System.out.println("Врач посещён в кабинете " + doctor.getRoomNumber());
    }

    public void setDoctor(IDoctor doctor) {
        this.doctor = doctor;
    }
}
