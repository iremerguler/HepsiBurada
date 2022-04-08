Feature: HepsiBurada - Adding an item to a shopping cart

  Scenario Outline:
    Given Navigate to HepsiBurada web
    And User should click on search box
    And User should enter search element "<searchElement>"
    And User should click on search button
    And User should click on EnAz
    And User should enter min price "<enAz>"
    And User should click on EnCok
    And User should enter max price "<enCok>"
    And User should click on OK button
    And User should scroll down until see the item
    And User should click on an item
    And User should click on Tum Saticilar
    And User should click on Satici
    And User should click on Satici again
    And User should click on Sepete Ekle of first Satici
    And User should click on Onarım Paketi Istemiyorum
    And User should click on Sepetim

    Examples:
      | searchElement | | enAz | | enCok |
      | cep telefonu  || 3000  || 5000  |

