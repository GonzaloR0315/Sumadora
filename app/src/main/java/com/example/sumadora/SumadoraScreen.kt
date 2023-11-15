package com.example.sumadora

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.compose.foundation.layout.Column as Column

enum class SumadoraScreen (@StringRes val title: Int){
    Start(title = R.string.app_name),
    Realizados(title = R.string.realizados)
}

@Composable
fun SumadoraScreen(
    valor1: String,
    valor2: String,
    onSumButtonClick: (String, String) -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            ) {
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
                Text(
                    text = stringResource(R.string.valor1),
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
                EditNumberField(
                    value = valor1,
                    onValueChange = { /* Handle value change if needed */ },
                    modifier = Modifier
                        .padding(bottom = 32.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
                Text(
                    text = stringResource(R.string.valor2),
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
                EditNumberField(
                    value = valor2,
                    onValueChange = { /* Handle value change if needed */ },
                    modifier = Modifier
                        .padding(bottom = 32.dp)
                        .fillMaxWidth()
                )
            }
            Row(modifier = Modifier.weight(1f, false)) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(
                        dimensionResource(id = R.dimen.padding_medium)
                    )
                ) {
                    // Botón de suma
                    Button(
                        onClick = {
                            onSumButtonClick(valor1, valor2)
                            // Navegar a la pantalla de resultados
                            navController.navigate("resultados")
                        },
                        modifier = Modifier
                            .widthIn(min = 250.dp)
                            .padding(top = 16.dp)
                    ) {
                        Text(stringResource(R.string.Suma))
                    }
                }
            }
        }
    }

