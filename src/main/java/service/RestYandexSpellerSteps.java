package service;

import Enums.Options;
import com.google.gson.Gson;
import dto.YandexSpellerDTO;

public class RestYandexSpellerSteps {

    public static YandexSpellerDTO[] getCorrectWord(String word, Options option){
        String response = new RestYandexSpellerService().checkText(word, option).getBody().asString();
        return new Gson().fromJson(response, YandexSpellerDTO[].class);
    }
}
