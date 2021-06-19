/**
* Swagger Petstore
* This is a sample server Petstore server.  You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).  For this sample, you can use the api key `special-key` to test the authorization filters.
*
* The version of the OpenAPI document: 1.0.5
* Contact: apiteam@swagger.io
*
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
* https://openapi-generator.tech
* Do not edit the class manually.
*/
package org.openapitools.client.apis

import org.openapitools.client.models.ApiResponse
import org.openapitools.client.models.Pet

import org.openapitools.client.infrastructure.*
import io.ktor.client.request.forms.formData
import kotlinx.serialization.UnstableDefault
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import io.ktor.http.ParametersBuilder
import kotlinx.serialization.*
import kotlinx.serialization.internal.StringDescriptor

class PetApi @UseExperimental(UnstableDefault::class) constructor(
    baseUrl: kotlin.String = "https://petstore.swagger.io/v2",
    httpClientEngine: HttpClientEngine? = null,
    serializer: KotlinxSerializer
) : ApiClient(baseUrl, httpClientEngine, serializer) {

    @UseExperimental(UnstableDefault::class)
    constructor(
        baseUrl: kotlin.String = "https://petstore.swagger.io/v2",
        httpClientEngine: HttpClientEngine? = null,
        jsonConfiguration: JsonConfiguration = JsonConfiguration.Default
    ) : this(baseUrl, httpClientEngine, KotlinxSerializer(Json(jsonConfiguration)))

    /**
     * Add a new pet to the store
     * 
     * @param body Pet object that needs to be added to the store 
     * @return void
     */
    suspend fun addPet(body: Pet): HttpResponse<Unit> {

        val localVariableAuthNames = listOf<String>("petstore_auth")

        val localVariableBody = body

        val localVariableQuery = mutableMapOf<String, List<String>>()

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            "/pet",
            query = localVariableQuery,
            headers = localVariableHeaders
        )

        return jsonRequest(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
        ).wrap()
    }



    /**
     * Deletes a pet
     * 
     * @param petId Pet id to delete 
     * @param apiKey  (optional)
     * @return void
     */
    suspend fun deletePet(petId: kotlin.Long, apiKey: kotlin.String?): HttpResponse<Unit> {

        val localVariableAuthNames = listOf<String>("petstore_auth")

        val localVariableBody = 
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()

        val localVariableHeaders = mutableMapOf<String, String>()
        apiKey?.apply { localVariableHeaders["api_key"] = this.toString() }

        val localVariableConfig = RequestConfig(
            RequestMethod.DELETE,
            "/pet/{petId}".replace("{" + "petId" + "}", "$petId"),
            query = localVariableQuery,
            headers = localVariableHeaders
        )

        return request(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
        ).wrap()
    }


    /**
     * Finds Pets by status
     * Multiple status values can be provided with comma separated strings
     * @param status Status values that need to be considered for filter 
     * @return kotlin.collections.List<Pet>
     */
    @Suppress("UNCHECKED_CAST")
    suspend fun findPetsByStatus(status: kotlin.collections.List<kotlin.String>): HttpResponse<kotlin.collections.List<Pet>> {

        val localVariableAuthNames = listOf<String>("petstore_auth")

        val localVariableBody = 
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        status?.apply { localVariableQuery["status"] = toMultiValue(this, "multi") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "/pet/findByStatus",
            query = localVariableQuery,
            headers = localVariableHeaders
        )

        return request(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
        ).wrap<FindPetsByStatusResponse>().map { value }
    }

    @Serializable
    private class FindPetsByStatusResponse(val value: List<Pet>) {
        @Serializer(FindPetsByStatusResponse::class)
        companion object : KSerializer<FindPetsByStatusResponse> {
            private val serializer: KSerializer<List<Pet>> = Pet.serializer().list
                override val descriptor = StringDescriptor.withName("FindPetsByStatusResponse")
                override fun serialize(encoder: Encoder, obj: FindPetsByStatusResponse) = serializer.serialize(encoder, obj.value)
                override fun deserialize(decoder: Decoder) = FindPetsByStatusResponse(serializer.deserialize(decoder))
        }
    }

    /**
     * Finds Pets by tags
     * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     * @param tags Tags to filter by 
     * @return kotlin.collections.List<Pet>
     */
    @Suppress("UNCHECKED_CAST")
    suspend fun findPetsByTags(tags: kotlin.collections.List<kotlin.String>): HttpResponse<kotlin.collections.List<Pet>> {

        val localVariableAuthNames = listOf<String>("petstore_auth")

        val localVariableBody = 
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        tags?.apply { localVariableQuery["tags"] = toMultiValue(this, "multi") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "/pet/findByTags",
            query = localVariableQuery,
            headers = localVariableHeaders
        )

        return request(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
        ).wrap<FindPetsByTagsResponse>().map { value }
    }

    @Serializable
    private class FindPetsByTagsResponse(val value: List<Pet>) {
        @Serializer(FindPetsByTagsResponse::class)
        companion object : KSerializer<FindPetsByTagsResponse> {
            private val serializer: KSerializer<List<Pet>> = Pet.serializer().list
                override val descriptor = StringDescriptor.withName("FindPetsByTagsResponse")
                override fun serialize(encoder: Encoder, obj: FindPetsByTagsResponse) = serializer.serialize(encoder, obj.value)
                override fun deserialize(decoder: Decoder) = FindPetsByTagsResponse(serializer.deserialize(decoder))
        }
    }

    /**
     * Find pet by ID
     * Returns a single pet
     * @param petId ID of pet to return 
     * @return Pet
     */
    @Suppress("UNCHECKED_CAST")
    suspend fun getPetById(petId: kotlin.Long): HttpResponse<Pet> {

        val localVariableAuthNames = listOf<String>("api_key")

        val localVariableBody = 
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "/pet/{petId}".replace("{" + "petId" + "}", "$petId"),
            query = localVariableQuery,
            headers = localVariableHeaders
        )

        return request(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
        ).wrap()
    }


    /**
     * Update an existing pet
     * 
     * @param body Pet object that needs to be added to the store 
     * @return void
     */
    suspend fun updatePet(body: Pet): HttpResponse<Unit> {

        val localVariableAuthNames = listOf<String>("petstore_auth")

        val localVariableBody = body

        val localVariableQuery = mutableMapOf<String, List<String>>()

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig(
            RequestMethod.PUT,
            "/pet",
            query = localVariableQuery,
            headers = localVariableHeaders
        )

        return jsonRequest(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
        ).wrap()
    }



    /**
     * Updates a pet in the store with form data
     * 
     * @param petId ID of pet that needs to be updated 
     * @param name Updated name of the pet (optional)
     * @param status Updated status of the pet (optional)
     * @return void
     */
    suspend fun updatePetWithForm(petId: kotlin.Long, name: kotlin.String?, status: kotlin.String?): HttpResponse<Unit> {

        val localVariableAuthNames = listOf<String>("petstore_auth")

        val localVariableBody = 
            ParametersBuilder().also {
                name?.apply { it.append("name", name.toString()) }
                status?.apply { it.append("status", status.toString()) }
            }.build()

        val localVariableQuery = mutableMapOf<String, List<String>>()

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            "/pet/{petId}".replace("{" + "petId" + "}", "$petId"),
            query = localVariableQuery,
            headers = localVariableHeaders
        )

        return urlEncodedFormRequest(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
        ).wrap()
    }


    /**
     * uploads an image
     * 
     * @param petId ID of pet to update 
     * @param additionalMetadata Additional data to pass to server (optional)
     * @param file file to upload (optional)
     * @return ApiResponse
     */
    @Suppress("UNCHECKED_CAST")
    suspend fun uploadFile(petId: kotlin.Long, additionalMetadata: kotlin.String?, file: io.ktor.client.request.forms.InputProvider?): HttpResponse<ApiResponse> {

        val localVariableAuthNames = listOf<String>("petstore_auth")

        val localVariableBody = 
            formData {
                additionalMetadata?.apply { append("additionalMetadata", additionalMetadata) }
                file?.apply { append("file", file) }
            }

        val localVariableQuery = mutableMapOf<String, List<String>>()

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            "/pet/{petId}/uploadImage".replace("{" + "petId" + "}", "$petId"),
            query = localVariableQuery,
            headers = localVariableHeaders
        )

        return multipartFormRequest(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
        ).wrap()
    }



    companion object {
        internal fun setMappers(serializer: KotlinxSerializer) {
            
            serializer.setMapper(FindPetsByStatusResponse::class, FindPetsByStatusResponse.serializer())
            serializer.setMapper(FindPetsByTagsResponse::class, FindPetsByTagsResponse.serializer())
            
        }
    }
}
