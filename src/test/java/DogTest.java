import Animals.Dog;
import Animals.Gender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DogTest {

    private Dog _dog;

    @BeforeEach
    void setUp() {
        //Arrange for each test
        _dog = new Dog("Doggy", Gender.FEMALE);
    }


    @Test
    public void setName() {

        // Arrange
        String expected = "Elsa";

        // Act
        _dog.setName(expected);
        String actual = _dog.getName();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void setGender() {

        // Arrange
        Gender expected = Gender.MALE;

        // Act
        _dog.setGender(expected);
        Gender actual = _dog.getGender();

        // Assert
        assertEquals(expected, actual);
    }

    @AfterEach
    void tearDown() {
        _dog = null;
    }
}
