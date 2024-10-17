# OpenAPI - {JSON} Placeholder
## https://jsonplaceholder.typicode.com/
## Resources
## JSONPlaceholder comes with a set of 6 common resources:
## /posts 100 posts/comments 500 comments/albums 100 albums/photos 5000 photos/todos 200 todos/users 10 users
# Your Tasks
# Task 1: Create a new Spring Boot Project
## Create a spring boot project bc-forum with appropriate maven dependencies.
# Task 2: Develop Service Layer
## Develop the service layer to get data from jsonplaceholder.typicode.com. Think about the design of the service methods.
## GET: https://jsonplaceholder.typicode.com/users
## GET: https://jsonplaceholder.typicode.com/posts
## GET: https://jsonplaceholder.typicode.com/comments
# Task 3: APIs
# Task 3a: GET all Users, Posts & Comments in one API
## Provide APIs for User, Post & Comment Data.
## Get all users. Each user may have zero or more posts, each post may have zero or more comments.
### If the user has no post, return empty list for that user.
### If the post has no comment, return empty list for that post.
## Sample Response (Not exactly the response of user ID 1, just a sample for demonstrating JSON structure).
# Task 3b: GET all Comments By User ID
## Get all comments by user id (Use RequestParam)
## Each user may have zero or more posts, each post may have zero or more comments.
## If the user has no posts and no comments, return an empty list for "comments".
#### Sample Response 1
#### Sample Response 2
# Task 3c: Handle Exceptions by Global Exception Handler
#### Sample Response: User Not Found by user ID
#### Sample Response: Invalid Input (USer ID)
#### Sample Response: RestTemplate Exception
## Any other exceptions that may be triggered.
# Your project should cover the following skills:
## DTO
## RestTemplate
## With Controller & Service Layers
## MockMvcTest, Mockito
## Global Exception Handler