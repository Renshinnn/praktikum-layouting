package www.smktelkommlg.sch.id

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val name: String?,
    val email: String?,
    val city: String?,
    val age: Int?
):Parcelable