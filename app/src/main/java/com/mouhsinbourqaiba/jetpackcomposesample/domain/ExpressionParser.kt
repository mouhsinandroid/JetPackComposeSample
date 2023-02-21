package com.mouhsinbourqaiba.jetpackcomposesample.domain

class ExpressionParser(
    private val calculation: String
) {
    fun parse(): List<ExpressionPart> {
        val result  = mutableListOf<ExpressionPart>()
        var i = 0

        while (i < calculation.length) {
            val curChar = calculation[i]
            when {
                curChar in operationSymbols -> {
                    result.add(
                        ExpressionPart.Op(operationFromSymbol(curChar))
                    )
                }
                curChar.isDigit() -> {
                    i = parsNumber(i, result)
                    continue
                }
                curChar in "()" -> {
                    parsParentheses(curChar, result)
                }
            }
            i++
        }
        return result
    }

    private fun parsNumber(staringIndex: Int, result: MutableList<ExpressionPart>): Int {
        var i =  staringIndex
        val numberAsString = buildString {
            while (i < calculation.length && calculation[i] in "0123456789.") {
                append(calculation[i])
                i++
            }
        }
        result.add(ExpressionPart.Number(numberAsString.toDouble()))
        return i
    }

    private fun parsParentheses(curChar: Char, result: MutableList<ExpressionPart>) {
        result.add(
            ExpressionPart.Parentheses(
                type = when(curChar){
                    '(' -> ParenthesesType.Opening
                    ')' -> ParenthesesType.Closing
                    else -> throw IllegalArgumentException("In valid parentheses expression")
                }
            )
        )

    }
}