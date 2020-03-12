
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;

public class SignUpTest {

    SignUpPage page;

    @BeforeEach
    public  void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Mark\\Desktop\\Учеба\\drivers\\chromedriver.exe");
        baseUrl ="https://www.spotify.com/us/signup";
        browser ="chrome";
    }

    @Test
    public  void typeInvalidYear(){
        page = new SignUpPage();
        page.open();
        page.setMonth("April")
                .setDay("28")
                .setYear("11")
        .setShare(true);
        page.getError("Please enter a valid year.").shouldBe(visible);
        page.getError("Please enter your birth month.").shouldNotBe(visible);
    }

    @Test
    public void typeInvalidEmail(){
        page = new SignUpPage();
        page.open();
        page.typeConfirmEmail("12312@FS.e");
        page.typeEmail("ram@mfa.eedas");
        page.clickSignUpButton();
        page.getError("Email address doesn't match.").shouldBe(visible);
    }
    @Test
    public void SignUpWithEmptyPasswordField(){
        page=new SignUpPage();
        page.open();
        page.typeEmail("dsad@fsd.re");
        page.typeConfirmEmail("dasdsa@fsd.ew");
        page.typeNickname("dasas");
        page.clickSignUpButton();
        page.getError("Enter a password to continue.").shouldBe(visible);


    }
    @Test
    public void typeInvalidValues(){
        page = new SignUpPage();
        page.open();
        page.setSex("Male");
       page.typeEmail("djasm@rw.da")

          .typeConfirmEmail("dasdas@das.sa")
            .typeNickname("saWDa")
            .setDay("12")
            .setMonth("April")
                .setYear("12")
                .typePassword("dad2")
                .setShare(false)
                .clickSignUpButton();
        page.getErrors().shouldHave(size(3));
        page.getErrorByNumber(1).shouldHave(text("Email address doesn't match."));


    }





}
