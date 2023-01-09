public class AyatLL {
    class Node {

        int surah;
        int verse;
        Node next;
        Node(int s, int v) {
            surah = s;
            verse = v;
        }
    }




    Node head = null;
    Node current = null;
    public Search_by_number x;
    public AyatLL(){}
    public AyatLL(Search_by_number q) {
        x = q;
    }


    //  Node q = new Node(0,0);

    int n;



  /*  //Big-Oh 0(n)
    public String toString() {
        current = head;
        String v = "";
        while (current != null) {
            v = v + current + " ,";
            current = current.next;
        }
        return v;
    }
*/
    //Big-Oh 0(n)
    public void Insert(int s, int v) {

        Node temp = new Node(s, v);
        if (head == null)
        {

            head = temp;
        }
        else {

            temp.next = head;
            head = temp;
        }

    }
    public String EFind()
    {
        x = new Search_by_number();
        String ayat = "";
        current = head;
        while(current != null)
        {

            ayat = ayat +x.FindBySurahAndVerseE(current.surah, current.verse)+ "\n";
            current = current.next;
        }
        return ayat;

    }
    public String UFind()
    {
        x = new Search_by_number();
        String ayat = "";
        current = head;
        while(current != null)
        {

            ayat = ayat +x.FindBySurahAndVerseU(current.surah, current.verse)+ "\n";
            current = current.next;
        }
        return ayat;

    }
    public String Find()
    {
        x = new Search_by_number();
        String ayat = "";
        current = head;
        while(current != null)
        {

            ayat = ayat + x.FindBySurahAndVerseA(current.surah, current.verse)+ "\n";
            current = current.next;
        }
        return ayat;

    }
}