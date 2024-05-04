package AISTGroup.ders1.task4;

//Tapshiriq 4

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("johndoe", "password".toCharArray(), "John Doe", 25, new BigDecimal("100.0"));
        User user2 = new User("freddie_trump", "password".toCharArray(), "Freddie Trump", 22, new BigDecimal("100.0"));
        User user3 = new User("markfredrix", "password".toCharArray(), "Mark Fredrix", 30, new BigDecimal("100.0"));

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);

        User newuser = new User();
        newuser.setUsername("jimmy_doe");
        newuser.setPassword("password".toCharArray());
        newuser.setFullName("Jimmy Doe");
        newuser.setAge(30);
        newuser.setBalance(new BigDecimal("200.0"));

        System.out.println(newuser.getUsername());
        System.out.println(newuser.getFullName());
    }
}