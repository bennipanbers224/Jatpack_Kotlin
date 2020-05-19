package uas2019.develops.stud11417025.testing_jetpack

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by test on 5/18/2020.
 */
class DataModel {
    @SerializedName("caption")
    @Expose
    val caption : String?=""
    @SerializedName("thumbnail")
    @Expose
    val thumbnail : String? =""
    @SerializedName("image")
    @Expose
    val image : String? = ""
}