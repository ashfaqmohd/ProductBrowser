package com.example.productbrowser.ui.product

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.productbrowser.domain.model.Product

@Composable
fun ProductList(
    products: List<Product>,
    onProductClick: (Int) -> Unit
) {

    LazyColumn {

        items(count = products.size) { pos ->

            ProductItem(
                product = products[pos],
                onClick = {
                    onProductClick(products[pos].id)
                }
            )
        }
    }
}

@Composable
fun ProductItem(
    product: Product,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(12.dp)
    ) {

        AsyncImage(
            model = product.thumbnail,
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
        )

        Spacer(Modifier.width(12.dp))

        Column {

            Text(
                text = product.name,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(Modifier.height(4.dp))

            Text(
                text = "$${product.price}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}