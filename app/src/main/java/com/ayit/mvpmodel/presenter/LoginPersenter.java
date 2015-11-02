package com.ayit.mvpmodel.presenter;

import com.ayit.mvpmodel.listener.IStatusCallback;
import com.ayit.mvpmodel.model.ILoginStatus;
import com.ayit.mvpmodel.model.IStatus;
import com.ayit.mvpmodel.model.impl.LoginStatus;
import com.ayit.mvpmodel.view.ILoginView;

/**
 * Created by Sweetheart on 2015/11/2 19:41.
 * Email: 378398018@qq.com
 * <br/>
 * MVP模式中的P(主导器)，它负责主导所有的模型和视图。
 */
public class LoginPersenter {
    private ILoginView mLoginView;// 持有视图对象
    private ILoginStatus mStatus;// 持有模型

    public LoginPersenter(ILoginView mLoginView) {
        mStatus = new LoginStatus();
        this.mLoginView=mLoginView;
    }
    public void didLoginSuccess(String account, String psw) {
        mStatus.login(account, psw, new IStatusCallback() {

            @Override
            public void onStatus(IStatus status) {
                LoginStatus s = (LoginStatus) status;
                switch (s.getStatus()) {
                    case ILoginStatus.STATUS_VERIFY_FAIL:// 验证失败
                    case ILoginStatus.STATUS_LOGIN_FAIL:// 登陆失败
                        mLoginView.hideLoadding();
                        mLoginView.showMsg(s.getMsg());
                        break;
                    case ILoginStatus.STATUS_LOGIN_ING:// 登陆中
                        mLoginView.showLoadding();
                        break;
                    case ILoginStatus.STATUS_LOGIN_SUCCESS:// 登陆成功
                        mLoginView.hideLoadding();
                        mLoginView.moveToMain();
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
