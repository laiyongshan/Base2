package com.yeohe.proceeds.ui.main;

import android.os.Bundle;
import android.view.KeyEvent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ccj.base.base.BaseActivity;
import com.ccj.base.utils.router.RouterConstants;
import com.yeohe.proceeds.R;
import com.yeohe.proceeds.utils.ToastUtil;

@Route(path = RouterConstants.MAIN_MOUDLE_ACTIVITY)
public class MainActivity extends BaseActivity implements MainContract.View{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    //退出时的时间
    private long mExitTime;
    //对返回键进行监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            ToastUtil.getShortToastByString(MainActivity.this, "再按一次退出应用");
            mExitTime = System.currentTimeMillis();
        } else {
//            MyConfig.clearSharePre(this, "users");
            finish();
            System.exit(0);
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showExitDialog() {

    }
}