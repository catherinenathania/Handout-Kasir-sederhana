package com.CatherineNathania.tugascashier.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.CatherineNathania.tugascashier.model.CashierUiState

@Composable
fun SummarySection(
    uiState: CashierUiState,
    onCheckoutClick: () -> Unit,
    onResetClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "Total item: ${uiState.totalItems}")
            Text(text = "Subtotal: Rp ${uiState.subtotalPrice}")
            Text(text = "Pajak (10%): Rp ${uiState.tax}")
            Text(text = "Total bayar: Rp ${uiState.totalPrice}")

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onCheckoutClick
            ) {
                Text(text = "Checkout")
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onResetClick
            ) {
                Text(text = "Reset Transaksi")
            }
        }
    }
}