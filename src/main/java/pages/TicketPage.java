package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class TicketPage {


    private SelenideElement amountTicket = $("[data-qa-id='payment_amount_input']");
    private SelenideElement cardNumber = $("[data-qa-id='payment_card_number_input']");
    private SelenideElement cardName =$("[data-qa-id='payment_card_holder_input']");
    private SelenideElement cardMonth = $("[data-qa-id='payment_card_month_select']");
    private SelenideElement cardYear = $("[data-qa-id='payment_card_year_select']");
    private SelenideElement cardCVV = $("[data-qa-id='payment_card_cvc_input']");
    private SelenideElement buttonPayment = $("[data-qa-id='payment_submit_button']");
    private SelenideElement confrimPaymentText = $x("//p[@class='text-xl mt-5']");

    @Step("Заполняем поле количества билетов")
    public TicketPage amountTicket (String amount) {
        amountTicket.setValue(amount);
        return this;
    }

    @Step("Заполняем поле номер карты")
    public TicketPage selectNumber (String number) {
        cardNumber.setValue(number);
        return this;
    }

    @Step("Заполняем поле имя держателя карты")
    public TicketPage selectName (String name) {
        cardName.setValue(name);
        return this;
    }

    @Step("Заполняем поле месяц карты")
    public TicketPage selectMonth (String month) {
        cardMonth.click();
        $$("div[role='option'] span")
                .findBy(text(month))
                .scrollTo()
                .click();
        return this;
    }

    @Step("Заполняем поле год карты")
    public TicketPage selectYear (String year) {
        cardYear.click();
        $("div[role='listbox'] div[role='option'] span")
                .click();
        return this;
    }

    @Step("Заполняем поле CVV карты")
    public TicketPage selectCVV (String cvv) {
        cardCVV.setValue(cvv);
        return this;
    }

    @Step("Нажимаем по кнопке подтверждения")
    public TicketPage buttonSucces () {
        buttonPayment.click();
        return this;
    }

    @Step("Проверяем оплату по тексту")
    public String confirmText () {
        return confrimPaymentText.getText();
    }




}
