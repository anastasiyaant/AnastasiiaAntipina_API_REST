package service;

import Enums.Options;
import com.google.gson.Gson;
import dto.YandexSpellerDTO;

import java.util.List;

public class RestYandexSpellerSteps {

    public static YandexSpellerDTO[] getCorrectText(String text, Options option) {
        String response = new RestYandexSpellerService().checkText(text, option.getItem()).getBody().asString();

        return new Gson().fromJson(response, YandexSpellerDTO[].class);
    }

    public static YandexSpellerDTO[] getCorrectTextOptions(String text, List<Options> options) {
        Integer fullOption = 0;
        for (Options option : options) {
            fullOption += option.getItem();
        }
        String response = new RestYandexSpellerService().checkText(text, fullOption).getBody().asString();
        return new Gson().fromJson(response, YandexSpellerDTO[].class);
    }
}
