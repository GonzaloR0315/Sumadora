// Resultados.kt
package com.example.sumadora

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Resultados(navController: NavController, viewModel: SumadoraScreen, result: String, onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(20.dp)
    ) {
        // Resto del código permanece igual

        // Botón para volver a la pantalla de entrada
        Button(
            onClick = {
                onBack()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("Volver a la entrada")
        }
    }
}
