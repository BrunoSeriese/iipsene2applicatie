package nl.hsleiden.service;

import nl.hsleiden.model.*;

/**
 * Service to make the ContentController less bulky.
 * @author Vincent Severin.
 */
public class ContentService {

    public String getFilename(Content content) {
        String filename = "";
        if (content instanceof Question) {
            filename = "Question.fxml";
        } else if (content instanceof Video) {
            filename = "Video.fxml";
        } else if (content instanceof Result) {
            filename = "Result.fxml";
        } else if (content instanceof Explanation) {
            filename = "Explanation.fxml";
        }
        return filename;
    }
}
