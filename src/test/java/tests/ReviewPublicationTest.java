package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junit.UITest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AllMoviesPage;
import pages.moviePage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@UITest
@Epic("Фильмы")
@Feature("Отзывы на странице фильма")

public class ReviewPublicationTest {

    private static final AllMoviesPage filterPage = new AllMoviesPage();
    private static final moviePage reviewPage = new moviePage();

    @Test
    @DisplayName("Публикация отзыва")
    public void reviewPublicationTest() {
        String textReview = "Отзыв на фильм";
        String rating = "4";

            filterPage.openMoviePage("Титаник");
            reviewPage.textReview(textReview);
            reviewPage.selectRating(rating);
            reviewPage.submitReview();


            String actualTextReview = reviewPage.getNewReviewText(textReview);
            Allure.step("Проверка текста отзыва", () -> {
                assertThat(actualTextReview).isEqualTo(textReview);
            });

        }
    @AfterEach
    public void deleteReview(){
        reviewPage.deleteReview();
        }
    }


