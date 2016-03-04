package models;

/**
 * Created by sioslife on 04/03/16.
 */
public class User {

    private final int id;
    private String name;
    private int money;
    private int credit;

    public User(int id, String name, int money, int credit) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        else if (!(o instanceof User)) {
            return false;
        }
        else {
            User user = (User) o;
            return id == user.id;
        }
    }

    @Override
    public int hashCode() {
        return id;
    }
}
