/*
 * Class: 44-242 Data Structures
 * Author: Christopher List
 * Description: Lab 2
 * Due: 9/16/15
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any other student.
 * I have not given my code to any other student and will not share this code
 * with anyone under any circumstances.
*/
package listquiltlab;

/**
 *
 * @author s519771
 */
public class ListQuiltLab {
    public static void main(String[] args) {
        //The block that was given in the lab.
/*        char [][] myBlock = new char [][] {{'x', '.', '.', '.', '.'},
            {'x', '+', '.', '.', '.'},{'x', '+', '+', '.', '.'},
            {'x', 'x', 'x', 'x', 'x'},};
        //Creating an array that's dimensions can change as the block changes.
        char [][] myQuilt = new char [myBlock.length * 3][myBlock[0].length *4];
*/
        //Below is the extra credit problem.  I was bored so I made Agumon.
        char [][] myBlock = new char [][] {
            {'.','.','.','.','.','X','X','X','X','X','.','.','.','.','.'},
            {'.','.','.','.','X','.','.','.','.','.','X','.','.','.','.'},
            {'.','.','.','X','X','.','X','X','.','.','.','X','.','.','.'},
            {'.','X','X','.','.','.','.','X','X','.','.','X','.','.','.'},
            {'X','.','.','.','.','.','X','X','X','.','.','.','X','.','.'},
            {'X','X','X','X','.','.','.','.','.','.','.','.','X','.','.'},
            {'.','X','.','.','.','.','.','.','.','.','.','.','X','.','.'},
            {'.','.','X','X','X','X','X','.','.','.','.','X','.','.','.'},
            {'.','.','.','X','X','.','.','.','X','.','X','.','.','.','.'},
            {'.','.','X','.','X','.','.','.','X','.','.','.','X','.','.'},
            {'.','.','X','X','X','.','.','.','X','X','X','.','X','.','.'},
            {'.','.','.','.','X','X','.','.','.','.','X','.','.','X','.'},
            {'.','.','X','X','.','.','X','X','X','X','.','.','.','X','.'},
            {'.','X','.','X','.','.','X','.','X','.','X','.','X','.','X'},
            {'.','X','X','X','X','X','X','.','X','X','X','X','X','X','X'}};
        //I created a new block length and width for this since it is much larger
        //than the assigned block.
        char [][] myQuilt = new char [myBlock.length * 2][myBlock[0].length *3];
        //displays a single block.
        displayPattern(myBlock);
        /*for (int i = 0; i < myQuilt.length; i++){
            for (int n = 0; n < myQuilt[0].length; n++){
                myQuilt[i][n] = '?';
            }
        }*/
        //Creates the quilt using the given block
        createQuilt(myQuilt, myBlock);
        //Displays the quilt.
        displayPattern(myQuilt);
    }
    //Simply displays an array.
    public static void displayPattern(char[][] myBlock){
        for (int i = 0; i < myBlock.length; i++){
            for (int n = 0; n < myBlock[0].length; n++){
                System.out.print(myBlock[i][n]);
            }
            System.out.println();
        }
    }
    //Creates a quilt using the block.  To get rid of the flipped blocks just
    //comment out the whole if-else statement except the line of code in the else.
    public static void createQuilt(char[][] quilt, char[][] block) {
        for (int i = 0; i < quilt.length; i ++){
            for (int n = 0; n < quilt[0].length; n ++){
                //This if statement is a bit ridiculous because I wanted it to be able
                //to adjust at any block size.
                if ((i > (block.length-1) && i < (block.length*2) && ((n < block[0].length )||(n > (block[0].length*2-1) && n < (block[0].length*3))))||
                        (i < block.length && ((n > (block[0].length-1) && n < (block[0].length*2)) || (n > (block[0].length*3-1) && n < (block[0].length*4))))||
                        ((i > (block.length * 2 -1) && i < (block.length*3)) && ((n > (block[0].length-1) && n < (block[0].length*2)) || (n > (block[0].length*3-1) && n < (block[0].length*4))))){
                    //For the above requirement it will use the flipped block in 
                    //assigning the array to the quilt.
                    quilt[i][n] = createFlipped(block)[i%block.length][n%block[0].length];
                }
                else{
                    //This can be used instead of the if-else statement if you 
                    //don't want any blocks flipped.
                    quilt[i][n] = block [i%block.length][n%block[0].length];
                }
            }
        }
    }
    //This creates a flipped version of the block.  ONLY FLIPS TOP TO BOTTOM!
    public static char[][] createFlipped(char[][] block) {
        //Creates a new 2D array with the same size as the old one.
        char [][] flippedBlock = new char [block.length][block[0].length];
        for (int i = 0; i < block.length; i++){
            for (int n = 0; n < block[0].length; n++){
                //To flip top to bottom/side to side replace the final [n]
                //in the following code with [block[0].length -n -1];
                flippedBlock [i][n] = block [block.length -i -1][n];
            }
        }
        //Returns the flipped array.
        return flippedBlock;
    }
}