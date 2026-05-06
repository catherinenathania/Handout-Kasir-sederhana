package com.CatherineNathania.tugascashier.data

import com.CatherineNathania.tugascashier.model.Product

object DummyProductData {
    val products = listOf(
        Product(id = 1, name = "Nasi Goreng", price = 15000),
        Product(id = 2, name = "Mie Goreng", price = 12000),
        Product(id = 3, name = "Es Teh", price = 5000),
        Product(id = 4, name = "Air Mineral", price = 4000),
        Product(id = 5, name = "Ayam Geprek", price = 18000)
    )
}