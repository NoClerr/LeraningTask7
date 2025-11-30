package tests;


import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junit.UITest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TicketPage;
import pages.AllMoviesPage;
import pages.moviePage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@UITest
@Epic("Фильмы")
@Feature("Покупка билета на странице фильма")

public class TicketPurchaseTest {

    private static final AllMoviesPage filterPage = new AllMoviesPage();
    private static final moviePage reviewPage = new moviePage();
    private static final TicketPage ticketPage = new TicketPage();

@Test
@DisplayName("Покупка билета")
    public void ticketBuy(){
        filterPage.openMoviePage("Титаник");
        reviewPage.buttonBuyTicket();
        ticketPage.amountTicket("2");
        ticketPage.setNumber("4242424242424242");
        ticketPage.setName("John Doe");
        ticketPage.selectYear("2025");
        ticketPage.selectMonth("Декабрь");
        ticketPage.setCVV("123");
        ticketPage.buttonSucces();

    String succesPay = ticketPage.confirmText();
    Allure.step("Проверка текста оплаты", () -> {
        assertThat(succesPay).isEqualTo("Спасибо за покупку");
    });
    }
}
