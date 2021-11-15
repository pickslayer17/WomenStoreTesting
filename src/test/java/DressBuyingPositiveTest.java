import Utils.TextConverter;
import data.ProductOrder;
import data.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


@Order(3)
public class DressBuyingPositiveTest extends AbstractBaseTest {

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
        int quantity = 3;
        App().Pages().ProductPage().setQuantityInput(quantity);

        ProductOrder initialOrder = new ProductOrder();
        initialOrder.setUnitPrice(App().Pages().ProductPage().getPriceDisplaySpanText());
        initialOrder.setQuantity(quantity);
        initialOrder.calculateTotal();

        App().Pages().ProductPage().clickAddToCardButton();
        App().Pages().ProductPage().clickProceedToCheckOutButton();

        ProductOrder orderPageOrder = new ProductOrder();
        orderPageOrder.setUnitPrice(App().Pages().OrderPages().SummaryOrderPage().getProductPriceSpanText());
        orderPageOrder.setQuantity(App().Pages().OrderPages().SummaryOrderPage().getQuantityInputText());
        orderPageOrder.setTotal(App().Pages().OrderPages().SummaryOrderPage().getTotalSpanText());
        orderPageOrder.setTotalShipping(App().Pages().OrderPages().SummaryOrderPage().getTotalShippingText());
        orderPageOrder.setTotalWithShipping(App().Pages().OrderPages().SummaryOrderPage().getTotalWithShippingText());
        initialOrder.setTotalShipping(orderPageOrder.getTotalShipping());
        initialOrder.calculateTotalWithShipping();

        Assertions.assertEquals(
                initialOrder.getUnitPrice(), orderPageOrder.getUnitPrice(),
                "Price on the OrderPage isn't correct"
        );
        Assertions.assertEquals(
                initialOrder.getQuantity(), orderPageOrder.getQuantity(),
                "Quantity on OrderPage isn't correct"
        );
        Assertions.assertEquals(
                initialOrder.getTotal(), orderPageOrder.getTotal(),
                "Total price on OrderPage isn't correct"
        );
        Assertions.assertEquals(
                initialOrder.getTotalWithShipping(), orderPageOrder.getTotalWithShipping(),
                "Total price With shipping on OrderPage isn't correct"
        );

        App().Pages().OrderPages().SummaryOrderPage().clickProceed();
        App().Pages().OrderPages().AddressOrderPage().clickProceed();
        App().Pages().OrderPages().ShippingOrderPage().clickProceed();

        Assertions.assertTrue(
                App().Pages().OrderPages().ShippingOrderPage().
                        isYouMustAgreePopupDivDisplayed(),
                "Popup \"You didn't agree with terms\" wasn't displayed"
        );

        App().Pages().OrderPages().ShippingOrderPage().clickYouMustAgreePopupDivCloseButton();
        App().Pages().OrderPages().ShippingOrderPage().clickAgreeTermsCheckbox();
        App().Pages().OrderPages().ShippingOrderPage().clickProceed();
        App().Pages().OrderPages().PaymentOrderPage().clickPayByCheck();

        double checkPaymentTotalWithShipping = TextConverter.parsePriceToDoubleFromTextWith$(
                App().Pages().OrderPages().CheckPaymentPage().getPriceSpanText()
        );

        Assertions.assertEquals(
                checkPaymentTotalWithShipping, initialOrder.getTotalWithShipping(),
                "Total price With shipping on CheckPayment Page isn't correct"

        );

        App().Pages().OrderPages().CheckPaymentPage().clickProceed();

        double confirmationPageTotalWithShipping = TextConverter.parsePriceToDoubleFromTextWith$(
                App().Pages().OrderPages().OrderConfirmedPage().getPriceSpanText()
        );
        Assertions.assertEquals(
                confirmationPageTotalWithShipping, initialOrder.getTotalWithShipping(),
                "Total price With shipping on Confirmation Page isn't correct"
        );
    }
}
