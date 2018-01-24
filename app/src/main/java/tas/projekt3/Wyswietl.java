package tas.projekt3;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Wyswietl extends ActionBarActivity {
    private TextView textview;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.idb);
        Button button2= (Button) findViewById(R.id.idb2);
        Button button3= (Button) findViewById(R.id.idb3);
        final EditText et1=(EditText) findViewById(R.id.editText4);
        final EditText et2=(EditText) findViewById(R.id.editText5);
        textview = (TextView) findViewById(R.id.idtv);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                new JSONTask().execute("http://uam.grzegorz2047.pl:8080/products/all",et1.getText().toString(),et2.getText().toString());
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                new JSONTask2().execute("http://uam.grzegorz2047.pl:8080/users/all",et1.getText().toString(),et2.getText().toString());
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                new JSONTask3().execute("http://uam.grzegorz2047.pl:8080/products/all",et1.getText().toString(),et2.getText().toString());
            }
        });

    }
    public class JSONTask extends AsyncTask<String,String,String> {
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            final String basicAuth = "Basic " + Base64.encodeToString((params[1] + ':' + params[2]).getBytes(), Base64.NO_WRAP);
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("Authorization", basicAuth);
                connection.connect();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                String finalJSON = buffer.toString();
                JSONObject finalObject = new JSONObject(finalJSON);
                JSONArray array = finalObject.getJSONArray("products");
                StringBuffer FinalBuffer = new StringBuffer();
                for (int i = 0; i < array.length(); i++) {
                    JSONObject podobject = array.getJSONObject(i);
                    String id = podobject.getString("id");
                    String nazwa = podobject.getString("name");
                    FinalBuffer.append(id + " Nazwa: " + nazwa );
                    JSONArray array2 = podobject.getJSONArray("opinions");
                    for(int j=0;j<array2.length();j++){
                        FinalBuffer.append("Opinia nr " + (j+1));
                        JSONObject opinieobject=array2.getJSONObject(j);
                        String pros=opinieobject.getString("pros");
                        String cons=opinieobject.getString("cons");
                        FinalBuffer.append(" Zalety: " + pros + "," );
                        FinalBuffer.append(" Wady: " +cons+ "\n");
                    }
                    FinalBuffer.append("\n");
                }
                return (FinalBuffer.toString());

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            textview.setText(result);
        }
    }
    public class JSONTask2 extends AsyncTask<String,String,String> {
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            final String basicAuth = "Basic " + Base64.encodeToString((params[1] + ':' + params[2]).getBytes(), Base64.NO_WRAP);
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("Authorization", basicAuth);
                connection.connect();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                String finalJSON = buffer.toString();
                JSONObject finalObject = new JSONObject(finalJSON);
                JSONArray array = finalObject.getJSONArray("users");
                StringBuffer FinalBuffer = new StringBuffer();
                for (int i = 0; i < array.length(); i++) {
                    JSONObject podobject = array.getJSONObject(i);
                    String id = podobject.getString("id");
                    String nazwa = podobject.getString("name");
                    FinalBuffer.append(id + " Nazwa: " + nazwa + "\n");
                }
                return (FinalBuffer.toString());

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            textview.setText(result);
        }
    }
    public class JSONTask3 extends AsyncTask<String,String,String> {
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            final String basicAuth = "Basic " + Base64.encodeToString((params[1]+':'+params[2]).getBytes(), Base64.NO_WRAP);
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty ("Authorization", basicAuth);
                connection.connect();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                String finalJSON= buffer.toString();
                JSONObject finalObject=new JSONObject(finalJSON);
                JSONArray array = finalObject.getJSONArray("products");
                StringBuffer FinalBuffer = new StringBuffer();
                for(int i=0;i<array.length();i++ ){
                    JSONObject podobject=array.getJSONObject(i);
                    String id = podobject.getString("id");
                    String nazwa = podobject.getString("name");
                    FinalBuffer.append(id  + " Nazwa: "+ nazwa +  "\n");
                }
                return(FinalBuffer.toString());

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e){
                e.printStackTrace();
            }
            finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            textview.setText(result);
        }
    }





}