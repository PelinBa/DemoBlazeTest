Feature: Purchase product from DemoBlaze site
  Scenario: User register, login and purchase product
    Given Open main page, register user and check "Sign up successful." message
    When Login user and check the name of user
    And Go to product, check the product info and add to cart
      | Name        | HTC One M9                                                                                                                                                                                                  |
      | Price       | $700 *includes tax                                                                                                                                                                                          |
      | Description | The HTC One M9 is powered by 1.5GHz octa-core Qualcomm Snapdragon 810 processor and it comes with 3GB of RAM. The phone packs 32GB of internal storage that can be expanded up to 128GB via a microSD card. |
    And Go to cart page, check the product info and open purchase form
      | Name        | HTC One M9 |
      | Price       | 700        |
    Then Fill the purchase form and check success message
      | Name                 | TestUser                           |
      | Country              | Turkiye                            |
      | City                 | Eskisehir                          |
      | Card                 | 11111111                           |
      | Month                | 10                                 |
      | Year                 | 2025                               |
      | SuccessMessageTitle  | Thank you for your purchase!       |
