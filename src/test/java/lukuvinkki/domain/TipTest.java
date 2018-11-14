package test.java.lukuvinkki.domain;

import lukuvinkki.domain.Tip;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TipTest {
    
    Tip tip;

    @Before
    public void setUp() {
        tip = new Tip("title", "author", "url", "description");
    }

    @Test
    public void constructorSetsValuesCorrectly() {
        assertEquals(tip.getTitle(), "title");
        assertEquals(tip.getAuthor(), "author");
        assertEquals(tip.getUrl(), "url");
        assertEquals(tip.getDescription(), "description");
    }
    
    @Test
    public void setIdSetsIdCorrectly() {
        int id = 10;
        tip.setId(id);
        int wanted = tip.getId();
        assertEquals(id, wanted);
    }

}