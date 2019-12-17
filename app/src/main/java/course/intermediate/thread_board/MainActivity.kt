package course.intermediate.thread_board

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import course.intermediate.thread_board.comment.NewCommentActivity
import course.intermediate.thread_board.thread.NewThreadActivity
import course.intermediate.thread_board.thread.Thread
import course.intermediate.thread_board.thread.ThreadsAdapter
import course.intermediate.thread_board.thread.getSampleThread
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = ThreadsAdapter(getSampleThread(), {thread -> threadItemClicked(thread)})

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

    private fun switchActivity(c: Class<*>) {
        val intent = Intent(this, c)
        startActivity(intent)
    }

    private fun threadItemClicked(threadItem : Thread) {
        Toast.makeText(this, "Clicked: ${threadItem.title}", Toast.LENGTH_LONG).show()
        switchActivity(NewCommentActivity::class.java)
    }
}
