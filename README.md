Author: Raj Khatri
Email: khatriraj200@gmail.com

What this app does?

The app allows the user to log in by providing the Google account credentials.
The app uses Spring Security with OAuth2.
The app secures the routes after the user has logged in.
The app displays a home page with the logged in user's information.

Nothing too fancy, just the focus is on the authentication part.

Why I created this?
I created this because in my previous company, Infosys, I had worked for some time on the implementation of Spring Security feature along with different IDPs.

So, I wanted to develop a small application completely on my own for demonstrating the complete OAuth2 flow in an easy way.

Tech used:
Java 17
Spring Boot
Spring Security
Google OAuth2 Client
Maven
AWS ECR, ECS, and ALB

Live Demo
The application is hosted in AWS ECS in a Docker container and an ALB is created for the application.
You can check the application live here:
https://oauth.rajkhatridev.online