Feature: Creating a new employee

  @positive
  Scenario Outline: Validating the ability to create a new employee in an organization when valid employee data is provided
    When Siva requests to create a new employee with data "<name>",<age>,<salary> and "<profilepic>"
    Then he should be able to create a new employee successfully
    Examples:
      | name       | age | salary | profilepic                                                          |
      | Sivaganesh | 33  | 54000  | https://brain-images-ssl.cdn.dixons.com/7/0/10198807/t_10198807.jpg |
      | Aadhav     | 23  | 29000  | https://brain-images-ssl.cdn.dixons.com/7/0/10198807/t_10198807.jpg |

  @negative
  Scenario Outline: Validating the ability to restrict new employee creation in an organization when invalid employee data is provided
    When Siva requests to create a new employee with data "<name>",<age>,<salary> and "<profilepic>"
    Then he should not be able to create a new employee
    Examples:
      | name   | age | salary | profilepic                                                          |
      | 1      | 0   | 54000  | https://brain-images-ssl.cdn.dixons.com/7/0/10198807/t_10198807.jpg |
      | Aadhav | -10 | 29000  | https://brain-images-ssl.cdn.dixons.com/7/0/10198807/t_10198807.jpg |
