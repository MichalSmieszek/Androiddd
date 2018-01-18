package tas.projekt3;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends ActionBarActivity {
    private TextView textview;
    private User user;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.powitalny);
        Button button = (Button) findViewById(R.id.btn1);
        Button button1=(Button) findViewById(R.id.btn2);
        Button button2=(Button) findViewById(R.id.btn3);
        textview = (TextView) findViewById(R.id.idtv);
        button.setOnClickListener(new View.OnClickListener(){
        public void onClick (View v) {
            Intent intent = new Intent(getApplicationContext(),Wyswietl.class);
            startActivity(intent);
        }
    });
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v) {
                Intent intent = new Intent(getApplicationContext(),Log.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v) {
                Intent intent = new Intent(getApplicationContext(),Wyslij.class);
                startActivity(intent);
            }
        });

    }
}
//https://www.youtube.com/watch?v=28jA5-mO8K8