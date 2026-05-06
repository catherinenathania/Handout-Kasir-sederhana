package com.CatherineNathania.tugascashier.model

data class CartItem(
    val product: Product,
    val quantity: Int
) {
    val subtotal: Int
        get() = product.price * quantity
}