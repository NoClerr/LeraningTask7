package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junit.UITest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pages.FilterPage;
import pages.ReviewPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@UITest
@Epic("Фильмы")
@Feature("Отзывы на странице фильма")

public class ReviewPublicationTest {

    private static final FilterPage filterPage = new FilterPage();
    private static final ReviewPage reviewPage = new ReviewPage();

    @Test
    public void ReviewPublicationTest() {
        String textReview = "Отзыв на фильм";
        String rating = "4";

            filterPage.setMovie("Титаник");
            reviewPage.textReview(textReview);
            reviewPage.selectRating("4");
            reviewPage.submitReview();


            String reviewText = reviewPage.getReviewText();
            Allure.step("Проверка текста отзыва", () -> {
                assertThat(reviewText).isEqualTo(textReview);
            });

        }
    @AfterEach
    public void deleteReview(){
        reviewPage.deleteReview();
        }
    }


