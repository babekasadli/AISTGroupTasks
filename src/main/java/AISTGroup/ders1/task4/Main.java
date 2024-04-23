package AISTGroup.ders1.task4;

//Tapshiriq 4

public class Main {
    public static void main(String[] args) {
        User user1 = new User("johndoe", "password", "John Doe", 25, 100.0);
        User user2 = new User("freddie_trump", "password", "Freddie Trump", 22, 50.0);
        User user3 = new User("markfredrix", "password", "Mark Fredrix", 30, 200.0);

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);

        User newuser = new User();
        newuser.setUsername("jimmy_doe");
        newuser.setPassword("password");
        newuser.setFullName("Jimmy Doe");
        newuser.setAge(30);
        newuser.setBalance(200.0);

        System.out.println(newuser.getUsername());
        System.out.println(newuser.getFullName());
    }
}