import java.util.Scanner;

class Fibonacci {
    private int number;
    private int number2;

    public Fibonacci(int n) {
        this.number = n;
        this.number2 = Calculate(n);
    }

    private int Calculate(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 2;
        int fib1 = 1, fib2 = 2, fibNum = 0;
        for (int i = 3; i <= n; i++) {
            fibNum = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibNum;
        }
        return fibNum;
    }

    public boolean Check() {
        int fibPlus2 = Calculate(this.number + 2);
        int TwoN = (int) Math.pow(2, this.number);
        return fibPlus2 < TwoN;
    }

    public int getNumber() {
        return this.number;
    }

    public int getNumber2() {
        return this.number2;
    }

    public void Print() {
        System.out.print("\nЗначення числа Фібоначі: " + this.number2);
        System.out.print("\nПеревірка умови задачі: " + Check());
    }
}
public class Main {
    public static void main(String[] args) {
        boolean check = true;
        Scanner info = new Scanner(System.in);

        while (check) {
            System.out.println("Введіть число N:");

            if (info.hasNextInt()) {
                int n = info.nextInt();
                if (n > 0) {
                    check = false;
                    Fibonacci fibonacci = new Fibonacci(n);
                    fibonacci.Print();
                } else {
                    System.out.println("Число має бути додатнім. Введіть ще раз:");
                }
            } else {
                System.out.println("Введені дані не є числом. Введіть ще раз:");
                info.next();
            }
        }
        info.close();
    }

}

