OpenAPI - {JSON} Placeholder
https://jsonplaceholder.typicode.com/
Resources
JSONPlaceholder comes with a set of 6 common resources:
/posts 100 posts
/comments 500 comments
/albums 100 albums
/photos 5000 photos
/todos 200 todos
/users 10 users
Your Tasks
Task 1: Create a new Spring Boot Project
Create a spring boot project bc-forum with appropriate maven dependencies.
Task 2: Develop Service Layer
Develop the service layer to get data from jsonplaceholder.typicode.com. Think about the design of the service methods.
GET: https://jsonplaceholder.typicode.com/users
GET: https://jsonplaceholder.typicode.com/posts
GET: https://jsonplaceholder.typicode.com/comments
Task 3: APIs
Task 3a: GET all Users, Posts & Comments in one API
Provide APIs for User, Post & Comment Data.
Get all users. Each user may have zero or more posts, each post may have zero or more comments.
If the user has no post, return empty list for that user.
If the post has no comment, return empty list for that post.
Sample Response (Not exactly the response of user ID 1, just a sample for demonstrating JSON structure).
Task 3b: GET all Comments By User ID
Get all comments by user id (Use RequestParam)
Each user may have zero or more posts, each post may have zero or more comments.
If the user has no posts and no comments, return an empty list for "comments".
* Sample Response 1
* Sample Response 2
Task 3c: Handle Exceptions by Global Exception Handler
* Sample Response: User Not Found by user ID
* Sample Response: Invalid Input(User ID)
* Sample Response: RestTemplate Exception
Any other exceptions that may be triggered.
Your project should cover the following skills:
DTO
RestTemplate
With Controller & Service Layers
MockMvcTest, Mockito
Global Exception Handler

///////////////////////////////////////////////////////////
Spring Boot Exercise 3 - {JSON} Placeholder
Author: Vincent Lau
Note: This material is intended for educational purposes only. All rights reserved. Any unauthorized sharing or copying of this material, in any form, to any individual or party, for any use without prior permission, is strictly prohibited.
OpenAPI - {JSON} Placeholder
Make sure you have completed spring boot exercise 2, as this exercise rides on the result of exercise 2.
Add features in bc-forum Spring Boot App for the tasks in this exercise.
Your Tasks
Task 1 - Design and create database tables
Create tables by Spring JPA & Entity in order to store the data that is retrieved from JsonPlaceHolder.
Table names:
a. Users
b. Posts
c. Comments
Task 2 - CommandLineRunner
Draw the ER diagram to present the relationship among the above tables.
Try to draw it by https://dbdiagram.io/d (Diagram as Code)
Capture the diagram as a jpg or png, place it in README.md.
Enhance the service layers (developed in Exercise 2) to store data into the above tables.
Add a CommandLineRunner to trigger the data pre-load into database before the app starts completed.
Task 3 - API Development
For the following API tasks, please use a generic API response class.
Success Scenario & Error Scenario in Global Exception Handler
Revise APIs for User, developed in Exercise 2, to retrieve data from DB, instead of JsonPlaceHolder directly.
a. GET all users
b. GET user by id (Use RequestParam)
Create APIs for User to retrieve data from DB
a. Put a user (Replace existing user by a whole user object)
Create APIs for Post to retrieve data from DB
a. Get all posts
b. Get posts by user id (Use PathVariable)
c. Add a new Post by user id (Use PathVariable)
d. Delete a post by post id (Use PathVariable)
Create APIs for Comment to retrieve data from DB
a. Get all comments
b. Get comments by post id (Use RequestParam)
c. Add a new comment by post id (Use RequestParam)
d. Patch the comment body by comment id (Use RequestParam)
Your project should cover the following skills:
DTO
RestTemplate
CommandLineRunner
Corresponding RESTful CRUD methods (GET, POST, DELETE, PUT) & URI design
With all controller, service, repository & config layer
JPA, Entity
MockMvcTest, Mockito
OpenAPI - {JSON} Placeholder
Make sure you have completed spring boot exercise 2, as this exercise rides on the result of exercise 2.
Add features in bc-forum Spring Boot App for the tasks in this exercise.
Your Tasks
Task 1 - Design and create database tables
Create tables by Spring JPA & Entity in order to store the data that is retrieved from JsonPlaceHolder.
Table names:
a. Users
b. Posts
c. Comments
Task 2 - CommandLineRunner
Draw the ER diagram to present the relationship among the above tables.
Try to draw it by https://dbdiagram.io/d (Diagram as Code)
Capture the diagram as a jpg or png, place it in README.md.
Enhance the service layers (developed in Exercise 2) to store data into the above tables.
Add a CommandLineRunner to trigger the data pre-load into database before the app starts completed.
Task 3 - API Development
For the following API tasks, please use a generic API response class.
Success Scenario & Error Scenario in Global Exception Handler