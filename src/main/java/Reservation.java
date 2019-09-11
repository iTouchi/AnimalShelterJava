import Animals.*;

import java.util.ArrayList;
import java.util.List;

public class Reservation {
    public List<Cat> cats = new ArrayList<Cat>();
    public List<Dog> dogs = new ArrayList<Dog>();

    public void NewCat(String name, Gender gender, String badHabits) {
        this.cats.add(new Cat(name, gender, badHabits));
    }

    public void NewDog(String name, Gender gender) {
        this.dogs.add(new Dog(name, gender));
    }


}
