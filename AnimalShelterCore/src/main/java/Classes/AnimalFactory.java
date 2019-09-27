package Classes;

import java.util.ArrayList;

public class AnimalFactory {
    public SerializableArrayList<Animal> animals = new SerializableArrayList<>();
    public Serializer serializer = new Serializer();

    public void createCat(String name,Gender gender, String badHabits){
        this.animals.add(new Cat(name,gender,badHabits));
    }

    public void createDog(String name,Gender gender){
        this.animals.add(new Dog(name, gender));
    }

    public ArrayList<Animal> getAnimals(){
        return animals;
    }

    public void saveAnimal(){
        serializer.serializeList(animals, "animals.ser");
    }

    public ArrayList<Animal> loadAnimal(){
        animals = serializer.deSerializeList("animals.ser");
        return animals;
    }
}
