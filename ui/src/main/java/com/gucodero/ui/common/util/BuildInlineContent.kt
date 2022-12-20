package com.gucodero.ui.common.util

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.material.Icon
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.unit.TextUnit

inline fun buildInlineContent(content: BuilderInlineContent.() -> Unit): Map<String, InlineTextContent> {
    return BuilderInlineContent().apply(content).map
}

class BuilderInlineContent{

    val map = mutableMapOf<String, InlineTextContent>()

    fun add(
        tag: String,
        fontSize: TextUnit,
        @DrawableRes icon: Int,
        onClick: (() -> Unit)? = null,
        placeholderVerticalAlign: PlaceholderVerticalAlign = PlaceholderVerticalAlign.Center,
        color: Color = Color.Unspecified
    ){
        map[tag] = InlineTextContent(
            placeholder = Placeholder(
                width = fontSize,
                height = fontSize,
                placeholderVerticalAlign = placeholderVerticalAlign
            )
        ) {
            Icon(
                painter = painterResource(
                    id = icon
                ),
                contentDescription = null,
                modifier = Modifier.let {
                    if(onClick != null){
                        it.clickable(
                            onClick = onClick,
                            indication = rememberRipple(
                                bounded = false
                            ),
                            interactionSource = remember { MutableInteractionSource() }
                        )
                    }else{
                        it
                    }
                },
                tint = color
            )
        }
    }

}