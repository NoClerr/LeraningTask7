package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FilterPage {

    private SelenideElement moviesLocationFilter = $x("//button[.//span[@data-qa-id='movies_filter_location_select']]");
    private SelenideElement genreFilter = $x("(//div[@class='w-36'])[2]//button");
    private SelenideElement moviesFilter = $x("//button[.//span[@data-qa-id='movies_filter_created_at_select']]");
    private SelenideElement loginPage = $("[class='login_page_button']");
    private SelenideElement filterPage = $(byText("Все фильмы"));

    @Step("Открыть главную страницу")
    public FilterPage open() {
        Selenide.open("https://cinescope.t-qa.ru/movies?page=1");
        return this;
    }

    @Step("Выбор города")
    public FilterPage setMoviesLocation (String city){
        moviesLocationFilter.click();
        $(byText(city)).click();;
        return this;
    }

    @Step("Выбор Жанра")
    public FilterPage setGenre (String genre){
        genreFilter.click();
        $$("div[role='option'] span").findBy(text(genre)).click();
        return this;
    }
    @Step("Выбор фильтра")
    public FilterPage setmoviesFilter (String filter){
        moviesFilter.click();
        $(byText(filter)).click();
        return this;
    }

    @Step("Выбор фильма")
    public FilterPage setMovie (String movieName){
        $x("//h3[text()='" + movieName + "']").click();
        return this;
    }

    @Step("Переход на страницу входа")
    public LoginPage goToLogin() {
        loginPage.click();
        return new LoginPage();
    }

    @Step("Переход на страницу c фильтрами")
    public FilterPage FilFiletPage () {
        filterPage.click();
        return this;
    }
}
