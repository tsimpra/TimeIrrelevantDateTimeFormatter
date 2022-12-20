import java.time.LocalDateTime
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField

fun main(args: Array<String>) {
    val date = "2022-12-20T05:18"
    val date2 = "2022-12-20"

    val format2 = DateTimeFormatterBuilder()
        .parseCaseSensitive()
        .appendValue(ChronoField.YEAR,4)
        .appendLiteral('-')
        .appendValue(ChronoField.MONTH_OF_YEAR,2)
        .appendLiteral('-')
        .appendValue(ChronoField.DAY_OF_MONTH,2)
        .optionalStart()
        .appendLiteral('T')
        .appendValue(ChronoField.HOUR_OF_DAY,2)
        .appendLiteral(':')
        .appendValue(ChronoField.MINUTE_OF_HOUR,2)
        .optionalEnd()
        .parseDefaulting(ChronoField.HOUR_OF_DAY,0)
        .parseDefaulting(ChronoField.MINUTE_OF_HOUR,0)
        .toFormatter()

    LocalDateTime.parse(date, format2).apply { println(this) }
    LocalDateTime.parse(date2, format2).apply { println(this) }
}