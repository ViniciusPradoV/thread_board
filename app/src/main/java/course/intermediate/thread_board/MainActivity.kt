package course.intermediate.thread_board

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import course.intermediate.thread_board.comment.Comment
import course.intermediate.thread_board.comment.NewCommentActivity
import course.intermediate.thread_board.thread.NewThreadActivity
import course.intermediate.thread_board.thread.ThreadsAdapter
import course.intermediate.thread_board.thread.getSampleThread
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    private val COMMENT_REQUEST_CODE = 0

    var threadList = getSampleThread()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState != null) {
           savedInstanceState.getParcelable<Parcelable>("threadList")
        }
        setContentView(R.layout.activity_main)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = ThreadsAdapter(threadList) {position -> threadItemClicked(position)}

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.new_thread){
            switchActivity(NewThreadActivity::class.java)
        }

        return true

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == COMMENT_REQUEST_CODE &&
            resultCode == Activity.RESULT_OK &&
            data != null){
            val author = data.getStringExtra("author")
            val body = data.getStringExtra("body")
            val position = data.getIntExtra("position", -1)

            threadList[position].posts?.add(Comment(author,body))
        }
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

    private fun switchActivity(c: Class<*>) {
        val intent = Intent(this, c)
        startActivity(intent)
    }

    private fun threadItemClicked(position: Int) {
        val intent = Intent(this, NewCommentActivity::class.java)
        Toast.makeText(this, "Clicked: ${position}", Toast.LENGTH_LONG).show()
        intent.putExtra("position", position)
        startActivityForResult(intent,COMMENT_REQUEST_CODE)
    }


}
