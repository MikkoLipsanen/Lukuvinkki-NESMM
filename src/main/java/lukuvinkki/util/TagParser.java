package lukuvinkki.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TagParser {
    private String tags;

    public TagParser(String tags) {
        this.tags = tags;
    }

    public List<String> parse() {
        return Arrays.stream(this.tags.split(";"))
                .map(String::trim)
                .map(String::toLowerCase)
                .filter(v -> !v.isEmpty())
                .distinct()
                .collect(Collectors.toList());
    }
}
