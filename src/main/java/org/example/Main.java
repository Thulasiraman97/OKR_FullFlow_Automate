package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.List;

public class Main{
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        ChromeSetting();
        CreateObjective();
        Create_KeyResults();
        Create_KeyInitiative();
        Create_MyTask();
        Create_SubTask();
    }
    static void ChromeSetting(){
        System.setProperty("Chrome","C:\\Users\\HEPL\\Downloads\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://localhost/project_management_okr_mis/public/login");
        driver.manage().window().maximize();
    }
    static void CreateObjective(){
        driver.findElement(By.id("email")).sendKeys("venkateshv@cavinkare.com");
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.linkText("Project Dashboard")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Tab View']")).click();
        driver.findElement(By.xpath("//button[@id='add_yearly_modal_clear']")).click();
        driver.switchTo().activeElement();
        driver.findElement(By.xpath("//div[@id='select2-objective_type-container']")).click();
        driver.findElement(By.xpath("//div[@class='select2-search select2-search--dropdown']//input[@role='searchbox']")).sendKeys("Yearly"+ Keys.ENTER);
        WebElement user=driver.findElement(By.xpath("//div[@class='select2-selection select2-selection--multiple']"));
        user.sendKeys("Binu"+Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='user_weightage119']")).sendKeys("30");
        driver.findElement(By.xpath("//textarea[@id='m_objective_yearly']")).sendKeys("Testing OKR");
        driver.findElement(By.id("add_yearly_form")).click();
        logout();

    }
    static  void Create_KeyResults() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys("binu@cavinkare.com");
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.linkText("Project Dashboard")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Tab View']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Key Results']")).click();
        driver.findElement(By.xpath("//a[@id='card3-quarterly-tab']")).click();
        driver.findElement(By.xpath("//div[@class='col-xl-3 col-lg-3 col-md-3 col-sm-12 col-12 mt-3']//button[@id='add_quarterly_modal_clear']")).click();
        driver.switchTo().activeElement();
        WebElement dropdownElement = driver.findElement(By.xpath("//div[@id='select2-m_objective_quarterly-container']"));
        dropdownElement.click();
        dropdownElement.click();
        dropdownElement.click();
        List<WebElement> check = driver.findElements(By.xpath("//div[@class='select2-results']/ul/li"));
        for (WebElement ss : check) {
            String drop = ss.getText();
            if (drop.contains("Testing OKR")) {
                ss.click();
                break;
            }
        }
        WebElement UOM = driver.findElement(By.xpath("//select[@id='quarterly_uom']"));
        Select select = new Select(UOM);
        select.selectByValue("Percentage");
        driver.findElement(By.xpath("//input[@id='quarterly_target_amount']")).sendKeys("70");
        driver.findElement(By.xpath("//form[@id='add_quarterly_form']//li[@class='select2-search select2-search--inline']")).click();
        driver.findElement(By.xpath("//div[@aria-expanded='true']//input[@role='searchbox']")).sendKeys("Rajesh Kumar Rastogi" + Keys.ENTER);
        driver.findElement(By.id("user_weightage176")).sendKeys("20");
        driver.findElement(By.id("user_target_kr176")).sendKeys("40");
        driver.findElement(By.xpath("//textarea[@id='m_task_quarterly']")).sendKeys("Testing Key Results");
        driver.findElement(By.xpath("//div[@id='add_quarterly_modal']//button[@type='submit'][normalize-space()='Submit']")).click();
        Thread.sleep(2000);
        logout();
    }
    static void Create_KeyInitiative(){
        driver.findElement(By.id("email")).sendKeys("rajeshr@cavinkare.com");
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.linkText("Project Dashboard")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Tab View']")).click();
        driver.findElement(By.xpath("//a[@role='button'][normalize-space()='Key Initiative']")).click();
        driver.findElement(By.xpath("//a[@id='portlet2-home-tab']")).click();
        driver.findElement(By.xpath("//button[@id='add_monthly_modal_clear']")).click();
        driver.switchTo().activeElement();
        WebElement dropdownElement = driver.findElement(By.xpath("//div[@id='select2-m_task_monthly_quarterly-container']"));
        dropdownElement.click();
        dropdownElement.click();
        dropdownElement.click();
        List<WebElement> check = driver.findElements(By.xpath("//ul[@id='select2-m_task_monthly_quarterly-results']/li"));
        for (WebElement ss : check) {
            String drop = ss.getText();
            if (drop.contains("Testing Key Results")) {
                ss.click();
                break;
            }
        }
        driver.findElement(By.xpath("//input[@id='m_target_monthly']")).sendKeys("50");
        driver.findElement(By.xpath("//*[@id='key_inti_user_cover']/div/div/div[1]/div")).click();
        driver.findElement(By.xpath("//div[@aria-expanded='true']//input[@role='searchbox']")).sendKeys("Soumya RANJAN Tripathy" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='user_weightage_keyinit190']")).sendKeys("20");
        driver.findElement(By.xpath("//input[@id='user_target_keyinit190']")).sendKeys("60");
        driver.findElement(By.xpath("//textarea[@id='m_task_monthly']")).sendKeys("Testing Key Initiative");
        List<WebElement> radio=driver.findElements(By.name("option1"));
        for (WebElement Rbutton:radio) {
            if (Rbutton.getAttribute("value").equalsIgnoreCase("1")){
                Rbutton.click();
            }
        }
        driver.findElement(By.xpath("//div[@id='add_monthly_modal']//button[2]")).click();
        logout();
    }
    static void Create_MyTask() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys("tsoumya@cavinkare.com");
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.linkText("Project Dashboard")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Tab View']")).click();
        driver.findElement(By.xpath("//a[@role='button'][normalize-space()='Task']")).click();
        driver.findElement(By.xpath("//a[@id='card3-mytask-tab']")).click();
        driver.findElement(By.xpath("//div[@id='card3-mytask']//button")).click();
        driver.switchTo().activeElement();
        WebElement dropdownElement = driver.findElement(By.xpath("//div[@id='select2-m_keyinitiative_weekly-container']"));
        dropdownElement.click();
        dropdownElement.click();
        dropdownElement.click();
        List<WebElement> divElement=driver.findElements(By.xpath("//ul[@id='select2-m_keyinitiative_weekly-results']//li"));
        for (WebElement element : divElement) {
            if (element.getText().contains("Testing Key Initiative")){
                element.click();
                break;
            }
        }
        driver.findElement(By.xpath("//*[@id='add_weekly_modal']/div/div/div[2]/div/div[1]/div[3]/div/div/div[1]/div")).click();
        driver.findElement(By.xpath("//div[@aria-expanded='true']//input")).sendKeys("Mahender Singh"+ Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='m_target_weekly']")).sendKeys("50");
        driver.findElement(By.xpath("//*[@id='user_weightage_task94']")).sendKeys("30");
        driver.findElement(By.xpath("//*[@id='user_target_task94']")).sendKeys("70");
        driver.findElement(By.xpath("//textarea[@id='m_task_weekly']")).sendKeys("Testing My Task");
        driver.findElement(By.xpath("//button[@id='add_weekly_form']")).click();
        Thread.sleep(2000);
        logout();
    }
    static void Create_SubTask() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys("mahender@cavinkare.com");
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.linkText("Project Dashboard")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Tab View']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Sub Task']")).click();
        driver.findElement(By.xpath("//a[@id='card3-subtask-tab']")).click();
        driver.findElement(By.xpath("//button[@id='add_sub_task_modal_clear']")).click();
        driver.switchTo().activeElement();
        Thread.sleep(1000);
        WebElement dropdownElement = driver.findElement(By.xpath("//div[@id='select2-m_task_subtask-container']"));
        dropdownElement.click();
        dropdownElement.click();
        dropdownElement.click();
        List<WebElement> divElement=driver.findElements(By.xpath("//ul[@id='select2-m_task_subtask-results']//li"));
        for (WebElement element : divElement) {
            if (element.getText().contains("Testing My Task")){
                element.click();
                break;
            }
        }
        driver.findElement(By.xpath("//*[@id='add_sub_task_modal']/div/div/div[2]/div/div[1]/div[3]/div/div/div[1]/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@aria-expanded='true']//input")).sendKeys("Mahender Singh"+ Keys.ENTER);
        driver.findElement(By.xpath("//*[@id='m_target_subtask']")).sendKeys("100");
        driver.findElement(By.xpath("//textarea[@id='get_task_subtask']")).sendKeys("Final Sub Task Testing ");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='add_subtask_form']")).click();
        Thread.sleep(2000);
        logout();
    }
    static void logout(){
        driver.navigate().to("http://localhost/project_management_okr_mis/public/logout");
    }

}