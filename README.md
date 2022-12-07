# Course Project Group 138

- Our project is a 2D topdown pixel adventure rpg game. The goal is to slay monsters, improve your equipment, and defeat the boss.
- The player can draw their own character.

# How to start and run the project
- [ ] Clone the project repository and open the project in Intellij
- [ ] Locate the file Game.java found in src/main/java/controllers/game/Game
- [ ] Right click Game.java and select Run
- [ ] It is designed for Windows and may have some compatibility issues with macOS
- [ ] If on macOS, navigate to src/main/java/settings/Settings and set the variable FPS to 10 instead of 60 before running Game.java
- [ ] The controls are WASD for movement and the mouse left click to interact with buttons on-screen.

# Program Overview
- The code is based around a game loop class that keeps iterating. It calls methods to update character position and the 
user interface as appropriate. 
- The player is given a drawing interface to draw their own character, and is then spawned
into the dungeon with starting equipment. 
- The dungeon is a randomly generated set of rooms that the player can navigate 
through. 
- Upon getting close enough to an enemy, the game enters a combat state. The player and enemy take turns attacking
one another until one is victorious. 
- If the player approaches a merchant, they will be given the option to upgrade their
equipment. 
- The player continues until they fight the final boss, and win the game if they defeat them. 
- The test folder is found in src/main/tests 
- The code is found in src/main/java.

# Adherence to SOLID
- a

# Adherence to Clean Architecture
- a

# Use of Refactoring
- In the early stages of the project, we were inexperienced in organizing a project, which resulted in a messy and hard to navigate project.
- We used refactoring to move classes into packages so that code with similar function would be grouped together, making finding relevant files much easier.
- The pull request containing the repackaging can be found at https://github.com/CSC207-2022F-UofT/course-project-group-138/pull/39

# Use of Design Patterns
- a

# Packaging
- The code has been separated into packages based on their Clean Architecture layer.

# Submitted Pull Requests
- https://docs.google.com/document/d/1rU_-iCrRTYVsREWWy2CvWcDw59OQhoiAfLOFTAcruH0/edit

# Presentation Slides
- https://docs.google.com/presentation/d/1a0-S8YFYCXG00mNj6Nmjwqhp0c-89DcZs4jhiaQHHQM/edit?usp=share_link

# Gallery
- An image of the player character in a dungeon room.
![image](https://github.com/CSC207-2022F-UofT/course-project-group-138/blob/attacking/images/readme/game_readme_1.jpg?raw=true)

- A gif of the player exploring the dungeon.
![gif](https://raw.githubusercontent.com/CSC207-2022F-UofT/course-project-group-138/51700f7985c2929148ea779ffe033c9c5a90d227/images/Dungeons_2022-12-07_01-44-27.gif)


- Make use of the readme and any other features you find useful to help your TA navigate your project and understand what you have done!
Your readme should be updated from the default one we provided and needs to at least contain information about how to run your code.
If the setup process to run your code is complicated and isn't feasible for your TA to do quickly, it would be a good idea to include a small demo / screenshots to demonstrate your current functionality.
We highly recommend you consider adding additional information that would help someone understand what you've been working on.
Consider targeting what you include to your TA who will appreciate having this extra info when they are grading!
