package technical.test.wanderer.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import technical.test.wanderer.R
import technical.test.wanderer.databinding.ItemListUserBinding
import technical.test.wanderer.model.Users

class UserViewHolder(
    private val binding: ItemListUserBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(users: Users) {
        binding.run {
            Glide.with(root.context)
                .load(users.avatar)
                .apply(RequestOptions().transform(CircleCrop()))
                .into(binding.ivAvatar)
            tvName.text = root.context.getString(R.string.fullname, users.firstname, users.lastname)
            tvEmail.text = users.email
        }
    }

}