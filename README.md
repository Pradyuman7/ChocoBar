# ChocoBar

[![](https://www.jitpack.io/v/Pradyuman7/ChocoBar.svg)](https://www.jitpack.io/#Pradyuman7/ChocoBar)

<p align="center">
  <img width="250" height="250" src="https://user-images.githubusercontent.com/41565823/50545792-3f2c5b80-0c1c-11e9-81e6-23b0035c7b4c.gif">
</p>

<p align="center">
  The usual Snackbar with more 🍫 and colours :grin:. Inspired by <a href="https://github.com/TonnyL/Light"> Light</a>.
</p>


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

Each method always returns a `Snackbar` object, so you can customize the Snackbar much more. **DON'T FORGET THE `show()` METHOD!**

To display a green ChocoBar:

``` java
ChocoBar.builder().setActivity(MainActivity.this).setText("GREEN").setDuration(ChocoBar.LENGTH_SHORT).green().show();
```
To display a red ChocoBar:

``` java
ChocoBar.builder().setView(v).setText("RED").setDuration(ChocoBar.LENGTH_INDEFINITE).setActionText(android.R.string.ok).red().show();
```            
            
To display a simple ChocoBar with a button:

``` java
ChocoBar.builder().setActivity(MainActivity.this).setActionText("ACTION").setActionClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this,"You clicked",Toast.LENGTH_LONG).show();
                            }
                        }).setText("This is a normal ChocoBar").setDuration(ChocoBar.LENGTH_INDEFINITE).build().show();
```
You can also create custom ChocoBars with tons of customizations like this:
``` java
ChocoBar.builder().setBackgroundColor(Color.parseColor("#00bfff")).setTextSize(18).setTextColor(Color.parseColor("#FFFFFF"))
	.setTextTypefaceStyle(Typeface.ITALIC)
	.setText("This is a custom Chocobar")
	.setMaxLines(4).centerText()
	.setActionText("ChocoBar")
	.setActionTextColor(Color.parseColor("#66FFFFFF"))
	.setActionTextSize(20)
	.setActionTextTypefaceStyle(Typeface.BOLD)
	.setIcon(R.mipmap.ic_launcher)
	.setActivity(MainActivity.this)
	.setDuration(ChocoBar.LENGTH_INDEFINITE).build().show();
            
```

