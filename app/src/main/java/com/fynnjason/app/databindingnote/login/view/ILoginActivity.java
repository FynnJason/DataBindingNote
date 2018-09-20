package com.fynnjason.app.databindingnote.login.view;

import com.fynnjason.app.databindingnote.login.model.LoginModel;
import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by FynnJason on on 2018/9/20.
 * Function：登录功能View接口层
 */
public interface ILoginActivity extends MvpView{

    void loginSuccess(LoginModel model);

    void loginFailure(String msg);

}
