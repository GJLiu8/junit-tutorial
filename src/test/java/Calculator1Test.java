import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Calculator1Test {
    Calculator1 calculator1;

    @BeforeEach
    void setUp() {
        this.calculator1 = new Calculator1();
    }

    @AfterEach
    void tearDown() {
        this.calculator1 = null;
    }

    @Test
    void add() {
        assertEquals(100, this.calculator1.add(100));
        assertEquals(150, this.calculator1.add(50));
        assertEquals(130, this.calculator1.add(-20));
    }

    @Test
    void sub() {
        assertEquals(-100, this.calculator1.sub(100));
        assertEquals(-150, this.calculator1.sub(50));
        assertEquals(-130, this.calculator1.sub(-20));
    }
}