import org.junit.jupiter.api.Test;

class AppTest {
    App app = new App();

    @Test
    void fib() {
        System.out.println(app.fib(5));
        System.out.println(app.fib(15));
        System.out.println(app.fib(40));
    }

    @Test
    void tribonacci() {
        System.out.println(app.tribonacci(5));
        System.out.println(app.tribonacci(15));
        System.out.println(app.tribonacci(30));
    }
}