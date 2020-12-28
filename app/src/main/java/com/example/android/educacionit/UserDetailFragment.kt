package com.example.android.educacionit

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.educacionit.broadcast.LowBatteryActivity
import com.example.android.educacionit.databinding.FragmentUserDetailBinding
import com.example.android.educacionit.notifications.NotificationsActivity

class UserDetailFragment: Fragment() {

    companion object {
        private const val ID = "ID"
        private const val NAME = "NAME"
        private const val USER_NAME = "USER_NAME"
        private const val EMAIL = "EMAIL"

        //se llama cuando se crea el fragment, en este caso quiero que se cree con parametros
        fun newInstance (id: Int,
                         name:String,
                         username:String,
                         email: String): Fragment{

            val newUserDetailFragment = UserDetailFragment ()
            val args = Bundle ()
            args.putInt(ID, id)
            args.putString(NAME,name)
            args.putString(USER_NAME,username)
            args.putString(EMAIL,email)
            newUserDetailFragment.arguments = args

            return newUserDetailFragment
        }
    }
    private lateinit var binding: FragmentUserDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentUserDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val id = arguments?.getInt(ID)
        binding.tvUserId.text = id.toString()
        val name = arguments?.getString(NAME)
        binding.tvName.text = name.toString()
        val userName = arguments?.getString(USER_NAME)
        binding.tvUserName.text = userName.toString()
        val email = arguments?.getString(EMAIL)
        binding.tvEmail.text = email.toString()

        binding.btnShowNotification.setOnClickListener { openNotificationActivity() }
    }

    private fun openNotificationActivity(){
        val intent = Intent (context, NotificationsActivity::class.java)
        startActivity(intent)
    }
    private fun openLowBatteryActivity(){
        val intent = Intent (context, LowBatteryActivity::class.java)
        startActivity(intent)
    }

}