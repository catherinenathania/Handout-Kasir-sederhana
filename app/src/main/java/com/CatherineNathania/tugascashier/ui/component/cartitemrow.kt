package com.CatherineNathania.tugascashier.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.CatherineNathania.tugascashier.model.CartItem

@Composable
fun CartItemRow(
    cartItem: CartItem,
    onAddClick: () -> Unit,
    onDecreaseClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text(text = cartItem.product.name)
            Text(text = "Jumlah: ${cartItem.quantity}")
            Text(text = "Subtotal: Rp ${cartItem.subtotal}")

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(onClick = onAddClick) {
                    Text(text = "+")
                }
                Button(onClick = onDecreaseClick) {
                    Text(text = "-")
                }
            }
        }
    }
}