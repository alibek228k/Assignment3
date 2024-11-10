package kz.alibek.assignment3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.alibek.assignment3.model.User

class UserAdapter(
    private var userList: List<User>,
    private val onItemClicked: (User) -> Unit,
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.textView_name)
        val ageTextView: TextView = itemView.findViewById(R.id.textView_age)

        val rootView = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.nameTextView.text = user.name
        holder.ageTextView.text = user.age.toString()

        holder.rootView.setOnClickListener {
            onItemClicked(user)
        }
    }

    override fun getItemCount(): Int = userList.size

    fun updateUsers(newUsers: List<User>) {
        userList = newUsers
        notifyDataSetChanged()
    }
}