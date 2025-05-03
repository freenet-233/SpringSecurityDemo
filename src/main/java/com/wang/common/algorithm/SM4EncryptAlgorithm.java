package com.wang.common.algorithm;

import lombok.Getter;
import org.apache.shardingsphere.encrypt.spi.EncryptAlgorithm;
import org.apache.shardingsphere.encrypt.spi.EncryptAlgorithmMetaData;
import org.apache.shardingsphere.infra.algorithm.core.config.AlgorithmConfiguration;
import org.apache.shardingsphere.infra.algorithm.core.context.AlgorithmSQLContext;
import org.apache.shardingsphere.infra.algorithm.cryptographic.core.CryptographicAlgorithm;
import org.apache.shardingsphere.infra.spi.type.typed.TypedSPILoader;

import java.util.Properties;

/**
 * shardingsphere SM4 encrypt algorithm.
 * @author Robin Wang
 */
public final class SM4EncryptAlgorithm implements EncryptAlgorithm {
    @Getter
    private final EncryptAlgorithmMetaData metaData = new EncryptAlgorithmMetaData(true, true, false);

    private Properties props;

    private CryptographicAlgorithm cryptographicAlgorithm;

    @Override
    public void init(final Properties props) {
        this.props = props;
        cryptographicAlgorithm = TypedSPILoader.getService(CryptographicAlgorithm.class, getType(), props);
    }

    @Override
    public String encrypt(Object plainValue, AlgorithmSQLContext algorithmSQLContext) {
        Object result = cryptographicAlgorithm.encrypt(plainValue);
        return null == result ? null : String.valueOf(result);
    }

    @Override
    public Object decrypt(Object cipherValue, AlgorithmSQLContext algorithmSQLContext) {
        return cryptographicAlgorithm.decrypt(cipherValue);
    }

    @Override
    public AlgorithmConfiguration toConfiguration() {
        return new AlgorithmConfiguration(getType(), props);
    }

    @Override
    public String getType() {
        return "SM4";
    }
}
