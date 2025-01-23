package school.token.hackaton_groupe7.application.features.month.queries.getAll;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class MonthGetAllOutput {
    public List<MonthGetAllOutput.Month> month = new ArrayList<>();

    @Data
    public static class Month {
        public int id;
        public String month;
    }
}
