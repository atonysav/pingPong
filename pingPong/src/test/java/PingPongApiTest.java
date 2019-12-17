import conditions.Conditions;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payloads.GetUserPayload;
import services.*;

public class PingPongApiTest {

    private final GetService getService = new GetService();
    private final PostService postService = new PostService();

    @BeforeClass
    public void setUp() {
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
        RestAssured.baseURI = config.baseUrl();
    }

    @Test
    public void testCanSendGetMess() {

        getService.sendForm()
                .shouldHave(Conditions.statusCode(200))
                .shouldHave(Conditions.headerConnection("Connection", Matchers.equalTo("keep-alive")));
    }

    @Test
    public void testCanGetDefaultUser() {

        getService.sendForm("getDefaultUser")
                .shouldHave(Conditions.statusCode(200))
                .shouldHave(Conditions.bodyField("gender", Matchers.equalTo("male")))
                .shouldHave(Conditions.bodyField("name", Matchers.equalTo("Oleksandr")))
                .shouldHave(Conditions.bodyField("surname", Matchers.equalTo("Yanov")))
                .shouldHave(Conditions.bodyField("salary", Matchers.equalTo(1231209471)));
    }

    @Test
    public void testCanGetCustomUser() {

        GetUserPayload newUser = new GetUserPayload()
                .gender("male")
                .name("Anton")
                .surname("Savonik")
                .salary(321);

        getService.sendForm("getUser", newUser)
                .shouldHave(Conditions.statusCode(200))
                .shouldHave(Conditions.bodyField("gender", Matchers.equalTo("male")))
                .shouldHave(Conditions.bodyField("name", Matchers.equalTo("Anton")))
                .shouldHave(Conditions.bodyField("surname", Matchers.equalTo("Savonik")))
                .shouldHave(Conditions.bodyField("salary", Matchers.equalTo(321)));
    }

    @Test
    public void testCanPostMessage() {

        postService.sendForm("Hello")
                .shouldHave(Conditions.statusCode(200))
                .shouldHave(Conditions.bodyMess(Matchers.equalTo("Hello")));
    }

}

