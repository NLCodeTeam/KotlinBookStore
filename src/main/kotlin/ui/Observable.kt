package ui

class Observable<T> {
    private val observers: ArrayList<Observer<T>> = ArrayList()

    var observerValue: T? = null
        set(value) {
            field = value
            if (value != null) {
                sendUpdateEvent(value)
            }
        }

    fun add(observer: Observer<T>) {
        observers.add(observer)
    }

    fun remove(observer: Observer<T>) {
        observers.remove(observer)
    }

    private fun sendUpdateEvent(arg: T) {
        observers.forEach { it.onChanged(arg) }
    }
}