package uas2019.develops.stud11417025.testing_jetpack

import io.reactivex.Single

/**
 * Created by test on 5/18/2020.
 */
interface ApiService {
    fun getData() : Single<List<DataModel>>
}