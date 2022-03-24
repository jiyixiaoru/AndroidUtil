package com.wkr.androidutil.permission;

import android.Manifest;
import android.view.View;

import com.wkr.androidutil.BaseActivity;
import com.wkr.androidutil.R;
import com.wkr.androidutil.databinding.ActivityPermissionBinding;
import com.wkr.androidutil.toast.ToastUtil;
import com.wkr.aspectj.permission.PermissionApply;
import com.wkr.aspectj.permission.PermissionApplyCancel;
import com.wkr.aspectj.permission.PermissionApplyReject;

import java.util.ArrayList;

public class PermissionActivity extends BaseActivity<ActivityPermissionBinding> {
    @Override
    protected void setView() {
        setContentView(R.layout.activity_permission);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        binding.permissionApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                permissionApply();
            }
        });
    }

    /**
     * 权限申请方法：
     * value:待申请的权限集合
     * code:申请的请求码
     * 申请通过则继续执行方法，申请失败则走失败的方法
     * <p>
     * 注意：申请的权限需在AndroidManifest中注册，不然会出现弹框一闪而过
     */
    @PermissionApply(value = {Manifest.permission.CAMERA, Manifest.permission.GET_ACCOUNTS}, code = 200)
    private void permissionApply() {
        ToastUtil.showToast(this, "权限申请成功！！！");
    }

    /**
     * 用户取消权限申请
     *
     * @param permissions 取消的权限的集合
     */
    @PermissionApplyCancel
    private void permissionApplyCancel(ArrayList<String> permissions) {
        ToastUtil.showToast(this, "用户取消权限申请！！！");
    }

    /**
     * 用户拒绝权限申请
     *
     * @param permissions 拒绝和取消权限的集合
     */
    @PermissionApplyReject
    private void permissionApplyReject(ArrayList<String> permissions) {
        ToastUtil.showToast(this, "用户拒绝权限申请！！！");
    }
}
