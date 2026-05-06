package com.CatherineNathania.tugascashier.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.CatherineNathania.tugascashier.data.DummyProductData
import com.CatherineNathania.tugascashier.model.CartItem
import com.CatherineNathania.tugascashier.model.CashierUiState
import com.CatherineNathania.tugascashier.model.Product

class CashierViewModel : ViewModel() {
    var uiState by mutableStateOf(
        CashierUiState(products = DummyProductData.products)
    )
        private set

    fun addToCart(product: Product) {
        val currentCart = uiState.cartItems.toMutableList()
        val index = currentCart.indexOfFirst { it.product.id == product.id }

        if (index >= 0) {
            val oldItem = currentCart[index]
            currentCart[index] = oldItem.copy(quantity = oldItem.quantity + 1)
        } else {
            currentCart.add(CartItem(product = product, quantity = 1))
        }

        uiState = uiState.copy(
            cartItems = currentCart,
            isCheckoutSuccess = false,
            message = "${product.name} ditambahkan"
        )
    }

    fun decreaseItem(productId: Int) {
        val currentCart = uiState.cartItems.toMutableList()
        val index = currentCart.indexOfFirst { it.product.id == productId }

        if (index >= 0) {
            val oldItem = currentCart[index]
            if (oldItem.quantity > 1) {
                currentCart[index] = oldItem.copy(quantity = oldItem.quantity - 1)
            } else {
                currentCart.removeAt(index)
            }

            uiState = uiState.copy(
                cartItems = currentCart,
                isCheckoutSuccess = false,
                message = "Jumlah item diperbarui"
            )
        }
    }

    fun checkout() {
        if (uiState.cartItems.isEmpty()) {
            uiState = uiState.copy(
                isCheckoutSuccess = false,
                message = "Keranjang masih kosong"
            )
            return
        }

        uiState = uiState.copy(
            isCheckoutSuccess = true,
            message = "Checkout berhasil"
        )
    }

    fun resetTransaction() {
        uiState = uiState.copy(
            cartItems = emptyList(),
            isCheckoutSuccess = false,
            message = "Transaksi baru dimulai"
        )
    }
}