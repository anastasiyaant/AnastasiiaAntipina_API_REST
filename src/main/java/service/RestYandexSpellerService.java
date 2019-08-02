package service;

import Enums.Options;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.requestSpecification;

public class RestYandexSpellerService {
    private static RequestSpecification REQUEST_SPECIFICATION;

    public RestYandexSpellerService (){
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri("https://speller.yandex.net/services/spellservice.json/")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter()).build();
    }

    public static Response checkText(String text, Options option) {
        return RestAssured.given(REQUEST_SPECIFICATION)
                .param("text", text)
                .param("options", option)
                .get("checkText");
    }
}
