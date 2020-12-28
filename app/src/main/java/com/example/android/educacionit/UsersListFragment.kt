package com.example.android.educacionit

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.android.educacionit.adapter.ItemAdapter
import com.example.android.educacionit.api.Api
import com.example.android.educacionit.databinding.FragmentUsersListBinding
import com.example.android.educacionit.extensions.hide
import com.example.android.educacionit.extensions.remove
import com.example.android.educacionit.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class UsersListFragment : Fragment(), ItemAdapter.OnItemClick {

    interface OnShowInfoListener {
        fun showUserInfo(id: Int,
                         name:String,
                         username:String,
                         email: String)
    }

    private lateinit var binding: FragmentUsersListBinding
    private lateinit var listener: OnShowInfoListener

    private lateinit var adapter: ItemAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        /*
        casteo la activity que se pasa como context a la interface xq solo me interesan eso metodos
        el "as" es para castear activities (puede usarse como as? de ser necesario)
        obligo a la activity a que implemente la interfaz
         */
        listener = context as OnShowInfoListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUsersListBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //creo instancia de Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val api: Api = retrofit.create(Api::class.java)

        api.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {

                hideProgressBar()
                if (response.isSuccessful) {

                    val usersList = response.body()

                    val recyclerView = binding.recyclerView
                    //una duda que tengo es por que paso el listener como "this" ??
                    adapter = ItemAdapter(requireContext(), this@UsersListFragment)
                    adapter.usersList = usersList!!
                    recyclerView.adapter = adapter
                    // Use this setting to improve performance if you know that changes
                    // in content do not change the layout size of the RecyclerView
                    recyclerView.setHasFixedSize(true)

                } else {
                    Toast.makeText(context, "ocurrio un error con esta petición", Toast.LENGTH_LONG)
                        .show()
                }
            }
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                hideProgressBar()
                Toast.makeText(context, "ha ocurrido un error", Toast.LENGTH_LONG).show()
            }

        })
    }

    override fun onItemClickListener(position: Int) {
        listener.showUserInfo(
                adapter.usersList[position].id,
                adapter.usersList[position].name,
                adapter.usersList[position].username,
                adapter.usersList[position].email)
    }
    private fun hideProgressBar(){
        binding.progressBar.remove()
    }

}
