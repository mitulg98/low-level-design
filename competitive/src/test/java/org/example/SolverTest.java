package org.example;

import org.junit.Assert;
import org.testng.annotations.Test;

class SolverTest {
    @Test
    public void testSolve() {
        Assert.assertEquals(0, Solver.solve());
    }
}