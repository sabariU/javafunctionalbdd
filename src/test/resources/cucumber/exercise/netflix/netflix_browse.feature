Feature: Provide Browse page for Netflix video library

  Scenario Outline: Render Browse page for Netflix movie library for a basic user
  with total number of titles
    Given The following titles exist in the system
      | s493 | Movie | An Hour and a Half | Wael Ehsan | Eyad Nassar,Ahmed Bedir | Egypt | April 26,2019 | 2012 | TV-14 | 87 min | Dramas,International Movies | Based on the 2002 El Ayyat train accident,this drama begins 90 minutes before the explosion,following the lives of riders in the third-class cars. |
      | s494 | Movie | An Imperfect Murder | James Toback | Sienna Miller,Alec Baldwin | United States | January 13,2021 | 2017 | R | 71 min | Dramas,Thrillers | Haunted by a nightmare involving her abusive ex-boyfriend,an actress begins to question her reality and whether the incident took place. |
      | s496 | Movie | An Interview with God | Perry Lang | Brenton Thwaites,David Strathairn | United States | March 1,2019 | 2018 | TV-PG | 97 min | Dramas,Faith & Spirituality | After an assignment in a war zone,a journalist trying to put his life back together is granted an interview with someone claiming to be God. |
      | s497 | Movie | An Ordinary Man | Brad Silberling | Ben Kingsley,Hera Hilmar | Serbia,United States | October 1,2020 | 2017 | R | 91 min | Dramas,Thrillers | A war criminal in hiding...|
      | s498 | Movie | An Unremarkable Christmas | Juan Camilo Pinzon | Antonio Sanint,Luis Eduardo Arango | Colombia | December 17,2020 | 2020 | TV-14 | 83 min | Comedies,Dramas,International Movies | An accountant and aspiring magician... |
      | s1721 | TV Show | Detention | Su I-Hsuan,Chuang Shiang-an,Liu Yi | Li Lingwei,Han Ning,Huang Guanzhi | Taiwan | December 5,2020 | 2020 | TV-MA | 1 Season | International TV Shows,TV Dramas,TV Horror | A tormented student uncovers... |
      | s1729 | TV Show | Devilman Crybaby | Masaaki Yuasa | Kouki Uchiyama,Ayumu Murase,Megumi Han,Ami Koshimizu | Japan | January 5,2018 | 2018 | TV-MA | 1 Season | Anime Series,International TV Shows,TV Horror | With demons reawakened... |
      | s2476 | Movie | Good and Prosperous | Sameh Abdulaziz | Ali Rabee,Mohamed Abdel-Rahman,Bayoumi Fouad | Egypt | December 10,2019 | 2017 | TV-14 | 101 min | Comedies,International Movies | As two jobless brothers... |
    When I login to netflix with "<email>"
    Then I see list of titles to browse
    Then I sort the titles by year on the section A
    Then I filter the titles by director on the section A
    Examples:
      | email |
      | basic-user@gmail.com |
      | standard-user@gmail.com |
      | premium-user@gmail.com |

#  Scenario Outline: eating
#    Given there are <start> cucumbers
#    When I eat <eat> cucumbers
#    Then I should have <left> cucumbers
#
#    Examples:
#      | start | eat | left |
#      |    12 |   5 |    7 |
#      |    20 |   5 |   15 |


#  Scenario: Render Browse page for Netflix movie library for a standard user
#  with total number of titles
#    Given I have a valid netflix user account
#    When I login to netflix with "standard-user@gmail.com"
#    When I go to the dashboard
#    And I look for total titles, title types
#    Then I see total number of titles
#
#  Scenario: Render Browse page for Netflix movie library for a premium user
#  with total number of titles
#    Given I have a valid netflix user account
#    When I login to netflix with "premium-user@gmail.com"
#    And I look for total titles
#    Then I see total number of titles, title types, countries

