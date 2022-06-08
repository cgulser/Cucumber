package stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.GuruPage;
import utilities.Driver;

import java.util.List;

public class GuruStepDefinitions {
    /*
    http://demo.guru99.com/test/web-table-element.php sayfasina gidelim
     Cucumber framework’de US1012_Guru_Web_Tables altinda
            Scenario : TC_18_kullanici_sutun_basligi_ile_liste_alabilmeli olusturun ve asagidaki testi yapin
        Given user web sayfasinda
        And “Istenen Baslik”, sutunundaki tum degerleri yazdirir
     */

    GuruPage guruPage=new GuruPage();
    @Given("cookies sorulursa kabul eder")
    public void cookies_sorulursa_kabul_eder() {
        Driver.getDriver().switchTo().frame(guruPage.cookiesIframe);
        guruPage.acceptCookies.click();
    }
    @Given("{string}, sutunundaki tum degerleri yazdirir")
    public void sutunundaki_tum_degerleri_yazdirir(String istenenSutun) {

        List<WebElement> tabloBaslikListesi= guruPage.baslikListesi;
        // listemiz webelementlerden olusuyor
        // dolayisiyla bu webelementlerden hangisi
        // istenen sutun basligini tasiyor bilemeyiz
        int istenenBaslikIndexi=-3;
        for (int i = 0; i < tabloBaslikListesi.size(); i++) {
            if (tabloBaslikListesi.get(i).getText().equals(istenenSutun)){
                istenenBaslikIndexi=i+1;
                break;
            }
        }

        // for loop ile tum sutun basliklarini bana verilen istenenSutun degeri ile karsilastirdim
        // loop biittiginde basligin bulunup bulunmadigini kontrol etmek ve
        // bulundu ise yoluma devam etmek istiyorum

        if (istenenBaslikIndexi != -3){ // baslik bulundu
            List<WebElement> istenenSutundakiElementler=
                    Driver.getDriver().findElements(By.xpath("//tbody//tr//td["+istenenBaslikIndexi+"]"));
            for (WebElement each:istenenSutundakiElementler
            ) {
                System.out.println(each.getText());
            }


        } else{ // baslik bulunamadi
            System.out.println("istenen baslik bulunamadi");
        }

    }
}