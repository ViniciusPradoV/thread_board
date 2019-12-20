package course.intermediate.thread_board.thread

import android.os.Parcelable
import course.intermediate.thread_board.comment.Comment
import io.bloco.faker.Faker
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Thread(val title: String,
                  val author: String,
                  val initialPost: String,
                  var posts: MutableList<Comment>) : Parcelable

fun getSampleThread() : MutableList<Thread> {

    val faker = Faker()

    return mutableListOf(
        Thread(
            title = faker.lorem.question(),
            author = faker.name.firstName(),
            initialPost = faker.lorem.paragraph(),
            posts = mutableListOf(
            )
        ),
        Thread(
            title = faker.lorem.question(),
            author = faker.name.firstName(),
            initialPost = faker.lorem.paragraph(),
            posts = mutableListOf(
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                )
            )
        ),
        Thread(
            title = faker.lorem.question(),
            author = faker.name.firstName(),
            initialPost = faker.lorem.paragraph(),
            posts =  mutableListOf(
            )
        ),
        Thread(
            title = faker.lorem.question(),
            author = faker.name.firstName(),
            initialPost = faker.lorem.paragraph(),
            posts = mutableListOf(
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                ),
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                ),
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                ),
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                )
            )
        ), Thread(
            title = faker.lorem.question(),
            author = faker.name.firstName(),
            initialPost = faker.lorem.paragraph(),
            posts = mutableListOf(
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                ),
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                )
            )
        ), Thread(
            title = faker.lorem.question(),
            author = faker.name.firstName(),
            initialPost = faker.lorem.paragraph(),
            posts = mutableListOf(
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                ),
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                ),
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                ),
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                ),
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                )
            )
        ), Thread(
            title = faker.lorem.question(),
            author = faker.name.firstName(),
            initialPost = faker.lorem.paragraph(),
            posts = mutableListOf(
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                ),
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                ),
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                ),
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                ),
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                ),
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                )
            )
        ), Thread(
            title = faker.lorem.question(),
            author = faker.name.firstName(),
            initialPost = faker.lorem.paragraph(),
            posts = mutableListOf(
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                )
            )
        ), Thread(
            title = faker.lorem.question(),
            author = faker.name.firstName(),
            initialPost = faker.lorem.paragraph(),
            posts = mutableListOf(
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                ),
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                ),
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                ),
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                ),
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                ),
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                ),
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                ),
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                ),
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                ),
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                )
            )
        ), Thread(
            title = faker.lorem.question(),
            author = faker.name.firstName(),
            initialPost = faker.lorem.paragraph(),
            posts = mutableListOf(
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                ),
                Comment(
                    author = faker.name.firstName(),
                    body = faker.lorem.paragraph()
                )
            )
        )
    )
}