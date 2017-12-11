/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class JavaApplication4 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException, IOException 
    {
     System.out.println("HOW TO PLAY: Use your key numbers 2(DOWN), 4 (LEFT),8(UP), 6(RIGHT), q for EXIT "
             + "to move the tiles. "); 
     System.out.println();
     System.out.println("******************** START *************************"); 
     System.out.println();
        Matrix matrix = new Matrix();
               while(!matrix.checkWinner()) {
                  System.out.print("Your Input : ");
                        System.out.println();
                Scanner in = new Scanner(System.in);
		String inputStr = in.next();
                matrix.addNewNumber();
                switch (inputStr) {
                case "8" : matrix.up(); break;
                case "6" : matrix.right(); break;
                case "4" : matrix.left(); break;
                case "2" : matrix.down(); break;

                case "q" : System.out.println("Game ended, user quit."); System.exit(0);
		default :  System.out.println("Invalid key! Use 8 for UP, 6 for RIGHT, " + "2 for DOWN and 4 for LEFT, q to exit. Press enter to submit your choice."); continue;
                }
                if(matrix.checkIsFull() && !matrix.canMove())
                        {
			System.out.println("****************** GAME OVER! YOU LOST! **********************");
			System.exit(0);
		}
               matrix.printBoard();
            }
        System.out.println("CONGRATULATIONS, YOU'VE WON!");
    }
}