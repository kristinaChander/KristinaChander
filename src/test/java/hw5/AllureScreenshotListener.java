package hw5;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class AllureScreenshotListener extends TestListenerAdapter {

    @Attachment(value = "screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        try {
            return ((TakesScreenshot) WebDriverSingleton.INSTANCE.getDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        takeScreenshot();
    }
}
