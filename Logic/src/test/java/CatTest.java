import domain.animal.Cat;
import domain.Gender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CatTest {

    private Cat _cat;

    @BeforeEach
    void setUp() {
        //Arrange for each test
        _cat = new Cat("Kitty", Gender.MALE, "Bites");
    }

    @Test
    private void setName() {

        // Arrange
        String expected = "Simba";

        // Act
        _cat.setName(expected);
        String actual = _cat.getName();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void setGender() {

        // Arrange
        Gender expected = Gender.FEMALE;

        // Act
        _cat.setGender(expected);
        Gender actual = _cat.getGender();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void setBadHabits() {

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
