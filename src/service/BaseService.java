package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public interface BaseService<T> {
    String userPath = "C:\\Users\\User\\IdeaProjects\\Payme\\src\\recurse\\User.json";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    int add(T t);

}
