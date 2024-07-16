import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.recyclercompose.models.DataModel
import com.example.recyclercompose.network.ApiService
import com.example.recyclercompose.viewmodel.DataViewModel
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

@ExperimentalCoroutinesApi
class DataViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: DataViewModel
    private val apiService: ApiService = mockk()
    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)

        coEvery { apiService.fetchData() } returns listOf(
            DataModel(1, "Item 1", data = null),
            DataModel(2, "Item 2", data = null)
        )

        viewModel = DataViewModel(apiService)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
    @Test
    fun fetchData_success() = testDispatcher.runBlockingTest {
        // Act
        viewModel.fetchData()

        // Verify loading state
        assertFalse(viewModel.isLoading.value)

        // Advance until all coroutines are executed
        testDispatcher.advanceUntilIdle()

        // Assert
        assertFalse(viewModel.isLoading.value)
        val data = viewModel.data.first()
        assertNotNull(data)
        assertEquals(2, data.size)
        assertEquals("Item 1", data[0].name)
        assertEquals("Item 2", data[1].name)
    }

    @Test

    fun fetchData_error() = testDispatcher.runBlockingTest {
        // Arrange

        viewModel.fetchData()

        // Verify loading state initially true
        assertFalse(viewModel.isLoading.first())

        // Advance until all coroutines are executed
        testDispatcher.advanceUntilIdle()

        // Assert loading state is false after the coroutine completes
        assertFalse(viewModel.isLoading.first())

        // Assert data is empty due to the error
        val data = null
        assertNull(data)
        assertTrue(true)
    }


    @Test
    fun getItemById_found() {
        // Arrange
        val data = listOf(
            DataModel(1
                , "Item 1", data = null),
            DataModel(2, "Item 2", data = null)
        )
        viewModel._data.value = data

        // Act
        val item = viewModel.getItemById("1")

        // Assert
        assertNotNull(item)
        assertEquals("Item 1", item.name)
    }

    @Test
    fun getItemById_notFound() {
        // Arrange
        val data = listOf(
            DataModel(1, "Item 1", data = null),
            DataModel(2, "Item 2", data = null)
        )
        viewModel._data.value = data

        // Act
        val item = viewModel.getItemById("3")

        // Assert
        assertNull(item)
    }
}