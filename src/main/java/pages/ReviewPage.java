package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ReviewPage { ;
    private SelenideElement buyTicket = $(byText("Купить билет"));
    private SelenideElement reviewTextarea = $("[data-qa-id='movie_review_input']");
    private SelenideElement ratingButton = $("button[dir='ltr']");
    private SelenideElement selectRating = $("[role='option']");
    private SelenideElement submitReviewButton = $("[data-qa-id='movie_review_submit_button']");
    private SelenideElement reviewText = $(".whitespace-pre-line");
    private SelenideElement reviewMenuButton = $("[data-qa-id='movie_review_actions_button']");
    private SelenideElement deleteReview = $("div[data-qa-id*='delete']");
    private SelenideElement nameFilm = $("h2.text-6xl");
    private SelenideElement genreFilm = $("p[class$='mt-5']");

    @Step("покупка билета")
    public ReviewPage buttonBuyTicket () {
        buyTicket.click();
        return this;
    }
    @Step("текст отзыва")
    public ReviewPage textReview (String ReviewText) {
        reviewTextarea.setValue(ReviewText);
        return this;
    }
    @Step("Выбор рейтинга")
    public ReviewPage selectRating(String rating) {
        ratingButton.scrollTo().click();
        $x("//*[text() = '" + rating + "']/parent::*[@role]").click();
        return this;
    }
    @Step("отправка отзыва")
    public ReviewPage submitReview() {
        submitReviewButton.click();
        return this;
    }
    @Step("получаем текст отзыва")
    public String getReviewText() {
        return reviewText.getText();
    }
    @Step("удаление отзыва через меню")
    public ReviewPage deleteReview() {
    reviewMenuButton.click();
        deleteReview.click();
    return this;

}
    @Step("Получаем название фильма")
    public String getFilmName() {
        return nameFilm.getText();
    }

    @Step("Получаем имя жанра")
    public String getGenreText() {
        return genreFilm.getText();
    }


}

