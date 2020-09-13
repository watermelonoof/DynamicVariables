# DynamicVariable-Kodular-AI2-Extension
Simple extension for adding dynamic variables in AI2 and its disturbution.

# Blocks

<table style = "width:100%">
	<tr>
		<th width = "35%">Blocks</th>
		<th width = "60%">Description</th>
		<th width = "5%">Method Code</th>
	</tr>
	<tr>
		<td>
			<img src = "assets/WhenErrorOccurred.png">
		</td>
		<td>Raises when any error occured. All errors explained in <a href="https://github.com/WaterMelonOof/DynamicVariables-Kodular-AI2-Extension/blob/master/README.md#errors">Errors</a>. <br><br>
		<table>
			<tr>
				<th>Params</th>
				<th>Type</th>
			</tr>
			<tr>
				<td>error</td>
				<td>String</td>
			</tr>
			<tr>
				<td>errorCode</td>
				<td>int</td>
			</tr>
			<tr>
				<td>methodCode</td>
				<td>int</td>
			<tr>
			</table>
		</td>
		<td align = "center">N/A</td>
	</tr>
	<tr>
		<td>
			<img src = "assets/Initialize.png">
		</td>
		<td>Initialize/Change a variable. "name" and "value" can be anything but not nothing. <br><br>
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
		<td align = "center">0</td>
	</tr>
	<tr>
		<td>
			<img src = "assets/InitializeListOfVariables.png">
		</td>
		<td>Initialize/Change list of variables. Both list mustn't be empty. "names" and "values" must a list, and their length must be the same. Variable(s) is/are initialize/change in assending way.<br><br>
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
		<td align = "center">1</td>
	</tr>
	<tr>
		<td>
			<img src = "assets/Get.png">
		</td>
		<td><b>Returns: <i>Any</i></b><br>Get value of a variable. If the variable isn't exist, return "not found".<br><br>
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
		<td align = "center">2</td>
	</tr>
		</table>
	
# Errors
