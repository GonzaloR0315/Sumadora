// Resultados.kt
package com.example.sumadora

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
        Text(stringResource(R.string.resultado), style = MaterialTheme.typography.labelMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(result, style = MaterialTheme.typography.bodySmall)
        Spacer(modifier = Modifier.height(16.dp))
        Text(stringResource(R.string.resultados), style = MaterialTheme.typography.labelMedium)
        Spacer(modifier = Modifier.height(8.dp))

        val resultadosAnterioresText = buildString {
            for (resultado in viewModel.resultadosAnteriores) {
                append(resultado)
                append("\n")
            }
        }

        Text(resultadosAnterioresText, style = MaterialTheme.typography.bodySmall)

        // Botón para volver a la pantalla de entrada
        Button(
            onClick = onBack,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(stringResource(R.string.volver))
        }
    }
}
