package site.ylan.k11_net.base

interface HttpCallbackListener {
    fun onSuccess(data: String)
    fun onFail(message: String)
}