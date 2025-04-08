package step_definitions;



import core.DriverFactory;
import io.cucumber.java.*;

import static core.Core.driver;

public class Hooks {

    /**
     * This method runs before each scenario.
     */
    @Before
    public void setup() {
        System.out.println("Starting a new test scenario...");
        driver = DriverFactory.createDriver();
    }


    /**
     * This method runs after each scenario.
     */
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("FAILED: " + scenario.getName());
        } else {
            System.out.println("PASSED: " + scenario.getName());
        }
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
