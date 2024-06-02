package zad1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TravelData {
    private List<Travel> travels = new ArrayList<>();
    private File dataFile;
    public TravelData(File data) {
        dataFile = data;
    }

    public List<String> getOffersDescriptionsList(String locale, String dateFormat) {
    }
}
