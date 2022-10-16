package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TelevisionShowTest {
    private TelevisionShow showTest1;
    private TelevisionShow showTest2;

    @BeforeEach
    public void runBefore() {
        showTest1 = new TelevisionShow("Andor");
        showTest2 = new TelevisionShow("Better Call Saul");
    }

    @Test
    public void testConstructor() {
        assertEquals("Andor", showTest1.getName());
        assertEquals( 0, showTest1.getNumber());
        assertEquals(0, showTest1.getRating());
        assertEquals("", showTest1.getDateReleased());
        assertEquals("", showTest1.getDescription());
        List<TelevisionSeason> emptyList = showTest1.getShowSeasons();
        assertEquals(0, emptyList.size());
    }

    @Test
    public void testModifyRating() {
        showTest1.setRating(10);
        assertEquals(10, showTest1.getRating());
        showTest2.setRating(1);
        assertEquals(1, showTest2.getRating());
        showTest1.setRating(5);
        assertEquals(5, showTest1.getRating());
    }

    @Test
    public void testRemoveRatingSuccess() {
        showTest1.setRating(5);
        boolean removeSuccess = showTest1.removeRating();
        assertTrue(removeSuccess);
        assertEquals(0, showTest1.getRating());
    }

    @Test
    public void testRemoveRatingFail() {
        boolean removeFail = showTest2.removeRating();
        assertFalse(removeFail);
        assertEquals(0, showTest2.getRating());
    }

    @Test
    public void testSetDateReleased() {
        showTest1.setDateReleased("2022-09-21");
        assertEquals("2022-09-21", showTest1.getDateReleased());
    }

    @Test
    public void testAddEpisodesToSeason() {
        TelevisionSeason seasonTest1 = new TelevisionSeason(1, "Season 1");
        TelevisionSeason seasonTest2 = new TelevisionSeason(2, "Season 2");
        showTest1.addSeasonToShow(seasonTest1);
        showTest1.addSeasonToShow(seasonTest2);
        List<TelevisionSeason> filledList = showTest1.getShowSeasons();
        assertEquals(2, filledList.size());
        assertEquals(seasonTest1, filledList.get(0));
        assertEquals(seasonTest2, filledList.get(1));
    }

    @Test
    public void testSetDescription() {
        String description = "The story of Rebel spy Cassian Andor's formative years of the Rebellion and his " +
                             "difficult missions for the cause.";
        showTest1.setDescription(description);
        assertEquals(description, showTest1.getDescription());
    }
}
