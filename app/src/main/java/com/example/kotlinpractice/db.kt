package com.example.kotlinpractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class db : AppCompatActivity() {

    var firestore : FirebaseFirestore? = null

    //firestore : 게시글 내용, 사진 위치, timestamp 등
    //firestorage : 문서, 이미지, 파일, 영상 등

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_db)
        firestore = FirebaseFirestore.getInstance()
        println("시작")
        createData()
        //addSnapshotDocument()
        //deleteData()
    }

    data class UserDTO(var name : String? = null, var address: String? = null)

    fun createData(){
        var userDTO = UserDTO("이름","주소")
        firestore?.collection("User")?.document("document1")?.set(userDTO)
    }

    fun readData(){
        firestore?.collection("User")?.document("document1")?.get()?.addOnCompleteListener{ //pull driven, controller에 따라 화면갱신
                task ->
            if(task.isSuccessful)
            {
                var userDTO = task.result?.toObject(UserDTO :: class.java)
                println(userDTO.toString())
            }
        }
    }

    fun addSnapshotDocument(){
        firestore?.collection("User")?.document("document1")?.addSnapshotListener{ //push driven, db 변경시마다 ui변경
                documentSnapshot, firebaseFirestoreException ->
            var document = documentSnapshot?.toObject(UserDTO::class.java)
            println(document.toString())
        }
    }

    fun updateData(){
        var map = mutableMapOf<String,Any>()
        map["phone"] = "010-1234-5678"
        firestore?.collection("User")?.document("document1")?.update(map)
    }

    fun deleteData(){
        firestore?.collection("User")?.document("document1")?.delete()
    }
}


