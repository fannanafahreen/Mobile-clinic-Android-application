package fannana.fahreen.mobileclinic.repo

import android.content.Context
import android.content.SharedPreferences

class PrefUtils private constructor(){

    companion object{

        const val PREF_DEP_CODE= "D000"
        const val PREF_DEP_NAME= "DEPARTMENT"

        private lateinit var sharedpreferences: SharedPreferences
        private const val PREFERENCE_NAME = "SRPref"
        private lateinit var instance : PrefUtils

        fun init(context: Context) : PrefUtils{
            sharedpreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
            if(!this::instance.isInitialized){
                instance = PrefUtils()
            }
            return instance
        }
    }

    fun saveStringData(key: String?, value: String?) {
        val editor = sharedpreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getStringData( key: String?): String? {
        return if (sharedpreferences.contains(key)) {
            sharedpreferences.getString(key, "")
        } else ""
    }

    fun saveIntData( key: String?, value: Int) {
        val editor = sharedpreferences.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun getIntData(key: String?): Int {
        return if (sharedpreferences.contains(key)) {
            sharedpreferences.getInt(key, 0)
        } else 0
    }

    fun saveBoolData( key: String?, value: Boolean) {
        val editor = sharedpreferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getBoolData(key: String?): Boolean {
        return if (sharedpreferences.contains(key)) {
            sharedpreferences.getBoolean(key, false)
        } else false
    }


}