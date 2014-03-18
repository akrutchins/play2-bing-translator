play2-bing-translator
=====================

A simple scala object to translate text with Bing Translator API

## Install
Just put the file "bing.scala" into your projet and import I18N.Translator:
```
    import I18N.Translator._
```

## Usage
Only two methods:
```
  /*
    @desc   Refresh access token for Bing scala object
    @params None
    @return AccessToken Option[String]
  */
  Bing.getAccessToken
```
```
  /*  
     @desc   Translate text from a language to another
     @params text String (ex: "I love chocolate")
             from String (ex: "en")
             to   String (ex: "fr")
             
     @return translation String
  */
  Bing.translate(text, from, to)
```
