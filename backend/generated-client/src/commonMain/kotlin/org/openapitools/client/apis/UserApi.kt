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

import org.openapitools.client.models.User

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

class UserApi @UseExperimental(UnstableDefault::class) constructor(
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
     * Create user
     * This can only be done by the logged in user.
     * @param body Created user object 
     * @return void
     */
    suspend fun createUser(body: User): HttpResponse<Unit> {

        val localVariableAuthNames = listOf<String>()

        val localVariableBody = body

        val localVariableQuery = mutableMapOf<String, List<String>>()

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            "/user",
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
     * Creates list of users with given input array
     * 
     * @param body List of user object 
     * @return void
     */
    suspend fun createUsersWithArrayInput(body: kotlin.collections.List<User>): HttpResponse<Unit> {

        val localVariableAuthNames = listOf<String>()

        val localVariableBody = CreateUsersWithArrayInputRequest(body)

        val localVariableQuery = mutableMapOf<String, List<String>>()

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            "/user/createWithArray",
            query = localVariableQuery,
            headers = localVariableHeaders
        )

        return jsonRequest(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
        ).wrap()
    }

    @Serializable
    private class CreateUsersWithArrayInputRequest(val value: List<User>) {
        @Serializer(CreateUsersWithArrayInputRequest::class)
        companion object : KSerializer<CreateUsersWithArrayInputRequest> {
            private val serializer: KSerializer<List<User>> = User.serializer().list
                override val descriptor = StringDescriptor.withName("CreateUsersWithArrayInputRequest")
                override fun serialize(encoder: Encoder, obj: CreateUsersWithArrayInputRequest) = serializer.serialize(encoder, obj.value)
                override fun deserialize(decoder: Decoder) = CreateUsersWithArrayInputRequest(serializer.deserialize(decoder))
        }
    }

    /**
     * Creates list of users with given input array
     * 
     * @param body List of user object 
     * @return void
     */
    suspend fun createUsersWithListInput(body: kotlin.collections.List<User>): HttpResponse<Unit> {

        val localVariableAuthNames = listOf<String>()

        val localVariableBody = CreateUsersWithListInputRequest(body)

        val localVariableQuery = mutableMapOf<String, List<String>>()

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            "/user/createWithList",
            query = localVariableQuery,
            headers = localVariableHeaders
        )

        return jsonRequest(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
        ).wrap()
    }

    @Serializable
    private class CreateUsersWithListInputRequest(val value: List<User>) {
        @Serializer(CreateUsersWithListInputRequest::class)
        companion object : KSerializer<CreateUsersWithListInputRequest> {
            private val serializer: KSerializer<List<User>> = User.serializer().list
                override val descriptor = StringDescriptor.withName("CreateUsersWithListInputRequest")
                override fun serialize(encoder: Encoder, obj: CreateUsersWithListInputRequest) = serializer.serialize(encoder, obj.value)
                override fun deserialize(decoder: Decoder) = CreateUsersWithListInputRequest(serializer.deserialize(decoder))
        }
    }

    /**
     * Delete user
     * This can only be done by the logged in user.
     * @param username The name that needs to be deleted 
     * @return void
     */
    suspend fun deleteUser(username: kotlin.String): HttpResponse<Unit> {

        val localVariableAuthNames = listOf<String>()

        val localVariableBody = 
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig(
            RequestMethod.DELETE,
            "/user/{username}".replace("{" + "username" + "}", "$username"),
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
     * Get user by user name
     * 
     * @param username The name that needs to be fetched. Use user1 for testing.  
     * @return User
     */
    @Suppress("UNCHECKED_CAST")
    suspend fun getUserByName(username: kotlin.String): HttpResponse<User> {

        val localVariableAuthNames = listOf<String>()

        val localVariableBody = 
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "/user/{username}".replace("{" + "username" + "}", "$username"),
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
     * Logs user into the system
     * 
     * @param username The user name for login 
     * @param password The password for login in clear text 
     * @return kotlin.String
     */
    @Suppress("UNCHECKED_CAST")
    suspend fun loginUser(username: kotlin.String, password: kotlin.String): HttpResponse<kotlin.String> {

        val localVariableAuthNames = listOf<String>()

        val localVariableBody = 
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        username?.apply { localVariableQuery["username"] = listOf("$username") }
        password?.apply { localVariableQuery["password"] = listOf("$password") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "/user/login",
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
     * Logs out current logged in user session
     * 
     * @return void
     */
    suspend fun logoutUser(): HttpResponse<Unit> {

        val localVariableAuthNames = listOf<String>()

        val localVariableBody = 
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "/user/logout",
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
     * Updated user
     * This can only be done by the logged in user.
     * @param username name that need to be updated 
     * @param body Updated user object 
     * @return void
     */
    suspend fun updateUser(username: kotlin.String, body: User): HttpResponse<Unit> {

        val localVariableAuthNames = listOf<String>()

        val localVariableBody = body

        val localVariableQuery = mutableMapOf<String, List<String>>()

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig(
            RequestMethod.PUT,
            "/user/{username}".replace("{" + "username" + "}", "$username"),
            query = localVariableQuery,
            headers = localVariableHeaders
        )

        return jsonRequest(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
        ).wrap()
    }




    companion object {
        internal fun setMappers(serializer: KotlinxSerializer) {
            
            serializer.setMapper(CreateUsersWithArrayInputRequest::class, CreateUsersWithArrayInputRequest.serializer())
            serializer.setMapper(CreateUsersWithListInputRequest::class, CreateUsersWithListInputRequest.serializer())
            
        }
    }
}
