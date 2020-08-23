package datastructureproject.datastructure;

public class ArrayList {
    private Object[] array;
    private int pointer;
    
    public ArrayList() {
        this.array = new Object[100];
        this.pointer = 0;
    }
    
    public Object get(int i) {
        return array[i];
    }
    
    /**
     * This method inserts an object into list's end.
     * @param o is the Object that is being inserted into the list
     */
    public void add(Object o) {  
        if (pointer == array.length) {
            
//            This is how copying would be done manually
            
            Object[] helperArray = new Object[array.length * 2];
            for (int i = 0; i < pointer; i++) {
                helperArray[i] = array[i];
            }
            array = helperArray;
            //int newLength = pointer * 2;
            //Object[] helperArray = new Object[newLength];
            //System.arraycopy(array, 0, helperArray, 0, pointer - 1);
            //array = helperArray;
        }
        
        array[pointer] = o; 
        pointer++;
    }
    
    public int size() {
        return pointer;
    }
    
    public boolean contains(Object o) {
        for (int i = 0; i < pointer; i++) {
            if (array[i].equals(o)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isEmpty() {
        return (pointer == 0); 
    }
}
