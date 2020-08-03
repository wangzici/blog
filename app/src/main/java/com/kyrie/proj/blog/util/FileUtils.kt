package com.kyrie.proj.blog.util

import android.content.Context
import java.io.InputStreamReader

/**
 * Created by wzt on 2020/7/22
 *
 */
class FileUtils {

    companion object{

        /**
         * get text from asset file
         * @param fileName 放置在assets文件夹下的文件名
         */
        @JvmStatic
        fun getTextFromAsset(
            context: Context,
            fileName: String?
        ): String? {
            try {
                val sb = StringBuilder()
                val reader =
                    InputStreamReader(context.resources.assets.open(fileName!!))
                val buf = CharArray(1024 * 8)
                var len: Int
                while (reader.read(buf).also { len = it } > 0) {
                    sb.append(buf, 0, len)
                }
                return sb.toString()
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return ""
        }
    }
}