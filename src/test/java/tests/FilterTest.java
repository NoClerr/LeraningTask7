package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junit.UITest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.allMoviesPage;
import pages.moviePage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@UITest
@Epic("Фильмы")
@Feature("Все фильтры фильмов на главной странице")
public class FilterTest {

    private static final allMoviesPage filterPage = new allMoviesPage();
    private static final moviePage reviewPage = new moviePage();
    private static final LoginPage loginPage = new LoginPage();

    @Test
    @DisplayName("Фильтры на странице с фильмами")
    public void FiltersTest() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        filterPage.open()
                .setMoviesLocation("MSK")
                .setGenre("Драма")
                .setmoviesFilter("Старые")
                .openMoviePage("Титаник");

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
