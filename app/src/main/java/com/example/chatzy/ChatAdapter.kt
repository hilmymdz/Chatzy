package com.example.chatzy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.ai.client.generativeai.Chat

class ChatAdapter(private val itemList: kotlin.collections.List<ItemList>): RecyclerView.Adapter<ChatAdapter.ViewHolder>(){

    class ViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage: ImageView = itemView.findViewById(R.id.profileImage)
        val userName: TextView = itemView.findViewById(R.id.userName)
        val lastMessage: TextView = itemView.findViewById(R.id.lastMessage)
        val timestamp: TextView = itemView.findViewById(R.id.timeStamp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]

        holder.userName.text = item.userName
        holder.lastMessage.text = item.lastMessage
        holder.timestamp.text = item.timestamp

        Glide.with(holder.profileImage.context).load(item.imageURL).into(holder.profileImage)

        holder.itemView.setOnClickListener {
            // Handle click on chat item
        }
    }

    override fun getItemCount(): Int{
        return itemList.size
    }

}
