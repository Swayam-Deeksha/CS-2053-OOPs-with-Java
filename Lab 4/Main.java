class A {
    A() {
        System.out.println("Hello, I am Class A");
    }
}

class B extends A {
    B() {
        System.out.println("Hello, I am Class B");
    }
}

class C extends B {
    C() {
        System.out.println("Hello, I am Class C");
    }
}

public class Main {
    public static void main(String[] args) {
        C obj = new C();
    }
}
