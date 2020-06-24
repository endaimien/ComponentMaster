package com.example.lib_common.utils

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaScannerConnection
import android.media.MediaScannerConnection.MediaScannerConnectionClient
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.text.TextUtils
import android.util.Log
import android.webkit.MimeTypeMap
import androidx.annotation.RequiresApi
import java.io.*
import java.net.URLConnection
import java.security.DigestInputStream
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*

/**
 * @Describe 文件相关工具类
 * @Author Jungle68
 * @Date 2016/12/15
 * @Contact 335891510@qq.com
 */
class FileUtils private constructor() {
    companion object {
        var msc: MediaScannerConnection? = null

        /**
         * 把图片插入系统插入图
         *
         * @param context
         * @param file
         */
        fun insertPhotoToAlbumAndRefresh(
            context: Context,
            file: File
        ) {
            // 其次把文件插入到系统图库
//        try {
//            MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), file.getName(), null);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
            // 最后通知图库更新
            context.sendBroadcast(
                Intent(
                    Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                    Uri.parse("file://" + file.absolutePath)
                )
            )
        }

        fun updateMediaStore(context: Context?, path: String?) {
            if (TextUtils.isEmpty(path)) {
                return
            }
            msc =
                MediaScannerConnection(context, object : MediaScannerConnectionClient {
                    override fun onMediaScannerConnected() {
                        msc!!.scanFile(path, null)
                    }

                    override fun onScanCompleted(
                        path: String,
                        uri: Uri
                    ) {
                        msc!!.disconnect()
                        msc = null
                    }
                })
            msc!!.connect()
        }

        /**
         * 返回缓存文件夹
         *
         * @param context
         * @param isExternalCache 是否是sd卡缓存路径
         * @return
         */
        @RequiresApi(Build.VERSION_CODES.FROYO)
        fun getCacheFile(
            context: Context,
            isExternalCache: Boolean
        ): File {
            return if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED && isExternalCache) {
                var file: File? = null
                file = context.externalCacheDir //获取系统管理的sd卡缓存文件
                if (file == null) { //如果获取的为空,就是用自己定义的缓存文件夹做缓存路径
                    file = File(
                        getCacheFilePath(context)
                    )
                    if (!file.exists()) {
                        file.mkdirs()
                    }
                }
                file
            } else {
//            Log.e("liubo"," 获取app缓存目录 == " + context.getCacheDir());
                context.cacheDir // 获取app缓存目录，glide就是默认缓存在这儿的
            }
        }

        /**
         * 获取自定义缓存文件地址
         *
         * @param context
         * @return
         */
        fun getCacheFilePath(context: Context): String {
            val packageName = context.packageName
            //        Log.e("liubo","获取自定义缓存文件地址"+  "/mnt/sdcard/" + packageName);
            return "/mnt/sdcard/$packageName"
        }

        /**
         * 使用递归删除文件夹
         *
         * @param dir
         * @return
         */
        fun deleteDir(dir: File?): Boolean {
            if (dir == null) {
                return false
            }
            if (!dir.isDirectory) {
                return false
            }
            val files = dir.listFiles()
            for (file in files) {
                if (file.isFile) {
                    file.delete()
                } else if (file.isDirectory) {
                    deleteDir(file) // 递归调用继续删除
                }
            }
            return true
        }

        /**
         * 根据文件路径获取文件
         *
         * @param filePath 文件路径
         * @return 文件
         */
        fun getFileByPath(filePath: String?): File? {
            return if (TextUtils.isEmpty(filePath)) null else File(filePath)
        }

        /**
         * 判断文件是否存在
         *
         * @param filePath 文件路径
         * @return `true`: 存在<br></br>`false`: 不存在
         */
        fun isFileExists(filePath: String?): Boolean {
            return isFileExists(
                getFileByPath(
                    filePath
                )
            )
        }

        /**
         * 删除文件
         *
         * @param filePath
         * @return
         */
        fun deleteFile(filePath: String?): Boolean {
            val file =
                getFileByPath(filePath)
            return if (isFileExists(file)) {
                file!!.delete()
            } else false
        }

        /**
         * 判断文件是否存在
         *
         * @param file 文件
         * @return `true`: 存在<br></br>`false`: 不存在
         */
        fun isFileExists(file: File?): Boolean {
            return file != null && file.exists()
        }

        /**
         * 重命名文件
         *
         * @param filePath 文件路径
         * @param newName  新名称
         * @return `true`: 重命名成功<br></br>`false`: 重命名失败
         */
        fun rename(filePath: String?, newName: String): Boolean {
            return rename(
                getFileByPath(
                    filePath
                ), newName
            )
        }

        /**
         * 重命名文件
         *
         * @param file    文件
         * @param newName 新名称
         * @return `true`: 重命名成功<br></br>`false`: 重命名失败
         */
        fun rename(file: File?, newName: String): Boolean {
            // 文件为空返回false
            if (file == null) {
                return false
            }
            // 文件不存在返回false
            if (!file.exists()) {
                return false
            }
            // 新的文件名为空返回false
            if (TextUtils.isEmpty(newName)) {
                return false
            }
            // 如果文件名没有改变返回true
            if (newName == file.name) {
                return true
            }
            val newFile =
                File(file.parent + File.separator + newName)
            // 如果重命名的文件已存在返回false
            return (!newFile.exists()
                    && file.renameTo(newFile))
        }

        /**
         * 判断是否是目录
         *
         * @param dirPath 目录路径
         * @return `true`: 是<br></br>`false`: 否
         */
        fun isDir(dirPath: String?): Boolean {
            return isDir(
                getFileByPath(
                    dirPath
                )
            )
        }

        /**
         * 判断是否是目录
         *
         * @param file 文件
         * @return `true`: 是<br></br>`false`: 否
         */
        fun isDir(file: File?): Boolean {
            return isFileExists(file) && file!!.isDirectory
        }

        /**
         * 判断是否是文件
         *
         * @param filePath 文件路径
         * @return `true`: 是<br></br>`false`: 否
         */
        fun isFile(filePath: String?): Boolean {
            return isFile(
                getFileByPath(
                    filePath
                )
            )
        }

        /**
         * 判断是否是文件
         *
         * @param file 文件
         * @return `true`: 是<br></br>`false`: 否
         */
        fun isFile(file: File?): Boolean {
            return isFileExists(file) && file!!.isFile
        }

        /**
         * 判断目录是否存在，不存在则判断是否创建成功
         *
         * @param dirPath 目录路径
         * @return `true`: 存在或创建成功<br></br>`false`: 不存在或创建失败
         */
        fun createOrExistsDir(dirPath: String?): Boolean {
            return createOrExistsDir(
                getFileByPath(
                    dirPath
                )
            )
        }

        /**
         * 判断目录是否存在，不存在则判断是否创建成功
         *
         * @param file 文件
         * @return `true`: 存在或创建成功<br></br>`false`: 不存在或创建失败
         */
        fun createOrExistsDir(file: File?): Boolean {
            // 如果存在，是目录则返回true，是文件则返回false，不存在则返回是否创建成功
            return file != null && if (file.exists()) file.isDirectory else file.mkdirs()
        }

        /**
         * 判断文件是否存在，不存在则判断是否创建成功
         *
         * @param filePath 文件路径
         * @return `true`: 存在或创建成功<br></br>`false`: 不存在或创建失败
         */
        fun createOrExistsFile(filePath: String?): Boolean {
            return createOrExistsFile(
                getFileByPath(
                    filePath
                )
            )
        }

        /**
         * 判断文件是否存在，不存在则判断是否创建成功
         *
         * @param file 文件
         * @return `true`: 存在或创建成功<br></br>`false`: 不存在或创建失败
         */
        fun createOrExistsFile(file: File?): Boolean {
            if (file == null) {
                return false
            }
            // 如果存在，是文件则返回true，是目录则返回false
            if (file.exists()) {
                return file.isFile
            }
            return if (!createOrExistsDir(file.parentFile)) {
                false
            } else try {
                file.createNewFile()
            } catch (e: IOException) {
                e.printStackTrace()
                false
            }
        }

        /**
         * 判断文件是否存在，存在则在创建之前删除
         *
         * @param filePath 文件路径
         * @return `true`: 创建成功<br></br>`false`: 创建失败
         */
        fun createFileByDeleteOldFile(filePath: String?): Boolean {
            return createFileByDeleteOldFile(
                getFileByPath(
                    filePath
                )
            )
        }

        /**
         * 判断文件是否存在，存在则在创建之前删除
         *
         * @param file 文件
         * @return `true`: 创建成功<br></br>`false`: 创建失败
         */
        fun createFileByDeleteOldFile(file: File?): Boolean {
            if (file == null) {
                return false
            }
            // 文件存在并且删除失败返回false
            if (file.exists() && file.isFile && !file.delete()) {
                return false
            }
            // 创建目录失败返回false
            return if (!createOrExistsDir(file.parentFile)) {
                false
            } else try {
                file.createNewFile()
            } catch (e: IOException) {
                e.printStackTrace()
                false
            }
        }

        /**
         * 获取目录下指定文件名的文件包括子目录
         *
         * 大小写忽略
         *
         * @param dir      目录
         * @param fileName 文件名
         * @return 文件链表
         */
        fun searchFileInDir(
            dir: File?,
            fileName: String
        ): List<File>? {
            if (dir == null || !isDir(dir)) {
                return null
            }
            val list: MutableList<File> =
                ArrayList()
            val files = dir.listFiles()
            if (files != null && files.size != 0) {
                for (file in files) {
                    if (file.name.toUpperCase() == fileName.toUpperCase()) {
                        list.add(file)
                    }
                    if (file.isDirectory) {
                        list.addAll(
                            searchFileInDir(
                                file,
                                fileName
                            )!!
                        )
                    }
                }
            }
            return list
        }

        /**
         * 将输入流写入文件
         *
         * @param file   文件
         * @param is     输入流
         * @param append 是否追加在文件末
         * @return `true`: 写入成功<br></br>`false`: 写入失败
         */
        fun writeFileFromIS(
            file: File?,
            `is`: InputStream?,
            append: Boolean
        ): Boolean {
            if (file == null || `is` == null) {
                return false
            }
            var os: OutputStream? = null
            return try {
                os = BufferedOutputStream(FileOutputStream(file, append))
                val data = ByteArray(1024)
                var len: Int
                while (`is`.read(data, 0, 1024).also { len = it } != -1) {
                    os.write(data, 0, len)
                }
                true
            } catch (e: IOException) {
                e.printStackTrace()
                false
            } finally {
                CloseUtils.closeIO(`is`, os)
            }
        }

        /**
         * 保存bitmap到文件
         *
         * @param picName 图片名称
         * @param imgPath 图片目录
         * @return 失败返回各种提示，成功返回图片路径 -2 sd卡不存在 -1 图片保存失败 其他 图片保存成功
         */
        fun saveFileByFileData(
            dataFile: File?,
            picName: String,
            imgPath: String?
        ): String {
            // 保存在sd卡中
            val dir = File(imgPath)
            if (!dir.isDirectory) {
                Log.e("liubo", "目录不存在，创建多级目录")
                if (!dir.mkdir()) {
                    Log.e("liubo", "创建多级目录失败")
                    return "-2"
                }
            }
            try {
                val f = File("$dir/$picName")
                val result =
                    writeFileFromIS(
                        f,
                        FileInputStream(dataFile),
                        false
                    )
                return if (result) {
                    f.absolutePath
                } else {
                    "-1"
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return "-1"
        }

        /**
         * 将字符串写入文件
         *
         * @param filePath 文件路径
         * @param content  写入内容
         * @param append   是否追加在文件末
         * @return `true`: 写入成功<br></br>`false`: 写入失败
         */
        fun writeFileFromString(
            filePath: String?,
            content: String?,
            append: Boolean
        ): Boolean {
            return writeFileFromString(
                getFileByPath(
                    filePath
                ), content, append
            )
        }

        /**
         * 将字符串写入文件
         *
         * @param file    文件
         * @param content 写入内容
         * @param append  是否追加在文件末
         * @return `true`: 写入成功<br></br>`false`: 写入失败
         */
        fun writeFileFromString(
            file: File?,
            content: String?,
            append: Boolean
        ): Boolean {
            if (file == null || content == null) {
                return false
            }
            if (!createOrExistsFile(file)) {
                return false
            }
            var bw: BufferedWriter? = null
            return try {
                bw = BufferedWriter(FileWriter(file, append))
                bw.write(content)
                true
            } catch (e: IOException) {
                e.printStackTrace()
                false
            } finally {
                CloseUtils.closeIO(bw)
            }
        }


        /**
         * 获取目录长度
         *
         * @param dirPath 目录路径
         * @return 文件大小
         */
        fun getDirLength(dirPath: String?): Long {
            return getDirLength(
                getFileByPath(
                    dirPath
                )
            )
        }

        /**
         * 获取目录长度
         *
         * @param dir 目录
         * @return 文件大小
         */
        fun getDirLength(dir: File?): Long {
            if (!isDir(dir)) {
                return -1
            }
            var len: Long = 0
            val files = dir!!.listFiles()
            if (files != null && files.size != 0) {
                for (file in files) {
                    len += if (file.isDirectory) {
                        getDirLength(file)
                    } else {
                        file.length()
                    }
                }
            }
            return len
        }

        /**
         * 获取文件长度
         *
         * @param filePath 文件路径
         * @return 文件大小
         */
        fun getFileLength(filePath: String?): Long {
            return getFileLength(
                getFileByPath(
                    filePath
                )
            )
        }

        /**
         * 获取文件长度
         *
         * @param file 文件
         * @return 文件大小
         */
        fun getFileLength(file: File?): Long {
            return if (!isFile(file)) {
                -1
            } else file!!.length()
        }

        /**
         * 获取文件的MD5校验码
         *
         * @param filePath 文件路径
         * @return 文件的MD5校验码
         */
        fun getFileMD5(filePath: String?): ByteArray? {
            val file =
                if (TextUtils.isEmpty(filePath)) null else File(filePath)
            return getFileMD5(file)
        }



        /**
         * 获取文件的MD5校验码
         *
         * @param file 文件
         * @return 文件的MD5校验码
         */
        fun getFileMD5(file: File?): ByteArray? {
            if (file == null) {
                return null
            }
            var dis: DigestInputStream? = null
            try {
                val fis = FileInputStream(file)
                var md = MessageDigest.getInstance("MD5")
                dis = DigestInputStream(fis, md)
                val buffer = ByteArray(1024 * 256)
                while (dis.read(buffer) > 0) {
                }
                md = dis.messageDigest
                return md.digest()
            } catch (e: NoSuchAlgorithmException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            } finally {
                CloseUtils.closeIO(dis)
            }
            return null
        }

        fun getFileMD5(stream: InputStream?): ByteArray? {
            if (stream == null) {
                return null
            }
            var dis: DigestInputStream? = null
            try {
                var md = MessageDigest.getInstance("MD5")
                dis = DigestInputStream(stream, md)
                val buffer = ByteArray(1024 * 256)
                while (dis.read(buffer) > 0) {
                }
                md = dis.messageDigest
                return md.digest()
            } catch (e: NoSuchAlgorithmException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            } finally {
                CloseUtils.closeIO(dis)
            }
            return null
        }

        /**
         * 获取文件的MD5校验码
         *
         * @param file 文件
         * @return 文件的MD5校验码
         */
        fun getFileSHA_256(file: File?): ByteArray? {
            if (file == null) {
                return null
            }
            var dis: DigestInputStream? = null
            try {
                val fis = FileInputStream(file)
                var md =
                    MessageDigest.getInstance("SHA-256")
                dis = DigestInputStream(fis, md)
                val buffer = ByteArray(1024 * 256)
                while (dis.read(buffer) > 0) {
                }
                md = dis.messageDigest
                return md.digest()
            } catch (e: NoSuchAlgorithmException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            } finally {
                CloseUtils.closeIO(dis)
            }
            return null
        }

        /**
         * 获取全路径中的最长目录
         *
         * @param file 文件
         * @return filePath最长目录
         */
        fun getDirName(file: File?): String? {
            return if (file == null) {
                null
            } else getDirName(file.path)
        }

        /**
         * 获取全路径中的最长目录
         *
         * @param filePath 文件路径
         * @return filePath最长目录
         */
        fun getDirName(filePath: String): String {
            if (TextUtils.isEmpty(filePath)) {
                return filePath
            }
            val lastSep = filePath.lastIndexOf(File.separator)
            return if (lastSep == -1) "" else filePath.substring(0, lastSep + 1)
        }

        /**
         * 获取全路径中的文件名
         *
         * @param file 文件
         * @return 文件名
         */
        fun getFileName(file: File?): String? {
            return if (file == null) {
                null
            } else getFileName(file.path)
        }

        /**
         * 获取全路径中的文件名
         *
         * @param filePath 文件路径
         * @return 文件名
         */
        fun getFileName(filePath: String): String {
            if (TextUtils.isEmpty(filePath)) {
                return filePath
            }
            val lastSep = filePath.lastIndexOf(File.separator)
            return if (lastSep == -1) filePath else filePath.substring(lastSep + 1)
        }

        /**
         * 获取全路径中的不带拓展名的文件名
         *
         * @param file 文件
         * @return 不带拓展名的文件名
         */
        fun getFileNameNoExtension(file: File?): String? {
            return if (file == null) {
                null
            } else getFileNameNoExtension(file.path)
        }

        /**
         * 获取全路径中的不带拓展名的文件名
         *
         * @param filePath 文件路径
         * @return 不带拓展名的文件名
         */
        fun getFileNameNoExtension(filePath: String): String {
            if (TextUtils.isEmpty(filePath)) {
                return filePath
            }
            val lastPoi = filePath.lastIndexOf('.')
            val lastSep = filePath.lastIndexOf(File.separator)
            if (lastSep == -1) {
                return if (lastPoi == -1) filePath else filePath.substring(0, lastPoi)
            }
            return if (lastPoi == -1 || lastSep > lastPoi) {
                filePath.substring(lastSep + 1)
            } else filePath.substring(lastSep + 1, lastPoi)
        }


        @RequiresApi(Build.VERSION_CODES.FROYO)
        fun readImgFromFile(context: Context, name: String): Bitmap {
            return BitmapFactory.decodeFile(
                getCacheFile(
                    context,
                    false
                ).absolutePath + "/" + name
            )
        }


        // url = file path or whatever suitable URL you want.
        fun getMimeTypeByUrl(url: String?): String? {
            var type: String? = null
            val extension = MimeTypeMap.getFileExtensionFromUrl(url)
            if (extension != null) {
                type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension)
            }
            return type
        }

        /**
         * 获取文件的MIME类型
         *
         * @param fileName
         * @return
         */
        fun getMimeTypeByFileName(fileName: String?): String {
            return URLConnection.guessContentTypeFromName(fileName)
        }


        fun getSuffix(file: File?): String? {
            if (file == null || !file.exists() || file.isDirectory) {
                return null
            }
            val fileName = file.name
            if (fileName == "" || fileName.endsWith(".")) {
                return null
            }
            val index = fileName.lastIndexOf(".")
            return if (index != -1) {
                fileName.substring(index + 1).toLowerCase(Locale.US)
            } else {
                null
            }
        }

        /**获取某个文件夹下的所有文件 */
        fun getAllChildFileName(fileAbsolutePath: String): Vector<String> {
            val vecFile = Vector<String>()
            val file = File(fileAbsolutePath)
            val subFile = file.listFiles() ?: return vecFile
            for (iFileLength in subFile.indices) {
                // 判断是否为文件夹
                if (!subFile[iFileLength].isDirectory) {
                    val filename = subFile[iFileLength].name
                    Log.e("eee", "文件名 ： $filename")
                    vecFile.add("$fileAbsolutePath/$filename")
                }
            }
            return vecFile
        }
    }

    init {
        throw UnsupportedOperationException("u can't instantiate me...")
    }
}