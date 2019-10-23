package orange;

import java.io.FileInputStream;
import java.util.Properties;

public class LoadProps {
    static Properties props;

    static FileInputStream inputStream;

    public String getProperty(String Key){
        props =new Properties();


        try {
            inputStream = new FileInputStream("src\\test\\java\\Resource\\TestData\\testdataConfig.properties");
            props.load(inputStream);
            inputStream.close();
        }catch (java.io.IOException e){
            e.printStackTrace();
        }
        return props.getProperty(Key);


    }


}
