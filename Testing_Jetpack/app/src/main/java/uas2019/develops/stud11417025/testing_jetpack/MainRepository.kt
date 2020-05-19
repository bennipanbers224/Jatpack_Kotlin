package uas2019.develops.stud11417025.testing_jetpack

import io.reactivex.Single

/**
 * Created by test on 5/18/2020.
 */
class MainRepository(private val apiHelper: ApiHelper) {
    fun getDatas() : Single<List<DataModel>>{
        return apiHelper.getData()
    }
}