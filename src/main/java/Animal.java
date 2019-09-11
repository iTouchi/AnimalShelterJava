import java.util.Date;

public class Animal {

    public String name;
    public Gender gender;
    public Reservor reservedBy;

    Date CurrentDate = new Date();


    Animal(String name, Gender gender) {
        this.name = name;
        this.gender = gender;

    }

    public boolean reserve(String reservedBy) {
        if (this.reservedBy == null) {
            this.reservedBy = new Reservor(reservedBy, CurrentDate);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String reserved = "not reserved";
        if (this.reservedBy != null) {
            reserved = "reserved by" + "," + this.reservedBy.name;
        }
        return this.name + "," + this.gender + "," + reserved;
    }

}
