import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Scanner;


public class SearchByTopic {

    int v = 0;

    class snode {

        String data;
        bnode[] subarr;
        AyatLL ayatlist;
        AyatLL.Node next;

        snode(String d, bnode[] a, AyatLL l) {
            data = d;
            ayatlist = l;
            subarr = a;
        }
    }

    class bnode {

        String sdata;
        AyatLL sayatlist;
        AyatLL.Node next;

        bnode(String d, AyatLL l) {
            sdata = d;
            sayatlist = l;
        }
    }

    snode[] arr = new snode[20];
    Search_by_number q;

    public SearchByTopic(Search_by_number quran) {


        File text = new File("src/database/topics.txt");
        Search_by_number q = quran;
        //Creating Scanner instance to read File in Java
        Scanner topic = null;
        try {
            topic = new Scanner(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line;


        //Reading each line of the file using Scanner class
        int lineNumber = 1;
        int i = 0;


        while (topic.hasNextLine()) {
            System.out.println();
            arr[i] = new snode("", null, null);


            line = topic.nextLine();
            arr[i].data = line.substring(3);
        

            line = topic.nextLine();


            int c = 3;
            char ch;
            arr[i].ayatlist = new AyatLL(q);

            while (c < line.length()) {
                String sr = "";
                String vr = "";


                while (c != line.length()) {
                    if (line.charAt(c) != ':') {
                        ch = line.charAt(c);
                        sr = sr + ch;

                        c++;
                    } else
                        break;
                }

                c++;

                while (c != line.length()) {

                    if (line.charAt(c) != ',') {
                        ch = line.charAt(c);
                        vr = vr + ch;
                        c++;
                    } else
                        break;
                }
                c++;
                c++;

                arr[i].ayatlist.Insert((Integer.parseInt(sr)), Integer.parseInt(vr));

            }

            line = topic.nextLine();
            int size = 0;
            String v = line.substring(3);
            size = (Integer.parseInt(line.substring(3)));
            line = topic.nextLine();

            if (size > 0) {

                arr[i].subarr = new bnode[size];
                int j = 0;

                line = topic.nextLine();
             
                while (line.compareTo("next") != 0) {
                    arr[i].subarr[j] = new bnode(null, null);

                    arr[i].subarr[j].sdata = line.substring(4);

                    int s = 5;
                    char sh;
                    arr[i].subarr[j].sayatlist = new AyatLL(q);
                    line = topic.nextLine();

                    while (s < line.length()) {
                        String sr = "";
                        String vr = "";

                        while (s != line.length()) {

                            if (line.charAt(s) != ':') {
                                sh = line.charAt(s);
                                sr = sr + sh;

                                s++;
                            } else
                                break;
                        }

                        s++;

                        while (s != line.length()) {

                            if (line.charAt(s) != ',') {
                                sh = line.charAt(s);
                                vr = vr + sh;
                                s++;
                            } else
                                break;
                        }
                        s++;
                        s++;


                        arr[i].subarr[j].sayatlist.Insert((Integer.parseInt(sr)), Integer.parseInt(vr));

                    }
                  
                    j++;

                    line = topic.nextLine();


                }

            }
            line = topic.nextLine();
            i++;
        }
    }


    public String[] STopicList(int t) {

        t= t-1;

        String tlist[] = new String[arr[t].subarr.length];
        for (int j = 0; j < arr[t].subarr.length; j++) {
            tlist[j] = j+1 + "  : " + arr[t].subarr[j].sdata;
        }


        return tlist;

    }

    public String Topicayat(int t) {

        t= t-1;

        v = t;
     
        return arr[t].ayatlist.Find();
    }

    public String ETopicayat(int t) {

        t= t-1;

        v = t;
        return arr[t].ayatlist.EFind();
    }

    public String UTopicayat(int t) {

        t= t-1;

        v = t;
        return arr[t].ayatlist.UFind();
    }

    public String STopicayat(int st) {
        return arr[v].subarr[st-1].sayatlist.Find();

    }

    public String ESTopicayat(int st) {
        return arr[v].subarr[st-1].sayatlist.EFind();

    }

    public String USTopicayat(int st) {
        return arr[v].subarr[st-1].sayatlist.UFind();

    }

}





