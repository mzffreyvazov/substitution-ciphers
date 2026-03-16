
/**
 * A simple implementation of the Caesar cipher for encrypting and decrypting messages.
 * The Caesar cipher is a substitution cipher where each letter in the plaintext is
 * shifted a certain number of places down the alphabet. This implementation assumes
 * that the input messages consist of uppercase letters only and does not handle
 * non-alphabetic characters.
 */
public class CeaserCipher {

    static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Encrypts a plaintext message using the Caesar cipher with a given shift.
     * Each letter in the plaintext is shifted by the specified number of positions
     * in the alphabet, wrapping around if necessary. Non-alphabetic characters are not handled.
     * @param plaintext the message to encrypt
     * @param shift the number of positions to shift each letter (positive for right shift)
     * @return the encrypted ciphertext
     */
    public static String encrypt(String plaintext, int shift) {

        StringBuilder cipher = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i++) {
            int index = ALPHABET.indexOf(plaintext.charAt(i));
            char newChar = ALPHABET.charAt((index + shift) % ALPHABET.length());
            cipher.append(newChar);

        }

        return cipher.toString();
    }

    /**
     * Decrypts a ciphertext message using the Caesar cipher with a given shift.
     * Each letter in the ciphertext is shifted back by the specified number of positions
     * in the alphabet, wrapping around if necessary. Non-alphabetic characters are not handled.
     * @param ciphertext the encrypted message to decrypt
     * @param shift the number of positions the letters were shifted (positive for right shift)
     * @return the decrypted plaintext
     */
    public static String decrypt(String ciphertext, int shift) {

        StringBuilder plaintext = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i++) {
            int index = ALPHABET.indexOf(ciphertext.charAt(i));

            int rotIndex;
            if (index < shift) {
                rotIndex = ALPHABET.length() + (index - shift);
            } else {
                rotIndex = index - shift;
            }
            char newChar = ALPHABET.charAt(rotIndex);
            plaintext.append(newChar);

        }

        return plaintext.toString();
    }


    public static void main(String[] args) {
        String message = "TRAVELEAST";
        int shift = 15;

        System.out.println(message);

        String cipher = encrypt(message, shift);
        System.out.println(cipher);

        String originalMessage = decrypt(cipher, shift);
        System.out.println(originalMessage);


    }
}
