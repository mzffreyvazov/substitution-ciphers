public class RussianNihilistCipher {
    PolybiusCipher polybiusCipher = new PolybiusCipher();

    public String encrypt(String plainText, String key) {
        StringBuilder output = new StringBuilder();

        String plainEncoded = polybiusCipher.encrypt(plainText);
        String keyEncoded = polybiusCipher.encrypt(key);

        for (int i = 0; i < plainEncoded.length(); i += 2) {
            int textInt = Integer.parseInt(plainEncoded.substring(i, i + 2));
            int keyInt = Integer.parseInt(keyEncoded.substring(i % keyEncoded.length(), i % keyEncoded.length() + 2));

            int cipher = textInt + keyInt;

            if (cipher < 10) {
                output.append("0");
            }
            output.append(cipher).append(" ");
        }

        return output.toString().trim();
    }

    public String decrypt(String cipherText, String key) {
        StringBuilder polybiusEncoded = new StringBuilder();

        String keyEncoded = polybiusCipher.encrypt(key);
        String[] tokens = cipherText.split(" ");

        for (int i = 0; i < tokens.length; i++) {
            int cipherInt = Integer.parseInt(tokens[i]);
            int keyInt = Integer.parseInt(keyEncoded.substring(i * 2 % keyEncoded.length(), i * 2 % keyEncoded.length() + 2));

            int textInt = cipherInt - keyInt;

            if (textInt < 10) {
                polybiusEncoded.append("0");
            }
            polybiusEncoded.append(textInt);
        }

        return polybiusCipher.decrypt(polybiusEncoded.toString());
    }

    public static void main(String[] args) {
        RussianNihilistCipher nihilist = new RussianNihilistCipher();

        String plainText = "TRAVELEAST";
        String key = "CRYPTO";

        System.out.println("Plaintext : " + plainText);
        System.out.println("Key       : " + key);

        String encrypted = nihilist.encrypt(plainText, key);
        System.out.println("Encrypted : " + encrypted);

        String decrypted = nihilist.decrypt(encrypted, key);
        System.out.println("Decrypted : " + decrypted);
    }
}