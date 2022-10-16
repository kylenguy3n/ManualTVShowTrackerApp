package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TelevisionSeasonTest {
    private TelevisionSeason seasonTest1;
    private TelevisionSeason seasonTest2;

    @BeforeEach
    public void runBefore() {
        seasonTest1 = new TelevisionSeason(1, "Season 1");
        seasonTest2 = new TelevisionSeason(2, "Season 2");
    }

    @Test
    public void testConstructor() {
        assertEquals("Season 1", seasonTest1.getName());
        assertEquals( 1, seasonTest1.getNumber());
        assertEquals(0, seasonTest1.getRating());
        assertEquals("", seasonTest1.getDateReleased());
        List<TelevisionEpisode> emptyList = seasonTest1.getSeasonEpisodes();
        assertEquals(0, emptyList.size());
    }

    @Test
    public void testModifyRating() {
        seasonTest1.setRating(10);
        assertEquals(10, seasonTest1.getRating());
        seasonTest2.setRating(1);
        assertEquals(1, seasonTest2.getRating());
        seasonTest1.setRating(5);
        assertEquals(5, seasonTest1.getRating());
    }

    @Test
    public void testRemoveRatingSuccess() {
        seasonTest1.setRating(5);
        boolean removeSuccess = seasonTest1.removeRating();
        assertTrue(removeSuccess);
        assertEquals(0, seasonTest1.getRating());
    }

    @Test
    public void testRemoveRatingFail() {
        boolean removeFail = seasonTest2.removeRating();
        assertFalse(removeFail);
        assertEquals(0, seasonTest2.getRating());
    }

    @Test
    public void testSetDateReleased() {
        seasonTest1.setDateReleased("2022-09-21");
        assertEquals("2022-09-21", seasonTest1.getDateReleased());
    }

    @Test
    public void testAddEpisodesToSeason() {
        TelevisionEpisode episodeTest1 = new TelevisionEpisode(1, "Kassa");
        TelevisionEpisode episodeTest2 = new TelevisionEpisode(2, "That Would Be Me");
        seasonTest1.addEpisodeToSeason(episodeTest1);
        seasonTest1.addEpisodeToSeason(episodeTest2);
        List<TelevisionEpisode> filledList = seasonTest1.getSeasonEpisodes();
        assertEquals(2, filledList.size());
        assertEquals(episodeTest1, filledList.get(0));
        assertEquals(episodeTest2, filledList.get(1));
    }
}

