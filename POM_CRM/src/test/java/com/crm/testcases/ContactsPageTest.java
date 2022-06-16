package com.crm.testcases;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.util.TestUtil;
import net.bytebuddy.build.Plugin;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;
    String sheetName = "contacts";

    public ContactsPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        testUtil.switchToFrame();
        //contactsPage = homePage.clickOnContactsLink();

    }

    @Test(priority = 1)
    public void verifyContactsPageLabel(){
        contactsPage = homePage.clickOnContactsLink();
        Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
    }
    @Test(priority = 2)
    public void selectContactsTest(){
        contactsPage = homePage.clickOnContactsLink();
        contactsPage.selectContactsByName("Raghav Roy");
    }
    @Test(priority=3)
    public void selectMultipleContactsTest(){
        contactsPage = homePage.clickOnContactsLink();
        contactsPage.selectContactsByName("Raghav Roy");
        contactsPage.selectContactsByName("Simmy Sen");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
