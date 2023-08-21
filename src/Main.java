import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Album arijit = new Album("Arijit Singh","Arijit Album");
        Album XXX = new Album("XXXXX","XXX Album");

        arijit.addSongToAlbum("wxy",3.2);
        arijit.addSongToAlbum("xyz",2.3);
        arijit.addSongToAlbum("abc",4.1);

        XXX.addSongToAlbum("cva",5);
        XXX.addSongToAlbum("mas",2.5);
        XXX.addSongToAlbum("kds",7.3);

        LinkedList<Song> myPlayList = new LinkedList<>();

        System.out.println(arijit.addSongToPlayListFromAlbum("wxy",myPlayList));
        System.out.println(arijit.addSongToPlayListFromAlbum(2,myPlayList));
        System.out.println(arijit.addSongToPlayListFromAlbum(5,myPlayList));

        System.out.println(XXX.addSongToPlayListFromAlbum("wxy",myPlayList));
        System.out.println(XXX.addSongToPlayListFromAlbum("mas",myPlayList));
        System.out.println(XXX.addSongToPlayListFromAlbum(1,myPlayList));
        
        play(myPlayList);
    }

    private static void play(LinkedList<Song> myPlayList) {

        if(myPlayList.size() == 0)
        {
            System.out.println("Your play List Is Empty");
            return;
        }

        ListIterator<Song> itr = myPlayList.listIterator();
        System.out.println("Now Song Play:- "+itr.next());

        Scanner sc = new Scanner(System.in);
        printmenu();

        boolean quite = false;
        while(!quite)
        {
            System.out.println("Enter Your Choice");
            int choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    printmenu();
                    break;

                case 2:
                    if(!itr.hasNext())
                    {
                        System.out.println("Next Song Not Present");
                    }
                    else{
                        System.out.println("Current Song Is:- "+itr.next());
                    }
                    break;

                case 3:
                    if(!itr.hasPrevious())
                    {
                        System.out.println("Previous Song Not Present"+itr.previous());
                    }
                    else{
                        System.out.println("Current Song Is:- "+itr.previous());
                    }
                    break;

                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    printSongList(myPlayList);
                    break;
                case 7:
                    quite = true;
                    break;
                default:
                    System.out.println("Wrong Choice. Enter Correct Choice");

            }
        }

    }

    private static void printSongList(LinkedList<Song> myPlayList) {
        for(Song song : myPlayList)
        {
            System.out.println(song);
        }
        return;
    }

    private static void printmenu() {
        System.out.println("1. Show the menu again");
        System.out.println("2. Play The New Song");
        System.out.println("3. Play The Previous Song");
        System.out.println("4. Play Current Song again");
        System.out.println("5. Delete Current Song From PlayList");
        System.out.println("6. Print The All Song in PlayList");
        System.out.println("7. Quite Application");

    }

}