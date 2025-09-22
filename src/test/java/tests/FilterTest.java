package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junit.UITest;
import org.junit.jupiter.api.Test;
import pages.FilterPage;
import pages.ReviewPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@UITest
@Epic("Фильмы")
@Feature("Все фильтры фильмов на главной странице")
public class FilterTest {

    private static final FilterPage filterPage = new FilterPage();
    private static final ReviewPage reviewPage = new ReviewPage();

    @Test

    public void FiltersTest() {
        filterPage.open()
               .setMoviesLocation("MSK")
                .setGenre("Драма")
                .setmoviesFilter("Старые")
                .setMovie("Титаник");

        String actualFilm = reviewPage.getFilmName();
        Allure.step("Проверка что название фильма соответствует выбранному", () -> {
            assertThat(actualFilm).contains("Титаник");
        });


        String actualGenre = reviewPage.getGenreText();
        Allure.step("Проверка что жанр фильма соответствует выбранному", () -> {
            assertThat(actualGenre).contains("Драма");
        });

    }
}
