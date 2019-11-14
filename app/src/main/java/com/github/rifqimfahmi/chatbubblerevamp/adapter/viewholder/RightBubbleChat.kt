package com.github.rifqimfahmi.chatbubblerevamp.adapter.viewholder

import android.view.View
import com.github.rifqimfahmi.chatbubblerevamp.R
import com.github.rifqimfahmi.chatbubblerevamp.custom.FlexBoxChatLayout
import kotlinx.android.synthetic.main.item_chat_right.view.*

abstract class RightBubbleChat(itemView: View) : ChatItem(itemView) {

    override fun getChatLayout(): FlexBoxChatLayout? {
        return itemView.fxChat
    }

//    override fun getBackgroundDrawable(): Int {
//        return R.drawable.bg_chat_right_first
//    }

    companion object {
        val LAYOUT = R.layout.item_chat_right
    }
}