package com.example.mynbt.tools;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class YoudaoTranslate {

    /**
     * returnPhrase : ["test"]
     * query : test
     * errorCode : 0
     * l : en2zh-CHS
     * tSpeakUrl : https://openapi.youdao.com/ttsapi?q=%E6%B5%8B%E9%AA%8C&langType=zh-CHS&sign=BEAA6C0ACAEA9A2ECF061A50409C87F8&salt=1670309376786&voice=4&format=mp3&appKey=2423360539ba5632&ttsVoiceStrict=false
     * web : [{"value":["测试","测验","试验","考试"],"key":"Test"},{"value":["测试用例","测试个案","测试案例","测试实例"],"key":"Test case"},{"value":["图灵测试","杜林测试","图林测试"],"key":"Turing test"}]
     * requestId : b213ae0f-148a-46f2-af21-14fcd68276a1
     * translation : ["测验"]
     * dict : {"url":"yddict://m.youdao.com/dict?le=eng&q=test"}
     * webdict : {"url":"http://mobile.youdao.com/dict?le=eng&q=test"}
     * basic : {"exam_type":["初中","高中","CET4","CET6","考研"],"us-phonetic":"test","phonetic":"test","uk-phonetic":"test","wfs":[{"wf":{"name":"复数","value":"tests"}},{"wf":{"name":"第三人称单数","value":"tests"}},{"wf":{"name":"现在分词","value":"testing"}},{"wf":{"name":"过去式","value":"tested"}},{"wf":{"name":"过去分词","value":"tested"}}],"uk-speech":"https://openapi.youdao.com/ttsapi?q=test&langType=en&sign=031FD1C86363732DFF4636122C808EE8&salt=1670309376786&voice=5&format=mp3&appKey=2423360539ba5632&ttsVoiceStrict=false","explains":["n. （书面或口头的）测验，考试；（医疗上的）检查，化验，检验；（对机器或武器等的）试验，检验；（对水、土壤、空气等的）检测，检验；（衡量能力或技能等的）测试，考验；医疗检查设备；化验结果；（常指板球、橄榄球的）国际锦标赛（Test）；准则，标准；（冶）烤钵，灰皿；（一些无脊椎动物和原生动物的）甲壳","v. 试验，测试；测验，考查（熟练程度，知识）；检测，检验（质量或含量）；检查（身体），（用试剂）化验；考验；尝，（触）试"],"us-speech":"https://openapi.youdao.com/ttsapi?q=test&langType=en&sign=031FD1C86363732DFF4636122C808EE8&salt=1670309376786&voice=6&format=mp3&appKey=2423360539ba5632&ttsVoiceStrict=false"}
     * isWord : true
     * speakUrl : https://openapi.youdao.com/ttsapi?q=test&langType=en&sign=031FD1C86363732DFF4636122C808EE8&salt=1670309376786&voice=4&format=mp3&appKey=2423360539ba5632&ttsVoiceStrict=false
     */

    private String query;
    private String errorCode;
    private String l;
    private String tSpeakUrl;
    private String requestId;
    private DictBean dict;
    private WebdictBean webdict;
    private BasicBean basic;
    private boolean isWord;
    private String speakUrl;
    private List<String> returnPhrase;
    private List<WebBean> web;
    private List<String> translation;

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

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

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

    public BasicBean getBasic() {
        return basic;
    }

    public void setBasic(BasicBean basic) {
        this.basic = basic;
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

    public List<String> getReturnPhrase() {
        return returnPhrase;
    }

    public void setReturnPhrase(List<String> returnPhrase) {
        this.returnPhrase = returnPhrase;
    }

    public List<WebBean> getWeb() {
        return web;
    }

    public void setWeb(List<WebBean> web) {
        this.web = web;
    }

    public List<String> getTranslation() {
        return translation;
    }

    public void setTranslation(List<String> translation) {
        this.translation = translation;
    }

    public static class DictBean {
        /**
         * url : yddict://m.youdao.com/dict?le=eng&q=test
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
         * url : http://mobile.youdao.com/dict?le=eng&q=test
         */

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class BasicBean {
        /**
         * exam_type : ["初中","高中","CET4","CET6","考研"]
         * us-phonetic : test
         * phonetic : test
         * uk-phonetic : test
         * wfs : [{"wf":{"name":"复数","value":"tests"}},{"wf":{"name":"第三人称单数","value":"tests"}},{"wf":{"name":"现在分词","value":"testing"}},{"wf":{"name":"过去式","value":"tested"}},{"wf":{"name":"过去分词","value":"tested"}}]
         * uk-speech : https://openapi.youdao.com/ttsapi?q=test&langType=en&sign=031FD1C86363732DFF4636122C808EE8&salt=1670309376786&voice=5&format=mp3&appKey=2423360539ba5632&ttsVoiceStrict=false
         * explains : ["n. （书面或口头的）测验，考试；（医疗上的）检查，化验，检验；（对机器或武器等的）试验，检验；（对水、土壤、空气等的）检测，检验；（衡量能力或技能等的）测试，考验；医疗检查设备；化验结果；（常指板球、橄榄球的）国际锦标赛（Test）；准则，标准；（冶）烤钵，灰皿；（一些无脊椎动物和原生动物的）甲壳","v. 试验，测试；测验，考查（熟练程度，知识）；检测，检验（质量或含量）；检查（身体），（用试剂）化验；考验；尝，（触）试"]
         * us-speech : https://openapi.youdao.com/ttsapi?q=test&langType=en&sign=031FD1C86363732DFF4636122C808EE8&salt=1670309376786&voice=6&format=mp3&appKey=2423360539ba5632&ttsVoiceStrict=false
         */

        @SerializedName("us-phonetic")
        private String usphonetic;
        private String phonetic;
        @SerializedName("uk-phonetic")
        private String ukphonetic;
        @SerializedName("uk-speech")
        private String ukspeech;
        @SerializedName("us-speech")
        private String usspeech;
        private List<String> exam_type;
        private List<WfsBean> wfs;
        private List<String> explains;

        public String getUsphonetic() {
            return usphonetic;
        }

        public void setUsphonetic(String usphonetic) {
            this.usphonetic = usphonetic;
        }

        public String getPhonetic() {
            return phonetic;
        }

        public void setPhonetic(String phonetic) {
            this.phonetic = phonetic;
        }

        public String getUkphonetic() {
            return ukphonetic;
        }

        public void setUkphonetic(String ukphonetic) {
            this.ukphonetic = ukphonetic;
        }

        public String getUkspeech() {
            return ukspeech;
        }

        public void setUkspeech(String ukspeech) {
            this.ukspeech = ukspeech;
        }

        public String getUsspeech() {
            return usspeech;
        }

        public void setUsspeech(String usspeech) {
            this.usspeech = usspeech;
        }

        public List<String> getExam_type() {
            return exam_type;
        }

        public void setExam_type(List<String> exam_type) {
            this.exam_type = exam_type;
        }

        public List<WfsBean> getWfs() {
            return wfs;
        }

        public void setWfs(List<WfsBean> wfs) {
            this.wfs = wfs;
        }

        public List<String> getExplains() {
            return explains;
        }

        public void setExplains(List<String> explains) {
            this.explains = explains;
        }

        public static class WfsBean {
            /**
             * wf : {"name":"复数","value":"tests"}
             */

            private WfBean wf;

            public WfBean getWf() {
                return wf;
            }

            public void setWf(WfBean wf) {
                this.wf = wf;
            }

            public static class WfBean {
                /**
                 * name : 复数
                 * value : tests
                 */

                private String name;
                private String value;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }
        }
    }

    public static class WebBean {
        /**
         * value : ["测试","测验","试验","考试"]
         * key : Test
         */

        private String key;
        private List<String> value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public List<String> getValue() {
            return value;
        }

        public void setValue(List<String> value) {
            this.value = value;
        }
    }
}
