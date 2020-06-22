package com.example.flashnotenote

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flashnotenote.database.AppDataBase
import com.example.flashnotenote.database.EntityNote
import com.example.flashnotenote.database.NoteDaoImpl
import com.example.flashnotenote.database.NoteDataSourceImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val context : Context) : ViewModel() {
    private lateinit var appDatabase: AppDataBase
    private lateinit var noteDataSourceImpl: NoteDataSourceImpl
    private var compositeDisposable = CompositeDisposable()
    val listNotesLiveData = MutableLiveData<List<EntityNote>>()

    fun getListSave(){
        appDatabase = AppDataBase.getInstance(context)
        noteDataSourceImpl = NoteDataSourceImpl.newInstance(NoteDaoImpl.getInstance(appDatabase.noteDao()))
        val disposable: Disposable = noteDataSourceImpl.getAllNote()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                listNotesLiveData.value = it
            },  {  })
        compositeDisposable.add(disposable)
    }
}