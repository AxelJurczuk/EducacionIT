package com.example.android.educacionit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android.educacionit.databinding.ActivityUsersBinding

class UsersActivity : AppCompatActivity(), UsersListFragment.OnShowInfoListener {
    private lateinit var binding: ActivityUsersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUsersBinding.inflate(layoutInflater)

        setContentView(binding.root)

        if (savedInstanceState==null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, UsersListFragment())
                    .commit()
        }

    }
    override fun showUserInfo(id: Int,
                              name:String,
                              username:String,
                              email: String) {
        //llamo al metodo estatico para psarle el argunmento al constructor
        val fragment = UserDetailFragment.newInstance(id, name, username, email)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}