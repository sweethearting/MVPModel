package com.ayit.mvpmodel.model.impl;

import android.os.AsyncTask;
import android.text.TextUtils;

import com.ayit.mvpmodel.listener.IStatusCallback;
import com.ayit.mvpmodel.model.ILoginStatus;

/**
 * Created by Sweetheart on 2015/11/2 19:32.
 * Email: 378398018@qq.com
 * <br/>
 * 实现类,处理数据
 */
public class LoginStatus implements ILoginStatus {
    private int status = ILoginStatus.STATUS_LOGIN_ING;
    private String msg = "";

    @Override
    public void login(final String account, final String psw,
                      final IStatusCallback callback) {
        new AsyncTask<String, Void, ILoginStatus>() {
            @Override
            protected ILoginStatus doInBackground(String... arg0) {
                if (varify(account, psw)) {
                    try {//模拟网络请求耗时处理
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if ("Change".equals(account) && "123".equals(psw)) {
                        status = ILoginStatus.STATUS_LOGIN_SUCCESS;
                        msg = "Success";
                    } else {
                        status = ILoginStatus.STATUS_LOGIN_FAIL;
                        msg = "Failed";
                    }
                }
                return LoginStatus.this;
            }

            @Override
            protected void onPreExecute() {
                callback.onStatus(LoginStatus.this);

            }

            @Override
            protected void onPostExecute(ILoginStatus result) {
                callback.onStatus(result);
            }
        }.execute();

    }

    /**
     * 本地校验
     * @param account
     * @param psw
     * @return
     */
    private boolean varify(String account, String psw) {
        if (TextUtils.isEmpty(account)) {
            status = ILoginStatus.STATUS_VERIFY_FAIL;
            msg = "Username cannot be empty";
            return false;
        }
        if (TextUtils.isEmpty(psw)) {
            status = ILoginStatus.STATUS_VERIFY_FAIL;
            msg = "Password cannot be empty";
            return false;
        }
        return true;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
