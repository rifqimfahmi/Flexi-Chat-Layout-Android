package com.github.rifqimfahmi.chatbubblerevamp.adapter.viewholder

import android.view.View
import android.widget.TextView
import com.github.rifqimfahmi.chatbubblerevamp.R
import kotlinx.android.synthetic.main.item_chat_right.view.*

class RightBubbleChat(itemView: View) : ChatItem(itemView) {

    override fun getMessageTextView(): TextView? {
        return itemView.tvMessage
    }

    companion object {
        val LAYOUT = R.layout.item_chat_right
    }
}