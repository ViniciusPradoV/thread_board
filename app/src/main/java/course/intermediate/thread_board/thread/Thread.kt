package course.intermediate.thread_board.thread

import course.intermediate.thread_board.comment.Comment

data class Thread(val title: String, val author: String, val initialPost: String, var posts: MutableList<Comment>?)

fun getSampleThread() : MutableList<Thread> {
    return mutableListOf(
        Thread(
            title = "First post!",
            author = "Carlos",
            initialPost = "This is the first post ever",
            posts = mutableListOf(
                Comment(
                    author = "Joao",
                    body = "Nice thread!"
                ),
                Comment(
                    author = "Silvia",
                    body = "Awesome thread!"
                )
            )
        ),
        Thread(
            title = "Post!",
            author = "Carbos",
            initialPost = "This is the second post ever",
            posts = mutableListOf(
                Comment(
                    author = "Carla",
                    body = "Nice thread!"
                )
            )
        ),
        Thread(
            title = "Third post!",
            author = "Carlod",
            initialPost = "This is the second post ever",
            posts = null /*mutableListOf(
                Comment(author = "Patricia",
                    body = "Nice thread!"
                )
            )*/
        )
    )
}