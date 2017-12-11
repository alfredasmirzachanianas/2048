/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;
import java.util.Random;

/**
 *
 * @author user
 */
public class Matrix {
    
    private int[][] matrix = new int[4][4];
    
    public Matrix() 
    {
        	for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				matrix[i][j] = 0;
			}
		}
    }
    
public void left() 
	{
		for(int k = 0 ; k < 4 ; k++) {
			for(int i = 0 ; i < 4 ; i++) {
				for(int j = 0 ; j < 4 - 1 ; j++) {
					if(matrix[i][j] == matrix[i][j+1] && matrix[i][j] != 0) {
						matrix[i][j] = matrix[i][j] * 2;
						matrix[i][j+1] = 0;					
					}
					if(matrix[i][j] == 0) {
						matrix[i][j] = matrix[i][j+1];
						matrix[i][j+1] = 0;
					}
				}
			}
		}
	}

public void right() 
	{
		for(int k = 0 ; k < 4 ; k++) {
			for(int i = 0 ; i < 4 ; i++) {
				for(int j = 4 - 1 ; j > 0 ; j--) {
					if(matrix[i][j] == matrix[i][j-1] && matrix[i][j] != 0) 
                                        {
						matrix[i][j] = matrix[i][j] * 2;
						matrix[i][j-1] = 0;					
					}
					if(matrix[i][j] == 0) 
                                        {
						matrix[i][j] = matrix[i][j-1];
						matrix[i][j-1] = 0;
					}
				}
			}
		}
	}

public void down() 
	{
		for(int k = 0 ; k < 4 ; k++) {
			for(int i = 4 - 1 ; i > 0 ; i--) {
				for(int j = 0 ; j < 4 ; j++) {
					if(matrix[i][j] == matrix[i-1][j] && matrix[i][j] != 0)
                                        {
						matrix[i][j] = matrix[i][j] * 2;
						matrix[i-1][j] = 0;					
					}
					if(matrix[i][j] == 0) {
						matrix[i][j] = matrix[i-1][j];
						matrix[i-1][j] = 0;
					}
				}
			}
		}
	}

public void up() {
		for(int k = 0 ; k < 4 ; k++) {
			for(int i = 0 ; i < 4 - 1 ; i++) {
				for(int j = 0 ; j < 4 ; j++) {
					if(matrix[i][j] == matrix[i+1][j] && matrix[i][j] != 0) {
						matrix[i][j] = matrix[i][j] * 2;
						matrix[i+1][j] = 0;					
					}
					if(matrix[i][j] == 0) {
						matrix[i][j] = matrix[i+1][j];
						matrix[i+1][j] = 0;
					}
				}
			}
		}
	}
public boolean checkIsFull()
{
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				if (matrix[i][j] == 0)
					return false;
	return true;
    }
public void addNewNumber(){
		if(!checkIsFull()){
			Random ir = new Random();
			Random jr = new Random();
			int i = ir.nextInt(4);
			int j = jr.nextInt(4);
			while(matrix[i][j] != 0)
                        {
				i = ir.nextInt(4);
				j = jr.nextInt(4);
			}
			int x = new Random().nextInt(4);
			if( x%2 == 0){
				matrix[i][j] = 2;
			}else {
				matrix[i][j] = 4;
			}
		}
	}
public boolean checkWinner()
{
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				if (matrix[i][j] >= 2048)
					return true;
	return false;
    }
public boolean canMove()
{
		if(!checkIsFull())
			return true;
		for(int i = 0 ; i < 4; i++)
			for(int j = 0; j < 4; j++)
                                if(((i + 1 < 4) && (matrix[i][j] == matrix[i+1][j]) ) 
                                        || ((j + 1 < 4) && (matrix[i][j] == matrix[i][j+1]) ))
					return true;
        return false;
    }
public void printBoard()
{
		
		for (int i = 0; i < 4; i++)
                {   
			System.out.println(ConsoleColors.RED  + "+-------+-------+-------+-------+" +
                        ConsoleColors.RESET);
			
			for (int k = 0; k < 4; k++){
                                if(matrix[i][k] == 0)
                                {
				System.out.print(ConsoleColors.PURPLE    + "|" + ConsoleColors.BLUE + "   " + "" + "\t" +
                                     ConsoleColors.RESET);
                                }
                                else
                                {
                                System.out.print(ConsoleColors.PURPLE    + "|" + ConsoleColors.BLUE + "   " + matrix[i][k] + "\t" +
                                     ConsoleColors.RESET);
                                }
			}
			
			System.out.println(ConsoleColors.PURPLE    + "|" + ConsoleColors.RESET);
		}
		
		System.out.print(ConsoleColors.RED + "+-------+-------+-------+-------+" +
                        ConsoleColors.RESET);
		System.out.println();
		System.out.println();
    }
}

