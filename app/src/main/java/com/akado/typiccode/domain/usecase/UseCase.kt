package com.akado.typiccode.domain.usecase

interface UseCase<out Type, in Param> {

    fun fetch(param : Param) : Type
}