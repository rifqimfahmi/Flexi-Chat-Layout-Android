package com.github.rifqimfahmi.chatbubblerevamp

import com.github.rifqimfahmi.chatbubblerevamp.adapter.Chat
import kotlin.random.Random

object ChatUtil {

    val CHAT_COUNT = 100
    val CHAT_MESSAGE_DUMMY = listOf(
        "Selamat datang",
        "Ada yang bisa dibantu?",
        "Mau cari susu yang bisa buat keker dlm satu malam ada gak?",
        "Mau cari susu yang bisa buat keker dlm satu malam ada gak ya gan?",
        "Mau cari susu yang bisa buat keker dlm satu malam ada gak ya gan yang mantap sehat?",
        "Mau cari susu yang bisa buat keker gan?",
        "Oh susu qeqerinstant?",
        "Mantoel gan"
    )

    fun getChats(): ArrayList<Chat> {
        val chats = arrayListOf<Chat>()
        val dummySize = CHAT_MESSAGE_DUMMY.size
        for (i in 0 until CHAT_COUNT) {
            val isSender = Random.nextBoolean()
            val messageIndex = (0 until dummySize).random()
            val message = CHAT_MESSAGE_DUMMY[messageIndex]
            chats.add(Chat(message, isSender))
        }
        return chats
    }
}