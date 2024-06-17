package site.ylan.k14_highother.model.bean

import android.os.Parcel
import android.os.Parcelable

class PersonParcelable() : Parcelable {

    var name = ""
    var age = 0
    
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name) // 写出name
        parcel.writeInt(age)     // 写出age
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PersonParcelable> {
        override fun createFromParcel(parcel: Parcel): PersonParcelable {
            val person = PersonParcelable()
            person.name = parcel.readString() ?: "" // 读取name
            person.age = parcel.readInt()           // 读取age
            return person
        }

        override fun newArray(size: Int): Array<PersonParcelable?> {
            return arrayOfNulls(size)
        }
    }
}