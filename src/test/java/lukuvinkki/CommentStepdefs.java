package lukuvinkki;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import lukuvinkki.domain.Comment;
import lukuvinkki.repository.CommentRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommentStepdefs extends AbstractStepdefs {
    @Autowired
    private WebDriver driver;

    @Resource
    CommentRepository commentRepository;

    @When("^new comment is created with nickname \"([^\"]*)\" and content \"([^\"]*)\"$")
    public void new_comment_created_with_nickname_and_content(String nickname, String content) throws Throwable {
        createNewComment(nickname, content);
    }

    @Then("^comment is found with nickname \"([^\"]*)\" and content \"([^\"]*)\"$")
    public void comment_is_found(String nickname, String content) throws Throwable {
        Comment comment = commentRepository.findAll().get(0);
        assertEquals(nickname, comment.getNickname());
        assertEquals(content, comment.getContent());
    }

    @Then("^page contains nickname \"([^\"]*)\" and content \"([^\"]*)\"$")
    public void page_contains_comment(String nickname, String content) throws Throwable {
        pageContains(nickname);
        pageContains(content);
    }
    
    @Then("^tip page contains a list of comments sorted by creation time$")
    public void page_contains_a_list_of_comments_sorted_by_creation_time() throws Throwable {
        List<WebElement> commentElements = driver.findElements(By.cssSelector(".comment-table tbody tr"));
        assertCommentTableElement(commentElements.get(0), "Bar Man", "romanus sum");
        assertCommentTableElement(commentElements.get(1), "Mars Bar", "muspi meroL");
        assertCommentTableElement(commentElements.get(2), "Foo Bar", "Lorem ipsum");
        //List<WebElement> commentElements = driver.findElements(By.xpath("/body/table[last()]/tr[2]"));
    }

    private void createNewComment(String nickname, String content) {
        WebElement webElement = driver.findElement(By.name("nickname"));
        webElement.sendKeys(nickname);
        webElement = driver.findElement(By.name("content"));
        webElement.sendKeys(content);
        webElement.submit();
    }
    
    private void assertCommentTableElement(WebElement element, String nickname, String content) {
        WebElement nameElement = element.findElement(By.className("nickname"));
        WebElement contentElement = element.findElement(By.className("content"));
        assertEquals(nameElement.getText(), nickname);
        assertEquals(contentElement.getText(), content);
    }
    
    
    private void pageContains(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
}
