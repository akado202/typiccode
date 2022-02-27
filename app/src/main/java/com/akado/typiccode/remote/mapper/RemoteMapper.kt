package com.akado.typiccode.remote.mapper

interface RemoteMapper<in M, out E> {

    fun mapToData(from: M): E

}