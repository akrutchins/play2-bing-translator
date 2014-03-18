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
## License
The MIT License (MIT)

Copyright (c) 2014 Nelinelo Inc.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
