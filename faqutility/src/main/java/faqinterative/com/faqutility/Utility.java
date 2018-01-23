package faqinterative.com.faqutility;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.view.Display;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Asad on 1/16/2018.
 */

public class Utility {

    public static boolean isNetworkAvailable(Context context) {
        if (context != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager == null) {
                return false;
            } else {
                NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
                if (activeNetwork != null) { //connected to the internet.
                    return true;
                }
            }
            return false;
        } else
            return false;
    }

    public static void showAlert(Context context, String title, String message) {
        try {
            final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);

            alertBuilder.setTitle(title);
            alertBuilder.setMessage(message);

            AlertDialog dialog = alertBuilder.create();
            dialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getCurrentTimeAtUtc() {
        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.getDefault());
        return format.format(Date.parse(calendar2.getTime().toString()));
    }

    ///////////////////////
    public static int getScreenWidth(Activity context) {
        Display display = context.getWindowManager().getDefaultDisplay();
        return display.getWidth();
    }

    public static int getScreenHeight(Activity context) {
        Display display = context.getWindowManager().getDefaultDisplay();
        return display.getHeight();
    }

    public static Date convertUtcToDateObject(String utcFormattedDate) {

        if (utcFormattedDate.contains(".")) {
            String[] splitDate = utcFormattedDate.split("\\.");
            utcFormattedDate = splitDate[0];

            if (splitDate[1].contains("+")) {
                String[] splitDate2 = splitDate[1].split("\\+");
                splitDate2[1] = splitDate2[1].replace(":","");
                utcFormattedDate += "+"+splitDate2[1];
            }

            if (splitDate[1].contains("-")) {
                String[] splitDate2 = splitDate[1].split("-");
                splitDate2[1] = splitDate2[1].replace(":","");
                utcFormattedDate += "-"+splitDate2[1];
            }
        }

        Date value = null;
        try {
            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat formatter = new SimpleDateFormat(getDateFormatFromString(utcFormattedDate));
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            value = formatter.parse(utcFormattedDate);

        }catch (Exception e){
            e.printStackTrace();
        }

        return value;
    }

    private static String getDateFormatFromString(String utcDate) {
        switch (utcDate.length()) {
            case 4:
                return "yyyy";
            case 7:
                return "yyyy-MM";
            case 10:
                return "yyyy-MM-DD";
            default:
                return getComplexUtcFormat(utcDate);
        }
    }

    private static String getComplexUtcFormat(String utcDate) {
        if (utcDate.contains("+")) {
            String[] splitDate = utcDate.split("\\+");
            switch (splitDate[0].length()) {
                case 16:
                    return "yyyy-MM-DD'T'hh:mmZ";
                default:
                    return "yyyy-MM-DD'T'hh:mm:ssZ";
            }
        }
        else{
            String[] splitDate = utcDate.split("T");

            if(splitDate[1].contains("-")) {
                String[] splitDate2 = utcDate.split("-");

                switch (splitDate2[0].length()) {
                    case 16:
                        return "yyyy-MM-DD'T'hh:mmZ";
                    default:
                        return "yyyy-MM-DD'T'HH:mm:ssZ";
                }
            }else if(!splitDate[1].contains("Z")){

                switch (utcDate.length()) {
                    case 16:
                        return "yyyy-MM-DD'T'hh:mm";
                    default:
                        return "yyyy-MM-DD'T'HH:mm:ss";
                }
            }else{
                switch (utcDate.length()) {
                    case 17:
                        return "yyyy-MM-DD'T'HH:mm'Z'";
                    default:
                        return "yyyy-MM-DD'T'HH:mm:ss'Z'";
                }
            }
        }
    }

    public static String convertDateToRequiredStringFormat(Date value, String requiredDateFormat){
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat dateFormatter = new SimpleDateFormat(requiredDateFormat);
        dateFormatter.setTimeZone(Calendar.getInstance().getTimeZone());
        return dateFormatter.format(value);
    }
}
