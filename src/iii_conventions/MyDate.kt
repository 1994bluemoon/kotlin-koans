package iii_conventions

import java.util.*
import java.util.function.Consumer

data class MyDate (val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        return when {
            year != other.year -> year - other.year
            month != other.month -> month - other.month
            else -> dayOfMonth - other.dayOfMonth
        }
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterable<MyDate>{
    override fun iterator(): Iterator<MyDate> {
        return DateIterator(this)
    }

    override operator fun contains(d: MyDate): Boolean {
        return d >= start && d <= endInclusive
    }
}


class DateIterator(val dateRange: DateRange) : Iterator<MyDate>{
    var current: MyDate = dateRange.start

    override fun hasNext(): Boolean = current <= dateRange.endInclusive

    override fun next(): MyDate {
        val result = current
        current = current.nextDay()
        return result
    }

}
