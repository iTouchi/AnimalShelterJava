package Classes;

public class AnimalFactory {
    public SerializableArrayList<Animal> animals = new SerializableArrayList<>();
    public Serializer serializer = new Serializer();

    public void createCat(String name,Gender gender, String badHabits){
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