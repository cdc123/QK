package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016091600525682";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCM0aY3DR25O942bd6yHGeA/yR7BA946cKA5OrsFVl7YIMhGRP5bC6uuneim+Xa4FzOd2HyPK7mYbVBPzSIa096vvgAucozLZMqLmu6f+aofFGVtV6nLWE83vHlvKGcP18ZNNDM3TQP5suXWJ9xjMFHrHzE+/dWhzHIVdqp6spw547ocl7j3kSXe4if0V6Fe84wBtydBdHaZSVyiaGQvsUbavUkMLl5Fjuf/LWQVkbmLm4FqOdxvUI3K26ya42olX1vQPtt36WwMx53Mmj2G955cgcM+hPOvZy4NTK6MCg1Gqd/qkeUj2lAg2xHixqbRaUR9Y1COdXjbqq+w+S9OxFNAgMBAAECggEAbjgqQSyi9zlE1JVqmT5iRTVu+FpVQe61ru1+cwrC3y7LdDyMxc1HPLv2p/AeGRNDkNcgctnMi8YueMNf+ucDbq/Krca93RDu/zUWXQN/JqEnumYbj/6U/XADJi5e0E1JwhD03WTGOywKbouPQPFK1y7K+eO91Jw8+vE4FYcQrQ1mFhucZQovVlmxKjmfVk8ivT5CPkVjN9n7yPIQzESwRlrzz70w4U304IJ8bXtnzc6Qo4lNhf14TnAd6Avi0kUG1fDboFyqT0ESmcxyfSrF5IZuBNmsHe8Tll14NJx963QQecVnRtZXDJFnem+PzViubfxalkISfzhKygj4q0V2gQKBgQDV7fkhFrCWR736Cwqn4xV6/F95gJAuN0P0gsKcXpq5QwxqMpTROmw6yQvJkD+rBesu0o2YBh84xv5fOMWgve6LmBQ6i7IQ8uAXnkH6y8tXNhJNb6frxWi+EQbTEpFUkngzazn0dlXmQ2TLe+75qxHFkivx6q07jN0Pg80t3ZzjiwKBgQCogwJU9G6TzGvpl0cQoEBZ2PBfdJN+63zrxYwfPEEhB76NSTMj+vTzrAZWR/6MLezbS+P3/OPVosJRoV1d/mpz3KVmP1JrKG01WItwMYPG6Eh51nSRKUut6s8ekP/VCG8M2B9Z7JHWLaBdV7ZEugWUud1d7JEH4uRIA8S27qOZhwKBgAQ71m9aNJp0xwS4zTgvXVB2yCjua2wOufCP2ewgTy2Vbxx27c0KO/QZ4HrXuPrYfiQKFLVKgbms7oHR7M9Wku7+ToAuHZMKS3cMMcAV4mtSbaBMsmUPHhiM27a3qlqjH2/dEmONJ/wLn2YLiNo2EX74epgqDc2c5w8Ui635sc4rAoGAQcUYZOYePot71ukXcJLLawX0E52hb9kjobYx0YMn/GdUZTqbvkBV2MFcm9JvtHC8UH9XU9QdbKWg6FFt6qDBFcWZvMWcOnzF2xtbGQgKYdkJaJxeVMXkZtYNzuVTJOesyDuWSPe/l/Oo8qWoWzyrrve4Qc9yb7yL0tu9rJSJwAMCgYBoWP9zyCMk8LHyjt2ClcklMd6VifPBULP7+hZIVDXlIXakgMhnxsZGOgigN3RXFQJUrEo4/QO+iWlT4RWcByLt5zMeLR4Mz3x0u/lpeITIXgKeMOb/zeegkAgEVgCDUyPN3SLbvOmLHoKQ2h5NcudKIhRxZ5vF5ikkBkJVjv5YNw==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0gE9DywUHA/gcrAZkYcn0F7Tx69KyH7rqP1tuP3WJnQCcT0pGtbXR6xWrIJu+hgQZjzQbmkY2bpfDwMfodFlDjnKnyzjjQpvyheQ5mkFQz6GffsSi8q5m4QbarzmklZx7TWyGbEPq4LHjk5UzbD75ai2mt1YcdGf3Ehwm3oyq4pFZjUw89vh0pFFv0OqZbm4DUC3CHUA6xbp1QFqhsPRLJHEVWD14LCxZTFd63k85J5CYEpeD16ibdnFwLIfwl/ddpea1hVydepLKUpBnIZTU3AvntzZUFZ7vTTWoQA/khEeZ4JuTstbkV73KolLBY0fpPmdh3cue50K3dDIzPne0QIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//	public static String return_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";
    public static String return_url = "http://47.94.1.116:8080/html/homepage.html";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";

	//返回格式
	public static String FORMAT = "json";

	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


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

