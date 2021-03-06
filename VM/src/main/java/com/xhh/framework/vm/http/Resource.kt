package com.xhh.framework.vm.http

/**
 *   @Author:小灰灰
 *   @Time:2020/10/26
 *   @Desc:
 */
sealed class Resource<T>(val code: String?, val data: T?, val message: String?) {


    companion object {
         fun <T> success(data: T?) :Resource<T>{
             return Success(data)
         }
         fun <T> error(code: String?, message: String?):Resource<T>{
             return  Error<T>(code, message)
         }
    }

     internal class Success<T>(data: T?) : Resource<T>(null, data, null)
     internal class Error<T>(code: String?, message: String?) : Resource<T>(code, null, message)
}