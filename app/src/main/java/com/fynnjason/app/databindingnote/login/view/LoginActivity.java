package com.fynnjason.app.databindingnote.login.view;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.fynnjason.app.databindingnote.R;
import com.fynnjason.app.databindingnote.base.BaseActivity;
import com.fynnjason.app.databindingnote.databinding.ActivityLoginBinding;
import com.fynnjason.app.databindingnote.login.model.LoginModel;
import com.fynnjason.app.databindingnote.login.presenter.LoginPresenter;

/**
 * Created by FynnJason on on 2018/9/20.
 * Function：登录界面
 */
public class LoginActivity extends BaseActivity<ActivityLoginBinding, ILoginActivity, LoginPresenter> implements ILoginActivity, View.OnClickListener {

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @NonNull
    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        binding.btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                presenter.login(binding.etLoginAccount.getText().toString(), binding.etLoginPassword.getText().toString());
                break;
        }
    }

    @Override
    public void loginSuccess(LoginModel model) {
        toast("登录成功！\n姓名：" + model.getName() + "\n性别：" + model.getSex());
    }

    @Override
    public void loginFailure(String msg) {
        toast(msg);
    }
}
