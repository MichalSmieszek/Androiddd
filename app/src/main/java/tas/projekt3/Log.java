package tas.projekt3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class Log extends ActionBarActivity {
    private TextView textview;
    private User user;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log);
        Button button = (Button) findViewById(R.id.btn1);
     //   final EditText nick = (EditText) findViewById(R.id.eT2);
      //  final EditText haslo = (EditText) findViewById(R.id.eT3);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v) {
            //    user.setnick(nick.toString());
             //   user.setpass(haslo.toString());
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
    });
    }
}