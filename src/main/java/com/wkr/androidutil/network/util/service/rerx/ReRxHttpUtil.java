package com.wkr.androidutil.network.util.service.rerx;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

//Retrofit 详解参考：https://www.cnblogs.com/baiqiantao/p/7494850.html#Retrofit
public class ReRxHttpUtil {
    public static final String BASE_URL = "http://192.168.123.223:8200/api/";
    private static final Long TIME_OUT = 30000L;
    private static Retrofit retrofit;

    /**
     * 获取Retrofit
     *
     * @return
     */
    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            synchronized (ReRxHttpUtil.class) {
                if (retrofit == null) {
                    /*** 相关属性意思及设置(参考：https://www.jianshu.com/p/4b3986d4640f):
                     * // dispatch。负责分配处理异步任务
                     *     this.dispatcher = new Dispatcher();
                     *     // 支持的协议，默认支持http2和http1.1
                     *     this.protocols = OkHttpClient.DEFAULT_PROTOCOLS;
                     *     // 指定socket链接配置。默认：MODERN_TLS和CLEARTEXT
                     *     this.connectionSpecs = OkHttpClient.DEFAULT_CONNECTION_SPECS;
                     *     // 监听http请求过程中涉及的各种事件。包括：开始请求、dns解析开始/结束、链接开始等等。默认是的Listener
                     *     this.eventListenerFactory = EventListener.factory(EventListener.NONE);
                     *     // 设置代理
                     *     this.proxySelector = ProxySelector.getDefault();
                     *     // 设置cookie
                     *     this.cookieJar = CookieJar.NO_COOKIES;
                     *     // 设置创建Socket链接的Factory
                     *     this.socketFactory = SocketFactory.getDefault();
                     *     // 验证域名和证书的域名是否匹配
                     *     this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
                     *     // 设置信任的证书，不信任之外的证书，默认是空的
                     *     this.certificatePinner = CertificatePinner.DEFAULT;
                     *     // 与身份认证有关。详见：https://square.github.io/okhttp/3.x/okhttp/okhttp3/Authenticator.html
                     *     this.proxyAuthenticator = Authenticator.NONE;
                     *     // 与身份认证有关。详见：https://square.github.io/okhttp/3.x/okhttp/okhttp3/Authenticator.html
                     *     this.authenticator = Authenticator.NONE;
                     *     // 连接池-缓存链接和清理空闲的连接
                     *     this.connectionPool = new ConnectionPool();
                     *     // 域名解析
                     *     this.dns = Dns.SYSTEM;
                     *     // 是否支持ssl重定向
                     *     this.followSslRedirects = true;
                     *     // 是否支持重定向
                     *     this.followRedirects = true;
                     *     // 失败后是否重试
                     *     this.retryOnConnectionFailure = true;
                     *     // 链接超时时间
                     *     this.connectTimeout = 10000;
                     *     // 读超时时间
                     *     this.readTimeout = 10000;
                     *     // 写超时时间
                     *     this.writeTimeout = 10000;
                     *     // ping的时间间隔。如果使用WebSocket请求设置pingInterval，以保活
                     *     this.pingInterval = 0;
                     */
                    OkHttpClient okHttpClient = new OkHttpClient.Builder()
                            .readTimeout(TIME_OUT, TimeUnit.SECONDS)//读取超时时间
                            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)//连接超时时间
                            .writeTimeout(TIME_OUT, TimeUnit.SECONDS)//写入超时时间
                            .addInterceptor(chain -> { //添加拦截器，设置请求头
                                Request.Builder builder = chain.request().newBuilder();
                                builder.addHeader("token", "123456");
                                return chain.proceed(builder.build());
                            })
                            .addInterceptor(chain -> {
                                Response response = chain.proceed(chain.request());
                                return response;
                            })
                            .build();
                    retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .client(okHttpClient)
                            .addConverterFactory(GsonConverterFactory.create())//json解析工具
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//rxjava处理工具
                            .build();
                }
            }
        }
        return retrofit;
    }
}
