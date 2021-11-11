import Utils.TextConverter;
import data.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


@Order(3)
public class DressBuyingPositive extends AbstractBaseTest {


    @Test
    public void buyADress() {
        App().Flow().navigateToUrl("http://automationpractice.com/");
        App().Pages().HomePage().clickSignInButton();

        User user = DataProvider.getUser();

        App().Pages().AuthenticationPage().fillEmailAddress(user.getEmail());
        App().Pages().AuthenticationPage().fillPassword(user.getPassword());
        App().Pages().AuthenticationPage().clickSignInButton();

        Assertions.assertEquals(App().Pages().MyAccountPage().getPAGE_URL(), App().Flow().getCurrentUrl());

        App().Pages().MyAccountPage().clickDressesLink();
        App().Pages().DressesCatalogPage().clickEveningDressesImgLink();
        App().Pages().EveningDressesCatalogPage().clickPrintedDress();
        String productPagePrice = App().Pages().ProductPage().getPriceDisplaySpanText();
        App().Pages().ProductPage().clickAddToCardButton();
        App().Pages().ProductPage().clickProceedToCheckOutButton();

//-----assertion block
        String orderPageUnitPrice = App().Pages().OrderPages().SummaryOrderPage().getProductPriceSpanText();
        String orderPageQuantity = App().Pages().OrderPages().SummaryOrderPage().getQuantityInputText();
        String orderPageTotal = App().Pages().OrderPages().SummaryOrderPage().getTotalSpanText();
        String orderPageTotalShipping = App().Pages().OrderPages().SummaryOrderPage().getTotalShippingText();
        Assertions.assertEquals(
                productPagePrice, orderPageUnitPrice,
                "Price on the OrderPage doesn't corresponds price on the ProductPage"
        );
        double orderPagePriceDouble = TextConverter.getDoubleValuePriceFromTextWith$(orderPageUnitPrice);
        int orderPageQuantityInt = Integer.parseInt(orderPageQuantity.trim());
        double orderPageTotalDouble = TextConverter.getDoubleValuePriceFromTextWith$(orderPageTotal);
        double orderPageTotalShippingDouble = TextConverter.getDoubleValuePriceFromTextWith$(orderPageTotalShipping);
        Assertions.assertTrue(
                orderPageTotalDouble == orderPagePriceDouble * orderPageQuantityInt,
                "Total price on OrderPage doesn't correspond price on ProductPage"
        );
        double TOTAL_PRICE = orderPagePriceDouble * orderPageQuantityInt;
        Assertions.assertTrue(
                orderPageTotalDouble == TOTAL_PRICE,
                "Total price with shipping on OrderPage doesn't correspond price on ProductPage" +
                        "\nPage price: " + orderPageTotalDouble +
                        "\nShould be: " + TOTAL_PRICE
        );
        double TOTAL_WITH_SHIPPING = TOTAL_PRICE + orderPageTotalShippingDouble;
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

        double checkPaymentTotalWithShipping = TextConverter.getDoubleValuePriceFromTextWith$(
                App().Pages().OrderPages().CheckPaymentPage().getPriceSpanText()
        );

        Assertions.assertTrue(
                checkPaymentTotalWithShipping == TOTAL_WITH_SHIPPING,
                "Prices are different!" +
                "\nShould be: " + TOTAL_WITH_SHIPPING +
                        "\nBut found: " +  checkPaymentTotalWithShipping
                );

        App().Pages().OrderPages().CheckPaymentPage().clickProceed();

        double confirmationPageTotalWithShipping = TextConverter.getDoubleValuePriceFromTextWith$(
                App().Pages().OrderPages().OrderConfirmedPage().getPriceSpanText()
        );
        Assertions.assertTrue(
                confirmationPageTotalWithShipping == TOTAL_WITH_SHIPPING,
                "Check price doesn't correspond the real price"
        );
    }
}
