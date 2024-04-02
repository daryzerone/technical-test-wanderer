package technical.test.wanderer.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import technical.test.wanderer.adapter.viewholder.UserViewHolder
import technical.test.wanderer.databinding.ItemListUserBinding
import technical.test.wanderer.model.Users

class UserAdapter : RecyclerView.Adapter<UserViewHolder>() {

    private val userList = mutableListOf<Users>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemListUserBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    fun addUserList(list: List<Users>) {
        val lastIndex = if (userList.size == 0) 0 else userList.size - 1
        userList.addAll(list)
        notifyItemRangeInserted(lastIndex, list.size)
    }
}