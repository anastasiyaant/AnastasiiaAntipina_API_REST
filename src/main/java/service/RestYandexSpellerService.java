package service;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static utils.UrlReaderUtils.readURLFromFile;

public class RestYandexSpellerService {
    private static RequestSpecification REQUEST_SPECIFICATION;

    public RestYandexSpellerService() {
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(getBaseURI())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter()).build();
    }

    public static Response checkText(String text, int option) {
        return RestAssured.given(REQUEST_SPECIFICATION)
                .param(Constants.TEXTS_PARAMETER, text)
                .param(Constants.OPTIONS_PARAMETER, option)
                .get(Constants.CHECK_TEXT_URI);
    }

    private String getBaseURI(){
        return readURLFromFile(Constants.PATH_TO_PROPERTIES)
                .getProperty("json_URI");
    }

}
