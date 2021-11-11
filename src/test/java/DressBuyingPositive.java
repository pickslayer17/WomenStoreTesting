import Utils.TextConverter;
import data.User;
import org.junit.jupiter.api.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DressBuyingPositive extends AbstractBaseTest {

    @Order(3)
    @Test
    public void buyADress() {
        App().Flow().navigateToUrl("http://automationpractice.com/");
        App().Pages().HomePage().clickSignInButton();

        User user = DataProvider.getUser();

        App().Pages().AuthenticationPage().fillEmailAddress(user.getUserData("E-mail"));
        App().Pages().AuthenticationPage().fillPassword(user.getUserData("Password"));
        App().Pages().AuthenticationPage().clickSignInButton();

        Assertions.assertEquals(App().Pages().MyAccountPage().getPAGE_URL(), App().Flow().getCurrentUrl());

        App().Flow().setWindowMaximized();
        App().Pages().MyAccountPage().clickDressesLink();
        App().Pages().DressesCatalogPage().clickEveningDressesImgLink();
        App().Pages().EveningDressesCatalogPage().clickPrintedDress();
        String productPagePrice = App().Pages().ProductPage().getPriceDisplaySpanText();
        App().Pages().ProductPage().clickAddToCardButton();
        App().Pages().ProductPage().clickProceedToCheckOutButton();

//-----assertion block
        String orderPagePrice = App().Pages().OrderPages().SummaryOrderPage().getProductPrice_tdText();
        String orderPageQuantity = App().Pages().OrderPages().SummaryOrderPage().getQuantity_tdText();
        String orderPageTotalPrice = App().Pages().OrderPages().SummaryOrderPage().getTotalProductPrice_tdText();
        String orderPageTotalShipping = App().Pages().OrderPages().SummaryOrderPage().getTotalShippingPriceText();
        Assertions.assertEquals(
                "Price on the OrderPage doesn't corresponds price on the ProductPage",
                productPagePrice, orderPagePrice
        );
        double orderPagePriceDouble = TextConverter.getDoubleValuePriceFromTextWith$(orderPagePrice);
        int orderPageQuantityInt = Integer.parseInt(orderPageQuantity.trim());
        double orderPageTotalPriceDouble = TextConverter.getDoubleValuePriceFromTextWith$(orderPageTotalPrice);
        double orderPageShippingPrice = TextConverter.getDoubleValuePriceFromTextWith$(orderPageTotalShipping);
        Assertions.assertTrue(
                orderPageTotalPriceDouble == orderPagePriceDouble * orderPageQuantityInt,
                "Total price on OrderPage doesn't correspond price on ProductPage"
        );
        double TOTAL_PRICE = orderPagePriceDouble * orderPageQuantityInt;
        Assertions.assertTrue(
                orderPageTotalPriceDouble == TOTAL_PRICE,
                "Total price with shipping on OrderPage doesn't correspond price on ProductPage" +
                        "\nPage price: " + orderPageTotalPriceDouble +
                        "\nShould be: " + TOTAL_PRICE
                );
        double TOTAL_PRICE_SHIPPING = TOTAL_PRICE + orderPageShippingPrice;
//----------

        App().Pages().OrderPages().SummaryOrderPage().clickProceed();
        App().Pages().OrderPages().AddressOrderPage().clickProceed();
        App().Pages().OrderPages().ShippingOrderPage().clickProceed();

        Assertions.assertTrue(
                App().Pages().OrderPages().ShippingOrderPage().
                isYouMustAgreePopupDivDisplayed(),
                "Prices are different!"
                );

        App().Pages().OrderPages().ShippingOrderPage().clickYouMustAgreePopupDivCloseButton();
        App().Pages().OrderPages().ShippingOrderPage().clickAgreeTermsCheckbox();
        App().Pages().OrderPages().ShippingOrderPage().clickProceed();
        App().Pages().OrderPages().PaymentOrderPage().clickPayByCheck();

        double FINAL_CHECK_PRICE = TextConverter.getDoubleValuePriceFromTextWith$(
                App().Pages().OrderPages().CheckPaymentPage().getPriceSpanText()
        );

        Assertions.assertTrue(FINAL_CHECK_PRICE == TOTAL_PRICE_SHIPPING, "Prices are different!");

        App().Pages().OrderPages().CheckPaymentPage().clickProceed();

        double confirmationPagePrice = TextConverter.getDoubleValuePriceFromTextWith$(
                App().Pages().OrderPages().OrderConfirmedPage().getPriceSpanText()
        );
        Assertions.assertTrue(
                confirmationPagePrice == TOTAL_PRICE_SHIPPING,
                "Check price doesn't correspond the real price"
        );

    }

}
