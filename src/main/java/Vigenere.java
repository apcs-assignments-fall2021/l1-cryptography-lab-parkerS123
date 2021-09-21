import java.util.Scanner;

public class Vigenere {
    public static char encryptCaesarLetter(char ch, int key) {
        if ((char) ('z' - key) < ch && ('z') >= ch) {
            ch = (char) (ch - (26 - key));
        } else if ((char) ('Z' - key) < ch && ('Z') >= ch) {
            ch = (char) (ch - (26 - key));
        } else if (ch >= 'a' && ch <= 'z') {
            ch = (char) (ch + key);
        } else if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + key);
        } else {
            ch = ch;
        }


        return ch;
    }

    public static char decryptCaesarLetter(char ch, int key) {
        if ((char)('a' + key) > ch && ('a') <= ch) {
            ch = (char)(ch + (26 - key));
        }
        else if ((char)('A' + key) > ch && ('A') <= ch) {
            ch = (char) (ch + (26 - key));
        }
        else if (ch >= 'a' && ch <= 'z') {
            ch = (char)(ch - key);
        }
        else if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch - key);
        }
        else {
            ch = ch;
        }
        return ch;
    }

    public static String encryptVigenere(String message, String key) {
        String new_message = "";
        int KeyIndex = 0;
        for (int i = 0; i < message.length(); i++) {
            char each_letter = key.charAt(KeyIndex);
            int holder = each_letter - 'A';

            new_message = new_message + (encryptCaesarLetter(message.charAt(i), holder));

            if (key.charAt(KeyIndex) >= 'a' && key.charAt(KeyIndex) <= 'z' || key.charAt(KeyIndex) >= 'A' && key.charAt(KeyIndex) <= 'Z') {
                KeyIndex++;
            }
            if (KeyIndex == key.length()) {
                KeyIndex = 0;
            }
        }
        return new_message;
    }

    public static String decryptVigenere(String message, String key) {
        String new_message = "";
        int keyindex = 0;

        for (int i = 0; i < message.length(); i++) {
            char each_letter = key.charAt(keyindex);
            int holder = each_letter - 'A';

            new_message = new_message + (decryptCaesarLetter(message.charAt(i), holder));

            if (key.charAt(keyindex) >= 'a' && key.charAt(keyindex) <= 'z' || key.charAt(keyindex) >= 'A' && key.charAt(keyindex) <= 'Z')
                keyindex ++;
            if (keyindex >= key.length()) {
                keyindex = 0;
            }
        }


        return new_message;

    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
