# Introduction
Here you can compile your own version of my extension.

# Preparation

## Step 0
Get your favourite IDE/text editor. (I recommend VS code. If you want, install the VS code for Java installer [here](https://code.visualstudio.com/docs/languages/java))

## Step 1
<i>Install JDK and ant</i><br>
Follow this tutorial [Configuring your computer to build App Inventor 2 extensions | by Shreyash Saitwal](https://medium.com/@saitwalshreyash19/writing-extensions-for-app-inventor-2-and-kodular-7d20092bff16) until step 2 in that website<br>
<big><b>OR</b></big><br>
This tutorial [Create Extensions - Kodular Docs](https://docs.kodular.io/guides/extensions/create-extensions/) until step 2 in that website

## Step 2
Follow this tutorial to install Git [link](https://www.atlassian.com/git/tutorials/install-git)
Assume you have installed, check your git installation by opening Git Bash, and do
```
$ git version
git version 2.28.0.windows.1
```

## Step 3
There are two folders in this directory. You can choose one of them and download it as zip. Then extract the folder in wherever you want. (for example, C:/extension-template/)
You can see the comparison here by @ysfchn [link](https://community.appinventor.mit.edu/t/extension-template-repository/4452/39)

I am sure that both of them works for this extension.

## Step 4 - Compiling

### <b>If you are using "appinventor-sources-master",</b>

The .java file is located in "...\appinventor-sources-master\appinventor\components\src\com\watermelonice\DynamicVariables"

When you are ready, go to ".../appinventor-sources-master/appinventor" in file explorer, right-click and choose git bash here. Execute `ant extensions`.
Or you can open `cmd`, `powershell`,`git bash` or any other terminal directly, type `cd (the directory of ".../appinventor-sources-master/appinventor")` and execute `ant extenions` there.

If you see `BUILD SUCESSFUL`, that's mean you have sucessfully compile the extension! The aix file will be located in ".../appinventor-sources-master\appinventor\components\build\extensions".

If you see `BUILD FAILED`, that's mean there're something wrong in your code.


### <b>If you are using "extensions-template",</b>

The .java file is located in "...\extension-template\src\com\watermelonice\DynamicVariables"

When you are ready, go to ".../extension-template" in file explorer, right-click and choose git bash here. Execute `ant extensions`.
Or you can open `cmd`, `powershell`, `git bash`, or any other terminal directly, type `cd (the directory of ".../extension-template")` and execute `ant extenions` there.

If you see `BUILD SUCESSFUL`, that's mean you have sucessfully compile the extension! The aix file will be located in ".../extension-template/out".

If you see `BUILD FAILED`, that's mean there're something wrong in your code.
