# DynamicVariables Extension
Simple extension for adding dynamic variables in AI2 and its distributions.

# Blocks

<table style = "width:100%">
	<tr>
		<th>Blocks</th>
		<th>Description</th>
	</tr>
	<tr>
		<td>
			<img src = "assets/WhenErrorOccurred.png">
		</td>
		<td>Raises when any error occured.<br><br>
		<table>
			<tr>
				<th>Params</th>
				<th>Type</th>
			</tr>
			<tr>
				<td>error</td>
				<td>String</td>
			</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<img src = "assets/Initialize.png">
		</td>
		<td>Initialize a variable.<br><br>
		<table>
			<tr>
				<th>Params</th>
				<th>Type</th>
			</tr>
			<tr>
				<td>name</td>
				<td>Any</td>
			</tr>
			<tr>
				<td>value</td>
				<td>Any</td>
			</tr>
			</table>
		</td>
			</tr>
	<tr>
		<td>
			<img src = "assets/InitializeListOfVariables.png">
		</td>
		<td>Initialize list of variables. Both list mustn't be empty. "names" and "values" must a list, and their length must be the same.<br><br>
		<table>
			<tr>
				<th>Params</th>
				<th>Type</th>
			</tr>
			<tr>
				<td>names</td>
				<td>List</td>
			</tr>
			<tr>
				<td>values</td>
				<td>List</td>
			</tr>
			</table>
		</td>
			</tr>
	<tr>
		<td>
			<img src = "assets/Get.png">
		</td>
		<td><b>Returns: <i>Any</i></b><br>Get the value of a variable. If the variable doesn't exist, return null.<br><br>
		<table>
			<tr>
				<th>Params</th>
				<th>Type</th>
			</tr>
			<tr>
				<td>name</td>
				<td>Any</td>
			</tr>
			</table>
		</td>
			</tr>
	<tr>
		<td>
			<img src = "assets/GetListOfValues.png">
		</td>
		<td><b>Returns: <i>List</i></b><br>Get a list of values. The input should be a list of variable's names. If any of the variables doesn't exist, that item will be null. If the input list is empty, or any errors occurred, return an empty list.<br><br>
		<table>
			<tr>
				<th>Params</th>
				<th>Type</th>
			</tr>
			<tr>
				<td>names</td>
				<td>List</td>
			</tr>
			</table>
		</td>
			</tr>
	<tr>
		<td>
			<img src = "assets/GetNameByValue.png">
		</td>
		<td><b>Returns: <i>List</i></b><br>Get variables' names by its value. Return an empty list if there are no variables, or when error occured.<br><br>
		<table>
			<tr>
				<th>Params</th>
				<th>Type</th>
			</tr>
			<tr>
				<td>value</td>
				<td>Any</td>
			</tr>
			</table>
		</td>
			</tr>
	<tr>
		<td>
			<img src = "assets/GetAllNames.png">
		</td>
		<td><b>Returns: <i>List</i></b><br>Get all of the variable names. Return an empty list if there are no variables, or when error occured.</td>
			</tr>
	<tr>
		<td>
			<img src = "assets/GetAllValues.png">
		</td>
		<td><b>Returns: <i>List</i></b><br>Get all of the values. Return an empty list if there are no variables, or when error occurred.</td>
			</tr>
	<tr>
		<td>
			<img src = "assets/Rename.png">
		</td>
		<td>Rename a variable. If the old variable doesn't exist, error will occur.<br><br>
		<table>
			<tr>
				<th>Params</th>
				<th>Type</th>
			</tr>
			<tr>
				<td>oldName</td>
				<td>Any</td>
			</tr>
			<tr>
				<td>newName</td>
				<td>Any</td>
			</tr>
		</table>
		</td>
			</tr>
	<tr>
		<td>
			<img src = "assets/RenameListOfVariables.png">
		</td>
		<td>Rename a list of varibles. All list must not be empty. Length of both list must be the same. If any one of the old names doesn't exist, error will occur.<br><br>
		<table>
			<tr>
				<th>Params</th>
				<th>Type</th>
			</tr>
			<tr>
				<td>oldNames</td>
				<td>List</td>
			</tr>
			<tr>
				<td>newNames</td>
				<td>List</td>
			</tr>
		</table>
		</td>
			</tr>
	<tr>
		<td>
			<img src = "assets/Remove.png">
		</td>
		<td><b>Returns: <i>Any</i></b><br>Remove a variable and return removed value. If the variable doesn't exist, return null.<br><br>
		<table>
			<tr>
				<th>Params</th>
				<th>Type</th>
			</tr>
			<tr>
				<td>name</td>
				<td>Any</td>
			</tr>
			</table>
		</td>
			</tr>
	<tr>
		<td>
			<img src = "assets/RemoveListOfVariables.png">
		</td>
		<td><b>Returns: <i>List</i></b><br>Remove list of variables and return a list of removed values. If any of variable's name doesn't exist, that item of the list will be null.<br><br>
		<table>
			<tr>
				<th>Params</th>
				<th>Type</th>
			</tr>
			<tr>
				<td>names</td>
				<td>List</td>
			</tr>
			</table>
		</td>
			</tr>
	<tr>
		<td>
			<img src = "assets/RemoveAll.png">
		</td>
		<td>Remove all variables.</td>
	</tr>
	<tr>
		<td>
			<img src = "assets/NameExist.png">
		</td>
		<td><b>Returns: <i>Boolean</i></b><br>Check if given variable name exists. Return true if variable exists, otherwise false. Return false if an error occurred.<br><br>
		<table>
			<tr>
				<th>Params</th>
				<th>Type</th>
			</tr>
			<tr>
				<td>name</td>
				<td>Any</td>
			</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<img src = "assets/ValueExist.png">
		</td>
		<td><b>Returns: <i>Boolean</i></b><br>Check if given value exists. Return true if value exists, otherwise false. Return false if an error occurred.<br><br>
		<table>
			<tr>
				<th>Params</th>
				<th>Type</th>
			</tr>
			<tr>
				<td>value</td>
				<td>Any</td>
			</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<img src = "assets/Size.png">
		</td>
		<td><b>Returns: <i>Number (int)</i></b><br>Return the number of variables. Return -1 if an error occurred.</td>
	</tr>
	<tr>
		<td>
			<img src = "assets/IsEmpty.png">
		</td>
		<td><b>Returns: <i>Boolean</i></b><br>Check if any variables exist. Return true if no variable exists, otherwise false. Return false if an error occurred.</td>
	</tr>
		</table>
	
# Change Log
## Version 2 (1.1)
- Removed method code and error code; they are useless
- Changed `NumOfVariables` to `Size`
- Changed `IsVariableExist` to `NameExist`
- Added `ValueExist`
- Added `GetNameByValue`
- Some methods return `"null"` instead of `"not found"`

# Reference
[Kodular Community](https://community.kodular.io/t/free-open-source-dynamic-variables-create-dynamic-variables/83592) | [MIT AI2 Community](https://community.appinventor.mit.edu/t/free-open-source-dynamic-variables-create-dynamic-variables/16321)
