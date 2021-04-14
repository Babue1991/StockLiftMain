@MailRepot
Feature: Compose a mail to send extense report

  Scenario: Send an email report after script execution
    Given Extense report file
    When The script execution is over
    Then Send a mail to all recipients
	