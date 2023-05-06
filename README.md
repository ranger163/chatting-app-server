# Chatting App Server

## A little boring but important introduction

This project is to play more with kotlin ktor framework for server side, and it has an android client version that you can test called [ChattingApp](https://github.com/ranger163/ChattingApp).
It's main goal to create REST APIs and serving data to/from client, it's like a simple whatsApp application, but instead of depending on user phone number here I've used normal signup form
and I'm depending on user email address for login and also for generating websocket session ID for each chat room.

In this application I've been using Ktor framework as my server side application, ktor is a great, simple and powerful framework to write backend applications in effective and
precise way, all work done on this project I've tried as much as possible to match the CLEAN architecture while I was writing every single feature of this project. The Project
contains endpoints to login, signup, getting friend list, getting chat room history between two friends and opening websocket to send and receive messages.

I've implemented JWT token authentication while user calls any API after loggging in to the client app like getting friend list, getting chat room history and connecteing to 
the websocket, So user from the client app will have his JWT token generated once he signs up/logs in into system, then he need to send it back again to the server to verify his
access to rest of application services as mentioned earlier.

I've implemented Kmongo DB to be used as my database that holds user login information, rooms messages history and each room session that is being generated for every two
users try to communicate with each other.

Sessions for websockets are being generated once user has entered a chat room with a friend, as each session will hold the sender and receivers emails (As I've been using emails as the unique key for every session)
also it contains the session ID for those both users, it's only generated once and being saved into it's own database table, but be summuned whenever any one of thoese peers
enters the room again. Along side sessions are being used to open the websocket connection between two users they are used to fetch every room's history messages.

## Application structure

<img src="https://github.com/ranger163/social-app-server/blob/master/screenshots/package_structure.png" width="300" height="650">

As showen above this is the package structure I've used when I was writing this app, so lets go throw it quickly.

#### COMMON PACKAGE
- This package is from its name holds the common utils/helpers and constants classes that are being used across the app.

#### DATA PACKAGE
- This package contains two sub-packages:-
  
  ##### MODEL SUB-PACKAGE
  - This sub-package hold JWT token payload that is being generated while login/signup and being verified when user tries to request inside app calls.
  - TokenExpiryResponseDTO is a data class holds the response whenever user token has been expired.
  
  ##### REPOSITORY SUB-PACKAGE
  - It holds the JWT token repositry interface and it's implementation, it's responsible of extracting JWT payload email and providing it when it's needed to app features.

#### DI PACKAGE
- It holds dependency injection provided by koin, such as common app dependencies in the AppModule file, data source dependencies in the DataSourceModule,
  repositories dependencies such as RepositoryModule and use case dependencies like UseCaseModule.

#### FEATURES PACKAGE
- This packge contain sub packges for handling each feature bussiness and separating it's logic per layer

  ##### DATA SUB-PACKAGE
  - It holds local database operations and table entities, also it could contain any remote network calls if we needed to.

  ##### DOMAIN SUB-PACKAGE
  - It holds data class mappers between database/remote data classes to presentation layer.
  - It holds presentation layer data classes itself regarding for each feature.
  - Also it holds feature repository layer which is responsible for providing data from database/remote to the presentation layer.
  - PS: I know that backend apps don't have presentation layer but I'm dealing with the routing/controller layer as it's my presentation layer, as it presents
    data in form of REST API endpoints.
    
    ##### RESOURCE SUB-PACKAGE
   - This layer holds the feature's use cases and endpoints that are exposed in form of REST API routes
 
#### PLUGINS PACKAGE
- It holds ktor related features and plugin configurations. 

## Installation

Install as usual,
* Clone this repo.
* Update your IntelliJ IDEA to version number 2022.1.2.
* Follow these guidlines to install MongoDB client on your local machine on [windows](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-windows),
[mac os](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-os-x/) and [linux](https://www.mongodb.com/docs/manual/administration/install-on-linux/)
* Happy coding.
* Support me by staring this repo and following me for more projects.

## References

* [Ktor](https://ktor.io/docs/welcome.html)
* [JWT Token](https://ktor.io/docs/jwt.html#install)
* [Routing](https://ktor.io/docs/routing-in-ktor.html)
* [Sessions](https://ktor.io/docs/sessions.html)
* [Web sockets](https://ktor.io/docs/creating-web-socket-chat.html)
* [Kmongo database](https://litote.org/kmongo/)
* [Koin Dependency Injection](https://insert-koin.io)

## Hire Me
I'm ready for a full-time or a freelancing job, just drop me an email [here](https://www.inassar.me) and let's do our chating.

## License
Made with :heart: by [Ahmed Nassar](https://github.com/ranger163), licensed under the [MIT License](https://github.com/ranger163/social-app-server/blob/master/licence)
