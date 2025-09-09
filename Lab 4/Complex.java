class A {
    protected double real, imag;

    A() {
        this.real = 0;
        this.imag = 0;
    }

    A(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    void display() {
        System.out.println(real + (imag >= 0 ? " + " : " - ") + Math.abs(imag) + "i");
    }
}

class B extends A {
    B() {
        super();
    }

    B(double real, double imag) {
        super(real, imag);
    }

    // Example: add a method to B
    void conjugate() {
        System.out.println(real + (imag >= 0 ? " - " : " + ") + Math.abs(imag) + "i");
    }
}

public class Complex {
    public static void main(String[] args) {
        A a = new A(3, 4);
        a.display();

        B b = new B(5, -6);
        b.display();
        b.conjugate();
    }
}
