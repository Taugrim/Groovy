package pages;

import implemet.DF;
import interfaces.BasePage;
import interfaces.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
//@Scope("prototype")
class BP implements BasePage {
    Logger log;
    protected WebDriver driver;
    @Autowired
    DF driverFactory;

    @PostConstruct
    public void init(){
        this.driver = driverFactory.getDriver();
        PageFactory.initElements(new DefaultFieldDecorator( new DefaultElementLocatorFactory(driver)), this);
    }
    public void set(DriverFactory driverFactory) {
        this.driver = driverFactory.getDriver();
//        PageFactory.initElements(new DefaultFieldDecorator( new DefaultElementLocatorFactory(driver)), this);
    }

    public void setLog(Logger log) {
        this.log = log;
    }
}
