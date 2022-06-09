Feature: US1004 kullanici parametre ile configration file' i kullanabilmeli

@sirali @parametre
  Scenario: TC07 configration propetries dosyasindan parametre kullanimini

    Given kullanici "techproeducationUrl" anasayfasinda
    Then kullanici 3 sn bekler
    And url'in "techproeducation" icerdigini test eder
    Then sayfayi kapatir

    # bu satir yorumdur