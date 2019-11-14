package com.github.rifqimfahmi.chatbubblerevamp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.rifqimfahmi.chatbubblerevamp.adapter.viewholder.*

class ChatFactory {

    fun getItemViewType(
        chats: ArrayList<Chat>,
        position: Int
    ): Int {
        val itemSize = chats.size

        var previousChat: Chat? = null
        val chat: Chat = chats[position]
        var nextChat: Chat? = null

        val previousPosition = position - 1
        val nextPosition = position + 1

        if (previousPosition in 1 until itemSize) {
            previousChat = chats[previousPosition]
        }

        if (nextPosition in 1 until itemSize) {
            nextChat = chats[nextPosition]
        }

        if (chat.isSender) {
            if (previousChat == null && nextChat != null) {
                if (nextChat.isSender) return RIGHT_FIRST
                if (!nextChat.isSender) return RIGHT_LAST
            } else if (previousChat != null && nextChat == null) {
                if (previousChat.isSender) return RIGHT_LAST
                if (!previousChat.isSender) return RIGHT_LAST
            } else if (previousChat != null && nextChat != null) {
                if (!previousChat.isSender && !nextChat.isSender) return RIGHT_LAST
                if (!previousChat.isSender && nextChat.isSender) return RIGHT_FIRST
                if (previousChat.isSender && nextChat.isSender) return RIGHT_MIDDLE
                if (previousChat.isSender && !nextChat.isSender) return RIGHT_LAST
            }
            return RIGHT_LAST
        } else {
            if (previousChat == null && nextChat != null) {
                if (nextChat.isSender) return LEFT_LAST
                if (!nextChat.isSender) return LEFT_FIRST
            } else if (previousChat != null && nextChat == null) {
                if (previousChat.isSender) return LEFT_LAST
                if (!previousChat.isSender) return LEFT_LAST
            } else if (previousChat != null && nextChat != null) {
                if (!previousChat.isSender && !nextChat.isSender) return LEFT_MIDDLE
                if (!previousChat.isSender && nextChat.isSender) return LEFT_LAST
                if (previousChat.isSender && nextChat.isSender) return LEFT_LAST
                if (previousChat.isSender && !nextChat.isSender) return LEFT_FIRST
            }
            return LEFT_LAST
        }


//        if (chat.isSender) {
//            return RightBubbleChat.LAYOUT
//        } else {
//            return LeftBubbleChat.LAYOUT
//        }
    }

    fun create(parent: ViewGroup, viewType: Int): ChatItem {
        var rightView: View? = null
        var leftView: View? = null
        if (viewType == RIGHT_FIRST || viewType == RIGHT_LAST || viewType == RIGHT_MIDDLE) {
            rightView = LayoutInflater.from(parent.context).inflate(RightBubbleChat.LAYOUT, parent, false)
        }
        if (viewType == LEFT_FIRST || viewType == LEFT_MIDDLE || viewType == LEFT_LAST) {
            leftView = LayoutInflater.from(parent.context).inflate(LeftBubbleChat.LAYOUT, parent, false)
        }

        return when (viewType) {
            RIGHT_FIRST -> RightFirstBubbleChat(rightView!!)
            RIGHT_MIDDLE -> RightMiddleBubbleChat(rightView!!)
            RIGHT_LAST -> RightLastBubbleChat(rightView!!)
            LEFT_FIRST -> LeftFirstBubbleChat(leftView!!)
            LEFT_MIDDLE -> LeftMiddleBubbleChat(leftView!!)
            LEFT_LAST -> LeftLastBubbleChat(leftView!!)
            else -> throw IllegalStateException()
        }
    }

    companion object {
        val RIGHT_FIRST = 0
        val RIGHT_MIDDLE = 1
        val RIGHT_LAST = 2
        val LEFT_FIRST = 3
        val LEFT_MIDDLE = 4
        val LEFT_LAST = 5
    }


}