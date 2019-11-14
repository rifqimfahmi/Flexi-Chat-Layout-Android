package com.github.rifqimfahmi.chatbubblerevamp.adapter.viewholder

import android.view.View
import android.widget.TextView
import com.github.rifqimfahmi.chatbubblerevamp.R
import com.github.rifqimfahmi.chatbubblerevamp.adapter.Chat
import com.github.rifqimfahmi.chatbubblerevamp.custom.FlexBoxChatLayout
import kotlinx.android.synthetic.main.item_chat_left.view.*

class LeftBubbleChat(itemView: View) : ChatItem(itemView) {

    override fun getChatLayout(): FlexBoxChatLayout? {
        return null
    }

    override fun getMessageTextView(): TextView? {
        return itemView.tvMessage
    }

    companion object {
        val LAYOUT = R.layout.item_chat_left
    }
}