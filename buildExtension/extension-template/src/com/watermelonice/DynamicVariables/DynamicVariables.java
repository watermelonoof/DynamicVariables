package com.watermelonice.DynamicVariables;

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.common.ComponentCategory;

import com.google.appinventor.components.runtime.util.YailList;

import java.util.*;

@DesignerComponent(version = 1,
                   versionName = "1.0",
                   helpUrl = "https://github.com/WaterMelonOof/DynamicVariables-Kodular-AI2-Extension",
                   description = "This Extension is created to create dynamic variables. <br> Craeted by WatermelonIce <br><br> <b>My Profile in Kodular Community: </b><a href=\"https://community.kodular.io/u/WatermelonIce/summary\">My Profile</a><br><b>Support me by subscribing my YouTube Channel: </b> <a href=\"https://www.youtube.com/channel/UCBq9ouxr4C4OZG0sMCgmpwg\">WatermelonIce YouTube Channel</a>",
                   category = ComponentCategory.EXTENSION,
                   nonVisible = true,
                   iconName = "aiwebres/profile.png")
@SimpleObject(external = true)
public class DynamicVariables extends AndroidNonvisibleComponent {
    private ComponentContainer container;

    public DynamicVariables(ComponentContainer container) {
        super(container.$form());
        this.container = container;
    }
  	
  	// All data
  	private static Hashtable<Object, Object> data = new Hashtable<>();
  
    // Errors
    private static final String EMPTYLIST = "List cannot be empty";
    private static final String LENGTHOFLIST = "Length of both list must be same";
    private static final String OLDVARNOTEXIST = "Old variable doesn't exist";

    // Create Variable
  	private void CreateVar(Object name, Object value) {
        data.put(name, value);
    }
  
  	private Object GetVar(Object name) {
        Object result = null;
        result = data.get(name);
        if (result == null) {
          result = "not found";
        }
        return result;
    }
  	
  	private void RenameVar(Object oldName, Object newName) {
        
        Object value = data.remove(oldName);
        CreateVar(newName, value);

    }
  
  	private boolean checkListLength(YailList first, YailList second) {
        return (first.size() == second.size());
    }
  	
  	private YailList reverseList(Object[] original) {
        List<Object> result = Arrays.asList(original);
        Collections.reverse(result);
        return YailList.makeList(result);
    }
  
  	@SimpleEvent(description = "Raises when any error occured")
  	public void ErrorOccurred(String error, int errorCode, int methodCode) {
        EventDispatcher.dispatchEvent(this, "ErrorOccurred", error, errorCode, methodCode);
    }
  
	@SimpleFunction(description = "Initialize/Change a variable. \"name\" and \"value\" can be anything but not nothing.")
  	public void Initialize(Object name, Object value){
        try {
            CreateVar(name, value);
        } catch (Exception e) {
            ErrorOccurred(e.getMessage(), 0, 0);
        }
    }
  
    @SimpleFunction(description = "Initialize/Change list of variables. Both list mustn't be empty. \"names\" and \"values\" must a list, and their length must be the same. Variable(s) is/are initialize/change in assending way.")
    public void InitializeListOfVariables(YailList names, YailList values) {
      
        if ((names.isEmpty()) || (values.isEmpty())) {
            ErrorOccurred(EMPTYLIST, 1, 1);
        } else if (!(checkListLength(names, values))) {
            ErrorOccurred(LENGTHOFLIST, 2, 1);
        } else {
        
            try {
                Object[] namesArr = names.toArray();
                Object[] valuesArr = values.toArray();
                for(int i = 0; i < names.size(); i++) {
                    CreateVar(namesArr[i], valuesArr[i]);
                }
            } catch (Exception e) {
                ErrorOccurred(e.getMessage(), 0, 1);
            }
        }
    }
  
  	@SimpleFunction(description = "Get value of a variable. If the variable isn't exist, return \"not found\".")
  	public Object Get(Object name) {
        try {
            return GetVar(name);
        } catch (Exception e) {
            ErrorOccurred(e.getMessage(), 0, 2);
            return "error";
        }
    }
  
  	@SimpleFunction(description = "Get list of values. Input should be a list of variable's name. Output will a list of values in the order of input list. If any of the names isn't exist, that item will be \"not found\". If the input list is empty, or any error occurred, return an empty list.")
  	public YailList GetListOfValues(YailList names) {
        if (names.isEmpty()) {
            ErrorOccurred(EMPTYLIST, 1, 3);
            return new YailList();
        } else {
            try {
                List<Object> list = new ArrayList<>();
                for (Object i : names.toArray()) {
                    list.add(GetVar(i));
                }
                return YailList.makeList(list);
            } catch (Exception e) {
                ErrorOccurred(e.getMessage(), 0, 3);
                return new YailList();
            }
        }
    }
  	
  	@SimpleFunction(description = "Get all variable's names. Return an empty list if there's no variable, or when error occured.")
  	public YailList GetAllNames() {
        try {
            return reverseList(data.keySet().toArray());
        } catch (Exception e) {
            ErrorOccurred(e.getMessage(), 0, 4);
            return new YailList();
        }
      
    }
  	@SimpleFunction(description = "Get all values. Return an empty list if there's no variable, or when error occurred.")
  	public YailList GetAllValues() {
        try {
            return reverseList(data.values().toArray());
        } catch (Exception e) {
            ErrorOccurred(e.getMessage(), 0, 5);
            return new YailList();
        }
      
    }
  
  	@SimpleFunction(description = "Rename a variable. If the old variable doesn't exist, error will occur.")
  	public void Rename(Object oldName, Object newName) {
        if (!(data.containsKey(oldName))) {
            ErrorOccurred(OLDVARNOTEXIST, 3, 6);
        } else {
            try {
                RenameVar(oldName, newName);
            } catch (Exception e) {
                ErrorOccurred(e.getMessage(), 0, 6);
            }
        }    
    }
  
  	@SimpleFunction(description = "Rename a list of varibles. All list must not be empty. Length of both list must be the same. This method will rename variable(s) in assending order. If any one of the oldName doesn't exist, error will occur, but the oldNames before the error occurred will be renamed.")
  	public void RenameListOfVariables(YailList oldNames, YailList newNames) {
        if ((oldNames.isEmpty()) || (newNames.isEmpty())) {
            ErrorOccurred(EMPTYLIST, 1, 7);
        } else if (!(checkListLength(oldNames, newNames))) {
            ErrorOccurred(LENGTHOFLIST, 2, 7);
        } else {
            try {
                Object [] oldArr = oldNames.toArray();
                Object [] newArr = newNames.toArray();
                for (int i = 0; i < oldNames.size(); i++) {
                    RenameVar(oldArr[i], newArr[i]);
                }
            } catch (Exception e) {
                ErrorOccurred(e.getMessage(), 0, 7);
            }
        }
    }
  
  	@SimpleFunction(description = "Remove a variable. Return removed value. If variable's name doesn't exist, error will occur and return an empty string.")
  	public Object Remove(Object name) {
        try {
            return data.remove(name);
        } catch (Exception e) {
            ErrorOccurred(e.getMessage(), 0, 8);
            return "";
        }
      
    }

   	@SimpleFunction(description = "Remove list of variables. Return a list of removed values. If any of variable's name doesn't exist, error will occur and return list of values that removed before the error occurred.")
  	public YailList RemoveListOfVariables(YailList names) {
        if (names.isEmpty()) {
            ErrorOccurred(EMPTYLIST, 1, 9);
            return new YailList();
        } else {
            try {
                List<Object> arr = new ArrayList<>();
                for (Object key : names.toArray()) {
                    arr.add(data.remove(key));
                }
                return YailList.makeList(arr);
            } catch (Exception e) {
                ErrorOccurred(e.getMessage(), 0, 9);
                return new YailList();
            }
        }
    }
  
  	@SimpleFunction(description = "Remove all variables. If there's no variable exist, nothing will happen.")
  	public void RemoveAll() {
          try {
            data.clear(); 
          } catch (Exception e) {
            ErrorOccurred(e.getMessage(), 0, 10);
          }
    }
  
  	@SimpleFunction(description = "Check if specific variable name exist. Return true of variable exists, otherwise false. Return false if error occurred.")
  	public boolean IsVariableExist(Object name) {
        try {
            return data.containsKey(name);
        } catch (Exception e) {
            ErrorOccurred(e.getMessage(), 0, 11);
            return false;
        }
      
    }
  
  	@SimpleFunction(description = "Return the number of variables. Return -1 if error occurred.")
  	public int NumOfVariables() {
        try {
            return data.size();
        } catch (Exception e) {
            ErrorOccurred(e.getMessage(), 0, 12);
            return -1;
        }
      
    }
  
  	@SimpleFunction(description = "Check if any variables exist. Return true if no variable exists, otherwise false. If error occurred, return false.")
  	public boolean IsEmpty() {
        try {
            return data.isEmpty();
        } catch (Exception e) {
            ErrorOccurred(e.getMessage(), 0, 13);
            return false;
        }
      
    }
}