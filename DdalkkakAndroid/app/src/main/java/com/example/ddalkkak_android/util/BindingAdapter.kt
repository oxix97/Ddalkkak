package com.example.ddalkkak_android.util

import android.content.Intent
import android.net.Uri
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.ddalkkak_android.R
import com.example.ddalkkak_android.ui.activity.LinkInfoActivity

@BindingAdapter("imgUrl")
fun setImageUrl(view: ImageView, url: String?) {
    if (url != null) {
        Glide.with(view.context)
            .load(url)
            .error(R.drawable.ic_launcher_foreground)
            .override(320,260)
            .into(view)
    } else {
        Glide.with(view.context)
            .load(R.drawable.kernel360)
            .override(320,260)
            .into(view)
    }
}

@BindingAdapter("urlClickListener")
fun setUrlClickListener(view: ConstraintLayout, url: String?) {
    if (url != null) {
        view.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(view.context, intent, null)
        }
    }
}

@BindingAdapter("userItemClickListener")
fun setUserItemClickListener(view: ConstraintLayout, user: String) {
    view.setOnClickListener {
        val intent = Intent(view.context, LinkInfoActivity::class.java)
        intent.putExtra("user", user)
        view.context.startActivity(intent)
    }
}
