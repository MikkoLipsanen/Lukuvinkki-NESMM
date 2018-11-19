package lukuvinkki.domain;

import lukuvinkki.domain.Tip;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TipTest {
    
    Tip tip;

    @Before
    public void setUp() {
        tip = new Tip();
        tip.setTitle("title");
        tip.setAuthor("author");
        tip.setUrl("url");
        tip.setDescription("description");
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
        long id = 10;
        tip.setId(id);
        long wanted = tip.getId();
        assertEquals(id, wanted);
    }

}