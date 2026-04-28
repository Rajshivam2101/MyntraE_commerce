package JavaConcepts.Oops;

public interface InterFaceTest {

    //consutractor is not alloed
//    public InterFaceTest{
//
//    }

    int a = 10;
    static int b = 20;

    public final int c = 10;
    public final static int d = 20;


    public abstract void testA();

    public abstract void testB();


    //Non staic not allowed
//    public void testC() {
//        System.out.println("Non Static Method 1");
//    }

    //static is allowed
    public static void testE() {
        System.out.println("Static Method 2");
    }

    public default void testD() {
        System.out.println("Non Static Method 1");

    }

    private void testG() {
        System.out.println("Final Method 3");
    }


    //protected is not allowed
//    protected void testH() {
//        System.out.println("Final Method 3");
//    }
//    final is not allowed
//    void testF() {
//        System.out.println("Final Method 3");
//    }


}
