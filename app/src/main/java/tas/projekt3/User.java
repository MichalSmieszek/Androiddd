package tas.projekt3;

/**
 * Created by User on 18-01-2018.
 */

public class User {
    private String nick=null;
    private String pass=null;
    public void setnick(String s){
        nick=s;
    }
    public void setpass(String s){
        pass=s;
    }
    public String getpass(){
        return pass;
    }
    public String getnick(){
        return nick;
    }
}
