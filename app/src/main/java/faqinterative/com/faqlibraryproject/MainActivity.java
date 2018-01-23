package faqinterative.com.faqlibraryproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Date;

import faqinterative.com.faqutility.Utility;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Date dateObj = Utility.convertUtcToDateObject("1997-07-16");
//        String date = Utility.convertDateToRequiredStringFormat(dateObj, "dd/MM/yy");
//        Log.d("tttt", date);
//        dateObj = Utility.convertUtcToDateObject("1997-07-16T11:20");
//        date = Utility.convertDateToRequiredStringFormat(dateObj, "dd/MM/yy - hh:mma");
//        Log.d("tttt", "1 >"+date);
//
//        dateObj = Utility.convertUtcToDateObject("1997-07-16T13:20:30");
//        date = Utility.convertDateToRequiredStringFormat(dateObj, "dd/MM/yy - hh:mm:ssa");
//        Log.d("tttt", "2 >"+date);
//
//        dateObj = Utility.convertUtcToDateObject("1997-07-16T15:25:30.45");
//        date = Utility.convertDateToRequiredStringFormat(dateObj, "dd/MM/yy - hh:mm:ssa");
//        Log.d("tttt", "3 >"+date);
//
//        dateObj = Utility.convertUtcToDateObject("1997-07-16T19:20:30.45+01:00");
//        date = Utility.convertDateToRequiredStringFormat(dateObj, "dd/MM/yy - hh:mma");
//        Log.d("tttt", "4 >"+date);
//
//        dateObj = Utility.convertUtcToDateObject("1997-07-16T19:22:30.45-01:00");
//        date = Utility.convertDateToRequiredStringFormat(dateObj, "dd/MM/yy - hh:mm:ssa");
//        Log.d("tttt", "5 >"+date);
//
//        dateObj = Utility.convertUtcToDateObject("1997-07-16T01:22:30Z");
//        date = Utility.convertDateToRequiredStringFormat(dateObj, "dd/MM/yy - hh:mm:ssa");
//        Log.d("tttt", "6 >"+date);
//
//        dateObj = Utility.convertUtcToDateObject("1997-07-16T19:22Z");
//        date = Utility.convertDateToRequiredStringFormat(dateObj, "dd/MM/yy - hh:mma");
//        Log.d("tttt", "7 >"+date);
//
//        if(Utility.isNetworkAvailable(this)){
//            Utility.showAlert(this, "has Int", "has Internet");
//        }else{
//            Utility.showAlert(this, "no Int", "no Internet");
//        }
//
//        Log.d("tttt", "width >"+Utility.getScreenWidth(this));
//        Log.d("tttt", "height >"+Utility.getScreenHeight(this));
//        Log.d("tttt", "current time at UTC >"+Utility.getCurrentTimeAtUtc());
    }
}
