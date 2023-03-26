package data

import data.source.BookDataSource
import data.source.BookDataSourceImpl

object BookDataSourceFactory {
    fun create(): BookDataSource = BookDataSourceImpl()
}