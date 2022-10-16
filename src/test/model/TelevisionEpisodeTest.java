package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    }
}