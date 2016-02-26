###Structure

There are two main packages in the project: logic and ui.

logic naturally consists of the classes handling the logic of the game.
 Main, that just starts the program. Game, which is the main logic class
 and contains the Grid-object in use. Grid, where the tiles are created
 and stored. And Tile that keeps the information about the specific tiles.


In ui there is the main ui-class GUI, which stores the Game-object and
 where the DisplayPanel, ButtonGrid(s) (one at a time) and related
 listeners are created. The menu and its listener are also created here
 because they are connected to the frame which is stored and handled in
 the GUI-class.


ui has two sub-packages: dialog and grid. dialog keeps the classes
 GameChoicesDialog and GameChoicesListener that handle the input from
 the user. In grid ButtonGrid, which consists of the JButtons that
 represent the tiles, and its listeners (the ActionListener TurnListener
 and MouseListener FlagListener).