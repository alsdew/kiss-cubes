package com.kisscubes

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val colorW = "#E49CE7"
    val colorM = "#99D9EA"

    var variants: MutableList<String> = ArrayList()

    var phraseField: TextView? = null
    var turnW: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize();
    }

    fun initialize() {
        phraseField = findViewById(R.id.phraseField)
        val actions = resources.getStringArray(R.array.actions)
        val parts = resources.getStringArray(R.array.parts)
        val added = resources.getStringArray(R.array.addedPhrases)
        for (a in actions) {
            for (p in parts) {
                variants.add("$a\n$p")
            }
        }
        for (a in added) {
            variants.add(a)
        }
    }

    fun next(view: View) {
        phraseField?.text = variants.random()
        phraseField?.setTextColor(Color.parseColor(if (turnW) colorW else colorM))
        turnW = !turnW
    }
}