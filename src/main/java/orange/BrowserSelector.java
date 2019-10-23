package orange;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserSelector extends Utils {
    //LoadProps loadProps=new LoadProps();

//    public void setupBrowser(){
//
//        String browser= loadProbs.getProperty("browser");
//        if(browser.equalsIgnoreCase("chrome")){
//            System.setProperty("webdriver.chrome.driver", "src\\test\\java\\Resource\\BrowserDriver\\chromedriver.exe");
//            //open the browser
//            driver = new ChromeDriver();
//        }else if (browser.equalsIgnoreCase("firefox")){
//            System.setProperty("webdriver.gecko.driver","src\\test\\java\\Resource\\BrowserDriver\\geckodriver.exe");
//
//            //open the browser
//            driver = new FirefoxDriver();
//        }else if (browser.equalsIgnoreCase("Ie")){
//            System.setProperty("webdriver.ie.driver","src\\test\\java\\Resource\\BrowserDriver\\IEDriverServer.exe");
//            driver = new InternetExplorerDriver();
//        }else {
//            System.out.println("Browser name is empty or typed wrong "+ browser);
//        }


    //public class BrowserSelector extends Utils{
    public static LoadProps loadProps = new LoadProps();
    public static final String USERNAME = loadProps.getProperty(("SAUCE_USERNAME"));
    public static final String ACCESS_KEY = loadProps.getProperty("SAUCE_ACCESS_KEY");
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";

    public static final boolean SAUCE_LAB = Boolean.parseBoolean(System.getProperty("Sauce"));
    public static final String browser = System.getProperty("browser");

    public void setUpBrowser() {
        System.out.println(USERNAME);
        System.out.println(ACCESS_KEY);
        //if sauce lab is true in TestDataConfig.properties.............................................................
        if (SAUCE_LAB) {
            System.out.println("Running in Saucelab...........with browser " + browser);
            if (browser.equalsIgnoreCase("Chrome")) {
                MutableCapabilities sauceOptions = new MutableCapabilities();

                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setExperimentalOption("w3c", true);
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "77.0");
                browserOptions.setCapability("sauce:options", "sauceOptions");
                DesiredCapabilities caps = DesiredCapabilities.chrome();
                caps.setCapability("platform", "Windows 7");
                caps.setCapability("version", "67.0");
                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browser.equalsIgnoreCase("IE")) {
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                caps.setCapability("platform", "Windows 10");
                caps.setCapability("version", "11");

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browser.equalsIgnoreCase("Firefox")) {
                MutableCapabilities sauceOptions = new MutableCapabilities();

                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "69.0");
                browserOptions.setCapability("sauce:options", sauceOptions);


                try {
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
//                else if (browser.equalsIgnoreCase("FireFox"))
//                {
//                    DesiredCapabilities caps = DesiredCapabilities.firefox();
//                    caps.setCapability("platform","Windows 7");
//                    caps.setCapability("version","56");
//                    caps.setCapability("name","Testing on Firefox 56");
//                    try
//                    {
//                        driver = new RemoteWebDriver(new URL(URL),caps);
//                    }
//                    catch (MalformedURLException e)
//                    {
//                        e.printStackTrace();
//                    }
                }
                else if (browser.equalsIgnoreCase("Safari")) {
                    DesiredCapabilities caps = DesiredCapabilities.safari();
                    caps.setCapability("platform", "os x 10.10");
                    caps.setCapability("version", "8.0");
                    try {
                        driver = new RemoteWebDriver(new URL(URL), caps);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();

                    }
                } else if (browser.equalsIgnoreCase("edge")) {
                    DesiredCapabilities caps = DesiredCapabilities.edge();
                    caps.setCapability("platform", "window 10");
                    caps.setCapability("version", "16.16299");
                    try {
                        driver = new RemoteWebDriver(new URL(URL), caps);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("wrong browser name or empty:" + browser);
                }
            } else {
                String browser = loadProps.getProperty("browser");

                if (browser.equalsIgnoreCase("firefox")) {
                    System.setProperty("webdriver.gecko.driver", "src\\test\\java\\Resource\\BrowserDriver\\geckodriver.exe");
                    driver = new FirefoxDriver();
                } else if (browser.equalsIgnoreCase("chrome")) {
                    System.setProperty("webdriver.chrome.driver", "src\\test\\java\\Resource\\BrowserDriver\\chromedriver.exe");
                    driver = new ChromeDriver();
                } else if (browser.equalsIgnoreCase("ie")) {
                    System.setProperty("webdriver.ie.driver", "src\\test\\java\\Resource\\BrowserDriver\\IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                }
            }
        }

    }

