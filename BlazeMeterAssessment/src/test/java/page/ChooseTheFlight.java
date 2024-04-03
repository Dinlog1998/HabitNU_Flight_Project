package page;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import base.BaseClass;

public class ChooseTheFlight extends BaseClass {

    By allRows = By.xpath("//table[@class='table']//tr");

    public void selectingFlights() {
        List<WebElement> rowLinks = com.multipleElementsLocator(allRows);
        int rows = rowLinks.size();
       
        double minValue = Double.MAX_VALUE;
        int minRow = -1;

        // Start from row = 1 assuming the first row might be headers
        for (int row = 1; row < rows; row++) {
            try {
                WebElement cell = driver.findElement(By.xpath("//table[@class='table']//tr[" + row + "]/td[6]"));
                String text = cell.getText().replace("$", ""); // Assuming the text is in format "$123.45"
                double value = Double.parseDouble(text);

                if (value < minValue) { //458
                    minValue = value; 
                    minRow = row;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Unable to find element for row " + row);
            }
        }

        // After identifying the minimum, perform click
        if (minRow != -1) {
            WebElement submitButton = com.elementsLocator(By.xpath("//table[@class='table']//tr[" + minRow + "]/td//input[@type='submit']"));
            submitButton.click();
        }
    }
}
