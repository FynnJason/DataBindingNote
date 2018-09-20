package com.fynnjason.app.databindingnote.login.presenter;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.fynnjason.app.databindingnote.login.model.LoginModel;
import com.fynnjason.app.databindingnote.login.view.ILoginActivity;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

/**
 * Created by FynnJason on on 2018/9/20.
 * Function：登录功能P层
 */
public class LoginPresenter extends MvpBasePresenter<ILoginActivity> {

    /**
     * 登录
     * <p>
     * 实际情况应该要用网络请求方式，这里因为是演示，所以直接判断账号密码正确性
     *
     * @param account  账号
     * @param password 密码
     */
    public void login(String account, String password) {
        if (!TextUtils.isEmpty(account) && !TextUtils.isEmpty(password)) {
            if (account.equals("123456") && password.equals("123456")) {
                ifViewAttached(new ViewAction<ILoginActivity>() {
                    @Override
                    public void run(@NonNull ILoginActivity view) {
                        LoginModel model = new LoginModel();
                        model.setName("FynnJason");
                        model.setSex("男");
                        view.loginSuccess(model);
                    }
                });
            } else {
                ifViewAttached(new ViewAction<ILoginActivity>() {
                    @Override
                    public void run(@NonNull ILoginActivity view) {
                        view.loginFailure("登录失败");
                    }
                });
            }
        } else {
            ifViewAttached(new ViewAction<ILoginActivity>() {
                @Override
                public void run(@NonNull ILoginActivity view) {
                    view.loginFailure("账号或密码为空");
                }
            });
        }
    }


}
