package deta;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
    public  static  Properties  userData  = loadProperties(System.getProperty("user.dir") +"\\src\\main\\java\\Properties\\userData.Properties") ;
private static Properties loadProperties(String path) {
    Properties pro = new Properties();

    //System for reading file
    try {
        FileInputStream stream = new FileInputStream(path);
        pro.load(stream);
        stream.close();
    }
    catch (FileNotFoundException e){
        System.out.println("Error Occur" +e.getMessage() );
    }
    catch (IOException s){
        System.out.println("Error Occure" +s.getMessage() );
    }
    return pro ;
}

}
