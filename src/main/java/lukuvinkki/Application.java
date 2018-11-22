package lukuvinkki;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import lukuvinkki.domain.Tip;
import lukuvinkki.repository.TipRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
        
    }
}
