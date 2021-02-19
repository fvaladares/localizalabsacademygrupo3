package com.localizalabsacademy.mobile.rentacar.util

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

object HourSource {
    private val _scheduleHourSource = mutableListOf<Date>()
    private val scheduleHourSource: List<Date>
        get() = _scheduleHourSource

    fun getTime(): Long = Date().time

    fun convertToDate(time: Long): Date = Date(time)


    fun getHours(date: Date): List<Date> {
        _scheduleHourSource.clear()


        // Get the current time
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
        val formatter = SimpleDateFormat("yyyyMMdd", Locale.getDefault())
        val c: Calendar = GregorianCalendar()

        Log.e("FGV_HourSource", formatter.format(date.time))
        Log.e("FGV_HourSource", formatter.format(Date().time))

        if (!formatter.format(date.time).equals(formatter.format(Date().time))) {
            Log.e("FGV_HourSource", "!!!if(!formatter.format(date.time).equals(Date().time))!!!")
            c.apply {
                time = date

                c.set(Calendar.HOUR_OF_DAY, 24)
                c.set(Calendar.MINUTE, 0)
                c.set(Calendar.SECOND, 0)
            }
        } else {
            Log.e("FGV_HourSource", "!!!if(formatter.format(date.time).equals(Date().time))!!!")
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
        }

        Log.e("FGV_HourSource", "c.time ${c.time}!!!")
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

//    fun adjustPickupReturnHour(date: Date) {
//        val c: Calendar = GregorianCalendar()
//        c.apply {
//            time = date
//            c.set(Calendar.HOUR_OF_DAY, 24)
//            c.set(Calendar.MINUTE, 0)
//            c.set(Calendar.SECOND, 0)
//        }
//    }
}