package com.example.multilingualapplication

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import com.example.multilingualapplication.databinding.CustomEditTextBinding
import com.google.android.material.card.MaterialCardView

class CustomEditText(context: Context, attrs: AttributeSet) : MaterialCardView(context, attrs) {

    val mBinding: CustomEditTextBinding =
        CustomEditTextBinding.inflate(LayoutInflater.from(context), this, true)

    var textColor: Int = R.color.black
        set(value) {
            field = value
            mBinding.editText.setTextColor(ContextCompat.getColor(context, textColor))
        }
    var hintText: String = ""
        set(value) {
            field = value
            mBinding.editText.hint = value
        }
    var inputType: Int = 0
        set(value) {
            field = value
            mBinding.editText.inputType = value
        }
    var maxlines: Int = 0
        set(value) {
            field = value
            mBinding.editText.maxLines = value
        }

    var editTextStyle: Int = 0
        set(value) {
            field = value
            mBinding.editText.setTextAppearance(value)
        }


    init {
        val styledAttributes =
            context.obtainStyledAttributes(attrs, R.styleable.CustomEditText)

        textColor = styledAttributes.getResourceId(R.styleable.CustomEditText_textColor, R.color.black)
        val backgroundTint = styledAttributes.getResourceId(R.styleable.CustomEditText_android_backgroundTint, R.color.black)
        val textColorHint = styledAttributes.getResourceId(R.styleable.CustomEditText_android_textColorHint, R.color.black)
        hintText = styledAttributes.getString(R.styleable.CustomEditText_android_hint).toString()
        inputType = styledAttributes.getInteger(R.styleable.CustomEditText_android_inputType,0)
        maxlines = styledAttributes.getInteger(R.styleable.CustomEditText_android_maxLines,0)
        editTextStyle = styledAttributes.getResourceId(R.styleable.CustomEditText_myStyle,0)

        mBinding.apply {
            editText.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, backgroundTint))
            editText.setHintTextColor(ColorStateList.valueOf(ContextCompat.getColor(context, textColorHint)))
        }
    }
}