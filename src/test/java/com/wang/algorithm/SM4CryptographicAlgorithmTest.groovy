package com.wang.algorithm

import com.wang.common.algorithm.SM4CryptographicAlgorithm

/**
 *
 * @date 2025/5/3 22:05
 * @author Robin Wang
 * @describe
 */
class SM4CryptographicAlgorithmTest {

    static void main(String[] args) {
        SM4CryptographicAlgorithm algorithm = new SM4CryptographicAlgorithm()
        Properties properties = new Properties()
        properties.setProperty("sm4-key", "86C63180C2806ED1F43A859DE501215C")
        properties.setProperty("sm4-mode", "ECB")
        properties.setProperty("sm4-padding", "PKCS5Padding")

        algorithm.init(properties)

        def encryptText = algorithm.encrypt("abc123")
        def plainText = algorithm.decrypt(encryptText)
        println(plainText)


    }
}
