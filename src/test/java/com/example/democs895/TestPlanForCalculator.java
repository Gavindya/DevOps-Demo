package com.example.democs895;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestPlanForCalculator {

    private static final WebDriver driver = new ChromeDriver();
//    private static final WebDriver driver = new SafariDriver();

    @LocalServerPort
    private int port;

    private String base;

    @BeforeEach
    public void setUp() throws Exception {
        this.base = "http://localhost:" + port + "/calculator";
    }

    @Test
    void testAddition(){
        driver.get(this.base);

        System.out.println(this.base);

        // Create a WebForm with Left operand = 5, Right operand = 30, and Operator is +
        WebFormForCalculator webFormForCalculator = new WebFormForCalculator(driver,"5","30","+","35.0");

        // Wait until element "leftOperand" is present in the current web page
        WebElement myDynamicElement =  (new WebDriverWait(driver, 100)).until(ExpectedConditions.presenceOfElementLocated(By.id("leftOperand")));

        // Enter Left Operand
        webFormForCalculator.enterLeftOperand();
        // Enter Right Operand
        webFormForCalculator.enterRightOperand();
        // Enter Operator
        webFormForCalculator.enterOperator();
        // Submit the Form to perform the  calculation
        webFormForCalculator.pressSubmitButton();

        // Previous page
        String winHandleBefore = driver.getWindowHandle();

        // Switch to the currently opened window
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        // After getting the currently opened window, some wait is be added to reload page.
        // It will provide small delay which is helpful for SeleniumDriver to identify elements.
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        String actual_result = webFormForCalculator.getAnswer();
        String expected_result = webFormForCalculator.getExpectedAnswer();

        // Compare Expected output and the actual output
        assertEquals(expected_result ,actual_result);
        System.out.println("Rsults of the Addition of 5 and 30: Expected = "
                +expected_result+", Actual = " + actual_result);
    }


    @Test
    void testABoundaryCase(){
        driver.get(this.base);

        System.out.println(this.base);

        WebFormForCalculator webFormForCalculator = new WebFormForCalculator(driver,"5","0","/","Infinity");

        // Wait until element "leftOperand" is present in the current web page
        WebElement myDynamicElement =  (new WebDriverWait(driver, 100)).until(ExpectedConditions.presenceOfElementLocated(By.id("leftOperand")));

        // Enter Left Operand
        webFormForCalculator.enterLeftOperand();
        // Enter Right Operand
        webFormForCalculator.enterRightOperand();
        // Enter Operator
        webFormForCalculator.enterOperator();
        // Submit the Form to perform the  calculation
        webFormForCalculator.pressSubmitButton();

        // Previous page
        String winHandleBefore = driver.getWindowHandle();

        // Switch to the currently opened window
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        // After getting the currently opened window, some wait is be added to reload page.
        // It will provide small delay which is helpful for SeleniumDriver to identify elements.
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        String actual_result = webFormForCalculator.getAnswer();
        String expected_result = webFormForCalculator.getExpectedAnswer();

        // Compare Expected output and the actual output
        assertEquals(expected_result ,actual_result);
        System.out.println("Rsults of a Boundary Case: Division by Zero (5/0): Expected = "
                +expected_result+", Actual = " + actual_result);
    }

    @Test
    void testMultiplication(){
        driver.get(this.base);

        System.out.println(this.base);

        WebFormForCalculator webFormForCalculator = new WebFormForCalculator(driver,"5","2","*","10.0");

        // Wait until element "leftOperand" is present in the current web page
        WebElement myDynamicElement =  (new WebDriverWait(driver, 100)).until(ExpectedConditions.presenceOfElementLocated(By.id("leftOperand")));

        // Enter Left Operand
        webFormForCalculator.enterLeftOperand();
        // Enter Right Operand
        webFormForCalculator.enterRightOperand();
        // Enter Operator
        webFormForCalculator.enterOperator();
        // Submit the Form to perform the  calculation
        webFormForCalculator.pressSubmitButton();

        // Previous page
        String winHandleBefore = driver.getWindowHandle();

        // Switch to the currently opened window
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        // After getting the currently opened window, some wait is be added to reload page.
        // It will provide small delay which is helpful for SeleniumDriver to identify elements.
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        String actual_result = webFormForCalculator.getAnswer();
        String expected_result = webFormForCalculator.getExpectedAnswer();

        // Compare Expected output and the actual output
        assertEquals(expected_result ,actual_result);
        System.out.println("Rsults of the Multiplication of 5 and 2: "
                +expected_result+", Actual = " + actual_result);
    }


    @AfterAll
    static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
