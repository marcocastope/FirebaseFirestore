package com.marcocastope.firebasefirestore

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.marcocastope.firebasefirestore.ui.screens.AddProductScreen
import com.marcocastope.firebasefirestore.ui.theme.FirebaseFirestoreTheme
import com.marcocastope.firebasefirestore.viewmodels.ProductViewModel

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: ProductViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ProductViewModel()
        super.onCreate(savedInstanceState)
        setContent {
            FirebaseFirestoreTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AddProductScreen { product ->
                        viewModel.saveProduct(product) { message ->
                            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }
    }
}