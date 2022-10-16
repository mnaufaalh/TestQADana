package steps;

import global.BaseClass;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class SeeToDo extends BaseClass {
    Integer totalTaskHome;
    Integer totalTaskActive;
    @Given("Click drop down")
    public void clickDropDown() {
        totalTaskHome = driver.findElements(By.className("android.widget.CheckBox")).size();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Filter\"]")).click();
    }

    @When("Click active")
    public void clickActive() {
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView")).click();
    }

    @Then("User see active task")
    public void userSeeActiveTask() {
        totalTaskActive = driver.findElements(By.className("android.widget.CheckBox")).size();
        Assert.assertEquals(totalTaskHome, totalTaskActive);
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Filter\"]")).click();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView")).click();
    }
}
