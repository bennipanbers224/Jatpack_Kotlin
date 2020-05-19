package uas2019.develops.stud11417025.testing_jetpack

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by test on 5/18/2020.
 */
class MainViewModel(private val mainRepository: MainRepository):ViewModel() {
    private val datas = MutableLiveData<Resource<List<DataModel>>>()
    private val compositeDisposible = CompositeDisposable()

    init {
        fetchData()
    }

    private fun fetchData() {
        datas.postValue(Resource.loading(null))
        compositeDisposible.add(
                mainRepository.getDatas()
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .subscribe({dataList->
                            datas.postValue(Resource.success(dataList))

                        },{throwable ->
                            datas.postValue(Resource.error(throwable.message!!, null))
                            Log.d("Error : ",throwable.message)
                        })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposible.dispose()
    }

    fun getDatas():LiveData<Resource<List<DataModel>>>{
        return datas
    }
}