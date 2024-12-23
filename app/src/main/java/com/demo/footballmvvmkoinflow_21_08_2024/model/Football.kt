package com.demo.footballmvvmkoinflow_21_08_2024.model

data class Football(var competitions:List<Competitions>)

data class Competitions(var area:Area,var name:String,var id:Int)

data class Area(var flag:String)

