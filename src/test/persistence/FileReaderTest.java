package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class FileReaderTest extends FileTest {


    @Test
    public void testReadNonExistentFile() {
        FileReader fileReader = new FileReader("./data/testReadNonExistentFile.json");
        try {
            ListOfTelevisionShowLists listOfTelevisionShowLists = fileReader.readFile();
            fail("IOException error was expected");

        } catch (IOException e) {
            // test passed
        }
    }

    @Test
    public void testReadEmptyListOfTelevisionShowLists() {
        FileReader fileReader = new FileReader("./data/testReadEmptyListOfTelevisionShowLists.json");
        try {
            ListOfTelevisionShowLists listOfTelevisionShowLists = fileReader.readFile();
            assertEquals("List of Television Show Lists", listOfTelevisionShowLists.getListOfListsName());
            List<TelevisionShowList> emptyList = listOfTelevisionShowLists.getListOfTelevisionShowLists();
            assertEquals(0, emptyList.size());

        } catch (IOException e) {
            fail("Could not read from empty file as expected");
        }
    }

    @Test
    public void testReadGeneralListOfTelevisionShowLists() {
        FileReader fileReader = new FileReader("./data/testReadGeneralListOfTelevisionShowLists.json");
        try {
            ListOfTelevisionShowLists listOfShowLists = fileReader.readFile();

            assertEquals("List of Television Show Lists", listOfShowLists.getListOfListsName());
            List<TelevisionShowList> oneListInListOfLists = listOfShowLists.getListOfTelevisionShowLists();
            assertEquals(1, oneListInListOfLists.size());
            TelevisionShowList firstTelevisionShowList = oneListInListOfLists.get(0);
            TelevisionShow firstShow;
            firstShow = checkShowList("Test Show List", 1, firstTelevisionShowList);
            TelevisionSeason firstSeason;
            firstSeason = checkShow(0, "Test Show", 3, 10, "", "X",
                                    firstShow);
            TelevisionEpisode firstEpisode;
            firstEpisode = checkSeason(1, "Season 1", 3, 0, "", firstSeason);
            checkEpisode(1, "Episode 1", 0, "", firstEpisode);

        } catch (IOException e) {
            fail("Could not read from general file as expected");
        }
    }
}
