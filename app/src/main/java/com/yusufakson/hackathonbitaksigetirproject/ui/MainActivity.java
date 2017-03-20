package com.yusufakson.hackathonbitaksigetirproject.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.yusufakson.hackathonbitaksigetirproject.R;
import com.yusufakson.hackathonbitaksigetirproject.model.Elements;
import com.yusufakson.hackathonbitaksigetirproject.model.ItemElements;
import com.yusufakson.hackathonbitaksigetirproject.service.ToolApi;
import com.yusufakson.hackathonbitaksigetirproject.tools.AlertDialogHelper;
import com.yusufakson.hackathonbitaksigetirproject.tools.InputFilterMinMax;
import com.yusufakson.hackathonbitaksigetirproject.view.DrawingView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * Created by lenovo on 20.3.2017.
 *
 * @author yusuf akson
 */

public class MainActivity extends AppCompatActivity {

    AlertDialogHelper alertDialogHelper;

    @InjectView(R.id.ParticipantName)
    EditText ParticipantName;

    @InjectView(R.id.ParticipantEmail)
    EditText ParticipantEmail;

    @InjectView(R.id.ParticipantPhoneNumber)
    EditText ParticipantPhoneNumber;

    @InjectView(R.id.ParticipantKnowledge)
    LinearLayout ParticipantKnowledge;

    @InjectView(R.id.MainLogo)
    LinearLayout Logo;

    @InjectView(R.id.Back)
    LinearLayout Back;


    @InjectView(R.id.drawingView)
    DrawingView drawingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        alertDialogHelper = new AlertDialogHelper(this);

    }

    @OnClick(R.id.GetFigure)
    public void getFigure() {

        String Name = ParticipantName.getText().toString();
        String Email = ParticipantEmail.getText().toString();

        ParticipantPhoneNumber.setFilters(new InputFilter[]{new InputFilterMinMax("11", "11")});
        String PhoneNumber = ParticipantPhoneNumber.getText().toString();

        if (CheckFieldValidation()) {

            Back.setVisibility(View.VISIBLE);
            Logo.setVisibility(View.GONE);

            Call<Elements> call = ToolApi.getApi().element(Name, Email, PhoneNumber);
            call.enqueue(new Callback<Elements>() {
                @Override
                public void onResponse(Response<Elements> response, Retrofit retrofit) {

                    if (response.body() != null) {
                        ParticipantKnowledge.setVisibility(View.GONE);
                        Elements elements = response.body();
                        setView(elements);
                    }

                }

                @Override
                public void onFailure(Throwable t) {

                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @OnClick(R.id.Back)
    void reStartApp() {

        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);

    }

    public void setView(Elements elements) {
        List<ItemElements> itemElementsList = elements.getElements();

        if (itemElementsList != null && !itemElementsList.isEmpty())
            drawingView.initialize(itemElementsList);
    }


    private boolean CheckFieldValidation() {

        boolean valid = true;
        if (ParticipantName.getText().toString().equals("")) {
            alertDialogHelper.showAlertEmpty(getResources().getString(R.string.nameValitadionError));
            valid = false;
        } else if (ParticipantEmail.getText().toString().equals("")) {
            alertDialogHelper.showAlertEmpty(getResources().getString(R.string.emailValitadionError));
            valid = false;
        } else if (ParticipantPhoneNumber.getText().toString().equals("")) {
            alertDialogHelper.showAlertEmpty(getResources().getString(R.string.phoneValitadionError));
            valid = false;
        }

        return valid;

    }
}
