package utils;

import java.util.*;

public class Help {
    static Scanner scan = new Scanner(System.in);
    static Random random = new Random();

    // #################################################################################

    public static int rand(int min, int max) {
        if (min > max) {
            return random.nextInt((min - max) + 1) + max;
        }
        return random.nextInt((max - min) + 1) + min;
    }

    public static double drand(int min, int max) {
        if (min > max) {
            return max + (min - max) * random.nextDouble();
        }
        return min + (max - min) * random.nextDouble();
    }

    // #################################################################################

    public static void pause() {
        System.out.print("\nPress ENTER to continue");
        scan.nextLine();
    }

    public static void cls() {
        System.out.println(new String(new char[30]).replace("\0", "\r\n"));
    }

    public static void sleep(int milisecond) {
        try {
            Thread.sleep(milisecond);
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }

    // #################################################################################

    public static void border(char c, int n) {
        for (int i = 0; i < n; ++i) {
            System.out.print(c);
        }
        System.out.println();
    }

    public static void border(char alphaomega, char c, int n) {
        System.out.print(alphaomega);
        for (int i = 1; i < n; ++i) {
            System.out.print(c);
        }
        System.out.println(alphaomega);
    }

    // #################################################################################

    public static int prompt(String prompt, int min, int max) {
        int input = min - 1;
        do {
            System.out.print(prompt);
            try {
                input = scan.nextInt();
            } catch (InputMismatchException e) {

            }
            scan.nextLine();
        } while (input < min || input > max);
        return input;
    }

    public static int prompt(String prompt, int min) {
        int input = min - 1;
        do {
            System.out.print(prompt);
            try {
                input = scan.nextInt();
            } catch (InputMismatchException e) {

            }
            scan.nextLine();
        } while (input < min);
        return input;
    }

    public static int prompt(String prompt) {
        int input;
        System.out.print(prompt);
        input = scan.nextInt();
        scan.nextLine();
        return input;
    }

    public static String choicePrompt(String prompt, String... args) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scan.nextLine();
            for (String choice : args) {
                if (input.equals(choice)) {
                    return input;
                }
            }
        }
    }

    public static String strPrompt(String beginning, int min_char) {
        String input;
        int len;
        do {
            System.out.print(beginning);
            input = scan.nextLine();
            len = input.length();
        } while (len < min_char);
        return input;
    }

    public static String strPrompt(String beginning, int min_char, int max_char) {
        String input;
        int len;
        do {
            System.out.print(beginning);
            input = scan.nextLine();
            len = input.length();
        } while (len < min_char || len > max_char);
        return input;
    }

    public static String strPrompt(String beginning, String error_msg, int min_char, int max_char) {
        String input;
        while (true) {
            System.out.print(beginning);
            input = scan.nextLine();
            int len = input.length();
            if (len < min_char || len > max_char) {
                System.out.println(error_msg);
                continue;
            }
            return input;
        }
    }

    public static String strPrompt(String beginning, String error_msg, int min_char) {
        String input;
        while (true) {
            System.out.print(beginning);
            input = scan.nextLine();
            int len = input.length();
            if (len < min_char) {
                System.out.println(error_msg);
                continue;
            }
            return input;
        }
    }

    public static String strPrompt(String beginning) {
        String input;
        do {
            System.out.print(beginning);
            input = scan.nextLine();
        } while (input.equals("") == true);
        return input;
    }

    // #################################################################################

    public static void list(String... tolist) {
        for (int i = 0; i < tolist.length; ++i) {
            System.out.println(i + 1 + ". " + tolist[i]);
        }
    }

    public static int comboList(String[] tolist, String prompt, int min, int max) {
        list(tolist);
        return prompt(prompt, min, max);
    }

    // #################################################################################

    public static boolean isAlphaNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isNumeric(String s) {
        return s != null && s.matches(".*\\d.*");
    }

    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        int atIndex = email.indexOf('@');
        int dotIndex = email.lastIndexOf('.');

        if (atIndex <= 0 || dotIndex < atIndex || email.startsWith(".") || email.endsWith(".") || email.contains(".@")
                || email.contains("@.")) {
            return false;
        }

        return true;
    }

    public static boolean hasUpperCase(String s) {
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                return true;
            }
        }
        return false;
    }

    public static boolean hasLowerCase(String s) {
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                return true;
            }
        }
        return false;
    }

    // #################################################################################

    public static Integer strToInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return null;
        }
    }

    public static String intToStr(int n) {
        try {
            return Integer.toString(n);
        } catch (Exception e) {
            return null;
        }
    }

}