package com.github.rifqimfahmi.chatbubblerevamp.custom

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.github.rifqimfahmi.chatbubblerevamp.R

class FlexBoxChatLayout : FrameLayout {

    private var message: TextView? = null
    private var status: LinearLayout? = null
    private var checkMark: ImageView? = null
    private var timeStamp: TextView? = null

    constructor(context: Context?) : super(context) {
        initView(context, null)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initView(context, attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView(context, attrs)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        initView(context, attrs)
    }


    private fun initView(context: Context?, attrs: AttributeSet?) {
        LayoutInflater.from(context).inflate(R.layout.chat_item, this, true).also {
            message = it.findViewById(R.id.tvMessage)
            status = it.findViewById(R.id.ll_status)
            checkMark = it.findViewById(R.id.checkMark)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var totalWidth = MeasureSpec.getSize(widthMeasureSpec)
        var totalHeight = MeasureSpec.getSize(heightMeasureSpec)

        if (message == null || status == null || totalWidth <= 0) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
            return
        }

        val messageLayout = message?.layoutParams as LayoutParams
        val statusLayout = status?.layoutParams as LayoutParams

        val availableWidth = totalWidth - paddingLeft - paddingRight
        val availableHeight = totalHeight - paddingTop - paddingBottom

        measureChildWithMargins(message, widthMeasureSpec, 0, heightMeasureSpec, 0)
        measureChildWithMargins(status, widthMeasureSpec, 0, heightMeasureSpec, 0)

        val messageWidth =
            message!!.measuredWidth + messageLayout.leftMargin + messageLayout.rightMargin
        val messageHeight =
            message!!.measuredHeight + messageLayout.topMargin + messageLayout.bottomMargin
        val statusWidth =
            status!!.measuredWidth + statusLayout.leftMargin + statusLayout.rightMargin
        val statusHeight =
            status!!.measuredHeight + statusLayout.topMargin + statusLayout.bottomMargin
        val messageLineCount = message?.lineCount
        val lastLineWidth: Float = if (messageLineCount!! > 0) {
            message!!.layout.getLineWidth(messageLineCount - 1)
        } else {
            0f
        }

        totalWidth = paddingLeft + paddingRight
        totalHeight = paddingTop + paddingBottom

        if (messageLineCount == 1 && (messageWidth + statusWidth <= availableWidth)) {
            totalWidth += messageWidth + statusWidth
            totalHeight += messageHeight
        } else if (messageLineCount > 1 && (lastLineWidth + statusWidth <= availableWidth)) {
            totalWidth += messageWidth
            totalHeight += messageHeight
        } else {
            totalWidth += messageWidth
            totalHeight += messageHeight + statusHeight
        }

        setMeasuredDimension(totalWidth, totalHeight)
        val widthSpec = MeasureSpec.makeMeasureSpec(totalWidth, MeasureSpec.EXACTLY)
        val heightSpec = MeasureSpec.makeMeasureSpec(totalHeight, MeasureSpec.EXACTLY)
        super.onMeasure(widthSpec, heightSpec)
    }

    fun setMessage(msg: String) {
        message?.text = msg
    }

    fun removeCheckMark() {
        checkMark?.visibility = View.GONE
    }
}