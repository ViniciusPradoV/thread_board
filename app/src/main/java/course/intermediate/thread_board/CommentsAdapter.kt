package course.intermediate.thread_board

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.comment_view.view.*

class CommentsAdapter(val comments: MutableList<Comment>) : RecyclerView.Adapter<CommentsAdapter.CommentViewHolder>() {

    class CommentViewHolder(val commentView : View) : RecyclerView.ViewHolder(commentView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_view, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {

        val comment = comments[position]
        holder.commentView.tv_postAuthor.text = comment.author
        holder.commentView.tv_postBody.text = comment.body
    }

    override fun getItemCount(): Int = comments.size
}