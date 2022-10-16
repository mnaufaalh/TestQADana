package steps;

import global.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class DeleteToDo extends BaseClass {
    Integer totalTask;
    Integer totalCurrent;
    @Given("Choose task")
    public void chooseTask() {
        totalTask = driver.findElements(By.className("android.widget.CheckBox")).size();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout")).click();
    }

    @When("Click delete task")
    public void clickDeleteTask() {
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.support.v7.widget.LinearLayoutCompat/android.widget.TextView")).click();
    }

    @Then("The task deleted success")
    public void theTaskDeletedSuccess() {
        totalCurrent = driver.findElements(By.className("android.widget.CheckBox")).size();
        totalTask = totalTask - 1;
        Assert.assertEquals(totalCurrent, totalTask);
    }
}
