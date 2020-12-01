package com.example.democs895;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebFormForCalculator extends PageObject{

    private String LEFT_OPERAND;
    private String RIGHT_OPERAND;
    private String OPERATOR;
    private String EXPECTED_RESULT;

    @FindBy(id = "leftOperand")
    private WebElement left_operand;

    @FindBy(id = "rightOperand")
    private WebElement right_operand;

    @FindBy(name = "operator")
    private WebElement operator;

    @FindBy(id="submit")
    private WebElement submit_button;

    @FindBy(id = "result")
    private WebElement result;

    public WebFormForCalculator(WebDriver driver,String Left,String Right,
                                String Operator,String ExpectedResult) {
        super(driver);
        this.LEFT_OPERAND = Left;
        this.RIGHT_OPERAND = Right;
        this.OPERATOR = Operator;
        this.EXPECTED_RESULT = ExpectedResult;
    }

    public void enterLeftOperand(){
        this.left_operand.sendKeys(LEFT_OPERAND);
    }

    public void enterRightOperand(){
        this.right_operand.sendKeys(RIGHT_OPERAND);
    }

    public void enterOperator(){
        this.operator.sendKeys(OPERATOR);
    }

    public void pressSubmitButton(){
        this.submit_button.click();
    }

    public String getAnswer(){
        return this.result.getAttribute("value");
    }

    public String getExpectedAnswer(){
        return this.EXPECTED_RESULT;
    }


}