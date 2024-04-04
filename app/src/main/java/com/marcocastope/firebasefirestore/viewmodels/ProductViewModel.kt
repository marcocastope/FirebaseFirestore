package com.marcocastope.firebasefirestore.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.marcocastope.firebasefirestore.model.Product

class ProductViewModel : ViewModel() {

    private val db = Firebase.firestore

    fun saveProduct(product: Product, onSuccessMessage: (String) -> Unit) {
        db.collection("products")
            .add(product)
            .addOnSuccessListener {
                onSuccessMessage("Producto registrado con éxito")
            }
            .addOnFailureListener { e ->
                Log.d(javaClass.simpleName, "${e.message}")
            }
    }
}