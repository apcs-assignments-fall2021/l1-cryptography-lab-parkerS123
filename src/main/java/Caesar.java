import java.util.Scanner;

public class Caesar {
    // Given a String, encrypts the String with the Caesar cipher
    // and returns the encrypted String
    // Ex. encryptCaesar("Hello, World!") => "Khoor, Zruog!"
    public static String encryptCaesar(String message) {
        String new_message = "";
        for (int i = 0; i < message.length(); i++) {
            if ('x' == message.charAt(i) || 'y' == message.charAt(i) || 'z' == message.charAt(i) || 'Z' == message.charAt(i) || 'Y' == message.charAt(i) || 'X' == message.charAt(i)){
                new_message = new_message + (char)(message.charAt(i) - 23);
            }
            else if (!(message.charAt(i) <= 'a' && message.charAt(i) >= 'z')) {
                new_message = new_message + (message.charAt(i));
            }
            else if (!(message.charAt(i) <= 'A' && message.charAt(i) >= 'Z')) {
                new_message = new_message + (message.charAt(i));
            }
            else {
                new_message = new_message + (char)(message.charAt(i) + 3);
            }

        }
        return new_message;
    }

    // Given a String, decrypts the String with the Caesar cipher
    // and returns the original String
    // Ex. decryptCaesar("Khoor, Zruog!") => "Hello, World!"
    public static String decryptCaesar(String message) {
        String new_message = "";
        for (int i = 0; i < message.length(); i++) {
            if ('a' == message.charAt(i) || 'b' == message.charAt(i) || 'c' == message.charAt(i) || 'A' == message.charAt(i) || 'B' == message.charAt(i) || 'C' == message.charAt(i)) {
                new_message = new_message + (char)(message.charAt(i) + 23);
            }
            else if (!(message.charAt(i) <= 'a' && message.charAt(i) >= 'z' && message.charAt(i) <= 'A' && message.charAt(i) >= 'Z')) {
                new_message = new_message + (message.charAt(i));
            }
            // else if (!(message.charAt(i) <= 'A' && message.charAt(i) >= 'Z')) {
                // new_message = new_message + (message.charAt(i));
            // }
            else {
                new_message = new_message + (char)(message.charAt(i) - 3);
            }
        }
        return new_message;
    }

    // Given a String and a key corresponding to a shift, encrypts
    // the String using the given key and returns the encrypted String
    // Ex. encryptCaesarKey("Hello, World!", 5) => "Mjqqt, Btwqi!".
    public static String encryptCaesarKey(String message, int key) {
        String new_message = "";
        for (int i = 0; i < message.length(); i++) {
            if ((char)('z' - key) <= message.charAt(i) && ('z') >= message.charAt(i)) {
                new_message = new_message + (char) (message.charAt(i) - (26 - key));
            }
            else if (!(message.charAt(i) <= 'a' && message.charAt(i) >= 'z')) {
                new_message = new_message + (message.charAt(i));
            }
            else if (!(message.charAt(i) <= 'A' && message.charAt(i) >= 'Z')) {
                new_message = new_message + (message.charAt(i));
            }
            else {
                new_message = new_message + (char) (message.charAt(i) + key);
            }
        }
        return new_message;
    }

    // Given a String and a key corresponding to a shift, decrypts
    // the String using the given key and returns the original String
    // Ex. decryptCaesarKey("Mjqqt, Btwqi!", 5) => "Hello, World!"
    public static String decryptCaesarKey(String message, int key) {
            String new_message = "";
            for (int i = 0; i < message.length(); i++) {
                if ((char)('a' + key) <= message.charAt(i) && ('a') >= message.charAt(i)) {
                    new_message = new_message + (char)(message.charAt(i) - (26 - key));
                }
                else if (!(message.charAt(i) <= 'a' && message.charAt(i) >= 'z')) {
                    new_message = new_message + (message.charAt(i));
                }
                else if (!(message.charAt(i) <= 'A' && message.charAt(i) >= 'Z')) {
                    new_message = new_message + (message.charAt(i));
                }
                else {
                    new_message = new_message + (char)(message.charAt(i) - key);
                }
        }

        return new_message;
    }


    // The main method is already provided for you
    // You do not need to edit this code until Part 2
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesar(message));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesar(message));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }



        scan.close();

        // System.out.println(encryptCaesar(message));
    }
}
