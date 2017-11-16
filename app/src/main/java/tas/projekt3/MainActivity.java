package tas.projekt3;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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


public class MainActivity extends ActionBarActivity {
    private TextView textview;
    private TextView textview2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.idb);
        Button button2= (Button) findViewById(R.id.idb2);
        textview = (TextView) findViewById(R.id.idtv);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                new JSONTask().execute("http://uam.grzegorz2047.pl:8080/opinions/all");
            }
    });
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                new JSONTask2().execute("http://uam.grzegorz2047.pl:8080/products/all");
            }
        });

}
    public class JSONTask extends AsyncTask<String,String,String> {
    protected String doInBackground(String... params) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
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
            JSONArray array = finalObject.getJSONArray("opinions");
            StringBuffer FinalBuffer = new StringBuffer();
            for(int i=0;i<array.length();i++ ){
                JSONObject podobject=array.getJSONObject(i);
                String id = podobject.getString("id");
                String nazwa = podobject.getString("productName");
                String opinion2 = podobject.getString("generalOpinion");
                String pros = podobject.getString("pros");
                String cons = podobject.getString("cons");
                int score = podobject.getInt("score");
                FinalBuffer.append(id  +" Nazwa: "+ nazwa + "; Opinia: " + opinion2+ "; Zalety: " + pros+ "; Wady: " +cons+ "; Ocena: "+score+ "\n");
            }
            return(FinalBuffer.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (JSONException e){
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
       /* setContentView(R.layout.drugilayout);
        Button button3= (Button) findViewById(R.id.powrot);
        textview2 = (TextView) findViewById(R.id.tV2);*/
        textview.setText(result);
    }
}
    public class JSONTask2 extends AsyncTask<String,String,String> {
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
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
        /*    setContentView(R.layout.drugilayout);
            Button button3= (Button) findViewById(R.id.powrot);
            textview2 = (TextView) findViewById(R.id.tV2);*/
            textview.setText(result);
        }
    }
}

//gkugjfhjfhf