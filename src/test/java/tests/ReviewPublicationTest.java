package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junit.UITest;
import movieapi.api.steps.ReviewApiSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AllMoviesPage;
import pages.MoviePage;



import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@UITest
@Epic("Фильмы")
@Feature("Отзывы на странице фильма")

public class ReviewPublicationTest {

    private static final AllMoviesPage filterPage = new AllMoviesPage();
    private final ReviewApiSteps reviewApiSteps = new ReviewApiSteps();
    private MoviePage moviePage;
    private Long movieId = 56L;

    @AfterEach
    void cleanup() {
        if (movieId != null) {
            reviewApiSteps.deleteReviewForMovie(movieId);
        }
    }


    @Test
    @DisplayName("Публикация отзыва")
    public void reviewPublicationTest() {
        String textReview = "Отзыв на фильм";
        String rating = "4";

        moviePage = filterPage.findMovie(
                "MSK",
                "Драма",
                "Старые",
                "Король Лев"
        );
        moviePage
                .setTextReview(textReview)
                .setMovieRating(rating)
                .submitReview();


        String actualTextReview = moviePage.getNewReviewText(textReview);
        Allure.step("Проверка текста отзыва", () -> {
            assertThat(actualTextReview).isEqualTo(textReview);
        });

    }
}
