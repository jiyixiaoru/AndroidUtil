package com.wkr.androidutil;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseActivity<VB extends ViewBinding> extends AppCompatActivity {
    private static final String TAG = "BaseActivity";

    protected VB binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();
        setBinding();
        initData();
        initListener();

    }

    //设置UI
    protected abstract void setView();

    //初始化数据
    protected abstract void initData();

    //初始化监听
    protected abstract void initListener();


    /**
     * 通过反射binding
     * ViewBind使用：https://developer.android.google.cn/topic/libraries/view-binding#java
     */
    private void setBinding() {
        Type type = this.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            try {
                //getActualTypeArguments 获取类属性中泛型的类型
                Class<VB> clazz = (Class<VB>) ((ParameterizedType) type).getActualTypeArguments()[0];
                Method method = clazz.getMethod("inflate", LayoutInflater.class);
                binding = (VB) method.invoke(null, getLayoutInflater());
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());

            }
            setContentView(binding.getRoot());
        }
    }

}
