package tests;


import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junit.UITest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.FilterPage;
import pages.ReviewPage;
import pages.TicketPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@UITest
@Epic("Фильмы")
@Feature("Покупка билета на странице фильма")

public class TicketPurchaseTest {

    private static final FilterPage filterPage = new FilterPage();
    private static final ReviewPage reviewPage = new ReviewPage();
    private static final TicketPage ticketPage = new TicketPage();

@Test
    public void ticketBuy(){
        filterPage.setMovie("Титаник");
        reviewPage.buttonBuyTicket();
        ticketPage.amountTicket("2");
        ticketPage.selectNumber("4242424242424242");
        ticketPage.selectName("John Doe");
        ticketPage.selectYear("2025");
        ticketPage.selectMonth("Декабрь");
        ticketPage.selectCVV("123");
        ticketPage.buttonSucces();

    String succesPay = ticketPage.confirmText();
    Allure.step("Проверка текста оплаты", () -> {
        assertThat(succesPay).isEqualTo("Спасибо за покупку");
    });
    }
}
