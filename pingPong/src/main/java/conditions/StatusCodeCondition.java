package conditions;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StatusCodeCondition implements Condition {

    private final int statusCode;

    @Override
    public void chek(Response response) {
        response.then().assertThat().statusCode(statusCode);
    }

    @Override
    public String toString() {
        return "status code is " + statusCode;
    }
}