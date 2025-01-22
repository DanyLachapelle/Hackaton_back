package school.token.hackaton_groupe7.application.features.year.queries.getAll;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class YearGetAllOutput {
    public List<school.token.hackaton_groupe7.application.features.year.queries.getAll.YearGetAllOutput.Year> year = new ArrayList<>();

    @Data
    public static class Year {
        public int year;
    }
}
