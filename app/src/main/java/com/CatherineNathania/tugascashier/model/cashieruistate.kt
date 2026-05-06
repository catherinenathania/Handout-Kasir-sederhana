package com.CatherineNathania.tugascashier.model

data class CashierUiState(
    val products: List<Product> = emptyList(),
    val cartItems: List<CartItem> = emptyList(),
    val isCheckoutSuccess: Boolean = false,
    val message: String = ""
) {
    val totalItems: Int
        get() = cartItems.sumOf { it.quantity }

    val subtotalPrice: Int
        get() = cartItems.sumOf { it.subtotal }

    val tax: Int
        get() = (subtotalPrice * 10) / 100

    val totalPrice: Int
        get() = subtotalPrice + tax
}