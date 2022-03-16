package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US1 extends TestBase {



        @DataProvider(name= "drivers")
        public Object[][] driverUsernameData(){
            return new Object[][]{
                    {"user1"},{"user2"},{"user3"}
            };
        }
        @DataProvider (name= "storeManagers")
        public Object[][] StoreManagersUsernameData(){
            return new Object[][]{
                    {"storemanager55"}
            };
        }
        @DataProvider (name= "salesManagers")
        public Object[][] SalesManagersUsernameData(){
            return new Object[][]{ {"salesmanager260"},{"salesmanager261"},{"salesmanager262"}

            };
        }


        @Test(dataProvider = "drivers")
        public void verifyModulesForDrivers(String username) {
            VytrackUtils.login(username, ConfigurationReader.getProperty("password"));
            BrowserUtils.sleep(1);
            List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));
            List<String> actualModuleElements=new ArrayList<>();

            for (WebElement moduleElement : moduleElements) {
                String moduleElementText = moduleElement.getText();
                actualModuleElements.add(moduleElementText);
            }

            List <String> expectedModuleElements = new ArrayList<>(Arrays.asList("Fleet", "Customers", "Activities", "System"));
            Assert.assertEquals(actualModuleElements,expectedModuleElements);

        }


        @Test (dataProvider = "storeManagers")
        public void verifyModulesForStoreManagers(String username) {
            VytrackUtils.login(username, ConfigurationReader.getProperty("password"));
            BrowserUtils.sleep(1);
            List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));
            List<String> actualModuleElements=new ArrayList<>();

            BrowserUtils.sleep(2);
            for (WebElement moduleElement : moduleElements) {
                String moduleElementText = moduleElement.getText();
                actualModuleElements.add(moduleElementText);
            }
            List <String> expectedModuleElements = new ArrayList<>(Arrays.asList("Dashboards",
                    "Fleet",
                    "Customers",
                    "Sales",
                    "Activities",
                    "Marketing",
                    "Reports & Segments",
                    "System"));
            Assert.assertEquals(actualModuleElements,expectedModuleElements);

        }


        @Test (dataProvider = "salesManagers")
        public void verifyModulesForSalesManagers(String username) {
            VytrackUtils.login(username, ConfigurationReader.getProperty("password"));
            BrowserUtils.sleep(1);
            List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));
            List<String> actualModuleElements=new ArrayList<>();

            for (WebElement moduleElement : moduleElements) {
                String moduleElementText = moduleElement.getText();
                actualModuleElements.add(moduleElementText);
            }
            List <String> expectedModuleElements = new ArrayList<>(Arrays.asList("Dashboards",
                    "Fleet",
                    "Customers",
                    "Sales",
                    "Activities",
                    "Marketing",
                    "Reports & Segments",
                    "System"));
            Assert.assertEquals(actualModuleElements,expectedModuleElements);

        }





    }

