class Complex {
    int r, i;
    Complex() {
        r = 0;
        i = 0;
    }
    Complex(int r, int i) {
        this.r = r;
        this.i = i;
    }
    Complex add(Complex c) {
        Complex temp = new Complex();
        temp.r = r + c.r;
        temp.i = i + c.i;
        return temp;
    }
    Complex add(int r, int i) {
        Complex temp = new Complex();
        temp.r = this.r + r;
        temp.i = this.i + i;
        return temp;
    }
    Complex subtract(Complex c) {
        Complex temp = new Complex();
        temp.r = r - c.r;
        temp.i = i - c.i;
        return temp;
    }
    void display() {
        System.out.println("The complex number is: " + r + " + " + i + "i");
    }
}

class MyComplex extends Complex {
    MyComplex(int r, int i) {
        super(r, i);
    }
}
public class ComplexDemo {
    public static void main(String[] args) {
        MyComplex c1 = new MyComplex(5, 10);
        MyComplex c2 = new MyComplex(3, 6);
        
        Complex sum1 = c1.add(c2);
        sum1.display();
        
        Complex sum2 = c1.add(2, 4);
        sum2.display();
        
        Complex diff = c1.subtract(c2);
        diff.display();
    }
}
