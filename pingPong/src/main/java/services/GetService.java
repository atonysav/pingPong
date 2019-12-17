package services;

import assertions.AssertableResponse;
import io.qameta.allure.Step;
import payloads.GetUserPayload;

public class GetService extends ApiService {

    @Step
    public AssertableResponse sendForm() {
        return new AssertableResponse(setup()
                .when()
                .get());
    }

    @Step
    public AssertableResponse sendForm(String path) {
        return new AssertableResponse(setup()
                .when()
                .get(path));
    }

    @Step
    public AssertableResponse sendForm(String path, GetUserPayload message) {

        String asQuery = "?gender=" + message.gender() + "&name=" + message.name() + "&surname=" + message.surname() + "&salary=" + message.salary();

        return new AssertableResponse(setup()
                .when()
                .get(path + asQuery));
    }
}
