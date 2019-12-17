package course.intermediate.thread_board.comment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import course.intermediate.thread_board.R
import kotlinx.android.synthetic.main.activity_new_comment.*

class NewCommentActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_comment)
    }

    fun saveComment(v: View) {
        if (comment_author.isBlank() || comment_body.isBlank()) {
            displayErrorMessage("Your comment needs an author and a body")
            return
        }

        // Instantiate the Comment object and getting intent

        val position: Int = intent.getIntExtra("position", -1)

        val author = comment_author.text.toString()
        val body = comment_body.text.toString()
        Toast.makeText(this, "Author: ${author}", Toast.LENGTH_LONG).show()
        Toast.makeText(this, "Body: ${body}", Toast.LENGTH_LONG).show()
        val intent = Intent()
        intent.putExtra("author", author)
        intent.putExtra("body", body)
        intent.putExtra("position", position)
        setResult(RESULT_OK, intent)
        finish()

    }

    private fun displayErrorMessage(message: String) {
        error_message.text = message
        error_message.visibility = View.VISIBLE

    }

    private fun EditText.isBlank() = this.text.toString().isBlank()
}