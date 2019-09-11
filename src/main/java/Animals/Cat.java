package Animals;

public class Cat extends Animal {

    private String badHabits;

    public void setBadHabits(String newBadHabits) {
        this.badHabits = newBadHabits;
    }

    public String getBadHabits() {
        return this.badHabits;
    }

    public Cat(String newName, Gender newGender, String newBadHabits) {
        super(newName, newGender);
        setBadHabits(newBadHabits);
    }

    @Override
    public String toString() {
        return super.toString() + ", bad habits: " + this.badHabits;
    }

}
