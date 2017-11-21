package tas.projekt3;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

import static android.R.attr.button;


public class MainActivity extends ActionBarActivity {
    private TextView textview;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.powitalny);
        Button button = (Button) findViewById(R.id.btn1);
        textview = (TextView) findViewById(R.id.idtv);
        button.setOnClickListener(new View.OnClickListener(){
        public void onClick (View v) {
            Intent intent = new Intent(getApplicationContext(),Wyswietl.class);
            startActivity(intent);
        }
    });
    }
}
