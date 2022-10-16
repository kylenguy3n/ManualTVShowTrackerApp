package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TelevisionShowTest {

    TelevisionShow showTest1;

    @BeforeEach
    public void runBefore() {
        showTest1 = new TelevisionShow("Andor");
    }

    @Test
    public void testConstructor() {
        assertEquals("Andor", showTest1.getName());
        assertEquals( 0, showTest1.getNumber());
        assertEquals(0, showTest1.getRating());
        assertEquals("", showTest1.getDescription());
    }
}
