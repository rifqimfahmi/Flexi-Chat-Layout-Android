package com.github.rifqimfahmi.chatbubblerevamp.adapter.viewholder

import android.view.View
import com.github.rifqimfahmi.chatbubblerevamp.R

class LeftLastBubbleChat(itemView: View) : LeftBubbleChat(itemView) {
    override fun getBackgroundDrawable(): Int {
        return R.drawable.bg_chat_left_last
    }
}