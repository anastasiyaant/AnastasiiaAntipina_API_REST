package service;

import dto.YandexSpellerDTO;
import static org.testng.Assert.assertTrue;

public class RestYandexSpellerAssertions {
    private YandexSpellerDTO[] words;

    public RestYandexSpellerAssertions(YandexSpellerDTO[] response) {
        this.words = response;
    }

    public RestYandexSpellerAssertions verifyWord(String expectedWord) {
        assertTrue(words[0].getS().contains(expectedWord));
        return this;
    }


}
