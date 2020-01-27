package syndroid.syarief.tescendana.network

import retrofit2.Call
import retrofit2.http.GET
import syndroid.syarief.tescendana.model.User

interface ApiService {

    @GET("users")
    fun getUser(): Call<List<User>>
}