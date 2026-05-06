package com.CatherineNathania.tugascashier.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.CatherineNathania.tugascashier.model.CashierUiState
import com.CatherineNathania.tugascashier.model.Product
import com.CatherineNathania.tugascashier.ui.component.CartItemRow
import com.CatherineNathania.tugascashier.ui.component.ProductCard
import com.CatherineNathania.tugascashier.ui.component.SummarySection

@Composable
fun CashierScreen(
    uiState: CashierUiState,
    onAddProduct: (Product) -> Unit,
    onDecreaseItem: (Int) -> Unit,
    onCheckout: () -> Unit,
    onResetTransaction: () -> Unit
) {
    val context = LocalContext.current

    // Efek Interaktif 1: Memunculkan pesan melayang (Toast) jika menekan checkout tapi keranjang kosong
    LaunchedEffect(uiState.message) {
        if (uiState.message == "Keranjang masih kosong") {
            Toast.makeText(context, uiState.message, Toast.LENGTH_SHORT).show()
        }
    }

    // Efek Interaktif 2: Memunculkan Pop-up jika isCheckoutSuccess bernilai true
    if (uiState.isCheckoutSuccess) {
        AlertDialog(
            onDismissRequest = { /* Dibiarkan kosong agar user wajib menekan tombol OK */ },
            title = {
                Text(
                    text = "Transaksi Berhasil!",
                    style = MaterialTheme.typography.titleLarge
                )
            },
            text = {
                Text("Total pembayaran: Rp ${uiState.totalPrice}\nTerima kasih telah berbelanja.")
            },
            confirmButton = {
                Button(onClick = {
                    // Mereset keranjang saat user menekan OK
                    onResetTransaction()
                }) {
                    Text("OK & Mulai Transaksi Baru")
                }
            }
        )
    }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(
                text = "Kasir Sederhana",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Pesan status bawaan dari modul tetap kita tampilkan
            Text(
                text = "Status: ${uiState.message}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Daftar Produk",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(uiState.products) { product ->
                    ProductCard(
                        product = product,
                        onAddClick = { onAddProduct(product) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Keranjang",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                uiState.cartItems.forEach { cartItem ->
                    CartItemRow(
                        cartItem = cartItem,
                        onAddClick = { onAddProduct(cartItem.product) },
                        onDecreaseClick = { onDecreaseItem(cartItem.product.id) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            SummarySection(
                uiState = uiState,
                onCheckoutClick = onCheckout,
                onResetClick = onResetTransaction
            )
        }
    }
}