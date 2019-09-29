package Classes;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Animal implements Serializable {

    private String name;
    private Gender gender;
    private Reservor reservedBy;
    private LocalDateTime currentDate = LocalDateTime.now();

    public Animal(String newName, Gender newGender) {
        this.name = newName;
        this.gender = newGender;
    }

    public boolean reserve(String reservedBy) {
        if (this.reservedBy == null) {
            this.reservedBy = new Reservor(reservedBy, currentDate);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String reserved = " not reserved";
        if (this.reservedBy != null) {
            reserved = " reserved by " + this.reservedBy.getName();
        }
        return this.name + ", " + this.gender + ", " + reserved;
    }


    //Setter
    //setName, setGender, setReservor
    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setReservedBy(Reservor reservor) {
        this.reservedBy = reservor;
    }

    //Getter
    //getName, getGender, getReservor
    public String getName() {
        return this.name;
    }

    public Gender getGender() {
        return this.gender;
    }

    public Reservor getReservor() {
        return this.reservedBy;
    }


}
