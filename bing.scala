package I18N.Translator

import play.api.libs.ws._
import play.api._

import scala.concurrent.Future
import scala.concurrent._
import scala.concurrent.duration._

/*
  A simple scala object to translate text
  Use Bing Translate API v2
*/
object Bing {

  implicit val context = scala.concurrent.ExecutionContext.Implicits.global

  var accessToken: Option[String] = None
  val clientId = "" // Your client ID
  val clientSecret = "" // Your client secret

  /* 
    Refresh the access token for the bing API
    You have to call it every (or before) ten minutes because it will expire
  */
  def getAccessToken() = {
    val url = "https://datamarket.accesscontrol.windows.net/v2/OAuth2-13"
    val data = "grant_type=client_credentials&client_id=" + clientId + "&client_secret=" + clientSecret +"&scope=http://api.microsofttranslator.com"
    val response = WS.url(url).withHeaders("Content-Type" -> "application/x-www-form-urlencoded").post(data)
    
    try {
      val result = Await.result(response, 10.seconds)
      accessToken = (result.json \ "access_token").asOpt[String]
      Logger.info("Bing Access Token has been refreshed.")
    } catch {
      case e: TimeoutException => Logger.error("Get token access for Bing API failed because timeout.")
    }

    accessToken
  }

  /* 
    Translate a text from a language to another
    Once you called getAccessToken, you can translate
  */
  def translate(text: String, from: String, to: String) = {
    val textEncoded = java.net.URLEncoder.encode(text, "UTF-8");
    val urlTranslate = "http://api.microsofttranslator.com/V2/Http.svc/Translate?text=" + textEncoded + "&from=" + from + "&to=" + to

    accessToken match {
      case Some(token: String) => {
        val response = WS.url(urlTranslate).withHeaders("Authorization" -> ("bearer " + token)).get
          try {
            val result = Await.result(response, 10.seconds)
            (result.xml \\ "string" headOption).map(_.text).map { translation => Option(translation) }
          } catch {
            case e: TimeoutException => {
              Logger.error("Get translation for Bing API failed because timeout.")
              None
            }
          }    
      }
      case _ => {
        Logger.error("Get translation for Bing API failed because accessToken is null.")
        None
      }
    }
    
  }
}