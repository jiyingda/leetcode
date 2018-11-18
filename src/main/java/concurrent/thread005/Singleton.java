package concurrent.thread005;

public class Singleton {

    private static int x= 0;

    private static int y;

    private static Singleton singleton = new Singleton();

    private Singleton(){
        x++;
        y++;
    }


    public static Singleton getInstance(){
        return singleton;
    }

    public static void main(String[] args){
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.x);
        System.out.println(singleton.y);
    }

}
