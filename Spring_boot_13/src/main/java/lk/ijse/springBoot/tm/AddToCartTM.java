package lk.ijse.springBoot.tm;

public class AddToCartTM {
    private String itemCode;
    private int qty;
    private double totalPrice;

    public AddToCartTM() {
    }

    public AddToCartTM(String orderId, String itemCode, int qty, double totalPrice) {
        this.itemCode = itemCode;
        this.qty = qty;
        this.totalPrice = totalPrice;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
