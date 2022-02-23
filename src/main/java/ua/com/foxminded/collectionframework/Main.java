package ua.com.foxminded.collectionframework;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        CharacterCalculationService characterCalculationService = new CharacterCalculationService();
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Input the expression: ");
                String expression = scanner.nextLine();
                System.out.println(characterCalculationService.build(expression));
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            } catch (RuntimeException exception) {
                System.out.println("System error");
            }
        }
    }
}
