package site.ylan.k29_mmkv.repository.loacl.cache

import com.tencent.mmkv.MMKV

/**
 * @ProjectName:    AndroidKotlin
 * @Package:        site.ylan.k29_mmkv.repository.loacl.cache
 * @ClassName:      MMKVManger
 * @Description:    作用：
 * @Author:         创建者：
 * @CreateDate:     2024/8/15/4:45 PM
 * @UpdateUser:     更新者：
 * @UpdateDate:     2024/8/15/4:45 PM
 */
object MMKVManger {

    private const val APP_CONF = "app_conf"

    private const val SP = "sharedPreferences"

    private const val AUTH = "auth"

    fun getDefaultMMKV() = MMKV.defaultMMKV()

    fun getSPMMKV() = MMKV.mmkvWithID(SP, MMKV.MULTI_PROCESS_MODE)

    fun getAppConfMMKV() = MMKV.mmkvWithID(APP_CONF, MMKV.MULTI_PROCESS_MODE)

    fun getAuthMMKV() = MMKV.mmkvWithID(AUTH, MMKV.MULTI_PROCESS_MODE)

}