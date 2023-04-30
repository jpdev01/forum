package br.com.jpdev.forum.mapper

interface Mapper<T, U> {

    fun map(t: T): U
}