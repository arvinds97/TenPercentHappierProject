# TenPercentHappierProject
A project that is part of the co-op selection process at TenPercentHappier.

The Problem Definition can be found at : https://tenpercenthappier.notion.site/tenpercenthappier/Android-Co-op-Project-c8866221ee604bd2a670936ba53b54a5#2dfb6103424a40dc892dee2511a9ff04 

This project was initially designed with an MVVM architecture in mind, but since the scope of the project is not of that big a scale, I have implemented the code for sending the get request and receiving the response, within the MainActivity itself. However, I have decoupled the model and the adapter. Ideally, the next stage of this project, would be to write a new viewmodel and repository class and move the business logic into view model and the data from the API and local cache into repository(when the JSON Payload is very large) and write unit tests for each class.

Some Assumptions made during development :
* The JSON file is constant and will not grow as of now.
* The topic titles are not very long and should fit comfortably within a card-view.
* As it was mentioned in the problem statement that we shouldn't spend too much time on this, I assume that we need not write unit tests.
* I have assumed that I have the freedom to set the launcher icon to the ten percent happier logo.

Some Limitations:
* The colors with the same HEX code look different in Android and in iOS.
* The fonts have slight differences and are not exactly the same.
* Some colors where not parseable by the Colors class of android, due to which for those particular topics, I have set a default color of blue.

Some common coding practices followed :
* Writing descriptive Javadocs.
* Line length should be less than 100.
* Interface-first development wherever possible.

Some screenshots : 

![image](https://user-images.githubusercontent.com/23290080/153782803-ebf82033-2ee5-4fef-bbda-ff134518b233.png)

![image](https://user-images.githubusercontent.com/23290080/153782821-e5727b8c-8b7a-4330-8c6f-181f0eec381a.png)

![image](https://user-images.githubusercontent.com/23290080/153782856-71c4e54f-9159-4d30-827a-dd6141204b09.png)
