package course.intermediate.thread_board

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.thread_view.view.*

class ThreadsAdapter(val threads: MutableList<Thread>) : RecyclerView.Adapter<ThreadsAdapter.ThreadViewHolder>() {

    class ThreadViewHolder(val threadView: View): RecyclerView.ViewHolder(threadView)

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThreadViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.thread_view, parent, false)
        return ThreadViewHolder(view)
    }

    override fun onBindViewHolder(holder: ThreadViewHolder, position: Int) {

      val thread = threads[position]
      holder.threadView.tv_threadTitle.text = thread.title
      holder.threadView.tv_initialPost.text = thread.initialPost
      holder.threadView.tv_threadAuthor.text = "By: ${thread.author}"
      val commentLayoutManager = LinearLayoutManager(holder.threadView.rv_comment.context, RecyclerView.VERTICAL , false)

        holder.threadView.rv_comment.apply{
            layoutManager = commentLayoutManager
            adapter = CommentsAdapter(thread.posts)
            setRecycledViewPool(viewPool)
        }
    }

    override fun getItemCount(): Int = threads.size
}