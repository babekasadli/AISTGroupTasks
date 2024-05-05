package AISTGroup.ders1.task6;

import java.util.Scanner;
//todo: istəyə uygun olaraq n qədər ədəd daxil etmək olmur, və programda davam etmək, çıxış kimi funkisionallıqlar nəzərə alınmayıb.
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=====CALCULATOR=====\nDiqqət: 'q' yazaraq proqramdan çıxış edə bilərsiniz");
        double result = 0;
        while (true){
            System.out.print("Birinci ədədi daxil edin: ");
            String firstEnterance = sc.next();

            if (firstEnterance.equals("q")) {
                System.out.println("Proqram sonlandırıldı");
                System.exit(0);
            }
            else if (!(firstEnterance.matches("[0-9]+"))) {
                System.out.println("Yalnız rəqəm daxil edilməlidir!");
            }
            else{
                result = Double.parseDouble(firstEnterance);
                break;
            }
        }

        while (true) {
            System.out.print("  (+, -, *, /): ");
            char operator = sc.next().charAt(0);

            if (operator == 'q') {
                System.out.println("Proqram sonlandırıldı");
                break;
            }

            if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
                System.out.println("Düzgün əməliyyat daxil edilməyib!");
                continue;
            }

            double nextNum = 0;

            while (true){
                System.out.print("Növbəti ədədi daxil edin: ");
                String nextEnterance = sc.next();

                if (nextEnterance.equals("q")) {
                    System.out.println("Proqram sonlandırıldı");
                    System.exit(0);
                }
                else if (!(nextEnterance.matches("[0-9]+"))){
                    System.out.println("Yalnız rəqəm daxil edilməlidir!");
                }else{
                    nextNum = Double.parseDouble(nextEnterance);
                    break;
                }
            }

            switch (operator) {
                case '+':
                    result += nextNum;
                    break;
                case '-':
                    result -= nextNum;
                    break;
                case '*':
                    result *= nextNum;
                    break;
                case '/':
                    if (nextNum != 0) {
                        result /= nextNum;
                    } else {
                        System.out.println("Sıfıra bölə bilməz!");
                        continue;
                    }
                    break;
            }

            System.out.print("Nəticə: " + result);
        }
    }
}
