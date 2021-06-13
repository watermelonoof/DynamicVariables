package com.watermelonice.DynamicVariables;

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.YailList;

import java.util.*;

@DesignerComponent(version = 2, versionName = "1.1", helpUrl = "https://github.com/WatermelonOof/DynamicVariables-Kodular-AI2-Extension", description = "This extension is created to create dynamic variables. <br> Created by WatermelonIce <br><br> <b>My Profile in Kodular Community: </b><a href=\"https://community.kodular.io/u/WatermelonIce/summary\">My Profile</a><br><b>Support me by subscribing my YouTube Channel: </b> <a href=\"https://www.youtube.com/channel/UCBq9ouxr4C4OZG0sMCgmpwg\">WatermelonIce YouTube Channel</a>", category = ComponentCategory.EXTENSION, nonVisible = true, iconName = "aiwebres/profile.png")
@SimpleObject(external = true)
public class DynamicVariables extends AndroidNonvisibleComponent {

    public DynamicVariables(ComponentContainer container) {
        super(container.$form());
    }

    private static java.util.Map<String, Object> data = new HashMap<>();

    @SimpleEvent(description = "Raises when any errors occured")
    public void ErrorOccurred(String error) {
        EventDispatcher.dispatchEvent(this, "ErrorOccurred", error);
    }

    @SimpleFunction(description = "Initialize a variable.")
    public void Initialize(String name, Object value) {
        try {
            data.put(name, value);
        } catch (Exception e) {
            ErrorOccurred(e.getMessage());
        }
    }

    @SimpleFunction(description = "Initialize list of variables. Both list mustn't be empty. \"names\" and \"values\" must a list, and their length must be the same.")
    public void InitializeListOfVariables(YailList names, YailList values) {
        if ((names.isEmpty()) || (values.isEmpty())) {
            ErrorOccurred(Errors.EMPTY_LIST.getMessage());
            return;
        }

        if (names.size() != values.size()) {
            ErrorOccurred(Errors.LENGTH_OF_LIST.getMessage());
            return;
        }

        try {
            Object[] namesArr = names.toArray();
            Object[] valuesArr = values.toArray();
            for (int i = 0; i < names.size(); i++) {
                data.put(namesArr[i].toString(), valuesArr[i]);
            }
        } catch (Exception e) {
            ErrorOccurred(e.getMessage());
        }
    }

    @SimpleFunction(description = "Get the value of a variable. If the variable doesn't exist, return null.")
    public Object Get(String name) {
        try {
            return Objects.requireNonNull(data.get(name), Errors.VAR_NOT_EXIST.getMessage());
        } catch (Exception e) {
            ErrorOccurred(e.getMessage());
            return "null";
        }
    }

    @SimpleFunction(description = "Get a list of values. The input should be a list of variable's names. If any of the variables doesn't exist, that item will be null. If the input list is empty, or any errors occurred, return an empty list.")
    public YailList GetListOfValues(YailList names) {
        if (names.isEmpty()) {
            ErrorOccurred(Errors.EMPTY_LIST.getMessage());
            return new YailList();
        }

        try {
            List<Object> list = new ArrayList<>();
            for (Object name : names.toArray()) {
                
                list.add(Get(name.toString()));
            }
            return YailList.makeList(list);
        } catch (Exception e) {
            ErrorOccurred(e.getMessage());
            return new YailList();
        }
    }

    @SimpleFunction(description = "Get variables' names by its value. Return an empty list if there are no variables, or when error occured.")
    public YailList GetNameByValue(Object value) {
        try {
            List<String> resultList = new ArrayList<>();
            for (java.util.Map.Entry<String, Object> en : data.entrySet()) {
                if (en.getValue().equals(value)) resultList.add(en.getKey());
            }
            return YailList.makeList(resultList);
        } catch (Exception e) {
            ErrorOccurred(e.getMessage());
            return new YailList();
        }
        
    }

    @SimpleFunction(description = "Get all of the variable's names. Return an empty list if there are no variables, or when error occured.")
    public YailList GetAllNames() {
        try {
            return YailList.makeList(data.keySet());
        } catch (Exception e) {
            ErrorOccurred(e.getMessage());
            return new YailList();
        }
    }

    @SimpleFunction(description = "Get all of the values. Return an empty list if there are no variables, or when error occurred.")
    public YailList GetAllValues() {
        try {
            return YailList.makeList(data.values());
        } catch (Exception e) {
            ErrorOccurred(e.getMessage());
            return new YailList();
        }
    }

    @SimpleFunction(description = "Rename a variable. If the old variable doesn't exist, error will occur.")
    public void Rename(String oldName, String newName) {
        if (!(data.containsKey(oldName))) {
            ErrorOccurred(Errors.OLD_VAR_NOT_EXIST.getMessage());
            return;
        }

        try {
            data.put(newName, data.remove(oldName));
        } catch (Exception e) {
            ErrorOccurred(e.getMessage());
        }
    }

    @SimpleFunction(description = "Rename a list of varibles. All list must not be empty. Length of both list must be the same. If any one of the old names doesn't exist, error will occur.")
    public void RenameListOfVariables(YailList oldNames, YailList newNames) {
        if ((oldNames.isEmpty()) || (newNames.isEmpty())) {
            ErrorOccurred(Errors.EMPTY_LIST.getMessage());
            return;
        }

        if (oldNames.size() != newNames.size()) {
            ErrorOccurred(Errors.LENGTH_OF_LIST.getMessage());
            return;
        }

        try {
            Object[] oldArr = oldNames.toArray();
            Object[] newArr = newNames.toArray();
            for (int i = 0; i < oldNames.size(); i++) {
                if (!(data.containsKey(oldArr[i].toString()))) {
                    ErrorOccurred(Errors.OLD_VAR_NOT_EXIST.getMessage());
                    continue;
                }
                data.put(oldArr[i].toString(), data.remove(newArr[i].toString()));
            }
        } catch (Exception e) {
            ErrorOccurred(e.getMessage());
        }
    }

    @SimpleFunction(description = "Remove a variable and return removed value. If the variable doesn't exist, return null.")
    public Object Remove(String name) {
        try {
            return Objects.requireNonNull(data.remove(name), Errors.VAR_NOT_EXIST.getMessage());
        } catch (Exception e) {
            ErrorOccurred(e.getMessage());
            return "null";
        }
    }

    @SimpleFunction(description = "Remove list of variables and return a list of removed values. If any of variable's name doesn't exist, that item of the list will be null.")
    public YailList RemoveListOfVariables(YailList names) {
        if (names.isEmpty()) {
            ErrorOccurred(Errors.EMPTY_LIST.getMessage());
            return new YailList();
        }

        try {
            List<Object> arr = new ArrayList<>();
            for (Object key : names.toArray()) {
                arr.add(Remove(key.toString()));
            }
            return YailList.makeList(arr);
        } catch (Exception e) {
            ErrorOccurred(e.getMessage());
            return new YailList();
        }
    }

    @SimpleFunction(description = "Remove all variables.")
    public void RemoveAll() {
        try {
            data.clear();
        } catch (Exception e) {
            ErrorOccurred(e.getMessage());
        }
    }

    @SimpleFunction(description = "Check if given variable name exists. Return true if variable exists, otherwise false. Return false if an error occurred.")
    public boolean KeyExist(String name) {
        try {
            return data.containsKey(name);
        } catch (Exception e) {
            ErrorOccurred(e.getMessage());
            return false;
        }
    }

    @SimpleFunction(description = "Check if given value exists. Return true if value exists, otherwise false. Return false if an error occurred.")
    public boolean ValueExist(String value) {
        try {
            return data.containsValue(value);
        } catch (Exception e) {
            ErrorOccurred(e.getMessage());
            return false;
        }
    }

    @SimpleFunction(description = "Return the number of variables. Return -1 if an error occurred.")
    public int Size() {
        try {
            return data.size();
        } catch (Exception e) {
            ErrorOccurred(e.getMessage());
            return -1;
        }

    }

    @SimpleFunction(description = "Check if any variables exist. Return true if no variable exists, otherwise false. Return false if an error occurred.")
    public boolean IsEmpty() {
        try {
            return data.isEmpty();
        } catch (Exception e) {
            ErrorOccurred(e.getMessage());
            return false;
        }
    }
}