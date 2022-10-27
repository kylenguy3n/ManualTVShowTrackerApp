package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class FileWriterTest extends FileTest {

    @Test
    public void testWriteInvalidFile() {
        try {
            ListOfTelevisionShowLists listOfTelevisionShowLists = new ListOfTelevisionShowLists();
            FileWriter fileWriter = new FileWriter("./data/testWrite\nInvalidFileName.json");
            fileWriter.openFile();
            fail("IOException error was expected");
        } catch (IOException e) {
            // test passed
        }
    }

    @Test
    public void testWriteEmptyListOfTelevisionShowLists() {
        try {
            ListOfTelevisionShowLists listOfTelevisionShowLists = new ListOfTelevisionShowLists();
            FileWriter fileWriter = new FileWriter("./data/testWriteEmptyListOfTelevisionShowLists.json");
            fileWriter.openFile();
            fileWriter.writeFile(listOfTelevisionShowLists);
            fileWriter.closeFile();

            FileReader fileReader = new FileReader("./data/testWriteEmptyListOfTelevisionShowLists.json");
            ListOfTelevisionShowLists loadedListOfTelevisionShowLists = fileReader.readFile();
            assertEquals("List of Television Show Lists", loadedListOfTelevisionShowLists.getListOfListsName());
            List<TelevisionShowList> emptyList = loadedListOfTelevisionShowLists.getListOfTelevisionShowLists();
            assertEquals(0, emptyList.size());
        } catch (IOException e) {
            fail("Exception was thrown when it was not expected");
        }
    }

    @Test
    public void testWriteGeneralListOfTelevisionShowLists() {
        try {
            ListOfTelevisionShowLists listOfShowLists = new ListOfTelevisionShowLists();

            TelevisionShowList showList = new TelevisionShowList("Test Show List");
            TelevisionShow show = new TelevisionShow("Test Show");
            show.setDescription("X");
            show.setRating(10);
            TelevisionSeason season = new TelevisionSeason(1, "Season 1");
            TelevisionEpisode episode = new TelevisionEpisode(1, "Episode 1");

            season.addEpisodeToSeason(episode);
            show.addSeasonToShow(season);
            showList.addShowToList(show);
            listOfShowLists.addTelevisionShowListToList(showList);

            FileWriter fileWriter = new FileWriter("./data/testWriteGeneralListOfTelevisionShowLists.json");
            fileWriter.openFile();
            fileWriter.writeFile(listOfShowLists);
            fileWriter.closeFile();

            FileReader fileReader = new FileReader("./data/testWriteGeneralListOfTelevisionShowLists.json");
            listOfShowLists = fileReader.readFile();

            assertEquals("List of Television Show Lists", listOfShowLists.getListOfListsName());
            List<TelevisionShowList> oneListInListOfLists = listOfShowLists.getListOfTelevisionShowLists();
            assertEquals(1, oneListInListOfLists.size());
            TelevisionShowList firstTelevisionShowList = oneListInListOfLists.get(0);
            TelevisionShow firstShow;
            firstShow = checkShowList("Test Show List", 1, firstTelevisionShowList);
            TelevisionSeason firstSeason;
            firstSeason = checkShow(0, "Test Show", 1, 10, "", "X",
                    firstShow);
            TelevisionEpisode firstEpisode;
            firstEpisode = checkSeason(1, "Season 1", 1, 0, "", firstSeason);
            checkEpisode(1, "Episode 1", 0, "", firstEpisode);

        } catch (IOException e) {
            fail("Could not read from general file as expected");
        }
    }
}
