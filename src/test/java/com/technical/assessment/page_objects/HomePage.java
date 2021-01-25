package com.technical.assessment.page_objects;

import com.technical.assessment.drivers.DriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends DriverManager {

    @FindBy(css = "input[placeholder='Enter Registration']")
    private WebElement registrationTxt;

    @FindBy(css = ".jsx-4211136584")
    private WebElement freeCarCheckBtn;

    @FindBy(css = "img[aria-label='Car Tax Check']")
    private WebElement home;
    public List<String> getInput() {
        return input;
    }

    public void setInput(List<String> input) {
        this.input = input;
    }

    private List<String> input;

    public List<String> vehicleSearch(List<String> numbers) {
        List<String> output = new ArrayList<>();
        for (String number : numbers) {
            home.click();
            waitUntilElementClickable(registrationTxt).clear();
            registrationTxt.sendKeys(number);
            registrationTxt.sendKeys(Keys.ENTER);
            sleep(3000);
            output.add(new ResultPage().extractVehicleTypeDate("Vehicle Identity"));
        }
        return output;
    }
}
