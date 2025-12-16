package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AllMoviesPage {

    private SelenideElement moviesLocationFilter = $x("//button[.//span[@data-qa-id='movies_filter_location_select']]");
    private SelenideElement genreFilter = $x("(//div[@class='w-36'])[2]//button");
    private SelenideElement moviesFilter = $x("//button[.//span[@data-qa-id='movies_filter_created_at_select']]");
    private SelenideElement loginPage = $("[class='login_page_button']");
    private SelenideElement filterPage = $(byText("Все фильмы"));
    private SelenideElement profileButton = $("[data-qa-id='profile_page_button']");

    @Step("Открыть главную страницу")
    public AllMoviesPage open() {
        filterPage.click();
        return this;
    }

    @Step("Выбор города")
    public AllMoviesPage setMoviesLocation (String city){
        moviesLocationFilter.click();
        $(byText(city)).click();;
        return this;
    }

    @Step("Выбор Жанра")
    public AllMoviesPage setGenre (String genre){
        genreFilter.click();
        $$("div[role='option'] span").findBy(text(genre)).click();
        return this;
    }
    @Step("Выбор фильтра")
    public AllMoviesPage setMoviesFilter(String filter){
        moviesFilter.click();
        $(byText(filter)).click();
        return this;
    }

    @Step("Выбор фильма")
    public MoviePage openMoviePage (String movieName){
        $x("//h3[text()='" + movieName + "']").click();
        return new MoviePage();
    }
    @Step ("Ищем фильм по фильтрам")
    public MoviePage findMovie (String city,String genre, String createdAtFilter, String movieName) {
        open();
        setMoviesLocation(city);
        setGenre(genre);
        setMoviesFilter(createdAtFilter);
        return openMoviePage(movieName);
    }
}
