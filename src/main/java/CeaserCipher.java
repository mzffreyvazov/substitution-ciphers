public class CeaserCipher {

    static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encrypt(String input, int shift) {

        StringBuilder cypher = new StringBuilder();

        for (int i = 0; i<input.length();  i++) {
            int index = ALPHABET.indexOf(input.charAt(i));
            char newChar = ALPHABET.charAt(index + shift);
            cypher.append(newChar);

        }

        return cypher.toString();
    }

    public static String decrypt(String cypher, int shift) {

        StringBuilder message = new StringBuilder();

        for (int i = 0; i<cypher.length();  i++) {
            int index = ALPHABET.indexOf(cypher.charAt(i));
            char newChar = ALPHABET.charAt(index - shift);
            message.append(newChar);

        }

        return message.toString();
    }


    public static void main(String[] args) {
        String message = "TRAVELEAST";
        int rotation = 3;

        System.out.println(message);

        String cypher = encrypt(message, rotation);
        System.out.println(cypher);

        String originalMessage = decrypt(cypher, rotation);
        System.out.println(originalMessage);


    }
}
