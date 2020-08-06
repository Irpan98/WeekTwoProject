package id.itborneo.task3recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.user_item.view.*
import kotlinx.android.synthetic.main.user_item_inside.view.*

class RvAdapter(private val users : ArrayList<User>, val clickListener:(User, View)-> Unit)  : RecyclerView.Adapter<RvAdapter.UserHolder>(){

    lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        context = parent.context
        val layout = R.layout.user_item
        val view = LayoutInflater.from(context).inflate(layout,parent,false)
        return UserHolder(view)

    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(users[position])
    }


    inner class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind ( user: User ){
            itemView.tv_name.text = user.name
            itemView.tv_address.text = user.city
            itemView.tv_followers.text = user.follower
            itemView.tv_followers.text = user.following


            itemView.iv_user.setImageResource(context.resources.getIdentifier(user.avatar,"drawable",context.packageName))


            itemView.setOnClickListener {
                clickListener(user, itemView)
            }

        }
    }
}