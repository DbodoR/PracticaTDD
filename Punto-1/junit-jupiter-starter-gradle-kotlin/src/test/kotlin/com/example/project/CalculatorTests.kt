package com.example.project

import org.junit.jupiter.api.Assertions.assertEquals

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculadoraTests {

    @Test
    fun `1 + 1 = 2`() {
        val calculadora = Calculadora()
        assertEquals(2, calculadora.add(1, 1), "1 + 1 should equal 2")
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource(
        "0,    1,   1",
        "1,    2,   3",
        "49,  51, 100",
        "1,  100, 101"
    )
    fun add(first: Int, second: Int, expectedResult: Int) {
        val calculadora = Calculadora()
        assertEquals(expectedResult, calculadora.add(first, second)) {
            "$first + $second should equal $expectedResult"
        }
    }

    @Test
    fun divisionByZeroError() {
        val calculadora = Calculadora()
        val exception = assertThrows<AssertionError> {
            calculadora.div(1, 0)
        }
        assertEquals("Division by Zero", exception.message)
    }
}
