package lukuvinkki;

import org.junit.rules.ExternalResource;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;


class ServerRule extends ExternalResource {

    private final int port;
    private SpringApplication app;
    private ConfigurableApplicationContext context;

    public ServerRule(int port) {
        this.port = port;
    }

    @Override
    protected void before() throws Throwable {
        this.app = new SpringApplication(Application.class);
        this.context = this.app.run();
    }

    @Override
    protected void after() {
        this.context.close();
    }
}