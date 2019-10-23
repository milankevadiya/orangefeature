package orange;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest extends Utils{

    LoadProps loadProps = new LoadProps();
    BrowserSelector browserSelector=new BrowserSelector();

    @BeforeMethod
    public void setUp() {
        browserSelector.setUpBrowser();
        //open the browser
        driver.manage().window().fullscreen();
        //set implicity wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        //loadProps.getProperty("url");

    }

    @AfterMethod

    public void close()
    {
        driver.quit();
    }


}
