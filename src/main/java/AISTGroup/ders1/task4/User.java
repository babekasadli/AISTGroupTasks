package AISTGroup.ders1.task4;

public class User {
    private String username;
    private String password; //password char[] şəklində saxlanılması tövsiyə olunur.
    private String fullName;
    private int age;
    private double balance; //todo: balance dəqiqlik üçün BigDecimal datatype-ında saxlanılmalıdır.

    private static int count = 0;

    public User(){
        count++;
        System.out.println("User count: " + count);
    }

    public User(String username, String password, String fullName, int age, double balance) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
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
