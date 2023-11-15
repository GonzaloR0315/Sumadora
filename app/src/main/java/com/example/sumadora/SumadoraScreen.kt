// SumadoraScreen.kt
package com.example.sumadora

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class SumadoraScreen : ViewModel() {
    // Valores de la Suma
    var valor1 by mutableStateOf("")
    var valor2 by mutableStateOf("")

    // Operación actual
    var resultadoActual by mutableStateOf("")

    // Lista
    var resultadosAnteriores = mutableListOf<String>()

    //  Suma
    fun sumar() {
        val num1 = valor1.toIntOrNull() ?: 0
        val num2 = valor2.toIntOrNull() ?: 0

        val resultado = num1 + num2

        // resultado, no se como meter stringResource(R.string.resultado)
        resultadoActual = "Resultado: $resultado"

        // añade suma a la lista
        resultadosAnteriores.add("$num1 + $num2 = $resultado")

        // Limpiacampos
        valor1 = ""
        valor2 = ""
    }
}
