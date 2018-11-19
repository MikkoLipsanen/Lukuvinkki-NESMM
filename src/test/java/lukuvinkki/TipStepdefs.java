package lukuvinkki;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import lukuvinkki.domain.Tip;
import lukuvinkki.repository.TipRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.annotation.Resource;
import java.util.List;

public class TipStepdefs extends AbstractStepdefs {
    private WebDriver driver = new HtmlUnitDriver(false);
    private String url = "http://localhost:" + 8080 + "/";
    private Tip dummyTip1, dummyTip2;
    @Resource
    private TipRepository tipRepository;


    @Given("^there are some tips created$")
    public void there_are_some_tips_created() throws Throwable {
        saveDummyTips();
    }

    @Given("^user selects view tips$")
    public void user_selects_view_tips() throws Throwable {
        driver.get(url);
        //TODO: Add a proper id to the link
        WebElement webElement = driver.findElement(By.linkText("täältä"));
        webElement.click();
    }

    @Then("^page contains list of tips in correct order$")
    public void page_contains_list_of_tips_in_correct_order() throws Throwable {
        List<WebElement> tipElements = driver.findElements(By.cssSelector(".table tbody tr"));
        assertTipTableElement(tipElements.get(0), dummyTip2);
        assertTipTableElement(tipElements.get(1), dummyTip1);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private void assertTipTableElement(WebElement element, Tip tip) {
        WebElement titleElement = element.findElement(By.className("title"));
        WebElement authorElement = element.findElement(By.className("author"));
        WebElement urlElement = element.findElement(By.className("url"));
        WebElement descriptionElement = element.findElement(By.className("description"));
        assertEquals(titleElement.getText(), tip.getTitle());
        assertEquals(authorElement.getText(), tip.getAuthor());
        assertEquals(urlElement.getText(), tip.getUrl());
        assertEquals(descriptionElement.getText(), tip.getDescription());
    }

    private void saveDummyTips() {
        dummyTip1 = new Tip();
        dummyTip1.setAuthor("Seppo");
        dummyTip1.setTitle("Sepon tarinat");
        dummyTip1.setUrl("https://google.com");
        dummyTip1.setDescription("Toiseksi mahtavin tarina ikinä");
        tipRepository.save(dummyTip1);
        dummyTip2 = new Tip();
        dummyTip2.setAuthor("Keijo");
        dummyTip2.setTitle("Keijon tarinat");
        dummyTip2.setUrl("https://example.com");
        dummyTip2.setDescription("Mahtavin tarina ikinä");
        tipRepository.save(dummyTip2);
    }

    private void pageContains(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

}
