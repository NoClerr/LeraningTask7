package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junit.UITest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AllMoviesPage;
import pages.MoviePage;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@UITest
@Epic("Фильмы")
@Feature("Все фильтры фильмов на главной странице")
public class FilterTest {

    private static final AllMoviesPage filterPage = new AllMoviesPage();

    @Test
    @DisplayName("Фильтры на странице с фильмами")
    public void FiltersTest() {
        MoviePage moviePage = filterPage.findMovie(
                "MSK",
                "Драма",
                "Старые",
                "Титаник"
        );

        String actualFilm = moviePage.getFilmName();
        Allure.step("Проверка что название фильма соответствует выбранному", () -> {
            assertThat(actualFilm).contains("Титаник");
        });


        String actualGenre = moviePage.getGenreText();
        Allure.step("Проверка что жанр фильма соответствует выбранному", () -> {
            assertThat(actualGenre).contains("Драма");
        });

    }
}
