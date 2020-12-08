package com.example.webviewbuttons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioButton mRedButton, mGreenButton, mBlueButton,mGoogleButton,myahooButton;
    RadioGroup mRadioGroup, mRadioGroupGooYaho;
    LinearLayout mLinearLayout;
    ConstraintLayout mConstraint;
    WebView mWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRadioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        mRedButton = (RadioButton) findViewById(R.id.radioButtonRed);
        mBlueButton = (RadioButton) findViewById(R.id.radioButtonBlue);
        mGreenButton = (RadioButton) findViewById(R.id.radioButtonGreen);
        mConstraint = (ConstraintLayout) findViewById(R.id.constraint);
        mGoogleButton = (RadioButton) findViewById(R.id.radiogoogle);
        myahooButton = (RadioButton) findViewById(R.id.radioyahoo);
        mRadioGroupGooYaho = (RadioGroup) findViewById(R.id.radiogroupGooYahoo);
        mWeb =(WebView)findViewById(R.id.webview);

        WebSettings browser = mWeb.getSettings();
        browser.setJavaScriptEnabled(true);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == (R.id.radioButtonRed)) {

                    mConstraint.setBackgroundColor(Color.RED);
                    // mRedButton.setTextColor(R.color.colorGreen);
                } else if (checkedId == R.id.radioButtonGreen) {
                    mConstraint.setBackgroundColor(Color.GREEN);
                } else {
                    mConstraint.setBackgroundColor(Color.BLUE);
                }
            }
        });
        mRadioGroupGooYaho.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == (R.id.radiogoogle)){
                    mWeb.setWebViewClient(new MyWebViewClient());
                    mWeb.getSettings().setJavaScriptEnabled(true);
                    mWeb.loadUrl("https://www.google.com");
                    mWeb.setVisibility(View.VISIBLE);
                } else if (checkedId == R.id.radioyahoo){

                    mWeb.setWebViewClient(new MyWebViewClient());
                    mWeb.getSettings().setJavaScriptEnabled(true);
                    mWeb.loadUrl("https://www.yahoo.com");
                    mWeb.setVisibility(View.VISIBLE);


                }
            }
        });
    }
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;

        }
    }
}