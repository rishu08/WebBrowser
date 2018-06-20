package com.example.rishabh.webbrowser;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final EditText text = findViewById(R.id.text1);
        Button btn = findViewById(R.id.btgo);
        final WebView weview = findViewById(R.id.webview);

         Intent i = getIntent();
        if(i.getData() != null)
        {
            String t = i.getData().toString();
            i.setAction(Intent.ACTION_VIEW);
//            startActivity(i);
            text.setText(t);
            weview.loadUrl(t);
        }

           btn.setOnClickListener(new View.OnClickListener() {
            @Override
          public void onClick(View view) {
               String t=text.getText().toString();
                if(t.contains("https://"))
                {
                    weview.loadUrl(t);
                }
                else
                 {
                     t = "https://"+t;
                     weview.loadUrl(t);
                 }
                                  }
        });
    }
}
