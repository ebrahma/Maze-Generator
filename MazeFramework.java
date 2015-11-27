//Emily Brahma

import java.util.Random;
import java.util.ArrayList;

/**
 * Randomly generates a maze of dimensions specified by the user.
 * Every cell in this maze must be reachable by every other cell
 * of the maze.
 */
public class MazeFramework implements Maze {
    /**
     * The two dimensional maze array that stores
     * all of the cells in the maze.
     */
    Cell[][] mazeRA;
    /**
     * The number of rows in the maze.
     */
    int numRows;
    
    /**
     * The number of columns in the maze.
     */
    int numCols;
    
    /**
     * The random generator for picking walls
     * to remove.
     */
    private Random rand;

    /**
     * The constructor of the MazeFramework.
     * @param   generator that selects random walls to remove
     * @param   rows of the maze
     * @param   cols of the maze
     */
    public MazeFramework(Random generator, int rows, int cols) {
        this.mazeRA = new Cell[rows][cols];
        this.numRows = rows;
        this.numCols = cols;
        this.rand = generator;
    }

    /**
     * Generate the maze.  This takes a constructed Maze object with
     * all of its walls present, and randomly removes interior walls until all 
     * cells of the maze are reachable from all other cells of the maze. 
     * Also removes the west wall of the top left corner cell (for a maze start)
     * & the east wall of the bottom right corner cell (for a maze finish line).
     */
    public void generateMaze() {
        int arraySize = this.numCols * this.numRows;
        UnionFindQuickUnions unions = new UnionFindQuickUnions(arraySize);
        ArrayList<Wall> walls = new ArrayList<Wall>();

        for (int i = 0; i < this.numRows; i++) {
            for (int k = 0; k < this.numCols; k++) {
                Cell c1 = new Cell();
                this.mazeRA[i][k] = c1;
            }
        }

        this.mazeRA[0][0].setWest(false);
        this.mazeRA[this.numRows - 1][this.numCols - 1].setEast(false);
        int counter = 0;
        //initializing array
        for (int k = 0; k < this.numRows; k++) {
            for (int i = 0; i < this.numCols - 1; i++) {
                Wall verWall = new Wall(counter, false);
                walls.add(verWall);
                counter++;
            }
            counter++;
        }

        for (int i = 0; i < arraySize - this.numCols; i++) {
            Wall hozWall = new Wall(i, true);
            walls.add(hozWall);
        }


        while (unions.getNumSubsets() != 1) {
            int range = walls.size();
            int index = this.rand.nextInt(range); //random index of walls array
            //gets the index number of this wall
            int cell1 = walls.get(index).indexNum; 
            int c = cell1 % this.numCols; //gets column
            int r = cell1 / this.numCols; //gets row

            if (walls.get(index).isHoz) {
                //index of adjacent cell to cell1
                int cell2 = cell1 + this.numCols; 
                int c2 = cell2 % this.numCols; //gets column
                int r2 = cell2 / this.numCols; //gets row
                if (unions.find(cell1) != unions.find(cell2)) {
                    unions.union(cell1, cell2);
                    this.mazeRA[r][c].setSouth(false);
                    this.mazeRA[r2][c2].setNorth(false);
                    //walls.remove(index);
                }
                //walls.remove(index);
            } else {
                int cell2 = cell1 + 1; //index of adjacent cell to cell1
                int c2 = cell2 % this.numCols; //gets column
                int r2 = cell2 / this.numCols; //gets row
                if (unions.find(cell1) != unions.find(cell2)) {
                    unions.union(cell1, cell2);
                    this.mazeRA[r][c].setEast(false);
                    this.mazeRA[r2][c2].setWest(false);
                    //walls.remove(index);
                }
            }
            walls.remove(index); //always remove after checking
        }
    }

    /**
     * Return the Cell object stored at the given (row, column) position.
     * @param r the row position of the Cell in the Maze object
     * @param c the col position of the Cell in the Maze object
     * @return the Cell object that is at the specified position
     */
    public Cell getCellAt(int r, int c) {
        return this.mazeRA[r][c];
    }

    /**
     * Set the cell at the given (row, column) position to the provided cell.
     * @param r the row position of the new Cell in the maze
     * @param c the column position of the new Cell in the maze
     * @param cell the new Cell object to be set in the specified position
     */
    public void setCellAt(int r, int c, Cell cell) {
        this.mazeRA[r][c] = cell;
    }

    /**
     * Return the number of rows in the maze.
     * @return the number of rows in the maze
     */
    public int getNumRows() {
        return this.numRows;
    }

    /**
     * Return the number of columns in the maze.
     * @return the number of columns in the maze
     */
    public int getNumCols() {
        return this.numCols;
    }

    /**
     * Wall is an inner class of the MazeFramework that stores
     * the index of the cell it borders and whether it is a 
     * horizontal cell or vertical cell.
     * @param   indexNum the index of the cell the wall borders
     * @param   isHoz true if the wall is a horizontal wall
     */
    private class Wall {
        /**
         * The index of the cell that the wall borders.
         */
        int indexNum;
        /**
         * True if the wall is a horizontal wall.
         */
        boolean isHoz;
        /**
         * The Wall constructor.
         * @param   num the index of the cell the wall borders
         * @param   hoz true if the wall is a horizontal wall
         */
        public Wall(int num, boolean hoz) {
            this.indexNum = num;
            this.isHoz = hoz;

        }
    }
}