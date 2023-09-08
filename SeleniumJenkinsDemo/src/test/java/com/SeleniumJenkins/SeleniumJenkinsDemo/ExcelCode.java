import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelCode {
    WebDriver driver;

    @Test(dataProvider = "getData")
    public void loginTest(String username, String password) {
        driver = new ChromeDriver();
        driver.get("https://example.com/login");

        WebElement usernameElement = driver.findElement(By.id("username"));
        WebElement passwordElement = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButton.click();

        // Add assertions and further test steps here
        // For demonstration purposes, let's just print the page title
        System.out.println("Page Title: " + driver.getTitle());

        driver.quit();
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = null;
        try {
            Workbook workbook = Workbook.getWorkbook(new java.io.File("C:\\Users\\sdhondge\\Downloads\\data.xls"));
            Sheet sheet = workbook.getSheet(0);
            int rows = sheet.getRows();
            data = new Object[rows][2];

            for (int i = 0; i < rows; i++) {
                Cell usernameCell = sheet.getCell(0, i);
                Cell passwordCell = sheet.getCell(1, i);

                data[i][0] = usernameCell.getContents();
                data[i][1] = passwordCell.getContents();
            }

            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
