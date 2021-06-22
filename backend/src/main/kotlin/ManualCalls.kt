import kotlinx.coroutines.runBlocking
import org.openapitools.client.apis.PetApi
import org.openapitools.client.apis.StoreApi
import org.openapitools.client.apis.UserApi
import org.openapitools.client.models.Order
import org.openapitools.client.models.Pet

@Suppress("MagicNumber")
fun main(): Unit = runBlocking {
    val petApi = PetApi()

    println("Call 1")
    petApi.addPet(
        Pet(
            name = "Kika",
            photoUrls = listOf("https://www.google.com/logos/doodles/2021/get-vaccinated-wear-a-mask-save-lives-june-22-6753651837109280-law.gif"),
            status = Pet.Status.available,
        )
    )

    println("Call 2")
    val findPetsByStatus = petApi.findPetsByStatus(listOf("available"))
    println(findPetsByStatus.body().take(5))

    val storeApi = StoreApi()

    println("Call 3")
    val inventory = storeApi.getInventory().body()
    println(inventory)

    println("Call 4")
    val order = storeApi.placeOrder(Order()).body()
    println(order)
}
