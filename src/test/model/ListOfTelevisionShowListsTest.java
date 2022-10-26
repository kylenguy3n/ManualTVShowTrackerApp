package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListOfTelevisionShowListsTest {
    private ListOfTelevisionShowLists listOfListsTest;
    private TelevisionShowList listTest;

    @BeforeEach
    public void runBefore() {
        listOfListsTest = new ListOfTelevisionShowLists();
        listTest = new TelevisionShowList("Test List");
    }

    @Test
    public void testConstructor() {
        assertEquals("List of Television Show Lists", listOfListsTest.getListOfListsName());
        List<TelevisionShowList> emptyList = listOfListsTest.getListOfTelevisionShowLists();
        assertEquals(0, emptyList.size());
    }

    @Test
    public void testAddListToList() {
        boolean addSuccess = listOfListsTest.addTelevisionShowListToList(listTest);
        assertTrue(addSuccess);
        List<TelevisionShowList> onceFilledList = listOfListsTest.getListOfTelevisionShowLists();
        assertEquals(1, onceFilledList.size());
        assertEquals(listTest, onceFilledList.get(0));
    }
}
