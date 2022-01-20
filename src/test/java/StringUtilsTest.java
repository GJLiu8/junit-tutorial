import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringUtilsTest {

    @Disabled
    @Test
    void testBug101() {
        // 这个测试不会运行
    }

    Config config;
    @BeforeEach
    void setUp() {
        this.config = new Config();
    }
    @AfterEach
    void tearDown() {
        this.config = null;
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testWindows() {
        assertEquals("C:\\test.ini", config.getConfigFile("test.ini"));
    }

    @Test
    @EnabledOnOs({ OS.LINUX, OS.MAC })
    void testLinuxAndMac() {
        assertEquals("/usr/local/test.cfg", config.getConfigFile("test.cfg"));
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 5, 100 })
    void testAbs(int x) {
        assertEquals(x, Math.abs(x));
    }

    @ParameterizedTest
    @ValueSource(ints = { -1, -5, -100 })
    void testAbsNegative(int x) {
        assertEquals(-x, Math.abs(x));
    }

    @ParameterizedTest
    @MethodSource
    void testCapitalize(String input, String result) {
        assertEquals(result, StringUtils.capitalize(input));
    }

    static List<Arguments> testCapitalize() {
        return List.of( // arguments:
                Arguments.arguments("abc", "Abc"),
                Arguments.arguments("APPLE", "Apple"),
                Arguments.arguments("gooD", "Good"));
    }

    @ParameterizedTest
    @CsvSource({ "abc, Abc", "APPLE, Apple", "gooD, Good" })
    void testCapitalizeByCsvSource(String input, String result) {
        assertEquals(result, StringUtils.capitalize(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test-capitalize.csv")
     void testCapitalizeByCsvFile(String input, String result) {
        assertEquals(result, StringUtils.capitalize(input));
    }
}