import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void maxPathSum() {
        List<List<Integer>> grid = List.of(
                List.of(1, 3, 12),
                List.of(5, 1, 1),
                List.of(3, 6, 3)
        );
        app.maxPathSum(grid);
    }

    @Test
    void summingSquares() {
        app.summingSquares(5);
        app.summingSquares(16);
        app.summingSquares(41);
    }

    @Test
    void countingChange() {
        app.countingChange(4, List.of(1, 2, 3));
        app.countingChange(8, List.of(1, 2, 3));
        app.countingChange(24, List.of(5, 7, 3));
    }
}