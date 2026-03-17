public class VigenereCypher {

    static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encrypt(String plaintext, String key) {

        StringBuilder cipher = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i++) {
            int rotationIndex = ALPHABET.indexOf(key.charAt(i % key.length())) + 1;

            int plainIndex = ALPHABET.indexOf(plaintext.charAt(i));
            char newChar = ALPHABET.charAt((plainIndex + rotationIndex) % ALPHABET.length());
            cipher.append(newChar);
        }
        return cipher.toString();
    }

    public static String decrypt(String cipher, String key) {
        StringBuilder plainText = new StringBuilder();

        for (int i = 0; i < cipher.length(); i++) {
            int rotationIndex = ALPHABET.indexOf(key.charAt(i % key.length())) + 1;

            int cipherIndex = ALPHABET.indexOf(cipher.charAt(i));
            char newChar;
            if (cipherIndex < rotationIndex) {
                newChar = ALPHABET.charAt(ALPHABET.length() + (cipherIndex - rotationIndex));
            } else {
                newChar = ALPHABET.charAt((cipherIndex - rotationIndex) % ALPHABET.length());
            }
            System.out.printf("Char to replace: %s\n", cipher.charAt(i));
            System.out.printf("rotationIndex=%d, cipherIndex=%d, newChar=%c%n\n",
                    rotationIndex, cipherIndex, newChar);
            plainText.append(newChar);
        }
        return plainText.toString();
    }

    public static void main(String[] args) {
        String plainText = "TRAVELEAST";
        String key = "CAT";
        String cipher = encrypt(plainText, key);

        System.out.println(cipher);

        String plainTextDerived = decrypt(cipher, key);
        System.out.println(plainTextDerived);
    }
}
