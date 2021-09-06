package com.Joel.merostationery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.bumptech.glide.Glide
import com.Joel.merostationery.api.ServiceBuilder
import de.hdodenhof.circleimageview.CircleImageView

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)





        val fname: TextView = findViewById(R.id.fname)
        val lname: TextView = findViewById(R.id.lname)
        val phone: TextView = findViewById(R.id.phone)
        val username: TextView = findViewById(R.id.username)
        val img: CircleImageView = findViewById(R.id.profile)


        username.text=  ServiceBuilder.user!!.Username.toString()
        phone.text =  ServiceBuilder.user!!.PhoneNumber.toString()


        if( ServiceBuilder.user!!.Profile=="no-img.jpg"){
            Glide.with(this).load(R.drawable.ic_person).into(img)

        }
        else{

            Glide.with(this).load("${ServiceBuilder.BASE_URL}images/${ ServiceBuilder.user!!.Profile.toString()}").into(img)
        }
    }


}