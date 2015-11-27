//Emily Brahma

import java.util.Stack;

/**
 * Creates an array and unions two sets when union is 
 * called, which implements path compression.
 */
public class UnionFindQuickUnions implements UnionFind {

    /**
     * The number of items stored in the array.
     */
    int numItems;
    
    /**
     * The number of subsets in the array.
     */
    int numSubsets;
    
    /**
     * The tree array that stores all sets and items.
     */
    int[] tree;

    /**
     * A dummy default constructor.
     */
    public UnionFindQuickUnions() {
        
    }
    
    /**
     * The constructor that creates a tree with all
     * roots initialized to -1.
     * @param   items the number of items in the tree
     */
    public UnionFindQuickUnions(int items) {
        if (items <= 0) {
            throw new IllegalArgumentException();
        }
        this.numItems = items;
        this.numSubsets = items;
        this.tree = new int[this.numItems];

        for (int i = 0; i < this.numItems; i++) {
            this.tree[i] = -1;
        }
    }

    /**
     * Determine the name of the set containing the specified element.
     * @param x the element whose set we wish to find
     * @return the name of the set containing x
     */
    public int find(int x) {
        Stack<Integer> compSets = new Stack<Integer>();
        compSets.push(x);
        int root = this.tree[x];
        
        if (root < 0) {
            return x;
        }

        while (root > 0) {
            if (this.tree[root] > 0) {
                compSets.push(root);
                root = this.tree[root]; 
            } else {
                break;
            }

        }

        while (!compSets.empty()) {
            this.tree[compSets.pop()] = root;
        }

        return root;
    }

    /**
     * Merge two sets if they are not already the same set.
     * @param a an item in the first set to be merged (need not be set name)
     * @param b an item in the second set to be merged (need not be set name)
     */
    public void union(int a, int b) {
        //if both are roots and size of a is less than size of b
        if (this.tree[a] > 0) {
            this.union(this.find(a), b);
        } else if (this.tree[b] > 0) {
            this.union(a, this.find(b));
        } else if (this.tree[a] < 0 && this.tree[b] < 0 
                && this.tree[b] < this.tree[a]) {
            this.union(b, a);
        } else {
            //size of a is greater than size of b
            this.tree[a] = this.tree[a] + this.tree[b]; //increase size of a
            this.tree[b] = a; //make root of b equal a
            this.numSubsets--;
        }
        
        this.find(b);
        

    }

    /**
     * Return the number of subsets in the structure.
     * @return the number of subsets
     */
    public int getNumSubsets() {

        return this.numSubsets;
    }

    /**
     * Returns a String representation of the implementation.  Normally
     * this would never be part of an interface like this, but will help us
     * test your implementation in a consistent way.  See assignment handout.
     * @return a String representing the current state of the structure
     */
    public String getCurrentState() {
        String currentState = "";
        for (int i = 0; i < this.numItems; i++) {
            currentState = currentState + i + ": " + this.tree[i] + "\n";
        }
        return currentState;
    }


}