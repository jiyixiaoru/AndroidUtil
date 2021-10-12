package com.wkr.androidutil;

import android.app.Application;

import com.kongzue.dialog.util.DialogSettings;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.CookieJarImpl;
import com.lzy.okgo.cookie.store.MemoryCookieStore;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import com.lzy.okgo.model.HttpHeaders;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import okhttp3.OkHttpClient;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initDialog();
        initNetworkByOkGo();
    }

    /**
     * 初始化网络连接框架 OkGo
     * 参考：
     * github原作者:https://github.com/jeasonlzy/okhttp-OkGo/wiki/Init#%E5%85%A8%E5%B1%80%E9%85%8D%E7%BD%AE
     * 简书：https://www.jianshu.com/p/952f98d5c9fa
     */
    private void initNetworkByOkGo() {
        //初始化OkHttp
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //设置cookie
        //builder.cookieJar(new CookieJarImpl(new SPCookieStore(this)));      //使用sp保持cookie，如果cookie不过期，则一直有效
        //builder.cookieJar(new CookieJarImpl(new DBCookieStore(this)));     //使用数据库保持cookie，如果cookie不过期，则一直有效
        builder.cookieJar(new CookieJarImpl(new MemoryCookieStore()));      //使用内存保持cookie，app退出后，cookie消失
        //设置log日志
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor("OkGo");
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);        //log打印级别，决定了log显示的详细程度
        loggingInterceptor.setColorLevel(Level.INFO);                               //log颜色级别，决定了log在控制台显示的颜色
        builder.addInterceptor(loggingInterceptor);                                 //添加OkGo默认debug日志
        //超时时间设置，默认60秒
        builder.readTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);      //全局的读取超时时间
        builder.writeTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);     //全局的写入超时时间
        builder.connectTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);   //全局的连接超时时间
        //设置公共请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put("Accept-Charset", "application/json");//header不支持中文，不允许有特殊字符
        //初始化
        OkGo.getInstance().init(this)
                .setOkHttpClient(builder.build())//建议设置OkHttpClient，不设置会使用默认的
                .setCacheMode(CacheMode.NO_CACHE)//全局统一缓存模式，默认不使用缓存，可以不传
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)//全局统一缓存时间，默认永不过期，可以不传
                .setRetryCount(3)//全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0
                .addCommonHeaders(httpHeaders);//全局公共头

    }

    /**
     * 初始化Dialog
     * 参考：https://github.com/kongzue/DialogV3
     */
    private void initDialog() {
//        DialogSettings.isUseBlur = (boolean);                   //是否开启模糊效果，默认关闭
//        DialogSettings.modalDialog = (boolean);                 //是否开启模态窗口模式，一次显示多个对话框将以队列形式一个一个显示，默认关闭
        DialogSettings.style = DialogSettings.STYLE.STYLE_IOS;          //全局主题风格，提供三种可选风格，STYLE_MATERIAL, STYLE_KONGZUE, STYLE_IOS
//        DialogSettings.theme = (DialogSettings.THEME);          //全局对话框明暗风格，提供两种可选主题，LIGHT, DARK
//        DialogSettings.tipTheme = (DialogSettings.THEME);       //全局提示框明暗风格，提供两种可选主题，LIGHT, DARK
//        DialogSettings.titleTextInfo = (TextInfo);              //全局对话框标题文字样式
//        DialogSettings.menuTitleInfo = (TextInfo);              //全局菜单标题文字样式
//        DialogSettings.menuTextInfo = (TextInfo);               //全局菜单列表文字样式
//        DialogSettings.contentTextInfo = (TextInfo);            //全局正文文字样式
//        DialogSettings.buttonTextInfo = (TextInfo);             //全局默认按钮文字样式
//        DialogSettings.buttonPositiveTextInfo = (TextInfo);     //全局焦点按钮文字样式（一般指确定按钮）
//        DialogSettings.inputInfo = (InputInfo);                 //全局输入框文本样式
//        DialogSettings.backgroundColor = (ColorInt);            //全局对话框背景颜色，值0时不生效
        DialogSettings.cancelable = false;                  //全局对话框默认是否可以点击外围遮罩区域或返回键关闭，此开关不影响提示框（TipDialog）以及等待框（TipDialog）
//        DialogSettings.cancelableTipDialog = (boolean);         //全局提示框及等待框（WaitDialog、TipDialog）默认是否可以关闭
//        DialogSettings.DEBUGMODE = (boolean);                   //是否允许打印日志
//        DialogSettings.blurAlpha = (int);                       //开启模糊后的透明度（0~255）
//        DialogSettings.systemDialogStyle = (styleResId);        //自定义系统对话框style，注意设置此功能会导致原对话框风格和动画失效
//        DialogSettings.dialogLifeCycleListener = (DialogLifeCycleListener);  //全局Dialog生命周期监听器
//        DialogSettings.defaultCancelButtonText = (String);      //设置 BottomMenu 和 ShareDialog 默认“取消”按钮的文字
//        DialogSettings.tipBackgroundResId = (drawableResId);    //设置 TipDialog 和 WaitDialog 的背景资源
//        DialogSettings.tipTextInfo = (InputInfo);               //设置 TipDialog 和 WaitDialog 文字样式
//        DialogSettings.autoShowInputKeyboard = (boolean);       //设置 InputDialog 是否自动弹出输入法
//        DialogSettings.okButtonDrawable = (drawable);           //设置确定按钮背景资源
//        DialogSettings.cancelButtonDrawable = (drawable);       //设置取消按钮背景资源
//        DialogSettings.otherButtonDrawable = (drawable);        //设置其他按钮背景资源
//        Notification.mode = Notification.Mode.FLOATING_WINDOW;  //通知实现方式。可选 TOAST 使用自定义吐司实现以及 FLOATING_WINDOW 悬浮窗实现方式

//检查 Renderscript 兼容性，若设备不支持，DialogSettings.isUseBlur 会自动关闭；
//        boolean renderscriptSupport = DialogSettings.checkRenderscriptSupport(context);
        DialogSettings.init();                           //初始化清空 BaseDialog 队列

    }

}
