package Core;

import org.testng.annotations.Parameters;

/**
 * Created by Admin on 18-May-17.
 */
public class Environment {
    public String BASE_URL = "http://localhost";

    public void setEnvironment(String baseUrl){

    }

    public String getBASE_URL(){
    return this.BASE_URL;
    }
}
