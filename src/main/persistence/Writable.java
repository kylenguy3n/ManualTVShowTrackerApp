package persistence;

import org.json.JSONObject;

// Represents writable content to return as JSON object
public interface Writable {

    // EFFECTS: returns this object as JSON object
    JSONObject objectToJson();


}
