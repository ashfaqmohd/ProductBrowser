import com.example.productbrowser.data.remote.NetworkResult
import com.example.productbrowser.domain.model.Product
import com.example.productbrowser.domain.repository.ProductRepository

class FakeProductRepository : ProductRepository {

    override suspend fun getProductDetail(id: Int): NetworkResult<Product> {

        return NetworkResult.Success(
            Product(
                id = id,
                name = "iPhone 15",
                description = "Latest Apple phone",
                brand = "Apple",
                price = 999.0,
                rating = 4.8,
                thumbnail = ""
            )
        )
    }

    override suspend fun getProducts(): NetworkResult<List<Product>> {
        return NetworkResult.Success(emptyList())
    }

    override suspend fun searchProducts(query: String): NetworkResult<List<Product>> {
        return NetworkResult.Success(emptyList())
    }
}