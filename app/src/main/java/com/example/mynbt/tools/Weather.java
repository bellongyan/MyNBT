package com.example.mynbt.tools;

import java.io.Serializable;
import java.util.List;

public class Weather implements Serializable {

    private Integer code;
    private String msg;
    private DataDTO data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class DataDTO implements Serializable {
        private String city;
        private List<AreaDTO> area;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public List<AreaDTO> getArea() {
            return area;
        }

        public void setArea(List<AreaDTO> area) {
            this.area = area;
        }

        public static class AreaDTO implements Serializable {
            private String name;
            private String stationNum;
            private List<WeatherDTO> weather;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getStationNum() {
                return stationNum;
            }

            public void setStationNum(String stationNum) {
                this.stationNum = stationNum;
            }

            public List<WeatherDTO> getWeather() {
                return weather;
            }

            public void setWeather(List<WeatherDTO> weather) {
                this.weather = weather;
            }

            public static class WeatherDTO implements Serializable {
                private String dateTime;
                private String weekDay;
                private String maxTemp;
                private String minTemp;
                private String wind;
                private String dayWtString;
                private String dayImageUrl;
                private String dayBigImageUrl;
                private String dayBgImageUrl;
                private String dayWindV;
                private String dayWindD;
                private String nightWtString;
                private String nightImageUrl;
                private String nightBigImageUrl;
                private String nightBgImageUrl;
                private String nightWindV;
                private String nightWindD;

                public String getDateTime() {
                    return dateTime;
                }

                public void setDateTime(String dateTime) {
                    this.dateTime = dateTime;
                }

                public String getWeekDay() {
                    return weekDay;
                }

                public void setWeekDay(String weekDay) {
                    this.weekDay = weekDay;
                }

                public String getMaxTemp() {
                    return maxTemp;
                }

                public void setMaxTemp(String maxTemp) {
                    this.maxTemp = maxTemp;
                }

                public String getMinTemp() {
                    return minTemp;
                }

                public void setMinTemp(String minTemp) {
                    this.minTemp = minTemp;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getDayWtString() {
                    return dayWtString;
                }

                public void setDayWtString(String dayWtString) {
                    this.dayWtString = dayWtString;
                }

                public String getDayImageUrl() {
                    return dayImageUrl;
                }

                public void setDayImageUrl(String dayImageUrl) {
                    this.dayImageUrl = dayImageUrl;
                }

                public String getDayBigImageUrl() {
                    return dayBigImageUrl;
                }

                public void setDayBigImageUrl(String dayBigImageUrl) {
                    this.dayBigImageUrl = dayBigImageUrl;
                }

                public String getDayBgImageUrl() {
                    return dayBgImageUrl;
                }

                public void setDayBgImageUrl(String dayBgImageUrl) {
                    this.dayBgImageUrl = dayBgImageUrl;
                }

                public String getDayWindV() {
                    return dayWindV;
                }

                public void setDayWindV(String dayWindV) {
                    this.dayWindV = dayWindV;
                }

                public String getDayWindD() {
                    return dayWindD;
                }

                public void setDayWindD(String dayWindD) {
                    this.dayWindD = dayWindD;
                }

                public String getNightWtString() {
                    return nightWtString;
                }

                public void setNightWtString(String nightWtString) {
                    this.nightWtString = nightWtString;
                }

                public String getNightImageUrl() {
                    return nightImageUrl;
                }

                public void setNightImageUrl(String nightImageUrl) {
                    this.nightImageUrl = nightImageUrl;
                }

                public String getNightBigImageUrl() {
                    return nightBigImageUrl;
                }

                public void setNightBigImageUrl(String nightBigImageUrl) {
                    this.nightBigImageUrl = nightBigImageUrl;
                }

                public String getNightBgImageUrl() {
                    return nightBgImageUrl;
                }

                public void setNightBgImageUrl(String nightBgImageUrl) {
                    this.nightBgImageUrl = nightBgImageUrl;
                }

                public String getNightWindV() {
                    return nightWindV;
                }

                public void setNightWindV(String nightWindV) {
                    this.nightWindV = nightWindV;
                }

                public String getNightWindD() {
                    return nightWindD;
                }

                public void setNightWindD(String nightWindD) {
                    this.nightWindD = nightWindD;
                }
            }
        }
    }
}
