package syndroid.syarief.tescendana.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.user_fragment.*
import kotlinx.android.synthetic.main.user_fragment.view.*
import syndroid.syarief.tescendana.MainActivity

import syndroid.syarief.tescendana.R
import syndroid.syarief.tescendana.adapter.UserAdapter
import syndroid.syarief.tescendana.model.User

class UserFragment : Fragment() {

    companion object {
        fun newInstance() = UserFragment()
    }

    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.user_fragment, container, false)
        view.rvUser.visibility = View.GONE
        view.layoutFailed.visibility = View.GONE
        view.loading.visibility = View.VISIBLE
        view.btnRefresh.setOnClickListener {
            view.rvUser.visibility = View.GONE
            view.layoutFailed.visibility = View.GONE
            view.loading.visibility = View.VISIBLE

            val timer = object : CountDownTimer(2000,1000){
                override fun onFinish() {
                    requestData()
                }

                override fun onTick(p0: Long) {
                }
            }
            timer.start()
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requestData()
    }

    private fun showData(data: List<User>) {
        rvUser.layoutManager = LinearLayoutManager(context)
        rvUser.adapter = UserAdapter(activity!!,data)
    }

    private fun requestData(){
        viewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        viewModel.getData()
        viewModel.setData().observe(this, Observer {
                task ->
            if (task.isNullOrEmpty()){
                loading.visibility = View.GONE
                rvUser.visibility = View.GONE
                layoutFailed.visibility = View.VISIBLE
            }else{
                loading.visibility = View.GONE
                rvUser.visibility = View.VISIBLE
                layoutFailed.visibility = View.GONE
            }
            task?.let { showData(it) }
        })
    }
}
