package com.mouhsinbourqaiba.jetpackcomposesample.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ExpressionParserTest {

    private lateinit var parser : ExpressionParser

    @Test
    fun `Simple expression is properly parsed`() {
        // 1. GIVEN
        parser = ExpressionParser("3+5-3*4/3")

        // 2. Do Something with what's given

        val actual = parser.parse()

        // 3. ASSERT ACCEPT == ACTUAL

        val excepted = listOf(
            ExpressionPart.Number(3.0),
            ExpressionPart.Op(Operation.ADD),
            ExpressionPart.Number(5.0),
            ExpressionPart.Op(Operation.SUBTRACT),
            ExpressionPart.Number(3.0),
            ExpressionPart.Op(Operation.MULTIPLY),
            ExpressionPart.Number(4.0),
            ExpressionPart.Op(Operation.DIVIDE),
            ExpressionPart.Number(3.0)
        )
        assertThat(excepted).isEqualTo(actual)
    }

    @Test
    fun `Expression with Parentheses is properly parsed`() {
        // 1. GIVEN
        parser = ExpressionParser("4-(4*5)")

        // 2. DO SOMETHING OF WHAT'S GIVEN
        val actual = parser.parse()

        // 3. ASSERT ACCEPT = ACTUAL

        val excepted = listOf(
            ExpressionPart.Number(4.0),
            ExpressionPart.Op(Operation.SUBTRACT),
            ExpressionPart.Parentheses(ParenthesesType.Opening),
            ExpressionPart.Number(4.0),
            ExpressionPart.Op(Operation.MULTIPLY),
            ExpressionPart.Number(5.0),
            ExpressionPart.Parentheses(ParenthesesType.Closing)
        )

        assertThat(excepted).isEqualTo(actual)
    }
}