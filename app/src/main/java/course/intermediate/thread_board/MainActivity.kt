package course.intermediate.thread_board

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import course.intermediate.thread_board.comment.Comment
import course.intermediate.thread_board.comment.NewCommentActivity
import course.intermediate.thread_board.thread.NewThreadActivity
import course.intermediate.thread_board.thread.Thread
import course.intermediate.thread_board.thread.ThreadsAdapter
import course.intermediate.thread_board.thread.getSampleThread
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val commentRequestCode = 0
    private val threadRequestCode = 1

    private lateinit var threadList : MutableList<Thread>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        threadList = if(savedInstanceState != null) {
            Log.d("savedInstanceState", "SavedInstanceState: $savedInstanceState")
            val threadArrayList =
                savedInstanceState.getParcelableArrayList<Parcelable>("threadList")
            Log.d("savedInstanceState", "Bundle: $threadArrayList")
            threadArrayList?.filterIsInstance<Thread>()!!.toMutableList()
        } else{
            getSampleThread()
        }
        setContentView(R.layout.activity_main)
        rv.layoutManager = LinearLayoutManager(this)
        Log.d("savedInstanceState", "Adapter: $threadList")
        rv.adapter = ThreadsAdapter(threadList) {position -> threadItemClicked(position)}

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.new_thread){
            val intent = Intent(this, NewThreadActivity::class.java)
            startActivityForResult(intent,threadRequestCode)
        }

        return true

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == commentRequestCode &&
            resultCode == Activity.RESULT_OK &&
            data != null){
            val author = data.getStringExtra("author")
            val body = data.getStringExtra("body")
            val position = data.getIntExtra("position", -1)

            threadList[position].posts.add(Comment(author,body))
            rv.adapter?.notifyDataSetChanged()

            Log.d("POSTS", "IF POSTS != NULL")
            Log.d("POSTS", "SIZE ${threadList[position].posts.size}")

        }
        if(requestCode == threadRequestCode &&
            resultCode == Activity.RESULT_OK &&
            data != null){
            val title = data.getStringExtra("title")
            val initialPost = data.getStringExtra("initialPost")
            val author = data.getStringExtra("author")

            threadList.add(Thread(title,author, initialPost, mutableListOf()))
            rv.adapter?.notifyItemInserted(threadList.size)


        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList("threadList", ArrayList<Parcelable>(threadList))
        Log.d("savedInstanceState", "OutState: $outState")
    }

    private fun threadItemClicked(position: Int) {
        val intent = Intent(this, NewCommentActivity::class.java)
        intent.putExtra("position", position)
        startActivityForResult(intent,commentRequestCode)
    }


}
