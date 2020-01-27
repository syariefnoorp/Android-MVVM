package syndroid.syarief.tescendana.adapter

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.isfaaghyth.rak.Rak
import kotlinx.android.synthetic.main.user_item.view.*
import syndroid.syarief.tescendana.DetailActivity
import syndroid.syarief.tescendana.R
import syndroid.syarief.tescendana.model.User

class UserAdapter(private var activity : Activity,private var listUser: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.user_item,p0,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tvName.text = listUser[position].name
        holder.itemView.tvName.setOnClickListener {
            val intent = Intent(activity,DetailActivity::class.java)
            Rak.initialize(activity)
            Rak.entry("user",listUser[position])
            activity.startActivity(intent)
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}