package course.intermediate.thread_board.comment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import course.intermediate.thread_board.R
import kotlinx.android.synthetic.main.activity_new_comment.*

class NewCommentActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_comment)
    }

    fun saveComment(@Suppress("UNUSED_PARAMETER")v: View) {
        if (comment_author.isBlank() || comment_body.isBlank()) {
            displayErrorMessage("Your comment needs an author and a body")
            return
        }

        // Instantiate the Comment object and getting intent

        val position: Int = intent.getIntExtra("position", -1)

        val author = comment_author.text.toString()
        val body = comment_body.text.toString()
        val intent = Intent()
        intent.apply{
            putExtra("position", position)
            putExtra("author", author)
            putExtra("body", body)
        }
        setResult(RESULT_OK, intent)
        finish()

    }

    private fun displayErrorMessage(message: String) {
        error_message.text = message
        error_message.visibility = View.VISIBLE

    }

    private fun EditText.isBlank() = this.text.toString().isBlank()
}