package speller;

import Enums.Options;
import dto.YandexSpellerDTO;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.RestYandexSpellerAssertions;
import service.RestYandexSpellerService;
import service.RestYandexSpellerSteps;

import java.util.List;

public class RepeatableLetters {

    @DataProvider
    public Object[][] repeatableLettersWordsData() {
        return new Object[][]{
                {"приивет", "привет"},
                {"lefft", "left"},
                {"strawwberry", "strawberry"},
                {"lemoon", "lemon"},
                {"купитьь", "купить"},
        };
    }

    @Test(dataProvider = "repeatableLettersWordsData")
    public void checkRepeatableLetters(String word,String expectedWord){
        YandexSpellerDTO[] words = RestYandexSpellerSteps.getCorrectWord(word, Options.NO_OPTIONS);
        new RestYandexSpellerAssertions(words).verifyWord(expectedWord);
    }
}
