package cn.edu.bistu.cs.se.wordsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cn.edu.bistu.cs.se.words.R;

public class Main2Activity extends AppCompatActivity {
    private EditText editText;
    private WebView webView;
    private Handler tHandler = new Handler();
    private Button b_return;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        webView=(WebView)findViewById(R.id.toutput);
        final Button submit=(Button)findViewById(R.id.submit);
        editText=(EditText)findViewById(R.id.tinput);
        b_return = (Button)findViewById(R.id.b);

        b_return.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSaveFormData(false);
        webSettings.setSavePassword(false);
        webSettings.setSupportZoom(false);
        submit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.setVisibility(WebView.VISIBLE);
                tHandler.post(new Runnable(){
                    public void run(){
                        if (editText.getText().toString() != ""){
                            webView.loadUrl("http://dict.cn/mini.php?q="+ editText.getText().toString());
                        }
                    }
                });
            }
        });
    }
}