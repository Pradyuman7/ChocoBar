# ChocoBar

[![](https://www.jitpack.io/v/Pradyuman7/ChocoBar.svg)](https://www.jitpack.io/#Pradyuman7/ChocoBar)
[ ![Download](https://api.bintray.com/packages/pradyuman7/ChocoBar/ChocoBar/images/download.svg) ](https://bintray.com/pradyuman7/ChocoBar/ChocoBar/_latestVersion)
[![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-ChocoBar-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/7415)

<p align="center">
  <img width="250" height="250" src="https://user-images.githubusercontent.com/41565823/50545792-3f2c5b80-0c1c-11e9-81e6-23b0035c7b4c.gif">
</p>

<p align="center">
  The usual Snackbar with more 🍫 and colours :tada:. Inspired by <a href="https://github.com/TonnyL/Light"> Light</a>.
</p>

## Screenshots

**Preview of Different kinds of ChocoBars you can use**

![screenshot 2018-12-31 at 4 26 25 am](https://user-images.githubusercontent.com/41565823/50554067-56b72300-0cb4-11e9-8b04-8f12b09820d9.png)
![screenshot 2018-12-31 at 4 24 32 am](https://user-images.githubusercontent.com/41565823/50554071-574fb980-0cb4-11e9-9c0d-95f0df30f72c.png)
![screenshot 2018-12-31 at 4 25 38 am](https://user-images.githubusercontent.com/41565823/50554069-574fb980-0cb4-11e9-95f5-df24d2a56a96.png)
![screenshot 2018-12-31 at 4 25 09 am](https://user-images.githubusercontent.com/41565823/50554070-574fb980-0cb4-11e9-8a7d-0ab8b061e120.png)
![screenshot 2018-12-31 at 4 26 00 am](https://user-images.githubusercontent.com/41565823/50554068-574fb980-0cb4-11e9-96f2-7802ad3a400f.png)


## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):


```gradle
allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	        implementation 'com.github.Pradyuman7:ChocoBar:V1.0'
}
```

## Usage

Each method always returns a `Snackbar` object, so you can customize the Snackbar and much more. Check out the following examples:

- To display a green ChocoBar:

``` java
ChocoBar.builder().setActivity(MainActivity.this)
		  .setText("GREEN")
		  .setDuration(ChocoBar.LENGTH_SHORT)
		  .green()
		  .show();
```
- To display a red ChocoBar:

``` java
ChocoBar.builder().setView(v)
		  .setText("RED")
	 	  .setDuration(ChocoBar.LENGTH_INDEFINITE)
		  .setActionText(android.R.string.ok)
		  .red()
		  .show();
```            
            
- To display a simple ChocoBar with a button and some action on clicking the button.

``` java
ChocoBar.builder().setActivity(MainActivity.this).setActionText("ACTION")
		.setActionClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     Toast.makeText(MainActivity.this,"You clicked",Toast.LENGTH_LONG).show();
                }
                })
		.setText("This is a normal ChocoBar")
		.setDuration(ChocoBar.LENGTH_INDEFINITE).build().show();
```
- You can also create custom ChocoBars with tons of customizations like this:
``` java
ChocoBar.builder().setBackgroundColor(Color.parseColor("#00bfff")).setTextSize(18)
	.setTextColor(Color.parseColor("#FFFFFF"))
	.setTextTypefaceStyle(Typeface.ITALIC)
	.setText("This is a custom Chocobar")
	.setMaxLines(4)
	.centerText()
	.setActionText("ChocoBar")
	.setActionTextColor(Color.parseColor("#66FFFFFF"))
	.setActionTextSize(20)
	.setActionTextTypefaceStyle(Typeface.BOLD)
	.setIcon(R.mipmap.ic_launcher)
	.setActivity(MainActivity.this)
	.setDuration(ChocoBar.LENGTH_INDEFINITE).build().show();
            
```

## Pull Request

Have some new ideas or found a bug? Do not hesitate to open an `issue` and make a `pull request`.

## License

**ChocoBar** is under an **MIT** license. See the [LICENSE](LICENSE.md) file for more info.

