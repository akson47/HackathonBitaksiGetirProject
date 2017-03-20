package com.yusufakson.hackathonbitaksigetirproject.tools;



import android.support.v7.app.AppCompatActivity;
import com.tapadoo.alerter.Alerter;
import com.yusufakson.hackathonbitaksigetirproject.R;


/**
 * @author yusuf akson
 */

public class AlertDialogHelper {

    private AppCompatActivity activity;


    public AlertDialogHelper(AppCompatActivity activity) {
        this.activity = activity;
    }


    public void showAlertEmpty(String message) {
        Alerter.create(activity)
                .setTitle("Uyarı!")
                .setText(message)
                .setBackgroundColor(R.color.colorAlertEmpty)
                .show();
    }


}
