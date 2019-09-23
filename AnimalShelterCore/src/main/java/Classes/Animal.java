package Classes;

import java.util.Date;

public abstract class Animal {

    private String name;
    private Gender gender;
    private Reservor reservedBy;

    Date CurrentDate = new Date();


    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }

    public void setGender(Gender newGender) {
        this.gender = newGender;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setReservedBy(Reservor newReservor) {
        this.reservedBy = newReservor;
    }

    public Reservor getReservedBy() {
        return this.reservedBy;
    }


    public Animal(String name, Gender gender) {
        setName(name);
        setGender(gender);

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
            reserved = "reserved by" + "," + this.reservedBy.getName();
        }
        return this.name + "," + this.gender + "," + reserved;
    }

}