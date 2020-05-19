package uas2019.develops.stud11417025.testing_jetpack

import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single

/**
 * Created by test on 5/18/2020.
 */
class ApiServiceImpl : ApiService {
    override fun getData(): Single<List<DataModel>> {

        return Rx2AndroidNetworking.get("https://info-malang-batu.firebaseapp.com/Gallery_Malang_Batu.json")
                .build()
                .getObjectListSingle(DataModel::class.java)
    }

}