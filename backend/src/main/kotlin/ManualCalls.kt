import kotlinx.coroutines.runBlocking
import org.openapitools.client.apis.PetApi

@Suppress("MagicNumber")
fun main(): Unit = runBlocking {
    val petApi = PetApi()
    val findPetsByStatus = petApi.findPetsByStatus(listOf("available"))
    println(findPetsByStatus.body().take(5))
}
