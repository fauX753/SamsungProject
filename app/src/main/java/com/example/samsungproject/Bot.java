package com.example.samsungproject;

import android.content.Context;

import org.json.JSONObject;


public class Bot {
    private String[] hello = {"Привет","Хай","Алоха","Здравствуйте","Добрый день"};
    private String[] howAreYou = {"Нормально","Более менее","Пойдёт","По-тихоньку развиваюсь"};
    private String[] bye = {"До свидания","Возвращайся скорее","Удачи"};

    public String answer(String input, Context context, Boolean cityB) {

        input = input.toLowerCase();
        String answer, city = "";

        if(cityB){
            city = input;
            input = "погода";
        }

        switch (input) {
            case "хай": case "здарова": case "добрый день": case "привет":
                answer = hello[(int) (Math.random()*hello.length)];
                break;
            case "до свидания": case "пойду спать": case "удачи": case "пока":
                answer = bye[(int) (Math.random()*bye.length)];
                break;
            case "как дела": case "как ты": case "как поживаешь":
                answer = howAreYou[(int)(Math.random()*howAreYou.length)];
                break;
            case "погода": case "какая сегодня погода": case "какая погода сегодня":
                if(cityB){
                    try {
                        Weather w = new Weather();
                        JSONObject data = w.getJSON(context, city);
                        answer = "Погода в городе" + city + ": "+"\n"+"Температура (min/max):"
                                + data.getString("temp_min")
                                    + "/" + data.getString("temp_max");
                    }catch (Exception e){
                        answer = e.toString();
                    }
                    break;
                }else{
                    answer = "Введите город";
                    break;
                }
            default:
                answer = "Я пока не знаю что ответить(";
                break;
        }

        return answer;
    }

}
