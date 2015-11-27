/**
 * Interface for a Maze object in HW5.
 * 600.226 Data Structures, Spring 2015
 */

public interface Maze {

    /**
     * Generate the maze.  This takes a constructed Maze object with
     * all of its walls present, and randomly removes interior walls until all 
     * cells of the maze are reachable from all other cells of the maze. 
     * Also removes the west wall of the top left corner cell (for a maze start)
     * and the east wall of the bottom right corner cell (for a maze finish line).
     */
    void generateMaze();

    /**
     * Return the Cell object stored at the given (row, column) position.
     * @param r the row position of the Cell in the Maze object
     * @param c the col position of the Cell in the Maze object
     * @return the Cell object that is at the specified position
     */
    Cell getCellAt(int r, int c);

    /**
     * Set the cell at the given (row, column) position to the provided cell.
     * @param r the row position of the new Cell in the maze
     * @param c the column position of the new Cell in the maze
     * @param cell the new Cell object to be set in the specified position
     */
    void setCellAt(int r, int c, Cell cell);

    /**
     * Return the number of rows in the maze.
     * @return the number of rows in the maze
     */
    int getNumRows();

    /**
     * Return the number of columns in the maze.
     * @return the number of columns in the maze
     */
    int getNumCols();

}
