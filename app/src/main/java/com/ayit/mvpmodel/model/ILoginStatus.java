package com.ayit.mvpmodel.model;

import com.ayit.mvpmodel.listener.IStatusCallback;

/**
 * Created by Sweetheart on 2015/11/2 19:29.
 * Email: 378398018@qq.com
 * <br/>
 * MVP模式的m（模型）层。
 * 登陆状态，登陆的实际逻辑实现它去完成。
 */
public interface ILoginStatus extends  IStatus {

    public static final int STATUS_VERIFY_FAIL = -1;//验证失败
    public static final int STATUS_LOGIN_FAIL = -2;//登陆失败
    public static final int STATUS_LOGIN_SUCCESS = 0;//登陆成功
    public static final int STATUS_LOGIN_ING = 1;//登陆中


    /**
     * 登陆行为
     * @param account
     * @param psw
     * @return 状态码
     */
    public void login(String account,String psw,IStatusCallback callback);

}
