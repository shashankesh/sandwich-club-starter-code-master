package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {
    public static Sandwich parseSandwichJson(String json) {
        JSONObject root = null;
        try {
            root = new JSONObject(json);
        JSONObject name = root.getJSONObject("name");
        String mainName = name.getString("mainName");
        JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
        ArrayList<String> temp = new ArrayList<String>();
        for(int i=0;i<alsoKnownAs.length();i++){
            temp.add(alsoKnownAs.getString(i));
        }
        String placeOfOrigin = root.getString("placeOfOrigin");
        String description = root.getString("description");
        String image = root.getString("image");
        JSONArray ingredients = root.getJSONArray("ingredients");
        ArrayList<String> temp1 = new ArrayList<String>();
    for(int i=0;i<ingredients.length();i++){
            temp1.add(ingredients.getString(i));
        }
           return new Sandwich(mainName,temp,placeOfOrigin,description,image,temp1);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
