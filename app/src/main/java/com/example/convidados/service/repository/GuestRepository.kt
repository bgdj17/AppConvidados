package com.example.convidados.service.repository

import android.content.Context
import com.example.convidados.service.model.GuestModel

class GuestRepository private constructor(context: Context){

    //Singletoon
    private var mGuestDataBaseHelpre: GuestDataBaseHelpre = GuestDataBaseHelpre(context)

    companion object{
        private lateinit var repository: GuestRepository
        fun getInstance(context: Context): GuestRepository{
            if(!::repository.isInitialized){
                repository = GuestRepository(context)
            }
            return GuestRepository(context)
        }
    }

    //Singletoon

    fun getAll(): List<GuestModel>{
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }
    fun getPresent(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }
    fun getAbsent(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun save(guest: GuestModel){
        mGuestDataBaseHelpre.writableDatabase

    }
    fun update(guest: GuestModel){

    }
    fun delete(guest: GuestModel){

    }

}