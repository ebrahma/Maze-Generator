import org.junit.Test;
//import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class UnionFindQuickUnionsTest extends UnionFindQuickUnions {
    UnionFindQuickUnions set = new UnionFindQuickUnions(8);

    /*
    @Before
    public void () {
    	
    }*/
    
    @Test
    public void testAll() {
    	set.union(1,6);
    	assertEquals(true, set.getNumSubsets() ==7);
    	assertEquals(true, set.find(1) == 1);
    	assertEquals(true, set.find(6) == 1);
    	//System.out.println(set.getCurrentState());
    	//System.out.println("0: -1\n1: -2\n2: -1\n3: -1\n4: -1\n5: -1\n6: 1\n7: -1\n");
    	//assertEquals(true, set.getCurrentState() == "0: -1\n1: -2\n2: -1\n3: -1\n4: -1\n5: -1\n6: 1\n7: -1\n");
    	
    	/*
    	set.union(2,4);
    	assertEquals(true, set.getNumSubsets() == 6);
    	assertEquals(true, set.find(1) == 1);
    	assertEquals(true, set.find(6) == 1);
    	assertEquals(true, set.find(2) == 2);
    	assertEquals(true, set.find(4) == 2);
    	System.out.println(set.getCurrentState());
    	*/
    	
    	
    	set.union(4,1);
    	//System.out.println(set.getCurrentState());
    	
    	
    	set.union(1,2);
    	assertEquals(true, set.getNumSubsets() == 5);
    	assertEquals(true, set.find(1) == 1);
    	assertEquals(true, set.find(6) == 1);
    	assertEquals(true, set.find(2) == 1);
    	assertEquals(true, set.find(4) == 1);
    	//System.out.println(set.getCurrentState());
    	
    	set.union(3,5);
    	assertEquals(true, set.getNumSubsets() == 4);
    	assertEquals(true, set.find(1) == 1);
    	assertEquals(true, set.find(6) == 1);
    	assertEquals(true, set.find(2) == 1);
    	assertEquals(true, set.find(4) == 1);
    	assertEquals(true, set.find(3) == 3);
    	assertEquals(true, set.find(5) == 3);
    	//System.out.println(set.getCurrentState());
    	
    	set.union(3,7);
    	assertEquals(true, set.getNumSubsets() == 3);
    	assertEquals(true, set.find(1) == 1);
    	assertEquals(true, set.find(6) == 1);
    	assertEquals(true, set.find(2) == 1);
    	assertEquals(true, set.find(4) == 1);
    	assertEquals(true, set.find(3) == 3);
    	assertEquals(true, set.find(5) == 3);
    	assertEquals(true, set.find(7) == 3);
    	//System.out.println(set.getCurrentState());
    	
    	set.union(3,1);
    	assertEquals(true, set.getNumSubsets() == 2);
    	assertEquals(true, set.find(1) == 1);
    	assertEquals(true, set.find(6) == 1);
    	assertEquals(true, set.find(2) == 1);
    	assertEquals(true, set.find(4) == 1);
    	assertEquals(true, set.find(3) == 1);
    	assertEquals(true, set.find(5) == 1);
    	assertEquals(true, set.find(7) == 1);
    	//System.out.println(set.getCurrentState());
    	
    	set.union(0,1);
    	assertEquals(true, set.getNumSubsets() ==1);
    	assertEquals(true, set.find(0) == 1);
    	assertEquals(true, set.find(1) == 1);
    	assertEquals(true, set.find(6) == 1);
    	assertEquals(true, set.find(2) == 1);
    	assertEquals(true, set.find(4) == 1);
    	assertEquals(true, set.find(3) == 1);
    	assertEquals(true, set.find(5) == 1);
    	assertEquals(true, set.find(7) == 1);
    	//System.out.println(set.getCurrentState());
    	
    	
    }
    
    
}