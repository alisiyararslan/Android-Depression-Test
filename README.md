# Android-Depression-Test

While this application was being developed, it was adapted from David Burns' "Burns Depression Scale". Depression Test application contains 25 questions and users can answer these questions starting from "Not At All" to "Extremely". People using the Depression Test app can rate their own symptoms and find a semi-reliable indicator of the presence or absence of depression symptoms. Depression Test application cannot be used for diagnosis or treatment purposes in any way. For conditions requiring diagnosis and treatment, please contact the competent authorities.

**Used Technologies:** Kotlin, Fragment, Navigation, RxJava, Room, MPAndroidChart

**Home Page:** The user encounters this page when he first opens the application. On this page, the user is given brief information about how to use the application. There is a south menu at the bottom. The same menu is used on all pages belonging to the application (main activity), not to the page (fragment).


![image](https://github.com/alisiyararslan/Android-Depression-Test/assets/95187142/f04da3da-d57a-4c5a-8013-28bc349f3b41)

**Test Page:** The user can come to this page using the south menu. The user is given instructions to follow. The user can start the test with the "I want to start the test" button in the lower right corner.

![image](https://github.com/alisiyararslan/Android-Depression-Test/assets/95187142/0a0bcb14-0bd0-49bf-adea-ced889d2ed5a)

**Question Page:**

-  Since it is the first question, the button to return to the previous question is not shown. At the top is the question number currently displayed. The question is shown below the question number, and the options are shown below the question.

    -   ![image](https://github.com/alisiyararslan/Android-Depression-Test/assets/95187142/3306a39d-1de0-4b22-91ef-072f94854756)


- Except for the first question, all other questions have a button to return to the previous question. You can only return to the previous question with this button, that is, you cannot go to the previous 2 questions using this button.

    - ![image](https://github.com/alisiyararslan/Android-Depression-Test/assets/95187142/f2bbb902-a237-4cf4-9ccc-18b2441e28eb)
 
- When you return to the previous question using the back button, the option you previously selected appears different from the others. You can choose any option you want again and continue testing.

  - ![image](https://github.com/alisiyararslan/Android-Depression-Test/assets/95187142/37601710-5dcc-4ecb-9f48-258b2098d840)
 

- After the user answers the last question, a window is shown to the user to find out whether he or she is curious about the test results. If the user clicks on the "I'M CURIOUS" button, he/she is directed to the results page.

  - ![image](https://github.com/alisiyararslan/Android-Depression-Test/assets/95187142/2327cb73-3c77-43d8-ba65-0cecdc661c57)
 

**Results Page:** 

- If the user automatically comes to this page after completing the test, the last test score and the last depression level are indicated in the frame indicated by the red arrow at the top of the page.

  - ![image](https://github.com/alisiyararslan/Android-Depression-Test/assets/95187142/abce9586-eb3e-46a5-ad21-8ac058dcb084)
 

- If the user comes to the Results page using the south menu, there is no information about the last test result at the top of the page. There is a table at the top of the page to see what depression level you are at based on the score. Below the table there is a button to go to the Evolution Chart. Below the button, your past test scores are listed with the date, with the most recent test at the top.

  - ![image](https://github.com/alisiyararslan/Android-Depression-Test/assets/95187142/bed13eb4-0c7c-4da6-9dfc-27362aef3690)


**Evolution of Depression Page:** The user can see the change in depression level as a line chart on this page and make analysis.

![image](https://github.com/alisiyararslan/Android-Depression-Test/assets/95187142/ec44ac50-a5ff-4eed-8ae6-ec3fe2aaaff9)



  
