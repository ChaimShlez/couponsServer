package com.chaim.coupons.timer;

import com.chaim.coupons.enums.ErrorTypes;
import com.chaim.coupons.exceptions.ServerException;
import com.chaim.coupons.logic.CouponsLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

@Component
public class MyTimerTask extends TimerTask {
    private CouponsLogic couponLogic;

    @Autowired
    public MyTimerTask(CouponsLogic couponLogic) {
        this.couponLogic = couponLogic;
    }

    @Override
    public void run()  {
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        try {
            couponLogic.deleteExpireCoupon(date);
        } catch (Exception e) {
           e.printStackTrace();

        }

    }


}

