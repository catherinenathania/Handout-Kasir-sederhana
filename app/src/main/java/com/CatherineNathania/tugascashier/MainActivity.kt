package com.CatherineNathania.tugascashier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.CatherineNathania.tugascashier.ui.screen.CashierScreen
import com.CatherineNathania.tugascashier.viewmodel.CashierViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val cashierViewModel: CashierViewModel = viewModel()
            val uiState = cashierViewModel.uiState

            CashierScreen(
                uiState = uiState,
                onAddProduct = cashierViewModel::addToCart,
                onDecreaseItem = cashierViewModel::decreaseItem,
                onCheckout = cashierViewModel::checkout,
                onResetTransaction = cashierViewModel::resetTransaction
            )
        }
    }
}