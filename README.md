![MAIN](https://user-images.githubusercontent.com/54840897/72450402-fca3d580-37c2-11ea-855a-64cac976aff2.PNG)

# descreption :
The game allows the user to play on a graphic map,
Where the game's data structures are a graph class, each node represents a road intersection.
The game has an option to play automatically, or to let the user play manually by entering values
The game works according to the dijkstra algorithm.
 When it calculates the shortest distances, and takes the distance and value of the fuel and moves to there
 The goal of the game is to win as many points as possible and beat the existing algorithm.
The fuels that appear on the screen at arrival are automatically updated and go statistically to another side on the graph

# Class diagram
![sadasda](https://user-images.githubusercontent.com/54840897/72457041-6fff1480-37ce-11ea-8211-e4ff09f5ae23.PNG)

# Welcome screen
![מסך פתיחה](https://user-images.githubusercontent.com/54840897/72536849-b793a800-3883-11ea-9849-253ec300d97b.PNG)

# Game GUI JAVA
![משחק עדכני](https://user-images.githubusercontent.com/54840897/72536902-d2661c80-3883-11ea-8506-a6139658bb61.PNG)

# Game GUI Google Earth
![משחק גוגל](https://user-images.githubusercontent.com/54840897/72461781-5e226f00-37d8-11ea-8f0f-6cfd6750ebc0.PNG)


## NodeData : 

### descreption :
Represents a single vertex in the graph receives an id and receives the point it sits on in the graph (x, y)

### Methods :
- getKey : Returns the node ID
- getLocation : Returns Point3D that contains x, y, z
- getWeight : Returns the "weight" of the node
- getInfo : Returns the values ​​that exist in the node as a string
- getTag : Represented in class as 1 or 0 and used if you want to mark a node
Each method has a set method Represented by set "value"


## EdgeData : 

### descreption :
Represents a one-way or two-way road by the description above , Need two to create an edge

### Methods :
- getSrc : Returns the value of the source (INT value)
- getDest : Returns the value of the destination (INT value)
- getWeight : Returns the "weight" of the edge
- getInfo : Returns the values ​​that exist in the edge as a string
- getTag : Represented in class as 1 or 0 and used if you want to mark a edge
Each method has a set method Represented by set "value"


## Dgraph : 

### descreption :
Represents a full graph with vertices and edges, with each graph describing a road system ת Where each vertex is a road intersection and each edge is the road

### Methods :
- getNode : Returns the vertex by its ID
- getEdge : Returns the edge by its src and its dest
- getWeight : Returns the edge Weight by its src and its dest
- connect : Creates a new edge between one node and the other that represents a road
- getV : Returns an ArrayList that represents all the graph vertices
- getE : Returns an ArrayList that represents all the graph Edges
- removeNode 
- removeEdge
- nodeSize
- edgeSize
- getMC : Returns the Mode Counter of the graph

## GameAlgo :
### descreption :
Represents the full game algorithm.
The algorithm uses the algorithm of the graph (TSP,ShortestWay).
The algorithm is greedy and wants to eat as many fuels as little as he can.


### Methods :
### checkWhereTheFruit:
Looking for where the fuel is by its location and checking its side. The algorithm tests this by the Triangle Equality Theorem.
The algorithm goes over the fruits and checks if the fruit is on the edge according to the triangle inequality theorem.
Then it checks its distance from the first vertex and then checks from the second vertex and checks if its absolute value is equal to the third

### findTheNearestBanana:
The algorithm checks each player the fruit thaht closest to him.
The algorithm uses the dijkstra algorithm to find the shortest distance and returns the edge on which the fruit sits.

### ReturnTheNextID:
The algorithm statistically checks the closest banana according to the other algorithms, and finds and returns its next vertex The algorithm constantly checks the best path according to another algorithm that the vehicle can drive

## Graph_Algo : 

### descreption :
Represents the entire graph algorithm, including the short way from road intersection to road intersection, with each Edge having a weight that represents traffic time.There is also an option to check a journey between several nodes and return the shortest way to get through all of them


### Methods :
- init : Load graph to algorithm
- save : Saves the graph with the algorithm in a CSV file
- init(String) : Load graph to algorithm from CSV file
- isConnected : Checks if a graph is strongly Connected

### Navigation algorithm :

#### shortestPathDist : 
Checks the shortest way from apex to apex and returns an int value, where the same value is the trip between edges.
The algorithm uses the Diaxtra source algorithm


#### shortestPath : 
Checks the shortest way from apex to apex and returns an int value, where the same value is the trip between edges.
The algorithm uses the Diaxtra source algorithm ,The algorithm returns the short path between a vertex and a vertex when it returns a node_data LIST

#### TSP - travel salesman : 
The algorithm gets a list of the vertices to pass through, the algorithm returns the shortest way to go through all the vertices, and stay the shortest time from place to place , The algorithm returns a list of vertices that are its overall trajectory




## MyGameGui:
A class in which all the work is represented on the GUI


## Player:
The department that represents a player in the game

### Methods :
- getKey : Returns the player ID
- getLocation : Returns Point3D that contains x, y, z (the location of the player)
- getWeight : Returns the current value of the player
- getInfo : Returns the values ​​that exist in the player as a string
- getTag : Represented in class as 1 or 0 and used if you want to mark a player
- getspeed : return the speed of the player
- setPicture : give the user to draw the player
- getDest : return the next node dest the player need to move 
Each method has a set method Represented by set "value"


## Fruit:
Represents the "fruits" that must be collected by the players.
### Methods :
- getKey : Returns the player ID
- getLocation : Returns Point3D that contains x, y, z (the location of the fruit)
- getWeight : Returns the current value of the fruit
- getInfo : Returns the values ​​that exist in the fruit as a string
- getTag : Represented in class as 1 or 0 and used if you want to mark a fruit

Each method has a set method Represented by set "value"



## FullGameGraph :
The class represents an object that holds all the data for the game, with which you can play

### Methods :
- newGame : Takes the object and enters a game loading refusal
- getGame : return the current game that in the GUI
- getP : return all the player in the Array list
- getF : return all the fruits in the Array list
- getGraphM : return the current graph in the game 
- setGraphM : set a new Grpag in the game
- getAlgo : return the Graph algo of the game 
- setAlgo : set a new Graph algo to the game 
- setPlayersList : set a new Player list
- setFruitList : set a new Fruit list
- getTheGameAlgo : return the current algo of the Game
- setTheGameAlgo : set the  algo of the Game
 
## KML_LOGGER:
A class that converts a game to a KML object so you can see the game and time in the Google World view
