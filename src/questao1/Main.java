package questao1;

import keystore.JKS;

import java.security.cert.X509Certificate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        JKS jks = new JKS();
        Scanner scanner = new Scanner(System.in);

        int input = 1;

        while (input != 0) {
            System.out.println("Digite 1 para analisar um certificado ou 0 para sair");
            input = Integer.parseInt(scanner.nextLine());
            if (input != 0) {
                System.out.println("Informe o caminho da keyStore");
                String path = scanner.nextLine();
                System.out.println("Informe a senha do arquivo da keystore");
                String password = scanner.nextLine();
                System.out.println("Informe o alias do certificado");
                String certificateName = scanner.nextLine();

                X509Certificate certificate = jks.getCertificate(path, certificateName, password);
                System.out.println("\nEmissor do certificado: " + certificate.getIssuerDN().getName());
                System.out.println("Proprietário do certificado: " + certificate.getSubjectDN().getName());
                boolean selfSigned = certificate.getIssuerDN().getName().equals(certificate.getSubjectDN().getName());
                System.out.println("É auto-assinado: " + selfSigned);
                System.out.println("Período de validade do certificado: " + certificate.getNotBefore() + " até " + certificate.getNotAfter());
            }
        }

    }

}
