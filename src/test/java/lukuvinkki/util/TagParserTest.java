package lukuvinkki.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TagParserTest {
    String rawTags = "foo;bar;baz";
    String rawTagsWithExtraSpaces = "  foo  ; bar;  baz  ;; ";

    @Test
    public void parserParsesTagsCorrectly() {
        TagParser parser = new TagParser(rawTags);
        assertCorrectTags(parser);
    }

    @Test
    public void parserParsesTagsCorrectlyWithExtraSpaces() {
        TagParser parser = new TagParser(rawTagsWithExtraSpaces);
        assertCorrectTags(parser);
    }

    public void assertCorrectTags(TagParser parser) {
        List<String> parsedTags = parser.parse();
        assertEquals(3, parsedTags.size());
        assertTrue(parsedTags.contains("foo"));
        assertTrue(parsedTags.contains("bar"));
        assertTrue(parsedTags.contains("baz"));
    }
}
