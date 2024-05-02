package AISTGroup.ders1.task6;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Birinci ədədi daxil edin: ");
            double num1 = sc.nextDouble();

            System.out.print("Ikinci ədədi daxil edin: ");
            double num2 = sc.nextDouble();

            System.out.print("Əməliyyatı daxil edin (+, -, *, /): ");
            char operator = sc.next().charAt(0);

            double result;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Sıfıra bölə bilməz!");
                        continue;
                    }
                    break;
                default:
                    System.out.println("Düzgün əməliyyat daxil edilməyib!");
                    continue;
            }

            System.out.println("Nəticə: " + result);
        }
    }
}