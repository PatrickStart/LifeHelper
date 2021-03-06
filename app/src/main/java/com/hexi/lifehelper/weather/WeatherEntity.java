package com.hexi.lifehelper.weather;

import java.io.Serializable;
import java.util.List;

/**
 * Created by he.xx on 2016/8/1.
 */
public class WeatherEntity implements Serializable{
    private String resultcode;
    private String reason;
    private Result result;

    public WeatherEntity(String resultcode, String reason, Result result, String error_code) {
        this.resultcode = resultcode;
        this.reason = reason;
        this.result = result;
        this.error_code = error_code;
    }


    public String getResultcode() {
        return resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public class Result{
        public Result(Sk sk, Today today, List<Future> future) {
            this.sk = sk;
            this.today = today;
            this.future = future;
        }

        public Sk getSk() {
            return sk;
        }

        public void setSk(Sk sk) {
            this.sk = sk;
        }

        public Today getToday() {
            return today;
        }

        public void setToday(Today today) {
            this.today = today;
        }

        public List<Future> getFuture() {
            return future;
        }

        public void setFuture(List<Future> future) {
            this.future = future;
        }

        private Sk sk;
        private Today today;
        private List<Future> future;
        public class Sk{
            private String temp;
            private String wind_direction;
            private String wind_strength;
            private String humidity;
            private String time;

            public Sk(String temp, String wind_direction, String wind_strength, String humidity, String time) {
                this.temp = temp;
                this.wind_direction = wind_direction;
                this.wind_strength = wind_strength;
                this.humidity = humidity;
                this.time = time;
            }

            public String getTemp() {
                return temp;
            }

            public void setTemp(String temp) {
                this.temp = temp;
            }

            public String getWind_direction() {
                return wind_direction;
            }

            public void setWind_direction(String wind_direction) {
                this.wind_direction = wind_direction;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getWind_strength() {
                return wind_strength;
            }

            public void setWind_strength(String wind_strength) {
                this.wind_strength = wind_strength;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }
        }

        public class Today{
            private String city;
            private String date_y;
            private String week;
            private String temperature;
            private String weather;

            private WeatherId weather_id;
            public class WeatherId{
                private int fa;
                private int fb;
            }
            private String wind;
            private String dressing_index;
            private String dressing_advice;
            private String uv_index;
            private String comfort_index;
            private String wash_index;
            private String travel_index;
            private String exercise_index;
            private String drying_index;

            public Today(String city, String date_y, String week, String temperature, String weather, WeatherId weather_id, String wind, String dressing_index, String dressing_advice, String comfort_index, String uv_index, String wash_index, String travel_index, String exercise_index, String drying_index) {
                this.city = city;
                this.date_y = date_y;
                this.week = week;
                this.temperature = temperature;
                this.weather = weather;
                this.weather_id = weather_id;
                this.wind = wind;
                this.dressing_index = dressing_index;
                this.dressing_advice = dressing_advice;
                this.comfort_index = comfort_index;
                this.uv_index = uv_index;
                this.wash_index = wash_index;
                this.travel_index = travel_index;
                this.exercise_index = exercise_index;
                this.drying_index = drying_index;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getDate_y() {
                return date_y;
            }

            public void setDate_y(String date_y) {
                this.date_y = date_y;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public WeatherId getWeather_id() {
                return weather_id;
            }

            public void setWeather_id(WeatherId weather_id) {
                this.weather_id = weather_id;
            }

            public String getWind() {
                return wind;
            }

            public void setWind(String wind) {
                this.wind = wind;
            }

            public String getDressing_index() {
                return dressing_index;
            }

            public void setDressing_index(String dressing_index) {
                this.dressing_index = dressing_index;
            }

            public String getDressing_advice() {
                return dressing_advice;
            }

            public void setDressing_advice(String dressing_advice) {
                this.dressing_advice = dressing_advice;
            }

            public String getUv_index() {
                return uv_index;
            }

            public void setUv_index(String uv_index) {
                this.uv_index = uv_index;
            }

            public String getComfort_index() {
                return comfort_index;
            }

            public void setComfort_index(String comfort_index) {
                this.comfort_index = comfort_index;
            }

            public String getWash_index() {
                return wash_index;
            }

            public void setWash_index(String wash_index) {
                this.wash_index = wash_index;
            }

            public String getTravel_index() {
                return travel_index;
            }

            public void setTravel_index(String travel_index) {
                this.travel_index = travel_index;
            }

            public String getExercise_index() {
                return exercise_index;
            }

            public void setExercise_index(String exercise_index) {
                this.exercise_index = exercise_index;
            }

            public String getDrying_index() {
                return drying_index;
            }

            public void setDrying_index(String drying_index) {
                this.drying_index = drying_index;
            }
        }
        public class Future{
            private String temperature;
            private String weather;
            private WeatherId weather_id;
            public class WeatherId{
                private int fa;
                private int fb;
            }
            private String wind;
            private String week;
            private String date;

            public Future(String temperature, String weather, WeatherId weather_id, String wind, String week, String date) {
                this.temperature = temperature;
                this.weather = weather;
                this.weather_id = weather_id;
                this.wind = wind;
                this.week = week;
                this.date = date;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public WeatherId getWeather_id() {
                return weather_id;
            }

            public void setWeather_id(WeatherId weather_id) {
                this.weather_id = weather_id;
            }

            public String getWind() {
                return wind;
            }

            public void setWind(String wind) {
                this.wind = wind;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            @Override
            public String toString() {
                return date +"\t\t" + week+"\n"+
                "温度：'" + temperature + "\t\t"
                        + weather
                        +"\t"+ wind
                        + "\n";
            }
        }



    }

    private String error_code;

    @Override
    public String toString() {
        return "WeatherEntity{" +
                "resultcode='" + resultcode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                ", error_code='" + error_code + '\'' +
                '}';
    }
}
