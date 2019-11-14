package com.github.rifqimfahmi.chatbubblerevamp.adapter

import android.view.View
import com.github.rifqimfahmi.chatbubblerevamp.adapter.viewholder.ChatItem
import com.github.rifqimfahmi.chatbubblerevamp.adapter.viewholder.LeftBubbleChat
import com.github.rifqimfahmi.chatbubblerevamp.adapter.viewholder.RightBubbleChat

class ChatFactory {

    fun getItemViewType(
        chats: ArrayList<Chat>,
        position: Int
    ): Int {
        val chat = chats[position]

        if (chat.isSender) {
            return RightBubbleChat.LAYOUT
        } else {
            return LeftBubbleChat.LAYOUT
        }
    }

    fun create(view: View, viewType: Int): ChatItem {
        return when (viewType) {
            LeftBubbleChat.LAYOUT -> LeftBubbleChat(view)
            RightBubbleChat.LAYOUT -> RightBubbleChat(view)
            else -> throw IllegalStateException()
        }
    }
}