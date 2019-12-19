package course.intermediate.thread_board.thread

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import course.intermediate.thread_board.R
import kotlinx.android.synthetic.main.activity_new_comment.error_message
import kotlinx.android.synthetic.main.activity_new_thread.*

class NewThreadActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_thread)
    }

    fun saveThread(@Suppress("UNUSED_PARAMETER")v: View) {
        if (thread_author.isBlank() || thread_title.isBlank() || thread_post.isBlank()) {
            displayErrorMessage("Your threads needs a title, initial post and an author")
            return
        }

        val author = thread_author.text.toString()
        val initialPost = thread_post.text.toString()
        val title = thread_title.text.toString()
        Toast.makeText(this, "Author: $author", Toast.LENGTH_LONG).show()
        Toast.makeText(this, "Body: $initialPost", Toast.LENGTH_LONG).show()
        Toast.makeText(this, "Body: $title", Toast.LENGTH_LONG).show()
        val intent = Intent()
        intent.apply{
            putExtra("author", author)
            putExtra("initialPost", initialPost)
            putExtra("title", title)
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