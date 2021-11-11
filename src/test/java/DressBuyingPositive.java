import Utils.TextConverter;
import data.User;
import org.junit.Assert;
import org.junit.Test;


public class DressBuyingPositive extends AbstractBaseTest {

    @Test
    public void buyADress() {
        App().Flow().navigateToUrl("http://automationpractice.com/");
        App().Pages().HomePage().clickSignInButton();

        User user = DataProvider.getUser();

        App().Pages().AuthenticationPage().fillEmailAddress(user.getUserData("E-mail"));
        App().Pages().AuthenticationPage().fillPassword(user.getUserData("Password"));
        App().Pages().AuthenticationPage().clickSignInButton();

        Assert.assertEquals(App().Pages().MyAccountPage().getPAGE_URL(), App().Flow().getCurrentUrl());

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
        Assert.assertEquals(
                "Price on the OrderPage doesn't corresponds price on the ProductPage",
                productPagePrice, orderPagePrice);

        double orderPagePriceDouble = TextConverter.getDoubleValuePriceFromTextWith$(orderPagePrice);
        int orderPageQuantityInt = Integer.parseInt(orderPageQuantity.trim());
        double orderPageTotalPriceDouble = TextConverter.getDoubleValuePriceFromTextWith$(orderPageTotalPrice);
        double orderPageShippingPrice = TextConverter.getDoubleValuePriceFromTextWith$(orderPageTotalShipping);
        Assert.assertTrue(
                "Total price on OrderPage doesn't correspond price on ProductPage",
                orderPageTotalPriceDouble == orderPagePriceDouble * orderPageQuantityInt
        );
        double TOTAL_PRICE = orderPagePriceDouble * orderPageQuantityInt;

        Assert.assertTrue(
                "Total price with shipping on OrderPage doesn't correspond price on ProductPage" +
                        "\nPage price: " + orderPageTotalPriceDouble +
                        "\nShould be: " + TOTAL_PRICE,
                orderPageTotalPriceDouble == TOTAL_PRICE
        );
        double TOTAL_PRICE_SHIPPING = TOTAL_PRICE + orderPageShippingPrice;
//----------

        App().Pages().OrderPages().SummaryOrderPage().clickProceed();
        App().Pages().OrderPages().AddressOrderPage().clickProceed();
        App().Pages().OrderPages().ShippingOrderPage().clickProceed();

        Assert.assertTrue("Prices are different!",
                App().Pages().OrderPages().ShippingOrderPage().
                        isYouMustAgreePopupDivDisplayed()
        );

        App().Pages().OrderPages().ShippingOrderPage().clickYouMustAgreePopupDivCloseButton();
        App().Pages().OrderPages().ShippingOrderPage().clickAgreeTermsCheckbox();
        App().Pages().OrderPages().ShippingOrderPage().clickProceed();
        App().Pages().OrderPages().PaymentOrderPage().clickPayByCheck();

        double FINAL_CHECK_PRICE = TextConverter.getDoubleValuePriceFromTextWith$(
                App().Pages().OrderPages().CheckPaymentPage().getPriceSpanText()
        );

        Assert.assertTrue("Prices are different!", FINAL_CHECK_PRICE == TOTAL_PRICE_SHIPPING);

        App().Pages().OrderPages().CheckPaymentPage().clickProceed();

        double confirmationPagePrice = TextConverter.getDoubleValuePriceFromTextWith$(
                App().Pages().OrderPages().OrderConfirmedPage().getPriceSpanText()
        );
        Assert.assertTrue("Check price doesn't correspond the real price", confirmationPagePrice == TOTAL_PRICE_SHIPPING);

    }

}
