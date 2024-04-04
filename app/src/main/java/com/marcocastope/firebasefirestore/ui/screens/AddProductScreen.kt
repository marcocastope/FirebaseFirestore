package com.marcocastope.firebasefirestore.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marcocastope.firebasefirestore.model.Product
import com.marcocastope.firebasefirestore.ui.theme.FirebaseFirestoreTheme

@Composable
fun AddProductScreen(onRegisterProduct: (Product) -> Unit) {
    var name by remember {
        mutableStateOf("")
    }
    val onNameChange: (String) -> Unit = {
        name = it
    }

    var price by remember {
        mutableStateOf("")
    }

    val onPriceChange: (String) -> Unit = {
        price = it
    }

    var stock by remember {
        mutableStateOf("")
    }

    val onStockChange: (String) -> Unit = {
        stock = it
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        Text(text = "Registrar Producto", fontSize = 22.sp, fontWeight = FontWeight.Bold)

        OutlinedTextField(value = name, onValueChange = onNameChange, label = {
            Text(text = "Nombre")
        })
        OutlinedTextField(value = price, onValueChange = onPriceChange, label = {
            Text(text = "Precio")
        }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal))
        OutlinedTextField(value = stock, onValueChange = onStockChange, label = {
            Text(text = "Stock")
        }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

        Button(onClick = {

        }, enabled = validateInputs(name, price, stock)) {
            Text(text = "Registrar")
        }
    }
}

private fun validateInputs(name: String, price: String, stock: String): Boolean {
    return name.isNotEmpty()
            && (price.takeIf { it.isNotEmpty() }?.toDouble() ?: 0.0) > 0.0
            && stock.isNotEmpty()
}

@Preview(showBackground = true)
@Composable
private fun AddProductScreenPrev() {
    FirebaseFirestoreTheme {
        AddProductScreen {}
    }
}