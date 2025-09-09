class A {
    int add(int a, int b) {
        return a + b;
    }
    double add(double a, double b) {
        return a + b;
    }
}
class B extends A {
    String add(String a, String b) {
        return a + b;
    }
}
public class Addition {
    public static void main(String[] args) {
        B obj = new B();
        System.out.println("The result of the given values are: " + obj.add(5, 10));
        System.out.println("The result of the given values are: " + obj.add(5.5, 10.5));
        System.out.println("The result of the given values are: " + obj.add("Hello, ", "World!"));
    }
}
