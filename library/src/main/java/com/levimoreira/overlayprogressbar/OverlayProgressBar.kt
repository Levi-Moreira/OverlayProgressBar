package com.levimoreira.overlayprogressbar

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import android.util.AttributeSet
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.view.LayoutInflater




/**
 * Created by levi on 11/02/18.
 */

class OverlayProgressBar(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : FrameLayout(context, attrs, defStyleAttr, defStyleRes) {

    lateinit var progressBar: ProgressBar
    lateinit var frameLayout: FrameLayout

    var indeterminateTint: Int = 0
    var indeterminateBackground: Drawable?
    var indeterminatePadding: Int = 0
    var indeterminateWidth: Int = 0
    var indeterminateHeight: Int = 0
    var overlayBackgroundColor: Int = 0

    init {
        val attrArray = context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.OverlayProgress,
                0, 0)

        try {
            indeterminateTint = attrArray.getColor(R.styleable.OverlayProgress_indeterminateTint, ResourcesCompat.getColor(resources, R.color.colorAccent, null))
            val indeterminateBackgroundId = attrArray.getResourceId(R.styleable.OverlayProgress_indeterminateBackground, R.drawable.progress_background)

            indeterminateBackground = ResourcesCompat.getDrawable(resources, indeterminateBackgroundId, null)

            indeterminatePadding = attrArray.getDimensionPixelSize(R.styleable.OverlayProgress_indeterminatePadding, 0)
            indeterminateWidth = attrArray.getDimensionPixelSize(R.styleable.OverlayProgress_indeterminateWidth, 0)
            indeterminateHeight = attrArray.getDimensionPixelSize(R.styleable.OverlayProgress_indeterminateHeight, 0)
            overlayBackgroundColor = attrArray.getColor(R.styleable.OverlayProgress_overlayBackgroundColor, ResourcesCompat.getColor(resources, R.color.dark, null))
        } finally {
            attrArray.recycle()
        }
        init()
    }


    constructor(context: Context) : this(context, null, 0, 0) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0, 0) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(context, attrs, defStyleAttr, 0) {
        init()
    }


    private fun init() {
        val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.overlay_progress_layout, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        var avalue: String? = "oi"

        val another : String = avalue as String
        frameLayout = this

        frameLayout.background = ColorDrawable(overlayBackgroundColor)

        progressBar = this.findViewById(R.id.progress)

        progressBar.indeterminateDrawable.setColorFilter(
                indeterminateTint,
                android.graphics.PorterDuff.Mode.SRC_IN)

        progressBar.background = indeterminateBackground

        progressBar.setPadding(indeterminatePadding, indeterminatePadding, indeterminatePadding, indeterminatePadding)

        progressBar.layoutParams = LayoutParams(indeterminateWidth, indeterminateHeight, Gravity.CENTER)

    }

}
