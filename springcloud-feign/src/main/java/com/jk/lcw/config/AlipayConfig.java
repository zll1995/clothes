package com.jk.lcw.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101400688051";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCB05mYlKz+5laLhi8jDJksrHiBsmedJLLrCFvXdrBnLz74iF/1VtLj0CH2qTzYtfqEdK3cPOP9hnHkhJtDXPgI98WksMN1EjBUT5GUrplGSgG1KrDoyBP8NXcsaxfnDvRIOzhJ3S+B1pH+rsydnIHqUtDANix0QI6yEQiH8HA9NJ+BnPAieaPUuEK2hziMiM/H3S2vQPWXRP7mmivOaQqaAiBHCnoyZ8A5CUGbXXGmbl6zAYbDHtLdO0kGSCeeKALrzaC0j7EnfcuDgfWHF1X0cM3v3STQFuWJK/lBFsEo4iGbFhplPrgzMt4UesAhIaj4+ZU4dYTgZXs8EmOAkbxZAgMBAAECggEAMb11ao0D3sE3RUuKwb3w7bnCjcZhhkZqOjxAm8OAgHgMg0IUqbWzJM84Q/3BLzJBof/mIKw/mYGqHyhjKCL1cNIlKh0DNdZbJ+I4X6OpW9G858FMeFM3vPhrCVyaks8a7pWp0jrpGbCwzMgB4xz0dWd3TT00OPIG+dgm0ZZgGkKEahKu0exHNtWSs6LJ8mznJBjLNXh7mO39QGagb5ULdswUxul38RPIpRwWaXc5aDgXNTm6PXMVlpFq2yuqt99e2ORJKVjoBWBStsdBuNSzpZrpUB3k/J6qtR1rQQ40ohLmIxB5euV4pHrVCHqeyt4tDHRKl2BuRzFAksPTQineAQKBgQC4Uj15PBXIsLJBlsr2O74lmcHyklF1feM5W+QrLOALiiiipvNtY9S/h6q9oVpNE0CIYlZriEBo18ciNQ4Geb+6tgO1kDyrLhvO3wKQQkchypYrHAmioJKMW8jH0wwtWVg2h7u2gRQfAPo3BtGnnKQvGzKncab8ZRDlelJSshDSGQKBgQC0UD4LZvHZFxudDXMkDZLuHPAPUgl/kzE9Lr+T507+Tx4Z1NbcQAsUGJd2aTAwJwzZp/FjxPwNXiJwsDArZ1R8NGk2lR3xCjET8tSQZ7/GHBBgqxKOhvUgzu9EFTaIl75Hy1Xwe+14eqqAQZHRCrHHsVTKCM1lDlrgxockx6QEQQKBgBZKq/Cbma7Z39Ua3ZUGCKsXe2NQ2tUw0mg/esrV9IqwvNVfB5W1OyemyrmAaCFmMKnN6tG6er+zSPwUGowh8VQtaylsNkolm2tbgT3dJikqDRtNmsS2UsLy3sd7+L8LTSXbKJKb7ckKHzjEdFqnERw5V9j0X9OqjW6Tap1ht7MRAoGAcZSCIKiN+1OE/17zgmhSf08XIG9qsEPFpmaGIuJ3bdXkfh0F4uMsl1IORnZn9k0C2S/i7BevNbRwOU+iaBTEsSBKjilMHQNwesJhhzzzHhWbc2kPXVxBmJMBQH+kRFJhd9PrpHpL0bJjKDslYOo9pi5b3I/C4b8zG5eylUZ0WIECgYAaxGcAvnMgaIB1wVM8ChRa/4oqeY3MzljAOlfpp2j6a5nkUY/dGV2KKJ7q25qVBjN6PEvUnuXPOBOAAzls1SDeepaW/bFhVoGYE25kSSo+m/1BHyVHFe0Bz6eQVaXE+6YJygdp0RKp+GtuhVpyw85yaTwIRWVLjw9rwC3rK6xUDA==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgdOZmJSs/uZWi4YvIwyZLKx4gbJnnSSy6whb13awZy8++Ihf9VbS49Ah9qk82LX6hHSt3Dzj/YZx5ISbQ1z4CPfFpLDDdRIwVE+RlK6ZRkoBtSqw6MgT/DV3LGsX5w70SDs4Sd0vgdaR/q7MnZyB6lLQwDYsdECOshEIh/BwPTSfgZzwInmj1LhCtoc4jIjPx90tr0D1l0T+5porzmkKmgIgRwp6MmfAOQlBm11xpm5eswGGwx7S3TtJBkgnnigC682gtI+xJ33Lg4H1hxdV9HDN790k0BbliSv5QRbBKOIhmxYaZT64MzLeFHrAISGo+PmVOHWE4GV7PBJjgJG8WQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://kyd.free.idcfengye.com/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://127.0.0.1:8092/query";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
