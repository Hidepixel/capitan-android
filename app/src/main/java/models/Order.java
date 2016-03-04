package models;

/**
 * Created by sioslife on 04/03/16.
 */
public class Order {

    private final int id;
    private int userId;
    private int productId;

    public Order(int id, int userId, int productId) {
        this.id = id;
        this.setUserId(userId);
        this.setProductId(productId);
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        else if (!(o instanceof Order)) {
            return false;
        }
        else {
            Order order = (Order) o;
            return id == order.id;
        }
    }

    @Override
    public int hashCode() {
        return id;
    }
}
