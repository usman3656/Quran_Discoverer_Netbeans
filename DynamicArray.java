public class DynamicArray {
    public DynamicArray(){}

    public WordNode[] increaseArraySize(WordNode[] array){
        WordNode[] newArray = new WordNode[2 * array.length];
        for (int i = 0; i < array.length; i++)
            newArray[i] = array[i];
        array = newArray;
        return array;
    }

    public boolean isFull(int numberOfOccupiedCell, int arrayLength){
        return (numberOfOccupiedCell <= (0.6667 * arrayLength));
    }

    public int[] simpleIsFull(int[] array){
        int[] newArray = new int[2*array.length];
        for (int i = 0; i < array.length; i++)
            newArray[i] = array[i];
        array = newArray;
        return array;
    }
}
