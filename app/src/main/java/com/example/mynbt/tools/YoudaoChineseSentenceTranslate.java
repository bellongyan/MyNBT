package com.example.mynbt.tools;

import java.util.List;

public class YoudaoChineseSentenceTranslate {

    /**
     * tSpeakUrl : https://openapi.youdao.com/ttsapi?q=This+is+a+test+statement&langType=en&sign=A20E5F860B595184109C196ED4B74FC9&salt=1670311203931&voice=4&format=mp3&appKey=2423360539ba5632&ttsVoiceStrict=false
     * requestId : 394498f6-4c60-44d3-90a7-84d5ae5fe63c
     * query : 这是一个测试语句
     * translation : ["This is a test statement"]
     * errorCode : 0
     * dict : {"url":"yddict://m.youdao.com/dict?le=eng&q=%E8%BF%99%E6%98%AF%E4%B8%80%E4%B8%AA%E6%B5%8B%E8%AF%95%E8%AF%AD%E5%8F%A5"}
     * webdict : {"url":"http://mobile.youdao.com/dict?le=eng&q=%E8%BF%99%E6%98%AF%E4%B8%80%E4%B8%AA%E6%B5%8B%E8%AF%95%E8%AF%AD%E5%8F%A5"}
     * l : zh-CHS2en
     * isWord : false
     * speakUrl : https://openapi.youdao.com/ttsapi?q=%E8%BF%99%E6%98%AF%E4%B8%80%E4%B8%AA%E6%B5%8B%E8%AF%95%E8%AF%AD%E5%8F%A5&langType=zh-CHS&sign=399BDF6F4D855000B3500038A2909B87&salt=1670311203931&voice=4&format=mp3&appKey=2423360539ba5632&ttsVoiceStrict=false
     */

    private String tSpeakUrl;
    private String requestId;
    private String query;
    private String errorCode;
    private DictBean dict;
    private WebdictBean webdict;
    private String l;
    private boolean isWord;
    private String speakUrl;
    private List<String> translation;

    public String getTSpeakUrl() {
        return tSpeakUrl;
    }

    public void setTSpeakUrl(String tSpeakUrl) {
        this.tSpeakUrl = tSpeakUrl;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public DictBean getDict() {
        return dict;
    }

    public void setDict(DictBean dict) {
        this.dict = dict;
    }

    public WebdictBean getWebdict() {
        return webdict;
    }

    public void setWebdict(WebdictBean webdict) {
        this.webdict = webdict;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public boolean isIsWord() {
        return isWord;
    }

    public void setIsWord(boolean isWord) {
        this.isWord = isWord;
    }

    public String getSpeakUrl() {
        return speakUrl;
    }

    public void setSpeakUrl(String speakUrl) {
        this.speakUrl = speakUrl;
    }

    public List<String> getTranslation() {
        return translation;
    }

    public void setTranslation(List<String> translation) {
        this.translation = translation;
    }

    public static class DictBean {
        /**
         * url : yddict://m.youdao.com/dict?le=eng&q=%E8%BF%99%E6%98%AF%E4%B8%80%E4%B8%AA%E6%B5%8B%E8%AF%95%E8%AF%AD%E5%8F%A5
         */

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class WebdictBean {
        /**
         * url : http://mobile.youdao.com/dict?le=eng&q=%E8%BF%99%E6%98%AF%E4%B8%80%E4%B8%AA%E6%B5%8B%E8%AF%95%E8%AF%AD%E5%8F%A5
         */

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
