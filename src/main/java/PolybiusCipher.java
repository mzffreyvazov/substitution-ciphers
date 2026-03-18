public class PolybiusCipher {

    public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public static String encrypt(String plainText) {

        StringBuilder cipher = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char plainTextChar = plainText.charAt(i);
            int plainTextIndex = ALPHABET.indexOf(plainTextChar);


            if (plainTextIndex >= 9) {
                plainTextIndex--;
            }

            int row = plainTextIndex / 5;
            int col = plainTextIndex % 5;

            cipher.append(row);
            cipher.append(col);
        }

        return cipher.toString();
    }

    public static String decrypt(String cipher) {
        StringBuilder message = new StringBuilder();

        for (int i = 0; i < cipher.length(); i+=2) {
            int row = Character.getNumericValue(cipher.charAt(i));
            int col = Character.getNumericValue(cipher.charAt(i+1));

            int messageIndex = 5 * row + col;
            if (messageIndex >= 9) {
                messageIndex++;
            }
            message.append(ALPHABET.charAt(messageIndex));

        }

        return message.toString();
    }

    public static void main(String[] args) {

        String message = "TRAVELEAST";
        System.out.println(message);

        String cipher = encrypt(message);
        System.out.println(cipher);

        String originalMessage = decrypt(cipher);
        System.out.println(originalMessage);

    }
}
