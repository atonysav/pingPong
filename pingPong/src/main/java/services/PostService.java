package services;

import assertions.AssertableResponse;
import io.qameta.allure.Step;

public class PostService extends ApiService {

    @Step
    public AssertableResponse sendForm(String message) {
        return new AssertableResponse(setup()
                .body(message)
                .when()
                .post("sendMessage"));
    }
}
