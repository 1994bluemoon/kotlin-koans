package iii_conventions

import util.TODO


class Invokable{
    var numOfInvocations: Int = 0
        private set
    operator fun invoke(): Invokable {
        numOfInvocations++
        return this
    }

    fun getNumberOfInvocations(): Int {
        return this.numOfInvocations
    }
}

fun todoTask31(): Nothing = TODO(
    """
        Task 31.
        Change the class 'Invokable' to count the number of invocations:
        for 'invokable()()()()' it should be 4.
    """,
    references = { invokable: Invokable -> })

fun task31(invokable: Invokable): Int {
    //todoTask31()
    return invokable()()()().getNumberOfInvocations()
}
