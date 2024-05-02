package AISTGroup.ders1.task8;

public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton anotherSingleton = Singleton.getInstance();
        System.out.println(singleton == anotherSingleton);
    }
}
