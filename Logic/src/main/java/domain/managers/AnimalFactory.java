package domain.managers;

import DAL.SerializableArrayList;
import DAL.Serializer;
import domain.Gender;
import domain.animal.Animal;
import domain.animal.Cat;
import domain.animal.Dog;

public class AnimalFactory {
    private SerializableArrayList<Animal> animals = new SerializableArrayList<>();
    private Serializer serializer = new Serializer();

    public void createCat(String name, Gender gender, String badHabits){
        this.animals.add(new Cat(name,gender,badHabits));
    }

    public void createDog(String name,Gender gender){
        this.animals.add(new Dog(name, gender));
    }

    public void deleteAnimal(Animal animal){
        this.animals.remove(animal);

    }

    public SerializableArrayList getAnimals(){
        return animals;
    }

    public void saveAnimals(){
        serializer.serializeList(animals, "animals.ser");
    }

    public SerializableArrayList<Animal> loadAnimals(){
        animals = serializer.deSerializeList("animals.ser");
        return animals;
    }
}
