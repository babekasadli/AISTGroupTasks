package AISTGroup.ders1.task4;

import java.math.BigDecimal;

public class User {
    private String username;
    private char[] password;
    private String fullName;
    private int age;
    private BigDecimal balance;

    private static int count = 0;

    public User(){
        count++;
        System.out.println("User count: " + count);
    }

    public User(String username, char[] password, String fullName, int age, BigDecimal balance) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.age = age;
        this.balance = balance;
        count++;
        System.out.println("User count: " + count);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Username: " + username + "\n" +
                "Full Name: " + fullName + "\n" +
                "Age: " + age + "\n" +
                "Balance: " + balance + "\n";
    }
}

