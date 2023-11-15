// Screen.kt
package com.example.sumadora

sealed class Screen(val route: String) {
    object Input : Screen("input")
    object Result : Screen("result") {
        const val ARG_RESULT = "result"

        fun withArgs(result: String): String {
            return "$route?$ARG_RESULT=$result"
        }
    }
}
