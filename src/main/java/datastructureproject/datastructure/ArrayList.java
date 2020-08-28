package datastructureproject.datastructure;

/**
 * Data structure that replaces Java's ArrayList.
 */
public class ArrayList {
    private Object[] array;
    private int pointer;
    
    public ArrayList() {
        this.array = new Object[100];
        this.pointer = 0;
    }
    
    /**
     * Method that returns object in certain index.
     * @param i depicts index
     * @return Object that is in the index
     */
    public Object get(int i) {
        return array[i];
    }
    
    /**
     * This method inserts an object into list's end.
     * @param o is the Object that is being inserted into the list
     */
    public void add(Object o) {  
        if (pointer == array.length) {
            Object[] helperArray = new Object[array.length * 2];
            for (int i = 0; i < pointer; i++) {
                helperArray[i] = array[i];
            }
            array = helperArray;
        }
        
        array[pointer] = o; 
        pointer++;
    }
    
    /**
     * @return size of list
     */
    public int size() {
        return pointer;
    }
    
    /**
     * Allows checking if some object is in the list
     * @param o is the object being checked
     * @return true if list contains the object
     */
    public boolean contains(Object o) {
        for (int i = 0; i < pointer; i++) {
            if (array[i].equals(o)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * @return true if list is empty, otherwise false.
     */
    public boolean isEmpty() {
        return (pointer == 0); 
    }
}
