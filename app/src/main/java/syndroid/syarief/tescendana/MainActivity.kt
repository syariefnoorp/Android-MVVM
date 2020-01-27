package syndroid.syarief.tescendana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import syndroid.syarief.tescendana.R
import syndroid.syarief.tescendana.ui.UserFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.title = "List Users"

        supportFragmentManager.beginTransaction().replace(R.id.layoutContainer,UserFragment()).commit()
    }
}
