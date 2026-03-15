import com.example.productbrowser.data.remote.NetworkResult
import com.example.productbrowser.domain.usecase.product.GetProductDetailUseCase
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class GetProductDetailUseCaseTest {

    private val repository = FakeProductRepository()
    private val useCase = GetProductDetailUseCase(repository)

    @Test
    fun `get product detail returns correct product`() = runTest {

        val result = useCase(1)

        if (result is NetworkResult.Success) {

            assertEquals(1, result.data.id)
            assertEquals("iPhone 15", result.data.name)
            assertEquals("Apple", result.data.brand)
        }
    }
}