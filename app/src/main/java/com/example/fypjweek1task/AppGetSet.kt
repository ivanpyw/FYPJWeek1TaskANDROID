package com.example.fypjweek1task

import android.app.Application

class AppGetSet : Application() {
    var Course_Name:String=""
    var Course_Code:String=""
    var Course_Description:String=""
    var Course_DateStart:String=""
    var Course_DateEnd:String=""
    var Course_classSize:String=""

    fun get_Course_Name():String{
        return Course_Name
    }

    fun set_Course_Name(CourseName:String){
        this.Course_Name = CourseName
    }

    fun get_Course_Code():String{
        return Course_Code
    }

    fun set_Course_Code(CourseCode:String){
        this.Course_Code = CourseCode
    }

    fun get_Course_Description():String{
        return Course_Description
    }

    fun set_Course_Description(CourseDescription:String){
        this.Course_Description = CourseDescription
    }

    fun get_Course_DateStart():String{
        return Course_DateStart
    }

    fun set_Course_DateStart(CourseDateStart:String){
        this.Course_DateStart = CourseDateStart
    }

    fun get_Course_DateEnd():String{
        return Course_DateEnd
    }

    fun set_Course_DateEnd(CourseDateEnd:String){
        this.Course_DateEnd = CourseDateEnd
    }

    fun get_Course_classSize():String{
        return Course_classSize
    }

    fun set_Course_classSize(CourseClassSize:String){
        this.Course_classSize = CourseClassSize
    }



}