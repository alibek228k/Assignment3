package kz.alibek.assignment3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.alibek.assignment3.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.insertButton)
        val textInput = findViewById<EditText>(R.id.editText_input)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_users)
        recyclerView.layoutManager = LinearLayoutManager(this)
        userViewModel = ViewModelProvider(this, UserViewModelFactory(application)).get(UserViewModel::class.java)
        userAdapter = UserAdapter(
            userList = emptyList(),
            onItemClicked = userViewModel::delete
        )
        recyclerView.adapter = userAdapter

        userViewModel.allUsers.observe(this) { users ->
            userAdapter.updateUsers(users)
        }

        button.setOnClickListener {
            userViewModel.insert(
                User(
                    id = 0,
                    name = textInput.text.toString(),
                    age = 0,
                )
            )
        }
    }
}




