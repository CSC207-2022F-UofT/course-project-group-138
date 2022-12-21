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
- Single responsibility  principle (SRP): Weapon class can only be changed through upgrading it (upgradeStrength).
- Open/closed principle (OCP): Tilepresenter displays all the tiles, and can add more tiles without changing the code
- Liskov substitution  principle (LSP): Character can be substituted for player or enemy class
- Interface  segregation  principle (ISP): Character, Equipment and Inventory all have their respective interface for CharacterCreator, EquipmentCreator, InventoryCreator
- Dependency inversion  principle (DIP): Paint event handler depends on PaintAction interface, instead of individual actions


# Adherence to Clean Architecture
- Dependency Inversion was used throughout the project to ensure that tasks could be executed from higher level use cases to lower level controllers without any dependencies.
- Classes in the character package, such as Character called methods from Equipment and Inventory
- This was an entity to entity dependency, and while not a violation of the dependency rule, were examples of unnecessary coupling EquipmentInterface and InventoryInterface were implemented by Equipment and Inventory respectively to decouple the classes
- Entities such as Character, Player, Enemy, Inventory, Weapon, Armor stored in the Entity package 
- Use cases such as merchantUseCases and playerUseCases stored in the useCases package
- Controllers CombatState, CombatController, CrawlingState, MenuState, DungeonController, StateManager in the controllers package
- Presenters


# Use of Refactoring
- In the early stages of the project, we were inexperienced in organizing a project, which resulted in a messy and hard to navigate project.
- We used refactoring to move classes into packages so that code with similar function would be grouped together, making finding relevant files much easier.
- The pull request containing the repackaging can be found at https://github.com/CSC207-2022F-UofT/course-project-group-138/pull/39

# Use of Design Patterns
- Character class: Facade design pattern, Encapsulated actors such as Inventory, so that the Character class does not need to contain its own Weapon and Armor
- StateFactory class: Factory design pattern



# Use of Github Features
- utilized Github Projects to keep track of our issues, as well as who were assigned to which issues and the deadlines by which they should be resolved
- utilized Github issues to keep track of what still needed to be done in the project, and assign work so that everyone contributed an equal amount
- utilized branch protection, pull requests onto the main branch needed a minimum of 3 reviews from other group members to ensure the code was quality and to provide a range of viewpoints
- utilized Github's version control to rollback commits 

# Packaging
- The code has been separated into packages based on their Clean Architecture layer.

# Submitted Pull Requests (Milestone 5)
- https://docs.google.com/document/d/18DRfUxJNzydfDAzbBp-hSfb5gG8EHqPekr9HJpc1O2M/edit?usp=sharing

# Presentation Slides
- https://docs.google.com/presentation/d/1a0-S8YFYCXG00mNj6Nmjwqhp0c-89DcZs4jhiaQHHQM/edit?usp=share_link

# Gallery
- An image of the player character in a dungeon room.
![image](https://github.com/CSC207-2022F-UofT/course-project-group-138/blob/main/images/readme/game_readme_1.jpg)
- A gif of the player exploring the dungeon and approaching enemies and merchants.
![gif](https://github.com/CSC207-2022F-UofT/course-project-group-138/blob/08ab1c86747001afe59914cbff9ffc640e89f48b/images/readme/Dungeons_2022-12-07_21-50-05.gif)


- Make use of the readme and any other features you find useful to help your TA navigate your project and understand what you have done!
Your readme should be updated from the default one we provided and needs to at least contain information about how to run your code.
If the setup process to run your code is complicated and isn't feasible for your TA to do quickly, it would be a good idea to include a small demo / screenshots to demonstrate your current functionality.
We highly recommend you consider adding additional information that would help someone understand what you've been working on.
Consider targeting what you include to your TA who will appreciate having this extra info when they are grading!
