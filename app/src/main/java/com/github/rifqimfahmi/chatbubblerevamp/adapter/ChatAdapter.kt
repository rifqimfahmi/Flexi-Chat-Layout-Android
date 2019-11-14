package com.github.rifqimfahmi.chatbubblerevamp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.rifqimfahmi.chatbubblerevamp.ChatUtil
import com.github.rifqimfahmi.chatbubblerevamp.adapter.viewholder.ChatItem

class ChatAdapter : RecyclerView.Adapter<ChatItem>() {

    private val chats = ChatUtil.getChats()
    private val factory = ChatFactory()

    override fun getItemViewType(position: Int): Int {
        return factory.getItemViewType(chats, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatItem {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return factory.create(view, viewType)
    }

    override fun getItemCount(): Int {
        return chats.size
    }

    override fun onBindViewHolder(holder: ChatItem, position: Int) {
        holder.bind(chats[position])
    }

}

data class Chat(val message: String, val isSender: Boolean)