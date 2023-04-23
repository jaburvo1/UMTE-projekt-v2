package com.example.umte_projekt.base


sealed interface State<T> {

    object None: State<Any?>

    object Loading: State<Any?>

    class Success(val any: Any? = null): State<Any?>

    class Failure(
        val throwable: Throwable
    ): State<Any?>

}

