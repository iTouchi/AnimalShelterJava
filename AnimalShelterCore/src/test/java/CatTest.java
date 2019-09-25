import Classes.Cat;
import Classes.Gender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatTest {

    private Cat _cat;

    @BeforeEach
    void setUp() {
        //Arrange for each test
        _cat = new Cat("Kitty", Gender.MALE, "Bites");
    }

    @Test
    public void setName() {

        // Arrange
        String expected = "Simba";

        // Act
        _cat.setName(expected);
        String actual = _cat.getName();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void setGender() {

        // Arrange
        Gender expected = Gender.FEMALE;

        // Act
        _cat.setGender(expected);
        Gender actual = _cat.getGender();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void setBadHabits() {

        // Arrange
        String expected = "Scratches";

        // Act
        _cat.setBadHabits(expected);
        String actual = _cat.getBadHabits();

        // Assert
        assertEquals(expected, actual);
    }

    @AfterEach
    void tearDown() {
        _cat = null;
    }


}
