package cipher;

import file.FileService;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

public class RSACipher {

    public void encrypt(byte[] keyToEncode, PublicKey publicKey, String path) {
        Cipher cipher;
        FileService fileService = new FileService();
        try {
            cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] bytes = cipher.doFinal(keyToEncode);
            fileService.saveFile(path, bytes);
        } catch (NoSuchAlgorithmException | BadPaddingException | InvalidKeyException | IllegalBlockSizeException |
                 NoSuchPaddingException e) {
            throw new RuntimeException("Erro ao criptografar a chave: ", e);
        }
    }

}
