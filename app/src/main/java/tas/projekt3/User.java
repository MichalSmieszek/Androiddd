package tas.projekt3;

/**
 * Created by User on 18-01-2018.
 */

public class User {
    private String nick="a";
    private String pass="b";
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
    User(){
        nick="Grzegorz";
        pass="admin1";
    }
}
