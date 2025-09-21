package Utils;

import java.util.Scanner;

public class UserDialog {
    private static final Scanner scanner = new Scanner(System.in);

    public static boolean askUser(String message) {
        System.out.println(message);
        while (true) {
            String answer = scanner.nextLine().trim();
            switch (answer) {
                case "д", "Д" -> {
                    return true;
                }
                case "н", "Н" -> {
                    return false;
                }
                default -> System.out.println("Введите корректный ответ (д/н): ");
            }
        }
    }

    public static String askInput(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine().trim();
    }

    public static String askFilePath(String prompt) {
        return askInput(prompt);
    }

    public static String askLine(String prompt) {
        return askInput(prompt);
    }
}
