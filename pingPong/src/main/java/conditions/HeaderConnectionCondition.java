package conditions;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.hamcrest.Matcher;


@RequiredArgsConstructor
public class HeaderConnectionCondition implements Condition {

    private final String connection;
    private final Matcher matcher;


    @Override
    public void chek(Response response) {
        response.then().assertThat().header(connection, matcher);
    }

    @Override
    public String toString() {
        return "Connection status [ " + connection + " ] " + matcher;
    }
}
