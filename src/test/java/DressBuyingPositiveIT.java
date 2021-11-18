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
        ProductOrder expectedOrder = setQuantityAndGetExpectedOrderData(3);
        clickBuyAndProceed();
        ProductOrder orderPageOrder = getOrderPageOrderData();
        expectedOrder.setTotalShipping(orderPageOrder.getTotalShipping());//set shipping
        expectedOrder.calculateTotalWithShipping();//calculate total with shipping price

        verifyProductPriceSummaryPage(expectedOrder, orderPageOrder);
        proceedFromSummaryToShipping();
        verifyAgreeTermsCheckBox();
        clickCheckboxAndProceed();
        proceedFromShippingToCheckPaymentAndVerify(expectedOrder);
        submitOrderAdnVerify(expectedOrder);
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


    @Step("Set dress quantity: {quantity}. Get order data without shipping for future comparing")
    private ProductOrder setQuantityAndGetExpectedOrderData(int quantity){
        ProductOrder expectedOrder = new ProductOrder();
        App().Pages().ProductPage().setQuantityInput(quantity);
        expectedOrder.setUnitPrice(App().Pages().ProductPage().getPriceDisplaySpanText());
        expectedOrder.setQuantity(quantity);
        expectedOrder.calculateTotal();
        Allure.addAttachment("Expected order", "text/plain", expectedOrder.toString());
        return expectedOrder;
    }

    @Step("Click \"Buy\" button and click \"Proceed to checkout\" button")
    private void clickBuyAndProceed(){
        App().Pages().ProductPage().clickAddToCardButton();
        App().Pages().ProductPage().clickProceedToCheckOutButton();
    }

    @Step
    private ProductOrder getOrderPageOrderData(){
        ProductOrder orderPageOrder = new ProductOrder();
        orderPageOrder.setUnitPrice(App().Pages().OrderPages().SummaryOrderPage().getProductPriceSpanText());
        orderPageOrder.setQuantity(App().Pages().OrderPages().SummaryOrderPage().getQuantityInputText());
        orderPageOrder.setTotal(App().Pages().OrderPages().SummaryOrderPage().getTotalSpanText());
        orderPageOrder.setTotalShipping(App().Pages().OrderPages().SummaryOrderPage().getTotalShippingText());
        orderPageOrder.setTotalWithShipping(App().Pages().OrderPages().SummaryOrderPage().getTotalWithShippingText());
        return orderPageOrder;
    }

    @Step("Verify expected prices and current on the page")
    private void verifyProductPriceSummaryPage(ProductOrder expectedOrder, ProductOrder currentOrder){
        Assertions.assertTrue(
                expectedOrder.equals(currentOrder),
                "Current order data doesn't correspond to expected"
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
