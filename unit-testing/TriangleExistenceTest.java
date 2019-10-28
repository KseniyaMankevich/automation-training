import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleExistenceTest {

    @Test(expected = IllegalArgumentException.class)
    public void oneSideIsNegative() {
        double a = 3, b = 4, c = -5;
        TriangleExistence.isTriangleExists(a, b, c);
    }

    @Test(expected = IllegalArgumentException.class)
    public void allSidesAreNegativeInfinity() {
        double a = Double.NEGATIVE_INFINITY, b = Double.NEGATIVE_INFINITY, c = Double.NEGATIVE_INFINITY;
        TriangleExistence.isTriangleExists(a, b, c);
    }

    @Test
    public void allSidesArePositiveInfinity() {
        double a = Double.POSITIVE_INFINITY, b = Double.POSITIVE_INFINITY, c = Double.POSITIVE_INFINITY;
        assertFalse(TriangleExistence.isTriangleExists(a, b, c));
    }

    @Test(expected = IllegalArgumentException.class)
    public void oneSideEqualsZero() {
        double a = 0, b = 10, c = 15;
        TriangleExistence.isTriangleExists(a, b, c);
    }

    @Test
    public void arbitraryTriangle() {
        double a = 10.2, b = 11.3, c = 12.7;
        assertTrue(TriangleExistence.isTriangleExists(a, b, c));
    }

    @Test
    public void equilateralTriangle() {
        double a = 15, b = 15, c = 15;
        assertTrue(TriangleExistence.isTriangleExists(a, b, c));
    }

    @Test
    public void rightTriangle() {
        double a = 3, b = 4, c = 5;
        assertTrue(TriangleExistence.isTriangleExists(a, b, c));
    }

    @Test
    public void isoscelesTriangle() {
        double a = 7.9, b = 7.9, c = 15;
        assertTrue(TriangleExistence.isTriangleExists(a, b, c));
    }

    @Test
    public void sumOfTwoSidesIsLessThanThird() {
        double a = 1, b = 10, c = 15;
        assertFalse(TriangleExistence.isTriangleExists(a, b, c));
    }

    @Test
    public void oneSideEqualsSumOfTwoSides() {
        double a = 10, b = 10, c = 20;
        assertFalse(TriangleExistence.isTriangleExists(a, b, c));
    }

    @Test
    public void allSidesAreMaxDouble() {
        double a = Double.MAX_VALUE, b = Double.MAX_VALUE, c = Double.MAX_VALUE;
        assertTrue(TriangleExistence.isTriangleExists(a, b, c));
    }
}