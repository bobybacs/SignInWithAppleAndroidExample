package com.example.signinwithappleexample

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_details.*
import io.jsonwebtoken.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val appleId = intent.getStringExtra("apple_id")
        val appleFirstName = intent.getStringExtra("apple_first_name")
        val appleMiddleName = intent.getStringExtra("apple_middle_name")
        val appleLastName = intent.getStringExtra("apple_last_name")
        val appleEmail = intent.getStringExtra("apple_email")
        val appleAccessToken = intent.getStringExtra("apple_access_token")
        val appleIDToken = intent.getStringExtra("apple_id_token")
        val appleRefreshToken = intent.getStringExtra("apple_refresh_token")

        apple_id_textview.text = appleId
        apple_first_name_textview.text = appleFirstName
        apple_middle_name_textview.text = appleMiddleName
        apple_last_name_textview.text = appleLastName
        apple_email_textview.text = appleEmail
        apple_access_token_textview.text = appleAccessToken
        apple_id_token_textview.text = appleIDToken
        apple_refresh_token_textview.text = appleRefreshToken

        /*val claim = JWTUtils.decodeJwt(appleIDToken)
        val issuer = claim.issuer
        Log.i("Issuer: ", issuer ?: "")*/


    }

}
