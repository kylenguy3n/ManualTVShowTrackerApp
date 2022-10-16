package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TelevisionEpisodeTest {
    private TelevisionEpisode episodeTest1;
    private TelevisionEpisode episodeTest2;

    @BeforeEach
    public void runBefore() {
        episodeTest1 = new TelevisionEpisode(1, "Kassa");
        episodeTest2 = new TelevisionEpisode(2, "That Would Be Me");
    }

    @Test
    public void testConstructor() {
        assertEquals("Kassa", episodeTest1.getName());
        assertEquals( 1, episodeTest1.getNumber());
        assertEquals(0, episodeTest1.getRating());
        assertEquals("", episodeTest1.getDateReleased());
    }

    @Test
    public void testModifyRating() {
        episodeTest1.setRating(10);
        assertEquals(10, episodeTest1.getRating());
        episodeTest2.setRating(1);
        assertEquals(1, episodeTest2.getRating());
        episodeTest1.setRating(5);
        assertEquals(5, episodeTest1.getRating());
    }

    @Test
    public void testRemoveRatingSuccess() {
        episodeTest1.setRating(5);
        boolean removeSuccess = episodeTest1.removeRating();
        assertTrue(removeSuccess);
        assertEquals(0, episodeTest1.getRating());
    }

    @Test
    public void testRemoveRatingFail() {
        boolean removeFail = episodeTest2.removeRating();
        assertFalse(removeFail);
        assertEquals(0, episodeTest2.getRating());
    }

    @Test
    public void testSetDateReleased() {
        episodeTest1.setDateReleased("2022-09-21");
        assertEquals("2022-09-21", episodeTest1.getDateReleased());
    }
}