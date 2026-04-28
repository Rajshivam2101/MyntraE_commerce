package JavaConcepts.Oops;

public abstract class AbstractClassTest {

    //constructors is allowed
    public AbstractClassTest() {
    }

    int a = 10;
    static int b = 20;

    public final int c = 10;
    public final static int d = 20;

    public abstract void testA();
    public abstract void testA(String a);   //unique method signature

    public  abstract void testz();


    //Non static is allowed
    public void testC() {
        System.out.println("Non Static Method 1");
    }

    //static is allowed
    public static void testE() {
        System.out.println("Static Method 2");
    }

//    public default void testD() {
//        System.out.println("Non Static Method 1");
//    }

    private void testG() {
        System.out.println("Final Method 3");
    }

    protected void testH() {
        System.out.println("Final Method 3");
    }

    final void testF() {
        System.out.println("Final Method 3");
    }
}
