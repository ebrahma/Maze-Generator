/**
 * Interface for a union-find data structure with int-type items.
 */
public interface UnionFind {
    
    /**
     * Determine the name of the set containing the specified element.
     * @param x the element whose set we wish to find
     * @return the name of the set containing x
     */
    int find(int x);

    /**
     * Merge two sets if they are not already the same set.
     * @param a an item in the first set to be merged (need not be set name)
     * @param b an item in the second set to be merged (need not be set name)
     */
    void union(int a, int b);

    /**
     * Return the number of subsets in the structure.
     * @return the number of subsets
     */
    int getNumSubsets();    

    /**
     * Returns a String representation of the implementation.  Normally
     * this would never be part of an interface like this, but will help us
     * test your implementation in a consistent way.  See assignment handout.
     * @return a String representing the current state of the structure
     */
    String getCurrentState();

}