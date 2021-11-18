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
        this.unitPrice = Utils.TextConverter.parsePriceToDoubleFromTextWith$(unitPrice);
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
        this.total = Utils.TextConverter.parsePriceToDoubleFromTextWith$(total);
    }

    public double getTotalShipping() {
        return totalShipping;
    }

    public void setTotalShipping(String totalShipping) {
        this.totalShipping = Utils.TextConverter.parsePriceToDoubleFromTextWith$(totalShipping);
    }

    public void setTotalShipping(double totalShipping) {
        this.totalShipping = totalShipping;
    }

    public double getTotalWithShipping() {
        return totalWithShipping;
    }

    public void setTotalWithShipping(String totalWithShipping) {
        this.totalWithShipping = Utils.TextConverter.parsePriceToDoubleFromTextWith$(totalWithShipping);
    }

    public void setTotalWithShipping(double totalWithShipping) {
        this.totalWithShipping = totalWithShipping;
    }

    @Override
    public String toString() {
        return "Price: " + String.valueOf(unitPrice) + "; " +
                "Quantity: " + String.valueOf(quantity) + "; " +
                "Total price: " + String.valueOf(total) + "; " +
                "Shipping: " + String.valueOf(totalShipping) + "; " +
                "Total price with shipping: " + String.valueOf(totalWithShipping) + ";";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductOrder)) {
            return false;
        }
        ProductOrder order = (ProductOrder) obj;

        return order.unitPrice == unitPrice &&
                order.quantity == quantity &&
                order.total == total &&
                order.totalShipping == totalShipping &&
                order.totalWithShipping == totalWithShipping;
    }

    @Override
    public int hashCode() {
        //return Objects.hash(totalWithShipping, quantity, total, totalShipping, totalWithShipping);

        int result = 11;

        result = 31 * result + Double.valueOf(unitPrice).hashCode();
        result = 31 * result + Integer.valueOf(quantity).hashCode();
        result = 31 * result + Double.valueOf(total).hashCode();
        result = 31 * result + Double.valueOf(totalShipping).hashCode();
        result = 31 * result + Double.valueOf(totalWithShipping).hashCode();

        return result;
    }
}
