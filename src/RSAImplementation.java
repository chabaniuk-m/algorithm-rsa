import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class RSAImplementation {
    private final BigInteger modulus;
    private final BigInteger publicKey;
    private final BigInteger privateKey;

    public RSAImplementation(int keySize) {
        SecureRandom random = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(keySize / 2, random);
        BigInteger q = BigInteger.probablePrime(keySize / 2, random);

        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        BigInteger e = BigInteger.valueOf(65537); // Common public exponent
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
            e = e.add(BigInteger.ONE);
        }

        BigInteger d = e.modInverse(phi);

        modulus = n;
        publicKey = e;
        privateKey = d;
    }

    public BigInteger encrypt(BigInteger message) {
        return message.modPow(publicKey, modulus);
    }

    public BigInteger decrypt(BigInteger ciphertext) {
        return ciphertext.modPow(privateKey, modulus);
    }

    private static BigInteger toBI(String text) {
        BigInteger bi = BigInteger.ZERO;
        BigInteger k = BigInteger.ONE;
        for (char c : text.toCharArray()) {
            bi = bi.add(k.multiply(BigInteger.valueOf(c)));
            k = k.multiply(BigInteger.valueOf(31));
        }
        return bi;
    }

    private void interactiveExample() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nenter your text: ");

            String text = scanner.nextLine();

            if (text.isEmpty() || text.equals("0")) {
                break;
            }

            showEncryption(text);
        }
    }

    private void showEncryption(String text) {
        BigInteger plaintext = toBI(text);
        BigInteger encrypted = encrypt(plaintext);
        BigInteger decrypted = decrypt(encrypted);

        System.out.println("original: " + plaintext);
        System.out.println("encrypted: " + encrypted);
        System.out.println("decrypted: " + decrypted);
    }

    public static void main(String[] args) {
        RSAImplementation rsa = new RSAImplementation(1024);

        rsa.showEncryption("Let's fuck and kill all Russians");

        rsa.interactiveExample();
    }
}
