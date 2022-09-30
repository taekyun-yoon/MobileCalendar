package com.kizitonwose.calendarcompose.shared

/**
 * Basically [MutableMap.getOrPut] but allows us read the map
 * in multiple places without calling `getOrPut` everywhere.
 */
internal class CalendarDataStore<V>(private val create: (offset: Int) -> V) :
    HashMap<Int, V>() {
    override fun get(key: Int): V {
        val value = super.get(key)
        return if (value == null) {
            val data = create(key)
            put(key, data)
            data
        } else {
            value
        }
    }
}
