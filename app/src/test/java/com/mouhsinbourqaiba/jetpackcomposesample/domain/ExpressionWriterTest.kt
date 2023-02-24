package com.mouhsinbourqaiba.jetpackcomposesample.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class ExpressionWriterTest {

    private lateinit var expressionWriter: ExpressionWriter

    @Before
    fun setup() {
        expressionWriter = ExpressionWriter()
    }

    @Test
    fun `Initial parentheses parsed`() {
        expressionWriter.processAction(CalculatorAction.Parentheses)
        expressionWriter.processAction(CalculatorAction.Number(5))
        expressionWriter.processAction(CalculatorAction.Op(Operation.ADD))
        expressionWriter.processAction(CalculatorAction.Number(4))
        expressionWriter.processAction(CalculatorAction.Parentheses)

        assertThat(expressionWriter.expression).isEqualTo("(5+4)")
    }

    @Test
    fun `Closing parentheses at the start not parsed`() {

        expressionWriter.processAction(CalculatorAction.Parentheses)
        expressionWriter.processAction(CalculatorAction.Parentheses)

        assertThat(expressionWriter.expression).isEqualTo("((")
    }

    @Test
    fun `Parentheses around a number are parsed`() {

        expressionWriter.processAction(CalculatorAction.Parentheses)
        expressionWriter.processAction(CalculatorAction.Number(6))
        expressionWriter.processAction(CalculatorAction.Parentheses)

        assertThat(expressionWriter.expression).isEqualTo("(6)")
    }
}