package com.ayit.mvpmodel;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ayit.mvpmodel.presenter.LoginPersenter;
import com.ayit.mvpmodel.view.ILoginView;

public class MainActivity extends AppCompatActivity  implements ILoginView,
        View.OnClickListener {
    private ProgressDialog dialog;
    private EditText etAccount, etPsw;
    private Button btnLogin;
    private LoginPersenter mPersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPersenter = new LoginPersenter(this);
        initViews();
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void moveToMain() {
        Intent toMain = new Intent(this, MainActivity.class);
        startActivity(toMain);
    }

    @Override
    public void showLoadding() {
        dialog.show();
    }

    @Override
    public void hideLoadding() {
        dialog.cancel();
    }


    public void initViews() {
        dialog = new ProgressDialog(this);
        dialog.setMessage("加载中。。。");
        etAccount = (EditText) findViewById(R.id.et_account);
        etPsw = (EditText) findViewById(R.id.et_psw);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.btn_login:
                mPersenter.didLoginSuccess(etAccount.getText().toString(), etPsw
                        .getText().toString());
                break;

            default:
                break;
        }
    }

}