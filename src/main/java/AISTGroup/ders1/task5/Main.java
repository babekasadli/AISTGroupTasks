package AISTGroup.ders1.task5;

public class Main {
    public static void main(String[] args) {
        //compile time polymorphism-ə uygun nümunə göstərilməyib.
        Java java = new Java();
        java.printLanguage();

        Language language = new Language();
        language.printLanguage();

        French french = new French();
        french.printLanguage();
    }
}
