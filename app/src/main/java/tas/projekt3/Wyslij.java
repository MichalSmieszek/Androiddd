package tas.projekt3;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.*;
import com.loopj.android.http.*;

 import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class Wyslij extends ActionBarActivity {

    private static AsyncHttpClient client = new AsyncHttpClient();
    TextView textview;
    EditText fname;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.wyslij);

        textview = (TextView) findViewById(R.id.textView3);
        fname = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                RequestParams params = new RequestParams();
                params.put("Grzegorz", "admin1");
                client.get("http://uam.grzegorz2047.pl:8080/products/add", params, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        // If the response is JSONObject instead of expected JSONArray
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {

                        System.out.println("");
                    }
                });

            }
        });

    }
}




