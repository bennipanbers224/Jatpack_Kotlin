package uas2019.develops.stud11417025.testing_jetpack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class Detail_Data : AppCompatActivity() {
    lateinit var thumbnail : ImageView
    lateinit var caption : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail__data)

        thumbnail = findViewById(R.id.thumbnail)
        caption = findViewById(R.id.caption)

        val get = getIntent()
        caption.text = get.getStringExtra("caption")
        Picasso.with(applicationContext).load(get.getStringExtra("image")).into(thumbnail)

    }
}
