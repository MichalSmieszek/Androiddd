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



public class Wyslijop extends ActionBarActivity {
    protected void onCreate(Bundle savedInstanceState) {
        final EditText nick,haslo,produkt,zaleta;
        Button button;
        final AsyncHttpClient client = new AsyncHttpClient();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wyslijop);
        produkt = (EditText) findViewById(R.id.editText8);
        button = (Button) findViewById(R.id.button2);
        nick = (EditText) findViewById(R.id.editText6);
        haslo = (EditText) findViewById(R.id.editText7);
        zaleta = (EditText) findViewById(R.id.editText9);
       button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                RequestParams params = new RequestParams();
                params.put("product", produkt.getText().toString());
                params.put("pros",zaleta.getText().toString());
                client.setBasicAuth(nick.getText().toString(),haslo.getText().toString());
                client.get("http://uam.grzegorz2047.pl:8080/opinions/add", params, new JsonHttpResponseHandler() {
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
