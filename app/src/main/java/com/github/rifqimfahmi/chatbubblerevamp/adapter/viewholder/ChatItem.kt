package com.github.rifqimfahmi.chatbubblerevamp.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.rifqimfahmi.chatbubblerevamp.adapter.Chat
import com.github.rifqimfahmi.chatbubblerevamp.custom.FlexBoxChatLayout


abstract class ChatItem(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val chatLayout = getChatLayout()

    abstract fun getChatLayout(): FlexBoxChatLayout?

    abstract fun getBackgroundDrawable(): Int

    open fun bind(chat: Chat) {
        chatLayout?.setMessage(chat.message)
        chatLayout?.setBackgroundResource(getBackgroundDrawable())
    }

    fun removeCheckMark() {
        chatLayout?.removeCheckMark()
    }
}