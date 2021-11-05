package com.dvillage.taxreturnbd.model;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Methods {
    public static String dateText(long timestamp){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        String dateText = simpleDateFormat.format(calendar.getTime());
        return  dateText;
    }
    public static String dateTimeText(long timestamp){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy h:m:s");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        String dateText = simpleDateFormat.format(calendar.getTime());
        return  dateText;
    }

    public static String indianCurrencyFormat(long amount){
        DecimalFormat formatter = new DecimalFormat("#,##,###.00");
        return formatter.format(amount);
    }
}
