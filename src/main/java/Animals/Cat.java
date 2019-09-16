package Animals;

public class Cat extends Animal {

    private String badHabits;

    public Cat(String newName, Gender newGender, String newBadHabits) {
        super(newName, newGender);
        setBadHabits(newBadHabits);
    }

    public void setBadHabits(String newBadHabits) {
        this.badHabits = newBadHabits;
    }

    public String getBadHabits() {
        return this.badHabits;
    }



    @Override
    public String toString() {
        return super.toString() + ", bad habits: " + this.badHabits;
    }

}
