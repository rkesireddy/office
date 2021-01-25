package com.technical.assessment.page_objects;

import com.technical.assessment.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultPage extends DriverManager {

    @FindBy(css = ".jsx-1843467667     .jsx-3807182525 ")
    private List<WebElement> vehicleTypes;


    public String extractVehicleTypeDate(String type) {
        StringBuilder str = new StringBuilder();
        vehicleTypes.forEach(vehicleType -> {
            boolean vehicle_type = vehicleType.getText().contains(type);
            if (vehicle_type) {
                List<WebElement> elements = vehicleType.findElements(By.cssSelector(".jsx-3496807389"));
                elements.forEach(s ->str.append(s.getText()+","));
            }
        });
        return str.toString();
    }
}
