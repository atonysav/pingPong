package assertions;

import conditions.Condition;
import io.qameta.allure.Step;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class AssertableResponse {

    private final Response response;

    @Step
    public AssertableResponse shouldHave(Condition condition) {
        log.info("About to check condition {}",condition);
        condition.chek(response);
        return this;
    }

    public <T> T asPojo(Class<T> tClass){

        return response.as(tClass);
    }

    public Headers headers(){
        return response.getHeaders();
    }
}
