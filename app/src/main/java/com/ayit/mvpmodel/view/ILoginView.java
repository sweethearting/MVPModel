package com.ayit.mvpmodel.view;

/**
 * Created by Sweetheart on 2015/11/2 19:36.
 * Email: 378398018@qq.com
 * <br/>
 * MVP模式的V（视图）层
 * 这是一个抽象的登陆视图，里面都是一些界面动作，想要执行这些动作的界面都会去实现它。
 */
public interface ILoginView extends  IView {
    /**
     * 弹出提示信息。
     */
    public void showMsg(String msg);
    /**
     * 成功登陆跳转主页。
     */
    public void moveToMain();
    /**
     * 加载中
     */
    public void showLoadding();
    /**
     * 隐藏
     */
    public void hideLoadding();
}
