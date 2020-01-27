package syndroid.syarief.tescendana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import io.isfaaghyth.rak.Rak
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.user_item.*
import kotlinx.android.synthetic.main.user_item.tvName
import syndroid.syarief.tescendana.model.User

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //display back
        supportActionBar!!.title = "Detail User"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        //get data user with rak
        Rak.initialize(this)
        val user : User = Rak.grab("user")

        //set item view
        tvName.text = user.name
        tvId.text = user.userId.toString()
        tvUsername.text = user.username
        tvEmail.text = user.email
        tvPhone.text = user.phone
        tvWeb.text = user.website
        tvStreet.text = user.address.street
        tvSuite.text = user.address.suite
        tvCity.text = user.address.city
        tvZipcode.text = user.address.zipcode
        tvLat.text = user.address.geo.lat
        tvLng.text = user.address.geo.lng
        tvCompName.text = user.company.companyName
        tvCp.text = user.company.catchPhrase
        tvBs.text = user.company.bs
    }

    override fun onSupportNavigateUp(): Boolean {
        this.finish()
        return true
    }
}
