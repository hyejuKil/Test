package com.example.kotlinpractice

import android.app.backup.BackupAgent

fun main(){
//    helloWorld()
//
//    println(add(4,5))
//
//    val name = "kil"
//    println("my name is ${name}")
//    println("2\$a")
//    forAndWhile()
//    nullcheck()

    val human = Human("Minsu")
    human.eating()
    println("${human.name}")

    val human2 = Human("hah",13)
}

//3일차

open class Human (name : String = "Annonymous") { //생성자 사용시, 주 생성자인듯

    constructor(name : String, age: Int) : this(name) // 부 생성자, 주 생성자의 위임(this), 주생성자 만들어진 다음 실행
    {
        println("my name is ${name}, age is ${age}")
    }

    init { //블럭단위 생성자
        println("wow!")
    }
    val name :String = name
    open fun eating(){
        println("Cake!")
    }
}

class Korean : Human(){ //같은 파일 내 있더라도 class가 final이므로 접근불가, 부모 open 필요
    override fun eating(){
        super.eating()
        println(" eating!" )
    }
}





//2일차

//array,list,mutablelist
fun array(){
    val array : Array<Int> = arrayOf(1,2,3)
    val list : List<Int> = listOf(1,2,3)

    val array2: Array<Any> = arrayOf(1,"string")

    //array -> mutable (값 수정 가능)
    //list -> 값 수정 불가, get만 가능.


    //arraylist : mutable list (값 수정 가능)
    val arrayList : ArrayList<Int> = arrayListOf<Int>()
    //val인 이유 : 주소값은 변하지 않으므로.
}

//for, while
fun forAndWhile(){
    val students : ArrayList<Int> = arrayListOf(1,2,3,4,5)

    for(su in students){
        println("${su}")
    }

    var sum :Int = 0
    for (i in 1..10){
        sum+=i
    }
    println(sum)

    sum =0
    for(i in 10 downTo 1) {
        sum += i
    }
    println(sum)

    sum =0
    for(i in 1 until 10){
        sum += i
    }
    println("${sum}")

    for ((index, name) in students.withIndex()){
        println("${index+1}번째 학생 : ${name}")
    }
}


//Nullable/ NonNull
fun nullcheck(){
    var name  = "joyce" //nonNull
    var nullName : String? = null //타입 생략 불가
    var nameInUpperCase = name.uppercase()
    var nullNameUpperCase = name?.uppercase() //null이면 null 반환, 아니면 upeercase 실행

    // ?:  -> 디폴트를 주고싶을 때
    val lastname : String? = null
    val fullname = name+" "+(lastname?:"No lastName") //null이면 뒤의값 디폴트로
    print(fullname)

    // !!  -> null이 아닌것을 보증

}

fun ignoreNull(str : String?){
    var str1 : String = str!! //확실히 str이 null이 아닐 때 사용, null exception 부를 수 있으므로 주의의
}

//1차
//
//fun helloWorld(){
//    println("Hello World!")
//    var e : Int
//    val a = 10
//    var b = 10
//}
//
//fun add(a : Int, b: Int) : Int{
//    return a+b
//}
//
//fun max(a:Int, b:Int) : Int{
//    if (a >b )
//        return a
//    else
//        return b
//}
//
//fun max2(a: Int, b:Int) : Int = if(a>b) a else b
//
//fun checkNum(score : Int)
//{
//    when(score) //swich
//    {
//        0 -> println("1")
//    }
//
//    var b : Int = when(score) //else 필수
//    {
//        1-> 1
//        2-> 2
//        else -> 3
//    }
//
//    var c : Int = when(score){
//        in 90..100 -> 1
//        in 10..80 -> 2
//        else -> 3
//    }
//
//
//}

