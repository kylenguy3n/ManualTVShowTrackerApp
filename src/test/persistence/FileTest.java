package persistence;

import model.TelevisionEpisode;
import model.TelevisionSeason;
import model.TelevisionShow;
import model.TelevisionShowList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileTest {

    protected TelevisionShow checkShowList(String name, int size, TelevisionShowList showList) {
        assertEquals(name, showList.getListName());
        assertEquals(size, showList.getTelevisionShowList().size());

        TelevisionShow firstShow = showList.getTelevisionShowList().get(0);
        return firstShow;
    }

    protected TelevisionSeason checkShow(int number, String name, int size, int rating, String dateReleased,
                                         String description, TelevisionShow show) {
        assertEquals(number, show.getNumber());
        assertEquals(name, show.getTitle());
        assertEquals(size, show.getShowSeasons().size());
        assertEquals(rating, show.getRating());
        assertEquals(dateReleased, show.getDateReleased());
        assertEquals(description, show.getDescription());

        TelevisionSeason firstSeason = show.getShowSeasons().get(0);
        return firstSeason;
    }

    protected TelevisionEpisode checkSeason(int number, String name, int size, int rating, String dateReleased,
                                            TelevisionSeason season) {
        assertEquals(number, season.getNumber());
        assertEquals(name, season.getTitle());
        assertEquals(size, season.getSeasonEpisodes().size());
        assertEquals(rating, season.getRating());
        assertEquals(dateReleased, season.getDateReleased());

        TelevisionEpisode firstEpisode = season.getSeasonEpisodes().get(0);
        return firstEpisode;
    }

    protected void checkEpisode(int number, String name, int rating, String dateReleased, TelevisionEpisode episode) {
        assertEquals(number, episode.getNumber());
        assertEquals(name, episode.getTitle());
        assertEquals(rating, episode.getRating());
        assertEquals(dateReleased, episode.getDateReleased());
    }
}
