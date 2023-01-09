import java.io.*;

public class Search_by_number {
public String[][] arabic;
public String[][] english;
public String[][] urdu;
public int[] ayas={7, 286, 200, 176, 120, 165, 206, 75, 129, 109, 123,
        111, 43, 52, 99, 128, 111, 110, 98, 135, 112, 78, 118, 64, 77, 227,
        93, 88, 69, 60, 34, 30, 73, 54, 45, 83, 182, 88, 75, 85, 54, 53, 89, 59,
        37, 35, 38, 29, 18, 45, 60, 49, 62, 55, 78, 96, 29, 22, 24, 13, 14, 11,
        11, 18, 12, 12, 30, 52, 52, 44, 28, 28, 20, 56, 40, 31, 50, 40, 46, 42,
        29, 19, 36, 25, 22, 17, 19, 26, 30, 20, 15, 21, 11, 8, 8, 19, 5, 8, 8,
        11, 11, 8, 3, 9, 5, 4, 7, 3, 6, 3, 5, 4, 5, 6};

    public static BufferedReader readFile(String path,String charset) throws IOException {
        File file = new File(path);
        InputStream in = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(in, charset));
        return br;
    }
    public static BufferedReader readFile(String path) throws IOException {
        File file = new File(path);
        InputStream in = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        return br;
    }


public Search_by_number(){
    arabic=new String[114][];
    english=new String[114][];
    urdu=new String[114][];
    try {

        BufferedReader Arabic = readFile("src/database/Arabic/arabic.txt", "utf-8");
        BufferedReader English = readFile("src/database/English/english.txt");
        BufferedReader Urdu = readFile("src/database/Urdu/urdu.txt", "utf-8");
        String aline;
        String eline;
        String uline;
        for(int i=0;i<ayas.length;i++){
            arabic[i]=new String[ayas[i]];
            english[i]=new String[ayas[i]];
            urdu[i]=new String[ayas[i]];
            for(int j=0;j<ayas[i];j++) {

                aline = Arabic.readLine();
                eline = English.readLine();
                uline = Urdu.readLine();
                StringBuilder a = new StringBuilder();
                StringBuilder e = new StringBuilder();
                StringBuilder u = new StringBuilder();
                a.append(aline);
                e.append(eline);
                u.append(uline);
                arabic[i][j] = a.toString();
                english[i][j] = e.toString();
                urdu[i][j] = u.toString();
            }
        }
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    public String FindBySurahAndVerseA(int a, int v){
        return arabic[a-1][v-1];
        
    }
    public String FindBySurahAndVerseE(int a, int v){
     
        return english[a-1][v-1];
    }
    public String FindBySurahAndVerseU(int a, int v){
       
        return urdu[a-1][v-1];
    }
   
    public String FindBySurahArabic(int a){
        String Arabic="";
        for(int i=0;i<ayas[a-1]; i++){
            Arabic=Arabic+arabic[a-1][i]+"\n";
        }
        return Arabic;
    }
    public String FindBySurahEnglish(int a){
        String English="";
        for(int i=0;i<ayas[a-1]; i++){
            English=English+english[a-1][i]+"\n";
        }
        return English;

    }
    public String FindBySurahUrdu(int a){
        String Urdu="";
       
        for(int i=0;i<ayas[a-1]; i++){
            Urdu=Urdu+urdu[a-1][i]+"\n";
        }
       
        return Urdu;
    }



}
