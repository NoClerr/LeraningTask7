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

    private static final AllMoviesPage filterPage = new AllMoviesPage();
    private static final MoviePage reviewPage = new MoviePage();
    private static final TicketPage ticketPage = new TicketPage();

@Test
@DisplayName("Покупка билета")
    public void ticketBuy(){
        filterPage.openMoviePage("Титаник");
        reviewPage.buttonBuyTicket();
        ticketPage.amountTicket("2");
        ticketPage.setCardNumber("4242424242424242");
        ticketPage.setCardName("John Doe");
        ticketPage.setCardYear("2025");
        ticketPage.setCardMonth("Декабрь");
        ticketPage.setCardCVV("123");
        ticketPage.buttonSucces();

    String succesPay = ticketPage.confirmText();
    Allure.step("Проверка текста оплаты", () -> {
        assertThat(succesPay).isEqualTo("Спасибо за покупку");
    });
    }
}
