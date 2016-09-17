package www.ensch.webvista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    WebView webView;
    String home="http://www.google.com";
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boton1=(Button) findViewById(R.id.button1);
        boton1.setOnClickListener(this);
        Button boton2=(Button) findViewById(R.id.button2);
        boton2.setOnClickListener(this);
        Button boton3=(Button) findViewById(R.id.button3);
        boton3.setOnClickListener(this);
        tv=(TextView) findViewById(R.id.textView1);

        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new Client());
        WebSettings webSettings=webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(home);
    }

    class Client extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            return(false);
        }
        @Override
        public void onPageFinished(WebView view, String url){
            tv.setText(url);
        }
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.button1)
            webView.goBack();
        else if (id==R.id.button2)
            webView.loadUrl(home);
        else if (id==R.id.button3)
            webView.goForward();
    }
}
