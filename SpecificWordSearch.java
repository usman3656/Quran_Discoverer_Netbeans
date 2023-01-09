import java.io.*;

public class SpecificWordSearch {
    sortedWordSearchNode[] storeItAll;
    WordHashFunction newHashKey;

    public SpecificWordSearch() {
        this.storeItAll = new sortedWordSearchNode[26];
        for (int oneMore = 0; oneMore < storeItAll.length; oneMore++)
            storeItAll[oneMore] = new sortedWordSearchNode();
    }

    public static BufferedReader readFile(String path) throws IOException {
        File file = new File(path);
        InputStream input = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        return br;
    }

    public void putWordsInArray() {
        try {
            BufferedReader readEnglishTranslationFile = readFile("src/database/English/english.txt");
            String sentence = readEnglishTranslationFile.readLine();
            while (sentence != null) {
                int firstInstanceOf = sentence.indexOf('|');
                String surahNumber = sentence.substring(0, firstInstanceOf);
                sentence = sentence.substring(firstInstanceOf + 1);
                int instanceOf = sentence.indexOf('|');
                String verseNumber = sentence.substring(0, instanceOf);
                sentence = sentence.substring(instanceOf + 1);
                String[] brokenForm = wordArray(sentence);
                //------------------------------------------------------------------------------------------------------
                newHashKey = new WordHashFunction();
                for (String s : brokenForm) {
                    if (s.toCharArray().length > 2) {
                        String newBrokenForm = s.toLowerCase();
                        StringBuilder newBrokenFormTwo = new StringBuilder();
                        char[] ofBorkenForm = newBrokenForm.toCharArray();
                        for (char c : ofBorkenForm) {
                            if (c >= 'a' && c <= 'z')
                                newBrokenFormTwo.append(c);
                        }
                        if (newBrokenForm.charAt(0) >= 'a' && newBrokenForm.charAt(0) <= 'z') {
                            int placementPosition = newBrokenFormTwo.charAt(0) - 97;
                            newHashKey.insertWordInArray(storeItAll[placementPosition], newBrokenFormTwo.toString(), storeItAll[placementPosition].allWordsWithSameStartingAlphabet.length, surahNumber, verseNumber);
                        }
                    }
                }
                sentence = readEnglishTranslationFile.readLine();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] wordArray(String sentence) {
        String[] wordBreakdown = sentence.split(" ");
        return wordBreakdown;
    }

    public WordNode searchAndPrintWordProperly(String Word) {
        Word = Word.toLowerCase();
        int firstLetter = Word.charAt(0) - 97;
        int insideArrayPosition = 0;
        long grandScore = calculateScore(Word);
        WordNode toBeFound = null;

        for (int comeOn = 0; comeOn < storeItAll[firstLetter].hashNumberHistory.length; comeOn++) {
            if (storeItAll[firstLetter].hashNumberHistory[comeOn] != 0) {
                insideArrayPosition = (int) grandScore % (storeItAll[firstLetter].hashNumberHistory[comeOn]);
                if (insideArrayPosition < 0)
                    insideArrayPosition = insideArrayPosition * -1;
                if (storeItAll[firstLetter].allWordsWithSameStartingAlphabet[insideArrayPosition] != null)
                    if (storeItAll[firstLetter].allWordsWithSameStartingAlphabet[insideArrayPosition].specificWord.equals(Word))
                        break;
                    else {
                        int rehashCallCount = 1;
                        int runLoopTime = 0;
                        while (runLoopTime <= 200) {
                            insideArrayPosition = (int) RehashQuadraticProbing(grandScore, rehashCallCount, storeItAll[firstLetter].hashNumberHistory[comeOn]);
                            if (insideArrayPosition < 0)
                                insideArrayPosition = -1 * insideArrayPosition;
                            if (insideArrayPosition < storeItAll[firstLetter].allWordsWithSameStartingAlphabet.length && storeItAll[firstLetter].allWordsWithSameStartingAlphabet[insideArrayPosition] != null)
                                if (storeItAll[firstLetter].allWordsWithSameStartingAlphabet[insideArrayPosition].specificWord.equals(Word))
                                    break;
                            rehashCallCount++;
                            runLoopTime++;
                        }
                    }
            }
        }

        toBeFound = storeItAll[firstLetter].allWordsWithSameStartingAlphabet[insideArrayPosition];
        if (toBeFound != null) {
            return toBeFound;
        }
        else {
            for (int forceSearch = 0; forceSearch < storeItAll[firstLetter].allWordsWithSameStartingAlphabet.length; forceSearch++) {
                if (storeItAll[firstLetter].allWordsWithSameStartingAlphabet[forceSearch] != null)
                    if (storeItAll[firstLetter].allWordsWithSameStartingAlphabet[forceSearch].specificWord.equals(Word)) {
                        toBeFound = storeItAll[firstLetter].allWordsWithSameStartingAlphabet[forceSearch];
                        return toBeFound;
                    }
            }
        }
        return null;
    }

    public long RehashQuadraticProbing(long key, int i, int length) {
        long value = key+i*i;
        return value % length;
    }

    public long calculateScore(String Word) {
        return newHashKey.calculateWordHash(Word);
    }

    public String wordSearchU(String letter) {
        WordNode forGUI = searchAndPrintWordProperly(letter);
        
            return UFind(forGUI);
      
    }
    public String wordSearchA(String letter) {
        WordNode forGUI = searchAndPrintWordProperly(letter);
       
            return Find(forGUI);
       
    }
    public String wordSearchE(String letter) {
        WordNode forGUI = searchAndPrintWordProperly(letter);
            if(forGUI != null)
            return EFind(forGUI);
            
            return null;
    }

    public String EFind(WordNode forGUI) {
        return forGUI.storeAyaatLocation.EFind();
    }

    public String UFind(WordNode forGUI) {
        return forGUI.storeAyaatLocation.UFind();
    }

    public String Find(WordNode forGUI) {
        return forGUI.storeAyaatLocation.Find();
    }

}




