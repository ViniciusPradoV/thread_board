package course.intermediate.thread_board.comment

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Comment(val author: String,
                   val body : String): Parcelable