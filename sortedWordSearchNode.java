public class sortedWordSearchNode {
    public WordNode[] allWordsWithSameStartingAlphabet;
    public int[] hashNumberHistory;
    int numOfCollisions = 0;
    int numOfOccupiedCells = 0;
    public sortedWordSearchNode() {
        hashNumberHistory = new int[10];
        this.numOfCollisions = numOfCollisions;
        this.numOfOccupiedCells = numOfOccupiedCells;
        allWordsWithSameStartingAlphabet = new WordNode[1000];
        for (int i = 0; i < allWordsWithSameStartingAlphabet.length; i++) {
            allWordsWithSameStartingAlphabet[i] = null;
        }
    }
}
