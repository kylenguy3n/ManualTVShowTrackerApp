package persistence;

import org.json.JSONArray;

// Represents writable content to return as JSON object in JSON array
public interface WritableArray {

    // EFFECTS: returns objects in JSON array
    JSONArray listOfObjectToJson();
}
