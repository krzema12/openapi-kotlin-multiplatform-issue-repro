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
package org.openapitools.client.models


import kotlinx.serialization.*
import kotlinx.serialization.internal.CommonEnumSerializer

/**
 * 
 * @param id 
 * @param petId 
 * @param quantity 
 * @param shipDate 
 * @param status Order Status
 * @param complete 
 */
@Serializable
data class Order (
    @SerialName(value = "id") val id: kotlin.Long? = null,
    @SerialName(value = "petId") val petId: kotlin.Long? = null,
    @SerialName(value = "quantity") val quantity: kotlin.Int? = null,
    @SerialName(value = "shipDate") val shipDate: kotlin.String? = null,
    /* Order Status */
    @SerialName(value = "status") val status: Order.Status? = null,
    @SerialName(value = "complete") val complete: kotlin.Boolean? = null
) {

    /**
     * Order Status
     * Values: placed,approved,delivered
     */
    enum class Status(val value: kotlin.String) {
        placed("placed"),
        approved("approved"),
        delivered("delivered");
    }
}

