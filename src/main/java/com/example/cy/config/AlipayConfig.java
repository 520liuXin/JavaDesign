package com.example.cy.config;



    /**
     * 支付宝配置信息
     * @author linhongcun
     *
     */
    public class AlipayConfig {

        //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ APPID
        public static String app_id = "2016092600597995";

        //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 生成公钥时对应的私钥
        public static String private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCnxIMZbA65kvvcX+cXtVMYFrv/DqFZ3/E7DCypMm4LPeWL20Jxk/MF0UfuXk+PM9VgDaqYo64rTRJeKGUaaPLEPZC2MCEiwrNKLGMm65BzTcOpSMQUNXJJrGgCkvOW71XJW35hoybrDsx8Tj8owhB7T8axHz9naoL6Q5Oti0X/JwOuwFiLmyJeGhsrVCPsDprWWoBTJPscUmW26Y0+gadfnIm3WOX4ttsjTRCLr3B6jlwq/upHqwWhv2mEncZW+HGNfBpxJBibVW4LEdvXhYKcK+QNzhDjHZWhx3c8ILMUdOqyS1635Gh6rVCuL+WEldEonP71ie9sGWTBsaMSQJtTAgMBAAECggEAP52ppLMv5jiRHqCTDY9pYeIFCZNvpZfgbmaQbNw9lC+1YlITIORcK+GO6BmFC6U5DQJBpT2z5qGEDIY+yEPxgm5h+GPJvNedisvIEVMT5FUhk4iPKaaWns8sZYV5rss0eXUjODzYnhtveNdm5bqo60l162YQ8dMWtXV4gz8jnLt+YgZCkUxH7AQnC7OPptpAa5WZpbMpaFRGXBHfMHqLQ073xK9RLtRditD2YfzwxLqaBfEkI2VTGZcrJEx3yrUOq8GRjZUg6yjAJukZwklj5pgRyijsTFtcZ6XE3aaU4+hAdGLH/Ku292Dzvv0OZItmID7VIvTZglXLyGJN9R7JSQKBgQDRGTYBTtxKyz3FLI8uRFvnD7qvYS89BimzsYOtAE1gAHKrAZm/rHZXtS5+CKNXnT3sqpyzfdPBIxaolmN83tFJ7O4jRHv5ahec57Az7bUuadTI2xVnYtOCMQFXvniPawfxZDomM2fMXf/lgI5FRX6JNQUDbXfbAdUyWJ3hNbSE5QKBgQDNZgNwGV8+LCpRHSRWKiKlC+vrp1FnOv1e9RalLnTEqKlhPhW0CybekJKId/MGqlQqzmJWOQeGRSIoiYZ3ApBmd7UBL5NG5rl+B7BPe27LGHQCDNCuJOjANITuNGN+2uQ6uPkE2fNBNidS+HfHG4Bzj556kg2FkFENRaZXtigT1wKBgCEJvbm5Lx92O31TDBCAZpD8sD+TuHYI6j/lNWv5V0Bq8bNJXnSlmFFFZGIvlTd7tdQWJQpLQFEM7UCX+oI5ZpIqqHnUEU6YT8DP7sxVq8H4oNFXpGsgd1Dj01V81+m5PJkMgA+XIbhtxcgKZvBVCag+Q1uGSWDGSlxZGiECblJtAoGAcR2JLycJ6Ldx5pHh/QHfan2SQ4k1r2AxQSZAfl+DNvqbrU3/rdOmaFO+HyHP2Q/comZeiZWGq09PbHuwbcIfvA6YxDprJVTTOrEJS/xyG68v1CEym3UAKTnDK1v2n1n07tIHccCF0pf8OBlV/XUL3JhvcpkUkUXVHTYKUaujjqkCgYBj+gaK1CSURJu2KZx4oud86EaUVTyD6A1qTi27oFaxfEn08R8XSO4Ni9KJdLY0q48BsmjRyIhhFjCkr7NWV3Y2xOMHq3X0xmHCTlcWL8wr0rJhuZJHe1CTxRv1+KAE3mwFHQlZbcPyOTCNq17jSi/nrKLnKi2HoMBB3P0iJZYIrw==";

        //Controller Mapping:得放到服务器上，且使用域名解析 IP
        public static String notify_url = "http://127.0.0.1:8888/alipay/returnUrl";

        //Controller Mapping:得放到服务器上，且使用域名解析 IP
        public static String return_url = "http://127.0.0.1:8888/alipay/notifyUrl";

        //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 支付宝网关（注意沙箱alipaydev，正式则为 alipay）
        public static String url = "https://openapi.alipaydev.com/gateway.do";

        public static String charset = "UTF-8";

        public static String format = "json";

        //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 公钥
        public static String public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2tOz8k+7V9ef5WSZRP+ZSQ7siVTYx6/rhZ25z1fda4QWuKr0ek9+WZNMXyLkV96JmtrHZwf5xFDR21RBei78PsQzTpZJY6c7H2tjmZjeCjJK4CCu4QoytRMUZWPKHR0gsizPH1SPwGNURXq2ygqw+XiccHontDljVd7r0t3gMotYYLds2yL4sDEp22Gs4RDsmuHWqay3ORJHVxTWmByurGPBaFbfe4vw1pK1ipjxhWLlYr6nn00qgiq8Xo2/WUULc3jJtoVmF+SJe+n8m3Kusy0x1c+VbR06de5ZsLB1AwlQjE6W14511ULvpWDDnxJyyT74b+ZMSQB9WqFiIkIGNQIDAQAB";

        public static String signtype = "RSA2";

    }



