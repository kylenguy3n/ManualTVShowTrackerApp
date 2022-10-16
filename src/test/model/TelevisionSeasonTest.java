package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TelevisionSeasonTest {
    private TelevisionSeason seasonTest1;

    @BeforeEach
    public void runBefore() {
        seasonTest1 = new TelevisionSeason(1, "Season 1");
    }

    @Test
    public void testConstructor() {
        assertEquals("Season 1", seasonTest1.getName());
        assertEquals( 1, seasonTest1.getNumber());
        assertEquals(0, seasonTest1.getRating());
    }
}

