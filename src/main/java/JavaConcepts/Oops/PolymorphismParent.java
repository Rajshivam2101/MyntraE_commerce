package JavaConcepts.Oops;

public class PolymorphismParent {

    String name;

    public PolymorphismParent(String name) {

        this.name = name;
        System.out.println("Shivam" + name);

    }

    public void methodOverLoadingParent() {
        System.out.println("method overloading with the same class");
    }

    public void methodOverLoadingParent(int a) {
        System.out.println("method overloading with the same class");
    }

    public void methodOverRidingParent() {
        System.out.println("Method overriding in Parent class");
    }


    //Static methodOverLoading
    public static void testStaticMethod() {
        System.out.println("method overloading static method");
    }

    public static void testStaticMethod(int b) {
        System.out.println("method overloading static method");
    }

    //Static methodOverRiding
    public static void testStaticMethodOverriding() {
        System.out.println("method overriding static method in parent class");
    }

}

class PolymorphismChild extends PolymorphismParent {

    String sirname;

    public PolymorphismChild(String sirname, String name) {
        super(name);
        this.sirname = sirname;
        System.out.println("Singh Rajput" + sirname);

    }


    public void methodOverRiding() {
        System.out.println("Method is overridden in child class");
    }

    public static void testStaticMethodOverriding() {
        System.out.println("method overriding static method in child class");
    }

    //Static methodOverLoading
    public static void testStaticMethod() {
        System.out.println("method overloading static method");
    }

    public static void testStaticMethod(int b) {
        System.out.println("method overloading static method");
    }
}

class PolymorphismTest3 extends PolymorphismChild {

    public PolymorphismTest3(String sirname, String name) {
        super(sirname, name);
    }

    public static void main(String[] args) {

        PolymorphismParent p = new PolymorphismChild("Singh", "Shivam");
        p.methodOverLoadingParent(10);  //Overloading depends on using parameters
        p.methodOverRidingParent(); //OverRiding

        PolymorphismChild p1 = new PolymorphismChild("Singh Rajput", "Shivam");
        p1.methodOverRiding();

        testStaticMethodOverriding();  //Variable Shadowing
        testStaticMethod();  //


    }
}
