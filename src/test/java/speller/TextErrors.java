package speller;

import Enums.Options;
import dto.YandexSpellerDTO;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.RestYandexSpellerAssertions;
import service.RestYandexSpellerSteps;

import java.util.Arrays;

public class TextErrors {

    @DataProvider
    public Object[][] wordErrorsNoOptionData() {
        return new Object[][]{
                {"превет", "привет"},
                {"coler", "color"},
                {"carpit", "carpet"},
                {"lemoni", "lemon"},
                {"капить", "купить"},
        };
    }

    @Test(dataProvider = "wordErrorsNoOptionData")
    public void checkWordErrorsNoOption(String text, String expectedWord) {
        YandexSpellerDTO[] words = RestYandexSpellerSteps.getCorrectText(text, Options.NO_OPTIONS);
        new RestYandexSpellerAssertions(words).verifyWord(expectedWord);
    }

    @DataProvider
    public Object[][] findRepeatWordsData() {
        return new Object[][]{
                {"hellohello", "hello"},
                {"коверковер", "ковер"},
        };
    }

    @Test(dataProvider = "findRepeatWordsData")
    public void findRepeatWordsOption(String text, String expectedWord) {
        YandexSpellerDTO[] words = RestYandexSpellerSteps.getCorrectText(text, Options.FIND_REPEAT_WORDS);
        new RestYandexSpellerAssertions(words).verifyWord(expectedWord);
    }

    @DataProvider
    public Object[][] ignoreDigitsOptionsData() {
        return new Object[][]{
                {"hello12"},
                {"ковер1"},
        };
    }

    @Test(dataProvider = "ignoreDigitsOptionsData")
    public void ignoreDigitsOption(String text) {
        YandexSpellerDTO[] words = RestYandexSpellerSteps.getCorrectText(text, Options.IGNORE_DIGITS);
        new RestYandexSpellerAssertions(words).verifySize();
    }

    @DataProvider
    public Object[][] ignoreUrlOptionsData() {
        return new Object[][]{
                {"http://ajs.com"},
                {"https://asdf.ru"},
                {"asdsjixsj@gmail.com"},
        };
    }

    @Test(dataProvider = "ignoreUrlOptionsData")
    public void ignoreUrlOption(String text) {
        YandexSpellerDTO[] words = RestYandexSpellerSteps.getCorrectText(text, Options.IGNORE_URLS);
        new RestYandexSpellerAssertions(words).verifySize();
    }

    @DataProvider
    public Object[][] ignoreAllOptionsData() {
        return new Object[][]{
                {"lovelove+http://ajs.com+67", "love love"},
                {"hourhour+https://asdf.ru+1", "hour"},
        };
    }

    @Test(dataProvider = "ignoreAllOptionsData")
    public void ignoreAllOption(String text, String expectedWord) {
        YandexSpellerDTO[] words = RestYandexSpellerSteps.getCorrectTextOptions(text,
                Arrays.asList(Options.IGNORE_URLS, Options.FIND_REPEAT_WORDS, Options.IGNORE_DIGITS));
        new RestYandexSpellerAssertions(words).verifyWord(expectedWord);
    }
}
