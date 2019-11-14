package com.github.rifqimfahmi.chatbubblerevamp.adapter.viewholder

import android.view.View
import com.github.rifqimfahmi.chatbubblerevamp.R

class RightLastBubbleChat(itemView: View) : RightBubbleChat(itemView) {
    override fun getBackgroundDrawable(): Int {
        return R.drawable.bg_chat_right_last
    }
}