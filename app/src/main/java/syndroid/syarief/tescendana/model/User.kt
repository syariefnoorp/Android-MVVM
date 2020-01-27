package syndroid.syarief.tescendana.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    @SerializedName("id")
    val userId : Int = 0,
    @SerializedName("name")
    val name : String = "",
    @SerializedName("username")
    val username : String = "",
    @SerializedName("email")
    val email : String = "",
    @SerializedName("address")
    val address : Address,
    @SerializedName("phone")
    val phone : String = "",
    @SerializedName("website")
    val website : String = "",
    @SerializedName("company")
    val company : Company
) : Serializable