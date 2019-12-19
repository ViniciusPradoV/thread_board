package course.intermediate.thread_board.thread

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import course.intermediate.thread_board.comment.CommentsAdapter
import course.intermediate.thread_board.R
import kotlinx.android.synthetic.main.thread_view.view.*

class ThreadsAdapter(private val threads: MutableList<Thread>, private val clickListener : (position: Int) -> Unit) : RecyclerView.Adapter<ThreadsAdapter.ThreadViewHolder>() {

    class ThreadViewHolder(val threadView: View): RecyclerView.ViewHolder(threadView){
        fun bind(position: Int, clickListener: (position : Int) -> Unit){
            threadView.btn_reply.setOnClickListener{clickListener(position)}
        }
    }

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThreadViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.thread_view, parent, false)
        return ThreadViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: ThreadViewHolder, position: Int) {
      val thread = threads[position]
        holder.bind(position, clickListener)
      holder.threadView.tv_threadTitle.text = thread.title
      holder.threadView.tv_initialPost.text = thread.initialPost
      holder.threadView.tv_threadAuthor.text = "By: ${thread.author}"
      val commentLayoutManager = LinearLayoutManager(holder.threadView.rv_comment.context, RecyclerView.VERTICAL , false)

        holder.threadView.rv_comment.apply{
            layoutManager = commentLayoutManager
            adapter =
                CommentsAdapter(thread.posts)
            setRecycledViewPool(viewPool)
        }
    }

    override fun getItemCount(): Int = threads.size
}