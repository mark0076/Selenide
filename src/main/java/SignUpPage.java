import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SignUpPage {

    public SignUpPage open(){
        Selenide.open("/");
        return this;
    }

   private By emailField =By.cssSelector("input#register-email");
   private By confirmEmailField= By.cssSelector("input#register-confirm-email");
   private By passwordField = By.cssSelector("input#register-password");
   private By nicknameField =By.cssSelector("input#register-displayname");
   private By monthDropDown = By.cssSelector("select#register-dob-month");
   private String getMonthDropDownOption = "//select[@id=\"register-dob-month\"]/option[text()='%s']";
   private By dayInput = By.cssSelector("input#register-dob-day");
   private By yearInput = By.cssSelector("input#register-dob-year");
   private String genderRadioButton = ("//li[@id=\"li-gender\"]//label[normalize-space()='%s']");
   private By shareCheckBox = By.cssSelector("input#register-thirdparty");
   private By registerButton = By.cssSelector("a#register-button-email-submit");
   private By errorLabel =By.xpath("//label[@class ='has-error' and string-length(text())>0]");
   private String errorByText ="//label[@class =\"has-error\" and text()=\"%s\"]";

    public SignUpPage typeEmail(String email){
        $(emailField).setValue(email);
        return this;
    }
    public SignUpPage typeConfirmEmail (String confirmEmail){
        $(confirmEmailField).setValue(confirmEmail);
        return this;
    }

    public SignUpPage typePassword(String password){
        $(passwordField).setValue(password);
        return this;
    }
    public SignUpPage typeNickname(String nickname){
        $(nicknameField).setValue(nickname);
        return this;
    }
    public SignUpPage setMonth(String month){
        $(monthDropDown).selectOption(month);
        return this;
    }
    public SignUpPage setDay(String day){
        $(dayInput).setValue(day);
        return this;
    }
    public SignUpPage setYear(String year){
        $(yearInput).setValue(year);
        return this;
    }
    public  SignUpPage setSex(String value){
        $(By.xpath(String.format(genderRadioButton,value))).click();
        return this;
    }
    public SignUpPage setShare(boolean value){
        $(shareCheckBox).setSelected(value);

        WebElement checkBox = $(shareCheckBox);
        if(!checkBox.isSelected()== value) checkBox.click();
        return this;
    }
    public void  clickSignUpButton(){
        $(registerButton).click();
    }

    public ElementsCollection getErrors(){
        return $$(errorLabel);
    }
    public SelenideElement getErrorByNumber(int number){
        return getErrors().get(number-1);
    }
    public SelenideElement getError (String message){
        return $(By.xpath(String.format(errorByText,message)));
    }


}
