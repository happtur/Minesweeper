###Structure

There are two main packages in the project: logic and ui.

logic naturally consists of the classes handling the logic of the game.
 Main, that just starts the program. Game, which is the main logic class
 and contains the Grid-object in use. Grid, where the tiles are created
 and stored. And Tile that keeps the information about the specific tiles.


In ui there is the main ui-class GUI, which controls the gui-components
 (like the MainFrame, ButtonGrid and DisplayPanel) and communicates
 with the Game-class.

ui has three sub-packages: frame, dialog and grid.
 -frame is where the MainFrame-related classes (the MainFrame which
 is the main frame of the game. The DisplayPanel that sits at the top
 of the frame and the MenuActionListener which is the MainFrame's menu's
 ActionListener) are.
 -dialog keeps the classes GameChoicesDialog and GameChoicesListener
 that handle the input from the user.
 -In grid ButtonGrid, which
 consists of the JButtons that represent the tiles, and its listeners
 (the ActionListener TurnListener and MouseListener FlagListener).