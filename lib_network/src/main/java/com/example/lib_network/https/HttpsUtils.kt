package com.example.lib_network.https

import android.content.Context
import java.io.IOException
import java.security.*
import java.security.cert.CertificateException
import java.security.cert.CertificateFactory
import java.security.cert.X509Certificate
import javax.net.ssl.*

class HttpsUtils {

     companion object{
         /**
          * des:信任所有的域名*/
         fun hostNameVerifier() : HostnameVerifier{
             return HostnameVerifier { hostname, session ->true}
         }
         /**
          * des: 提供SSL证书*/
         fun getOneWaySSLFactory():SSLSocketFactory{
                var sslfactory:SSLSocketFactory;
             var sslContext :SSLContext = SSLContext.getInstance("TLS")
             sslContext.init(null, arrayOf(TrustAllCert()), SecureRandom())
             sslfactory = sslContext.socketFactory
             return sslfactory
         }
         /**
          * des: 提供SSL保存在本地的证书*/
         fun getSaveSSLFactory(context: Context,array: IntArray): SSLSocketFactory? {
             if (context == null) {
                 throw NullPointerException("context == null")
             }

             val certificateFactory: CertificateFactory
             try {
                 certificateFactory = CertificateFactory.getInstance("X.509")
                 val keyStore = KeyStore.getInstance(KeyStore.getDefaultType())
                 keyStore.load(null, null)
                 for (i in array.indices) {
                     val certificate =
                         context.resources.openRawResource(array.get(i))
                     keyStore.setCertificateEntry(
                         i.toString(),
                         certificateFactory.generateCertificate(certificate)
                     )
                     certificate.close()
                 }
                 val sslContext =
                     SSLContext.getInstance("TLS")
                 val trustManagerFactory =
                     TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
                 trustManagerFactory.init(keyStore)
                 sslContext.init(
                     null,
                     trustManagerFactory.trustManagers,
                     SecureRandom()
                 )
                 return sslContext.socketFactory
             } catch (e: CertificateException) {
                 e.printStackTrace()
             } catch (e: NoSuchAlgorithmException) {
                 e.printStackTrace()
             } catch (e: KeyStoreException) {
                 e.printStackTrace()
             } catch (e: IOException) {
                 e.printStackTrace()
             } catch (e: KeyManagementException) {
                 e.printStackTrace()
             }

             return null
         }
     }

}
/**
 * des:https单向验证，信任所有的服务器证书
 * */
class TrustAllCert :    X509TrustManager{
    override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {
        TODO("Not yet implemented")
    }

    override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
        TODO("Not yet implemented")
    }

    override fun getAcceptedIssuers(): Array<X509Certificate?> {
        return  arrayOfNulls(0)
    }

}