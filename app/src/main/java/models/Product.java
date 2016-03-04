package models;

/**
 * Created by sioslife on 04/03/16.
 */
public class Product {

    private final int id;
    private String name;
    private String category;
    private int price;
    private String color;

    public Product(int id, String name, String category, int price, String color) {
        this.id = id;
        this.setName(name);
        this.setCategory(category);
        this.setPrice(price);
        this.setColor(color);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        else if (!(o instanceof Product)) {
            return false;
        }
        else {
            Product product = (Product) o;
            return id == product.id;
        }
    }

    @Override
    public int hashCode() {
        return id;
    }
}
