package service;

import Enums.ErrorCodes;
import dto.YandexSpellerDTO;

import static org.assertj.core.api.Assertions.assertThat;

public class RestYandexSpellerAssertions {
    private YandexSpellerDTO[] words;

    public RestYandexSpellerAssertions(YandexSpellerDTO[] response) {
        this.words = response;
    }

    public RestYandexSpellerAssertions verifyWord(String expectedWord) {
        assertThat(expectedWord).isNotEmpty();
        assertThat(words[0].getS()).contains(expectedWord);
        return this;
    }

    public static void verifyErrorCode(YandexSpellerDTO[] texts, ErrorCodes expectedText) {
        assertThat(texts[0].getCode()).isEqualTo(expectedText.getItem());
    }

    public void verifySize() {
        assertThat(words).isEmpty();
    }
}
