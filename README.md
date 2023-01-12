Team Members:
1- Alaa El-Sayed Al-Araby
2- Nada Ayman
3- Arwa Ashraf
4- Moaz Khaled


# Tic Tac Toe Client

This project contains:
  ## 1- Splash Screen
  ![2022-12-26 (14)](https://user-images.githubusercontent.com/53160167/209555972-8cadb51e-6972-4243-a2b0-2eaed5b72444.png)
  
  ## 2- Mode Screen 
    Player can choose between two modes one of them to play alone and another to play with another player.
![2022-12-26 (6)](https://user-images.githubusercontent.com/53160167/209556078-eeb88971-5782-496e-ab88-4e65176fb169.png)

  ## 3- Single Mode
    In this mode player chooses to play with the computerm,and it contains 3 different modes 
      Easy Mode
      Medium Mode
      Hard Mode
     
![2022-12-26 (12)](https://user-images.githubusercontent.com/53160167/209556288-181b5154-9dd0-4891-924f-eeae41ce4722.png)

  ## 4- Dual Mode
    In this mode player has two choice; to play with another player in same the device, or to join server to choose a player.
    
![2022-12-26 (5)](https://user-images.githubusercontent.com/53160167/209556485-e0df3224-b806-4b1d-9f0d-12293a33bc3f.png)

  ## 5- Local 
    To play in same device they should enter their names to enter the game.
    
![2022-12-26 (11)](https://user-images.githubusercontent.com/53160167/209556625-7788bc14-c824-48d3-b96d-800bfae707a7.png)

  ## 6- Create an account 
    If a player has no account, he could enter his password and username to join to server and to be added to database.
    Before adding a new player, check the validation of username and password exist already or number of password charcters.
  
![2022-12-26 (3)](https://user-images.githubusercontent.com/53160167/209556735-e73e5243-bb66-4792-968e-d95a4d811e4d.png)

  ## 7- Login
    If he has an account, he could join using correct username and password.
  
![2022-12-26 (4)](https://user-images.githubusercontent.com/53160167/209556731-63a50d18-3bf5-40ed-bc8c-66e3cd0bea22.png)


  ## 8- Invitation List 
    Player can choose the person who wants to play with from a list contains online players.
    
![2022-12-26 (2)](https://user-images.githubusercontent.com/53160167/209557191-4009ccbe-2392-45aa-9153-67ac10777120.png)
    
    Then send request....
    
![2022-12-26 (9)](https://user-images.githubusercontent.com/53160167/209557337-fcdb7743-df2a-4e2f-bec8-0f5a21445657.png)


    Second player will be offered to play...
    
![2022-12-26 (13)](https://user-images.githubusercontent.com/53160167/209558671-fafd17fd-d22b-48b7-9d77-34b970712bb8.png)



  ## 9- Game Screen
    Each player can record the game to be added to his profile and could watch it later.
    Each recorded game has a date-Time name.
    
 ![2022-12-26 (10)](https://user-images.githubusercontent.com/53160167/209557341-8da6dd47-c99c-45fe-b40f-5ef326991f4d.png)


  ## 10- Player Profile 
    Each player can change his username or password from profile, check his score, and check his recorded games.

![2022-12-26 (1)](https://user-images.githubusercontent.com/53160167/209557331-bdbbe0cc-94e3-4e66-b8c9-89d24c29f5a6.png)

  ## 11- Recorded Game
    This screen to display the game that the player recorded.
  
![2022-12-26](https://user-images.githubusercontent.com/53160167/209557356-89469705-9fb5-4352-9faa-32d13337537c.png)


# Database
We have two tables:
1- one for player(player_ID,username,password,IPAddress,score,status)
2- one for recorded_game(player_ID,game_ID,game_name)
  
# Recorded Game
Each recorded game saved in a local JSON file, and added to database table using its name. 


[Check Server Repo](https://github.com/alaagawish/TicTacToe-Server)
