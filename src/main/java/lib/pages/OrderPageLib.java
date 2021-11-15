package lib.pages;

import org.openqa.selenium.WebDriver;
import pages.catalog.order.*;


public class OrderPageLib {
    private WebDriver driver;

    private SummaryOrderPage summaryOrderPage;
    private AddressOrderPage addressOrderPage;
    private ShippingOrderPage shippingOrderPage;
    private PaymentOrderPage paymentOrderPage;
    private CheckPaymentPage checkPaymentPage;
    private OrderConfirmedPage orderConfirmedPage;

    public OrderPageLib(WebDriver driver) {
        this.driver = driver;
        initializePages();
    }

    private void initializePages() {
        summaryOrderPage = new SummaryOrderPage(driver);
        addressOrderPage = new AddressOrderPage(driver);
        shippingOrderPage = new ShippingOrderPage(driver);
        paymentOrderPage = new PaymentOrderPage(driver);
        checkPaymentPage = new CheckPaymentPage(driver);
        orderConfirmedPage = new OrderConfirmedPage(driver);
    }

    public SummaryOrderPage SummaryOrderPage() {
        return summaryOrderPage;
    }

    public AddressOrderPage AddressOrderPage() {
        return addressOrderPage;
    }

    public ShippingOrderPage ShippingOrderPage() {
        return shippingOrderPage;
    }

    public PaymentOrderPage PaymentOrderPage() {
        return paymentOrderPage;
    }

    public CheckPaymentPage CheckPaymentPage() {
        return checkPaymentPage;
    }

    public OrderConfirmedPage OrderConfirmedPage() {
        return orderConfirmedPage;
    }
}
