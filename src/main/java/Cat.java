
public class Cat extends Animal {

    public String badHabits;

    Cat(String name, Gender gender, String badHabits) {
        super(name, gender);
        this.badHabits = badHabits;
    }

    @Override
    public String toString() {
        return super.toString() + ", bad habits: " + this.badHabits;
    }

}
