package com.ghen61.agabankh;

import android.view.View;

/**
 * Created by LG on 2018-06-13.
 */

public class ListViewItem {


    private String account;
    private String money;
    private String month;
    private String onetime;

    public View.OnClickListener onClickListener;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getOnetime() {
        return onetime;
    }

    public void setOnetime(String onetime) {
        this.onetime = onetime;
    }
}
