package uas2019.develops.stud11417025.testing_jetpack

/**
 * Created by test on 5/18/2020.
 */
class ApiHelper(private val apiService: ApiService) {
    fun getData()  = apiService.getData()
}