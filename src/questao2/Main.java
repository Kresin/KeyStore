package questao2;

import cipher.AES;
import cipher.RSACipher;
import keystore.JKS;

import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        JKS jks = new JKS();
        AES aes = new AES();
        RSACipher rsaCipher = new RSACipher();
        Scanner scanner = new Scanner(System.in);

        // Obtendo as informações do certificado
        System.out.println("Informe o caminho da keyStore");
        String path = scanner.nextLine();
        System.out.println("Informe a senha do arquivo da keystore");
        String password = scanner.nextLine();
        System.out.println("Informe o alias do certificado");
        String certificateName = scanner.nextLine();
        X509Certificate certificate = jks.getCertificate(path, certificateName, password);
        PublicKey publicKey = certificate.getPublicKey();

        // Criptografia da imagem com o AES
        aes.cipher();
        String aesKey = "AAAAAAAAAAAAAAAA";

        // Criptografia da chave usada pelo AES
        System.out.println("Informe onde o arquivo key.aes deverá ser salvo (Ex: C:/User/Temp/key.aes)");
        path = scanner.nextLine();
        rsaCipher.encrypt(aesKey.getBytes(), publicKey, path);
    }

}
