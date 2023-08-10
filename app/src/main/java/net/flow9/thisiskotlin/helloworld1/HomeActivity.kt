package net.flow9.thisiskotlin.helloworld1

import android.annotation.SuppressLint
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import net.flow9.thisiskotlin.helloworld1.R.id.btn_close
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val signin_edit_id =
            intent.getStringExtra("SignInActivity_id")
                val textView = findViewById<TextView>(R.id.home_txt_id)
                textView.setText("아이디 :${signin_edit_id}")


        val imgView = findViewById<ImageView>(R.id.img_favorite1)
        val randomImgArr: Array<Int> = arrayOf(R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5)
        val num: Int = Random.nextInt(5)

        imgView.background = ShapeDrawable(OvalShape())


        if(Build.VERSION.SDK_INT >= 21){
            imgView.clipToOutline = true
        }

        imgView.setImageResource(randomImgArr[num])


        val btn_close = findViewById<Button>(btn_close)
            btn_close.setOnClickListener {
                Toast.makeText(applicationContext, "종료되었습니다.", Toast.LENGTH_SHORT).show()
                finish()

            }

//        val iv_logo = findViewById<ImageView>(R.id.iv_home_logo)

        val id = when((1..6).random()) {
            1 -> R.drawable.img1
            2 -> R.drawable.img2
            3 -> R.drawable.img3
            4 -> R.drawable.img4
            5-> R.drawable.img5
            else -> R.drawable.img1
        }

//        iv_logo.setImageDrawable(ResourcesCompat.getDrawable(resources, id, null))
        }
    }


//