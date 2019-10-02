package domain.animal;

import domain.Gender;
import domain.Reservor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Animal is the main class of all animals
 *
 * @author aytac
 */
public abstract class Animal implements Serializable {

    // Name of the animal
    private String name;
    // Gender of the animal
    private Gender gender;
    // Reservor of the animal
    private Reservor reservedBy;
    // Current date of the local time
    private LocalDateTime currentDate = LocalDateTime.now();

    /**
     * Constructor.
     * @param newName name of the animal
     * @param newGender gander of the animal
     */
    Animal(String newName, Gender newGender) {
        this.name = newName;
        this.gender = newGender;
    }

    /**
     * Reserve the given animal.
     * @param reservedBy name of the the one who reserves the animal
     * @return a true or false statement.
     */
    public boolean reserve(String reservedBy) {
        if (this.reservedBy == null) {
            this.reservedBy = new Reservor(reservedBy, currentDate);
            return true;
        }
        return false;
    }


    /**
     * Set the name of this Animal
     * @param name name of the animal
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the gender of this animal
     * @param gender gender of the animal
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Get the name of this animal.
     * @return name of this animal.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the gender of this animal.
     * @return the gender of this animal.
     */
    public Gender getGender() {
        return this.gender;
    }

    /**
     * Get the reservor of this animal.
     * @return the reservor of this animal.
     */
    public Reservor getReservor() {
        return this.reservedBy;
    }

    /**
     * An method that overrides the toString method.
     * @return the string representation of the Animal
     */
    @Override
    public String toString() {
        String reserved = " not reserved";
        if (this.reservedBy != null) {
            reserved = " reserved by " + this.reservedBy.getName();
        }
        return this.name + ", " + this.gender + ", " + reserved;
    }

}
