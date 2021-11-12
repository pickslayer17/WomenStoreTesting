package data;

public class ProductOrder {
    double unitPrice;
    int quantity;
    double total;
    double totalShipping;
    double totalWithShipping;


    public void calculateTotal() {
        total = unitPrice * quantity;
    }

    public void calculateTotalWithShipping() {
        totalWithShipping = total + totalShipping;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = Utils.TextConverter.getDoubleValuePriceFromTextWith$(unitPrice);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = Integer.parseInt(quantity.trim());
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = Utils.TextConverter.getDoubleValuePriceFromTextWith$(total);
    }

    public double getTotalShipping() {
        return totalShipping;
    }

    public void setTotalShipping(String totalShipping) {
        this.totalShipping = Utils.TextConverter.getDoubleValuePriceFromTextWith$(totalShipping);
    }

    public void setTotalShipping(double totalShipping) {
        this.totalShipping = totalShipping;
    }

    public double getTotalWithShipping() {
        return totalWithShipping;
    }

    public void setTotalWithShipping(String totalWithShipping) {
        this.totalWithShipping = Utils.TextConverter.getDoubleValuePriceFromTextWith$(totalWithShipping);
    }

    public void setTotalWithShipping(double totalWithShipping) {
        this.totalWithShipping = totalWithShipping;
    }
}
