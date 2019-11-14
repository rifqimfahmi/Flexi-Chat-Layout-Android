package com.github.rifqimfahmi.chatbubblerevamp.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.rifqimfahmi.chatbubblerevamp.adapter.Chat
import com.github.rifqimfahmi.chatbubblerevamp.custom.FlexBoxChatLayout


abstract class ChatItem(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val message = getMessageTextView()
    private val chatLayout = getChatLayout()

    abstract fun getChatLayout(): FlexBoxChatLayout?

    abstract fun getMessageTextView(): TextView?

    open fun bind(chat: Chat) {
        message?.text = chat.message
        chatLayout?.setMessage(chat.message)
    }
}