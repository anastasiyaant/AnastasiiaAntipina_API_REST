package speller;

import Enums.ErrorCodes;
import Enums.Options;
import dto.YandexSpellerDTO;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.RestYandexSpellerAssertions;
import service.RestYandexSpellerSteps;

public class RepeatableWords {

    @DataProvider
    public Object[][] repeatableWordsData() {
        return new Object[][]{
                {"qwewr qwewr", ErrorCodes.ERROR_UNKNOWN_WORD},
                {"leftr leftr", ErrorCodes.ERROR_UNKNOWN_WORD},
                {"zxrcv zxrcv", ErrorCodes.ERROR_UNKNOWN_WORD},
        };
    }

    @Test(dataProvider = "repeatableWordsData")
    public void checkRepeatableWords(String text, ErrorCodes expectedError) {
        YandexSpellerDTO[] texts = RestYandexSpellerSteps.getCorrectText(text, Options.FIND_REPEAT_WORDS);
        RestYandexSpellerAssertions.verifyErrorCode(texts, expectedError);
    }
}
