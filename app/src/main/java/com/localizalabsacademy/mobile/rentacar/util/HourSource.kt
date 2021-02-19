package com.localizalabsacademy.mobile.rentacar.util

import java.util.*

object HourSource {
    private val _scheduleHourSource = mutableListOf<Date>()
    private val scheduleHourSource: List<Date>
        get() = _scheduleHourSource

    fun getTime(): Long = Date().time

    fun convertToDate(time: Long): Date = Date(time)


    fun getHours(date: Date): List<Date> {
        // Get the current time
        val calendar = Calendar.getInstance()
//        val timeFormatter = SimpleDateFormat("HH:mm")
        val currentHour = roundToNextWholeHour(date)
        val theEndOfTheDay = theEndOfTheDay(currentHour)

        var time: Date = currentHour

        while (time.before(theEndOfTheDay)) {
            time = nextSchedule(time)
            _scheduleHourSource.add(time)
        }

        return scheduleHourSource
    }

    private fun roundToNextWholeHour(date: Date): Date {
        val c: Calendar = GregorianCalendar()
        c.apply {
            time = date

            when {
                c.get(Calendar.MINUTE) >= 30 -> {
                    add(Calendar.MINUTE, 30)
                    set(Calendar.MINUTE, 0)
                    set(Calendar.SECOND, 0)
                }
                else -> {
                    add(Calendar.HOUR, 1)
                    set(Calendar.MINUTE, 0)
                    set(Calendar.SECOND, 0)
                }
            }
        }
        return c.time
    }

    private fun nextSchedule(date: Date): Date {
        val c: Calendar = GregorianCalendar()
        c.time = date
        c.add(Calendar.MINUTE, 30)
        c.set(Calendar.SECOND, 0)

        return c.time
    }

    private fun theEndOfTheDay(date: Date): Date {
        val c: Calendar = GregorianCalendar()
        c.time = date
        c.apply {
            set(Calendar.HOUR_OF_DAY, 23)
            set(Calendar.MINUTE, 30)
            set(Calendar.SECOND, 0)
        }

        return c.time
    }
}