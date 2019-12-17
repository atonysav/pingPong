package conditions;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.hamcrest.Matcher;

@RequiredArgsConstructor
public class BodyMessageCondition implements Condition {

    private final Matcher matcher;

    @Override
    public void chek(Response response) {
        response.then().assertThat().body(matcher);
    }

    @Override
    public String toString() {
        return "body message " + matcher;
    }
}
