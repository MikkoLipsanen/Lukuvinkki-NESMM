package lukuvinkki;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
@ComponentScan(basePackages = {"lukuvinkki.TestConfiguration"})
@SpringBootTest
public abstract class AbstractStepdefs {
    protected static final String BASE_URL = "http://localhost:8080/";
}