package net.flow9.thisiskotlin.helloworld1

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts


class SignInActivity : AppCompatActivity() {
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)


        val btn_login = findViewById<Button>(R.id.btn_login)
        val btn_signup = findViewById<Button>(R.id.btn_signup)

        val signin_edit_id = findViewById<EditText>(R.id.signin_edit_id)
        val signin_edit_password = findViewById<EditText>(R.id.signin_edit_pw)


        activityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    val user_id = it.data?.getStringExtra("SignUpActivity_id") ?: ""
                    val user_pw = it.data?.getStringExtra("SignUpActivity_password") ?: ""
                    val user_name = it.data?.getStringExtra("SignUpActivity_name") ?: ""
                    signin_edit_id.setText(user_id)
                    signin_edit_password.setText(user_pw)
                    //signin_edit_id.setText("${user_id}${user_name}")
                }
            }

        btn_login.setOnClickListener {

            val strDataid = signin_edit_id.text.toString()
            val strDatapassword = signin_edit_password.text.toString()

            if (strDataid.isEmpty() || strDatapassword.isEmpty()) {
                Toast.makeText(applicationContext, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {

                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("SignInActivity_id", strDataid)

                Toast.makeText(applicationContext, "로그인 되었습니다.", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }

        }


        btn_signup.setOnClickListener {

            val signup_edit_id = intent.getStringExtra("SignUpActivity_id")
            val signup_edit_id_Text = findViewById<EditText>(R.id.signin_edit_id)

            signup_edit_id_Text.setText(signup_edit_id)

            val intent = Intent(this, SignUpActivity::class.java)

            Toast.makeText(applicationContext, "회원가입 페이지로 이동합니다.", Toast.LENGTH_SHORT).show()

            activityResultLauncher.launch(intent)
            //
        }
    }
}


