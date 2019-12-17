# Jobsity Challenge
A sample application to calculate a ten-pin bowling game score

## Minimum compiling requirements
In order to compile this application you need to have Maven 3+ installed and set up in your computer.

For a detailed walkthough on Maven download, install and set up please refer to the [Maven Official Documentation](https://maven.apache.org/install.html)

## Application compile
Once you have downloaded and unziped the source code, open a new command line window, navigate to the unzipped folder (i.e. C:\jobsity_challenge) and execute the maven command `mvn clean verify`.

## Application execution
Once the application has been compiled successfully you can execute it by navigating to the `target` folder (i.e. C:\jobsity_challenge\target) and run it by running the command `java -jar jobsity_challenge-0.0.1-SNAPSHOT.jar`.

The application will ask for the score source file (i.e. C:\scores.txt) and then calculate and display the scores table for each player in the game.

## Purpose
This application calculates and shows the score for a ten-pin bowling game for several `Player`. 

Such score calculation requires the information of every roll to be available in the format 

```
<Player1> <roll1>
<Player1> <roll2>
<Player2> <roll1>
<Player1> <roll3>
```

for every player that is in the game.

## Design pattern

The application was designed and implemented with the MVC pattern in mind. 

Although there is no web view to be displayed, the application provides a view in the form of a console output for the information to be presented to the user.

## Technology stack
- Microservices framework: [Spring Boot](https://spring.io/projects/spring-boot)

## Questions?
Feel free to contact me at <marcelobelbey@gmail.com>
