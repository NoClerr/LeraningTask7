package tests;


import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junit.UITest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TicketPage;
import pages.AllMoviesPage;
import pages.MoviePage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@UITest
@Epic("Фильмы")
@Feature("Покупка билета на странице фильма")

public class TicketPurchaseTest {

    private static final AllMoviesPage allMoviesPage  = new AllMoviesPage();

@Test
@DisplayName("Покупка билета")
    public void ticketBuy(){

    MoviePage moviePage = allMoviesPage .findMovie(
            "MSK",
            "Драма",
            "Старые",
            "Король Лев"
    );

    TicketPage ticketPage = moviePage.buttonBuyTicket();
    ticketPage
        .amountTicket("2")
        .setCardNumber("4242424242424242")
        .setCardName("John Doe")
       .setCardYear("2026")
       .setCardMonth("Декабрь")
       .setCardCVV("123")
       .buttonSucces();

    String succesPay = ticketPage.confirmText();
    Allure.step("Проверка текста оплаты", () -> {
        assertThat(succesPay).isEqualTo("Спасибо за покупку");
    });
    }
}
