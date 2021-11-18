package e1;

import java.util.StringTokenizer;

public class StringCount {

    /**
     * Counts the number of words in a given String.
     * Words are groups of characters separated by one or more spaces. *
     *
     * @param text String with the words
     */

    public static int countWords(String text) {
        if(text == null) return 0;
        int totalWords = text.split("\\s+|\n").length;
        if (Character.isSpaceChar(text.charAt(0))){
            return totalWords - 1;
        }
        else return totalWords;
    }

    /**
     * Counts the number of times the given character appears in the String.
     * Accented characters are considered different characters.
     *
     * @param text String with the characters
     * @param c    the character to be found
     * @return Number of times the character appears in the String or zero if null
     */

    public static int countChar(String text, char c) {
        int count = 0;
        if(text == null) return 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == c) count++;
        }
        return count;
    }

    /**
     * Counts the number of times the given character appears in the String.
     * The case is ignored so an ’a’ is equal to an ’A’.
     * Accented characters are considered different characters.
     *
     * @param text String with the characters
     * @param c    the character to be found
     * @return Number of times the character appears in the String or zero if null
     */

    public static int countCharIgnoringCase(String text, char c) {
        int count = 0;
        if(text == null) return 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.toLowerCase().charAt(i) == Character.toLowerCase(c)){
                count++;
            }
        }
        return count;
    }

    /**
     * Checks if a password is safe according to the following rules:
     * - Has at least 8 characters
     * - Has an uppercase character
     * - Has a lowercase character
     * - Has a digit
     * - Has a special character among these: ’?’, ’@’, ’#’, ’$’, ’.’ and ’,’ * @param password The password, we assume it is not null.
     * @return true if the password is safe, false otherwise
     */

    public static boolean isPasswordSafe(String password) {

        boolean mayus = false;
        boolean minus = false;
        boolean digit = false;
        boolean special = false;
        String specialCharacters = "?@#$.,";

        if (password.length() < 8) {
            return false;
        }
        else{
            for (int i = 0; i < password.length(); i++) {
                char actualChar = password.charAt(i);

                if (Character.isUpperCase(actualChar)) {
                    mayus = true;
                }
                if (Character.isLowerCase(actualChar)) {
                    minus = true;
                }
                if (Character.isDigit(actualChar)) {
                    digit = true;
                }
                if (specialCharacters.contains(Character.toString(actualChar))) {
                    special = true;
                }
            }
        }
        return mayus && minus && digit && special;
    }
}

