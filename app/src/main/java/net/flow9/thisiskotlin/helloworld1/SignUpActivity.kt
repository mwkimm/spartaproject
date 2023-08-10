package net.flow9.thisiskotlin.helloworld1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import net.flow9.thisiskotlin.helloworld1.R.id.btn_signUp

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


//        lateinit을 사용 가능함 실제 사용될때 초기화
//        lateinit var melon
//         val melon bylazy

//        by lazy 상수일때
//        val edt_id by lazy {
//            findViewById(R.id...
//        }


        val signup_edit_id = findViewById<EditText>(R.id.signup_edit_id) //
        val signup_edit_password = findViewById<EditText>(R.id.signup_edit_password) //
        val signup_edit_name = findViewById<EditText>(R.id.signup_edit_name) //


        val btn_signUp = findViewById<Button>(btn_signUp)

        btn_signUp.setOnClickListener {

            val strData = signup_edit_id.text.toString()
            val strDatapassword = signup_edit_password.text.toString()
            val strDataname = signup_edit_name.text.toString()


            if (strData.isEmpty() || strDatapassword.isEmpty() || strDataname.isEmpty()) {
                Toast.makeText(applicationContext, "아이디/비밀번호/이름/ 확인해주세요", Toast.LENGTH_SHORT).show()

            } else {

                val intent = Intent(this, SignInActivity::class.java).apply {
                    putExtra("SignUpActivity_id", strData)
                    putExtra("SignUpActivity_password", strDatapassword)
                    putExtra("SignUpActivity_name", strDataname)

                }

                setResult(RESULT_OK, intent)
                if (!isFinishing) finish()
            }

        }

    }
}

