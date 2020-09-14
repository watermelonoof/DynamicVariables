---
layout: documentation
title: Extension
---

[&laquo; Back to index](index.html)
# Extension

Table of Contents:

* [DynamicVariables](#DynamicVariables)

## DynamicVariables  {#DynamicVariables}

Component for DynamicVariables



### Properties  {#DynamicVariables-Properties}

{:.properties}
None


### Events  {#DynamicVariables-Events}

{:.events}

{:id="DynamicVariables.ErrorOccurred"} ErrorOccurred(*error*{:.text},*errorCode*{:.number},*methodCode*{:.number})
: Raises when any error occured

### Methods  {#DynamicVariables-Methods}

{:.methods}

{:id="DynamicVariables.Get" class="method returns any"} <i/> Get(*name*{:.any})
: Get value of a variable. If the variable isn't exist, return "not found".

{:id="DynamicVariables.GetAllNames" class="method returns list"} <i/> GetAllNames()
: Get all variable's names. Return an empty list if there's no variable, or when error occured.

{:id="DynamicVariables.GetAllValues" class="method returns list"} <i/> GetAllValues()
: Get all values. Return an empty list if there's no variable, or when error occurred.

{:id="DynamicVariables.GetListOfValues" class="method returns list"} <i/> GetListOfValues(*names*{:.list})
: Get list of values. Input should be a list of variable's name. Output will a list of values in the order of input list. If any of the names isn't exist, that item will be "not found". If the input list is empty, or any error occurred, return an empty list.

{:id="DynamicVariables.Initialize" class="method"} <i/> Initialize(*name*{:.any},*value*{:.any})
: Initialize/Change a variable. "name" and "value" can be anything but not nothing.

{:id="DynamicVariables.InitializeListOfVariables" class="method"} <i/> InitializeListOfVariables(*names*{:.list},*values*{:.list})
: Initialize/Change list of variables. Both list mustn't be empty. "names" and "values" must a list, and their length must be the same. Variable(s) is/are initialize/change in assending way.

{:id="DynamicVariables.IsEmpty" class="method returns boolean"} <i/> IsEmpty()
: Check if any variables exist. Return true if no variable exists, otherwise false. If error occurred, return false.

{:id="DynamicVariables.IsVariableExist" class="method returns boolean"} <i/> IsVariableExist(*name*{:.any})
: Check if specific variable name exist. Return true of variable exists, otherwise false. Return false if error occurred.

{:id="DynamicVariables.NumOfVariables" class="method returns number"} <i/> NumOfVariables()
: Return the number of variables. Return -1 if error occurred.

{:id="DynamicVariables.Remove" class="method returns any"} <i/> Remove(*name*{:.any})
: Remove a variable. Return removed value. If variable's name doesn't exist, error will occur and return an empty string.

{:id="DynamicVariables.RemoveAll" class="method"} <i/> RemoveAll()
: Remove all variables. If there's no variable exist, nothing will happen.

{:id="DynamicVariables.RemoveListOfVariables" class="method returns list"} <i/> RemoveListOfVariables(*names*{:.list})
: Remove list of variables. Return a list of removed values. If any of variable's name doesn't exist, error will occur and return list of values that removed before the error occurred.

{:id="DynamicVariables.Rename" class="method"} <i/> Rename(*oldName*{:.any},*newName*{:.any})
: Rename a variable. If the old variable doesn't exist, error will occur.

{:id="DynamicVariables.RenameListOfVariables" class="method"} <i/> RenameListOfVariables(*oldNames*{:.list},*newNames*{:.list})
: Rename a list of varibles. All list must not be empty. Length of both list must be the same. This method will rename variable(s) in assending order. If any one of the oldName doesn't exist, error will occur, but the oldNames before the error occurred will be renamed.
