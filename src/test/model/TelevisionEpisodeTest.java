package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TelevisionEpisodeTest {

    TelevisionEpisode episodeTest1;
    TelevisionEpisode episodeTest2;

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
        assertEquals("", episodeTest1.getDescription());
    }
}