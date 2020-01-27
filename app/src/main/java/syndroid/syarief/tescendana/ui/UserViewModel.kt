package syndroid.syarief.tescendana.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import syndroid.syarief.tescendana.model.User
import syndroid.syarief.tescendana.network.NetworkConfig

class UserViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private var data = MutableLiveData<List<User>>()

    fun getData() {
        NetworkConfig().api().getUser().enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {

                if(response.isSuccessful){
                    data.value = response.body()
                }
            }
        })
    }

    fun setData() : MutableLiveData<List<User>> {
        return data
    }
}
