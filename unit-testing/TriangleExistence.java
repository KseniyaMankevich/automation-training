public class TriangleExistence {
    private static final String NEGATIVE_OR_ZERO_SIDE_VALUE = "The side of triangle can't be negative or equal to 0";

    public static boolean isTriangleExists(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0)
            throw new IllegalArgumentException(NEGATIVE_OR_ZERO_SIDE_VALUE);
        return (a + b) > c && (b + c) > a && (a + c) > b;
    }
}
