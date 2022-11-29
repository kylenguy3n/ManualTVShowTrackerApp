package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TelevisionShowListTest {
    private TelevisionShowList listTest1;
    private TelevisionShowList listTest2;
    private TelevisionShow showTest1;

    @BeforeEach
    public void runBefore() {
        listTest1 = new TelevisionShowList("Favourite Shows");
        listTest2 = new TelevisionShowList("Plan To Watch");
        showTest1 = new TelevisionShow("Andor");
    }

    @Test
    public void testConstructor() {
        assertEquals("Favourite Shows", listTest1.getListName());
        List<TelevisionShow> emptyList = listTest1.getTelevisionShowList();
        assertEquals(0, emptyList.size());
    }

    @Test
    public void testAddShowSuccess() {
        EventLog eventLog = EventLog.getInstance();
        TelevisionShow showTest2 = new TelevisionShow("Better Call Saul");
        boolean addSuccess1 = listTest1.addShowToList(showTest1);
        boolean addSuccess2 = listTest1.addShowToList(showTest2);
        assertTrue(addSuccess1);
        assertTrue(addSuccess2);
        List<TelevisionShow> twiceFilledlist = listTest1.getTelevisionShowList();
        assertEquals(2, twiceFilledlist.size());
        assertEquals(showTest1, twiceFilledlist.get(0));
        assertEquals(showTest2, twiceFilledlist.get(1));

        List<String> strings = new ArrayList<>();

        for (Event nextEvent : eventLog) {
            strings.add(nextEvent.getDescription());
        }

        assertEquals("Added Andor to Favourite Shows", strings.get(0));
        assertEquals("Added Better Call Saul to Favourite Shows", strings.get(1));
    }

    @Test
    public void testAddShowFail() {
        listTest2.addShowToList(showTest1);
        boolean addFail = listTest2.addShowToList(showTest1);
        assertFalse(addFail);
        List<TelevisionShow> onceFilledList = listTest2.getTelevisionShowList();
        assertEquals(1, onceFilledList.size());
    }

    @Test
    public void testRemoveShowSuccess() {
        EventLog eventLog = EventLog.getInstance();
        listTest2.addShowToList(showTest1);
        boolean removeSuccess = listTest2.removeShowFromList(showTest1);
        assertTrue(removeSuccess);
        List<TelevisionShow> nowEmptyList = listTest2.getTelevisionShowList();
        assertEquals(0, nowEmptyList.size());

        List<String> strings = new ArrayList<>();

        for (Event nextEvent : eventLog) {
            strings.add(nextEvent.getDescription());
        }

        assertEquals("Added Andor to Plan To Watch", strings.get(0));
        assertEquals("Removed Andor from Plan To Watch", strings.get(1));
    }

    @Test
    public void testRemoveShowFail() {
        boolean removeFail = listTest1.removeShowFromList(showTest1);
        assertFalse(removeFail);
        List<TelevisionShow> wasNeverFilledList = listTest1.getTelevisionShowList();
        assertEquals(0, wasNeverFilledList.size());
    }
}
