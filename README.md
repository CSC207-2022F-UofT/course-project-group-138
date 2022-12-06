# Course Project Group 138

Our project is a 2D topdown pixel adventure rpg game. The goal is to slay monsters, improve your equipment, and defeat the boss.
The player can draw their own character.
It is designed for Windows and may have some compatibility issues with macOS.
If you are on macOS, navigate to src/main/java/settings/Settings and set the variable FPS to 10 instead of 60
The controls are WASD for movement and the mouse left click to interact with buttons on-screen.

Start the program by running Game.java. 
It can be found in src/main/java/controllers/game/Game

The test folder is found in src/main/tests
The code is found in src/main/java, separated into packages based on their Clean Architecture layer.

The code is based around a game loop class that keeps iterating. It calls methods to update character position and the 
user interface as appropriate. The player is given a drawing interface to draw their own character, and is then spawned
into the dungeon with starting equipment. The dungeon is a randomly generated set of rooms that the player can navigate 
through. Upon getting close enough to an enemy, the game enters a combat state. The player and enemy take turns attacking
one another until one is victorious. If the player approaches a merchant, they will be given the option to upgrade their
equipment. The player continues until they fight the final boss, and win the game if they defeat them.

An image of the player character in a dungeon room.
![image](https://github.com/CSC207-2022F-UofT/course-project-group-138/blob/attacking/images/readme/game_readme_1.jpg?raw=true)

Make use of the readme and any other features you find useful to help your TA navigate your project and understand what you have done!
Your readme should be updated from the default one we provided and needs to at least contain information about how to run your code.
If the setup process to run your code is complicated and isn't feasible for your TA to do quickly, it would be a good idea to include a small demo / screenshots to demonstrate your current functionality.
We highly recommend you consider adding additional information that would help someone understand what you've been working on.
Consider targeting what you include to your TA who will appreciate having this extra info when they are grading!

## Checklist For Your Project
- [ ] Verify the correct settings for your project repository
- [ ] Set up Github Projects
- [ ] Create the implementation plan using issues and Github Projects
- [ ] Create deveopment branches for your features
- [ ] Use pull requests to merge finished features into main branch
- [ ] Conduct code reviews

**If your team has trouble with any of these steps, please ask on Piazza. For example, with how GitHub Classroom works, your team *may* not have permissions to do some of the first few steps, in which case we'll post alternative instructions as needed.**

## Workflow Documents

* Github Workflow: Please refer to the workflow that was introduced in the first lab. You should follow this when working on your code. The following document provides additional details too.

* [Project Planning and Development Guide](project_plan_dev.md): This document helps you to understand how to create and maintain a project plan for your class project. **This document helps you to complete the Implementation Plan Milestone.**

## Gradle Project
Import this project into your Intellij editor. It should automatically recognise this as a gradle repository.
The starter code was built using SDK version 11.0.1. Ensure that you are using this version for this project. (You can, of course, change the SDK version as per your requirement if your team has all agreed to use a different version)

You have been provided with two starter files for demonstration: HelloWorld and HelloWorldTest.

You will find HelloWorld in `src/main/java/tutorial` directory. Right click on the HelloWorld file and click on `Run HelloWorld.main()`.
This should run the program and print on your console.

You will find HelloWorldTest in `src/test/java/tutorial` directory. Right click on the HelloWorldTest file and click on `Run HelloWorldTest`.
All tests should pass. Your team can remove this sample of how testing works once you start adding your project code to the repo.

Moving forward, we expect you to maintain this project structure. You *should* use Gradle as the build environment, but it is fine if your team prefers to use something else -- just remove the gradle files and push your preferred project setup. Assuming you stick with Gradle, your source code should go into `src/main/java` (you can keep creating more subdirectories as per your project requirement). Every source class can auto-generate a test file for you. For example, open HelloWorld.java file and click on the `HelloWorld` variable as shown in the image below. You should see an option `Generate` and on clicking this your should see an option `Test`. Clicking on this will generate a JUnit test file for `HelloWorld` class. This was used to generate the `HelloWorldTest`.

![image](https://user-images.githubusercontent.com/5333020/196066655-d3c97bf4-fdbd-46b0-b6ae-aeb8dbcf351d.png)

You can create another simple class and try generating a test for this class.
