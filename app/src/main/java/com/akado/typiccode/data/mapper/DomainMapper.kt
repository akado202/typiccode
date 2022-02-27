package com.akado.typiccode.data.mapper

interface DomainMapper<in V, out D> {

    fun mapToModel(from: V): D
}