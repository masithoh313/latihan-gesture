package com.example.gestureimageview

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.PopupMenu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView_gesture.setOnClickListener() {
            val popupMenu = PopupMenu(this, `it`)
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.menu_share -> {
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.facebook.com")
                        )
                        startActivity(intent)
                        true

                    }
                    R.id.menu_info -> {
                        Toast.makeText(this, "Ada Toast!", Toast.LENGTH_LONG).show()
                        true
                    }
                    else -> false
                } //as Boolean //as Boolean;return@setOnMenuItemClickListener {}
            }
            popupMenu.inflate(R.menu.menu)
            try {
                val fieldMPopupMenu = PopupMenu::class.java.getDeclaredField("mPopup")
                fieldMPopupMenu.isAccessible = true
                val mPopupMenu = fieldMPopupMenu.get(popupMenu)
                mPopupMenu.javaClass
                    .getDeclaredMethod("set Force show Icon", Boolean::class.java)
                    .invoke(mPopupMenu, true)
            } catch (e: Exception) {
                Log.e("Main", "error showing menu icons.", e)
            } finally {
                popupMenu.show()
            }
            true
        }
    }
}


