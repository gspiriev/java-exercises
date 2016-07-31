/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexercises;

/**
 *
 * @author root_spiriev
 */
public class SpiralMatrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int n = 5;
        int[][] matrix = new int[n][n];
        int maxRotations = n*n;
        String direction = "right";
        int row = 0;
        int col = 0;
        
        for (int i = 1; i <= maxRotations; i++) {
            
            if (direction == "right" && (col > n - 1 || matrix[row][col] != 0)) {
                direction = "down";
                row++;
                col--;
            }
            
            if (direction == "down" && (row > n - 1 || matrix[row][col] != 0)) {
                direction = "left";
                col--;
                row--;
            }
            if (direction == "left" && (col < 0 || matrix[row][col] != 0)) {
                direction = "up";
                row--;
                col++;
            }
            if (direction == "up" && (row < 0 || matrix[row][col] != 0)) {
                direction = "right";
                row++;
                col++;
            }
            
            matrix[row][col] = i;
            
            if (direction == "right") {
                col++;
            }
            else if (direction == "down") {
                row++;
            }
            else if (direction == "left") {
                col--;
            }
            else if (direction == "up") {
                row--;
            }
            
        }
        
        drawMatrix(matrix, n);
        
    }
    
    private static void drawMatrix(int[][] m, int n){
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String toPrint = String.format("%-3s", m[i][j]);
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
}
