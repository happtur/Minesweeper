package OhHa.minesweeper.ui;

import OhHa.minesweeper.logic.Game;
import java.util.Scanner;

public class TextUI {

    /*    
     Since this is a temporary ui used as a programming tool, I won't bother
     making it fool proof or user friendly.
     x grows from left to right, y grows downwards.
     */
    private Scanner scanner;
    private Game game;

    public TextUI() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {

        while (true) {
            System.out.print("size: ");
            int size = Integer.parseInt(scanner.nextLine());
            
            System.out.print("amount of bombs: ");
            int bombs = Integer.parseInt(scanner.nextLine());
            
            this.game = new Game(size, bombs);

            while (true) {
                this.displayGame();
                if (!this.receiveCommand()) {
                    break;
                }
            }

            if (this.game.isWon()) {
                System.out.println("CONGRATULATIONS! YOU WON!\n");
            } else {
                System.out.println("GAME OVER\n");
            }

        }
    }

    private void displayGame() {
        for (int y = 0; y < this.game.getSizeOfGrid(); y++) {
            for (int x = 0; x < this.game.getSizeOfGrid(); x++) {

                //move to Game? Depends on the properties of the GUI
                if (!this.game.isTurned(x, y)) {
                    if (!this.game.isFlagged(x, y)) {
                        System.out.print("*");
                    } else {
                        System.out.print("-");
                    }
                } else {
                    System.out.print(this.game.getValue(x, y));
                }
            }
            System.out.println("");
        }

        System.out.println("");
    }

    private boolean receiveCommand() {
        System.out.println("to flip a tile, press enter\n"
                + "to flag a tile, press 1 and enter\n"
                + "to start a new game, press 2 and enter ");

        String command = this.scanner.nextLine();

        if (command.isEmpty()) {
            System.out.print("x: ");
            int x = Integer.parseInt(scanner.nextLine());
            System.out.print("y: ");
            int y = Integer.parseInt(scanner.nextLine());

            if (!this.game.turn(x, y)) {
                return false;
            }

        } else if (command.equals("1")) {
            System.out.print("x: ");
            int x = Integer.parseInt(scanner.nextLine());
            System.out.print("y: ");
            int y = Integer.parseInt(scanner.nextLine());

            this.game.flag(x, y);

        } else if (command.equals("2")) {
            return false;
        }

        return true;

    }

}
