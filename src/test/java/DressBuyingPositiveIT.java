import Utils.TextConverter;
import data.ProductOrder;
import data.User;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


@Order(3)
public class DressBuyingPositiveIT extends AbstractBaseTest {

    @Epic("Smoke test")
    @Feature("Shop validation")
    @Story("Buy 3 printed dresses by check")
    @Test
    public void buyADress() {
        goToSignInPage("http://automationpractice.com/");

        User user = DataProvider.getUser();
        singInUser(user.getEmail(), user.getPassword());

        chooseADress();
        ProductOrder initialOrder = new ProductOrder();
        setQuantity(3, initialOrder);
        clickBuyAndProceed();
        ProductOrder orderPageOrder = new ProductOrder();
        verifyProductPriceSummaryPage(initialOrder, orderPageOrder);
        proceedFromSummaryToShipping();
        verifyAgreeTermsCheckBox();
        clickCheckboxAndProceed();
        proceedFromShippingToCheckPaymentAndVerify(initialOrder);
        submitOrderAdnVerify(initialOrder);
    }

    @Step("Go to HomePage url and click sign in button")
    private void goToSignInPage(String url) {
        App().Flow().navigateToUrl(url);
        App().Pages().HomePage().clickSignInButton();
    }

    @Step("Enter user email and password. And Click sign in")
    private void singInUser(String eMail, String password) {
        App().Pages().AuthenticationPage().fillEmailAddress(eMail);
        App().Pages().AuthenticationPage().fillPassword(password);
        App().Pages().AuthenticationPage().clickSignInButton();
        Assertions.assertEquals(App().Pages().MyAccountPage().getPAGE_URL(), App().Flow().getCurrentUrl(), "Couldn't sign in");
    }

    @Step("Choose dress by clicking on image links")
    private void chooseADress(){
        App().Pages().MyAccountPage().clickDressesLink();
        App().Pages().DressesCatalogPage().clickEveningDressesImgLink();
        App().Pages().EveningDressesCatalogPage().clickPrintedDress();
    }


    @Step("Set dress quantity: {quantity}. Calculate sum")
    private void setQuantity(int quantity, ProductOrder productOrder){
        App().Pages().ProductPage().setQuantityInput(quantity);
        productOrder.setUnitPrice(App().Pages().ProductPage().getPriceDisplaySpanText());
        productOrder.setQuantity(quantity);
        productOrder.calculateTotal();
    }

    @Step("Click \"Buy\" button and click \"Proceed to checkout\" button")
    private void clickBuyAndProceed(){
        App().Pages().ProductPage().clickAddToCardButton();
        App().Pages().ProductPage().clickProceedToCheckOutButton();
    }

    @Step("Verify expected prices and current on the page")
    private void verifyProductPriceSummaryPage(ProductOrder expectedOrder, ProductOrder currentOrder){
        currentOrder.setUnitPrice(App().Pages().OrderPages().SummaryOrderPage().getProductPriceSpanText());
        currentOrder.setQuantity(App().Pages().OrderPages().SummaryOrderPage().getQuantityInputText());
        currentOrder.setTotal(App().Pages().OrderPages().SummaryOrderPage().getTotalSpanText());
        currentOrder.setTotalShipping(App().Pages().OrderPages().SummaryOrderPage().getTotalShippingText());
        currentOrder.setTotalWithShipping(App().Pages().OrderPages().SummaryOrderPage().getTotalWithShippingText());
        expectedOrder.setTotalShipping(currentOrder.getTotalShipping());
        expectedOrder.calculateTotalWithShipping();


        Assertions.assertEquals(
                expectedOrder.getUnitPrice(), currentOrder.getUnitPrice(),
                "Price on the OrderPage isn't correct"
        );
        Assertions.assertEquals(
                expectedOrder.getQuantity(), currentOrder.getQuantity(),
                "Quantity on OrderPage isn't correct"
        );
        Assertions.assertEquals(
                expectedOrder.getTotal(), currentOrder.getTotal(),
                "Total price on OrderPage isn't correct"
        );
        Assertions.assertEquals(
                expectedOrder.getTotalWithShipping(), currentOrder.getTotalWithShipping(),
                "Total price With shipping on OrderPage isn't correct"
        );

    }

    @Step("Click \"Proceed\" button 2 times for get Shipping page")
    private void proceedFromSummaryToShipping(){
        App().Pages().OrderPages().SummaryOrderPage().clickProceed();
        App().Pages().OrderPages().AddressOrderPage().clickProceed();
    }

    @Description("Popup should appear in case we pressed \"proceed\" button not checking agree terms checkbox")
    @Step("Verify work of agree terms checkbox")
    private void verifyAgreeTermsCheckBox(){
        App().Pages().OrderPages().ShippingOrderPage().clickProceed();
        Assertions.assertTrue(
                App().Pages().OrderPages().ShippingOrderPage().
                        isYouMustAgreePopupDivDisplayed(),
                "Popup \"You didn't agree with terms\" wasn't displayed"
        );
        App().Pages().OrderPages().ShippingOrderPage().clickYouMustAgreePopupDivCloseButton();
    }

    @Step("Click checkbox and click \"Proceed\" button")
    private void clickCheckboxAndProceed(){
        App().Pages().OrderPages().ShippingOrderPage().clickAgreeTermsCheckbox();
        App().Pages().OrderPages().ShippingOrderPage().clickProceed();
    }

    @Step("Click proceed to go to Check_payment page and verify prices there")
    private void proceedFromShippingToCheckPaymentAndVerify(ProductOrder expectedOrder){
        App().Pages().OrderPages().PaymentOrderPage().clickPayByCheck();
        double checkPaymentTotalWithShipping = TextConverter.parsePriceToDoubleFromTextWith$(
                App().Pages().OrderPages().CheckPaymentPage().getPriceSpanText()
        );
        Allure.addAttachment("Current Total Price with Shipping on CheckPayment", "text/plain", String.valueOf(checkPaymentTotalWithShipping));
        Assertions.assertEquals(
                checkPaymentTotalWithShipping, expectedOrder.getTotalWithShipping(),
                "Total price With shipping on CheckPayment Page isn't correct"

        );
    }

    @Step("Submit the order and verify final price")
    private void submitOrderAdnVerify(ProductOrder expectedOrder){
        App().Pages().OrderPages().CheckPaymentPage().clickProceed();

        double confirmationPageTotalWithShipping = TextConverter.parsePriceToDoubleFromTextWith$(
                App().Pages().OrderPages().OrderConfirmedPage().getPriceSpanText()
        );
        Allure.addAttachment("Current Total Price with Shipping on CheckPayment", "text/plain", String.valueOf(confirmationPageTotalWithShipping));
        Assertions.assertEquals(
                confirmationPageTotalWithShipping, expectedOrder.getTotalWithShipping(),
                "Total price With shipping on Confirmation Page isn't correct"
        );
    }
}
