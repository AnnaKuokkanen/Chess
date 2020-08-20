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
    
    public void add(Object o) {
        Object[] helperArray = new Object[array.length * 2];
        if (pointer == array.length - 1) {
            for (int i = 0; i < array.length; i++) {
                helperArray[i] = array[i];
            }
            array = helperArray;
        }
        array[pointer] = o; 
        pointer++;
    }
    
    public int size() {
        return pointer;
    }
}
