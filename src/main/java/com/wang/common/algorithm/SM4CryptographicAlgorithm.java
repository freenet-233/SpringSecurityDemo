package com.wang.common.algorithm;

import lombok.SneakyThrows;
import org.apache.shardingsphere.infra.algorithm.core.exception.AlgorithmInitializationException;
import org.apache.shardingsphere.infra.algorithm.cryptographic.core.CryptographicAlgorithm;
import org.apache.shardingsphere.infra.exception.core.ShardingSpherePreconditions;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.Security;
import java.util.*;

/**
 * @author Robin Wang
 * @date 2025/5/3 21:25
 * @describe SM4 cryptographic algorithm.
 */
public final class SM4CryptographicAlgorithm implements CryptographicAlgorithm {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    private static final String SM4_KEY = "sm4-key";

    private static final String SM4_IV = "sm4-iv";

    private static final String SM4_MODE = "sm4-mode";

    private static final String SM4_PADDING = "sm4-padding";

    private static final int KEY_LENGTH = 16;

    private static final int IV_LENGTH = 16;

    private static final Set<String> MODES = new HashSet<>(Arrays.asList("ECB", "CBC"));

    private static final Set<String> PADDINGS = new HashSet<>(Arrays.asList("PKCS5Padding", "PKCS7Padding"));

    private byte[] sm4Key;

    private byte[] sm4Iv;

    private String sm4ModePadding;

    @Override
    public void init(Properties props) {
        String sm4Mode = createSm4Mode(props);
        String sm4Padding = createSm4Padding(props);
        sm4ModePadding = "SM4/" + sm4Mode + "/" + sm4Padding;
        sm4Key = createSm4Key(props);
        sm4Iv = createSm4Iv(props, sm4Mode);
    }

    @Override
    public Object encrypt(Object plainValue) {
        return null == plainValue ? null : Hex.toHexString(encrypt(String.valueOf(plainValue).getBytes(StandardCharsets.UTF_8)));

    }

    private byte[] encrypt(final byte[] plainValue) {
        return handle(plainValue, Cipher.ENCRYPT_MODE);
    }

    @Override
    public Object decrypt(Object cipherValue) {
        return null == cipherValue ? null : new String(decrypt(Hex.decode((String) cipherValue)), StandardCharsets.UTF_8);

    }

    private byte[] decrypt(final byte[] cipherValue) {
        return handle(cipherValue, Cipher.DECRYPT_MODE);
    }

    @Override
    public String getType() {
        return "SM4";
    }


    private String createSm4Mode(final Properties props) {
        ShardingSpherePreconditions.checkState(props.containsKey(SM4_MODE), () -> new AlgorithmInitializationException(this, "%s can not be null or empty", SM4_MODE));
        String result = String.valueOf(props.getProperty(SM4_MODE)).toUpperCase();
        ShardingSpherePreconditions.checkState(MODES.contains(result), () -> new AlgorithmInitializationException(this, "Mode must be either CBC or ECB"));
        return result;
    }

    private byte[] createSm4Key(final Properties props) {
        ShardingSpherePreconditions.checkState(props.containsKey(SM4_KEY), () -> new AlgorithmInitializationException(this, "%s can not be null", SM4_KEY));
        byte[] result = Hex.decode(String.valueOf(props.getProperty(SM4_KEY)));
        ShardingSpherePreconditions.checkState(KEY_LENGTH == result.length,
                () -> new AlgorithmInitializationException(this, "Key length must be " + KEY_LENGTH + " bytes long"));
        return result;
    }

    private byte[] createSm4Iv(final Properties props, final String sm4Mode) {
        if (!"CBC".equalsIgnoreCase(sm4Mode)) {
            return null;
        }
        ShardingSpherePreconditions.checkState(props.containsKey(SM4_IV), () -> new AlgorithmInitializationException(this, "%s can not be null", SM4_IV));
        String sm4IvValue = String.valueOf(props.getProperty(SM4_IV));
        byte[] result = Hex.decode(sm4IvValue);
        ShardingSpherePreconditions.checkState(IV_LENGTH == result.length, () -> new AlgorithmInitializationException(this, "Iv length must be " + IV_LENGTH + " bytes long"));
        return result;
    }

    private String createSm4Padding(final Properties props) {
        ShardingSpherePreconditions.checkState(props.containsKey(SM4_PADDING), () -> new AlgorithmInitializationException(this, "%s can not be null", SM4_PADDING));
        String result = String.valueOf(props.getProperty(SM4_PADDING)).toUpperCase().replace("PADDING", "Padding");
        ShardingSpherePreconditions.checkState(PADDINGS.contains(result), () -> new AlgorithmInitializationException(this, "Padding must be either PKCS5Padding or PKCS7Padding"));
        return result;
    }


    @SneakyThrows(GeneralSecurityException.class)
    private byte[] handle(final byte[] input, final int mode) {
        Cipher cipher = Cipher.getInstance(sm4ModePadding, BouncyCastleProvider.PROVIDER_NAME);
        SecretKeySpec secretKeySpec = new SecretKeySpec(sm4Key, "SM4");
        Optional<byte[]> sm4Iv = Optional.ofNullable(this.sm4Iv);
        if (sm4Iv.isPresent()) {
            cipher.init(mode, secretKeySpec, new IvParameterSpec(sm4Iv.get()));
        } else {
            cipher.init(mode, secretKeySpec);
        }
        return cipher.doFinal(input);
    }
}
