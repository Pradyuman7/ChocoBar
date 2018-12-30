# ChocoBar

<p align="center">
  <img width="250" height="250" src="https://user-images.githubusercontent.com/41565823/50545792-3f2c5b80-0c1c-11e9-81e6-23b0035c7b4c.gif">
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
ChocoBar.builder().setBackgroundColor(Color.parseColor("#00bfff")).setTextSize(18).setTextColor(Color.parseColor("#FFFFFF")).setTextTypefaceStyle(Typeface.ITALIC).setText("This is a custom Chocobar").setMaxLines(4).centerText().setActionText("ChocoBar").setActionTextColor(Color.parseColor("#66FFFFFF")).setActionTextSize(20).setActionTextTypefaceStyle(Typeface.BOLD).setIcon(R.mipmap.ic_launcher).setActivity(MainActivity.this).setDuration(ChocoBar.LENGTH_INDEFINITE).build().show();
            
```

## Screenshots

**Please click the image below to enlarge.**

![screenshot 2018-12-30 at 10 55 08 am](https://user-images.githubusercontent.com/41565823/50546114-a3eab480-0c22-11e9-9d36-f145ca3724a9.png)
![screenshot 2018-12-
![screenshot 2018-12-30 at 10 55 21 am](https://user-images.githubusercontent.com/41565823/50546132-f62bd580-0c22-11e9-9f9b-872efa8983bb.png)
![screenshot 2018-12-30 at 10 54 11 am](https://user-images.githubusercontent.com/41565823/50546133-f62bd580-0c22-11e9-9cbc-a136fcca814b.png)
30 at 10 54 54 am](https://user-images.githubusercontent.com/41565823/50546115-a3eab480-0c22-11e9-8d5d-063a18d8fb58.png)
![screenshot 2018-12-30 at 10 54 39 am](https://user-images.githubusercontent.com/41565823/50546116-a3eab480-0c22-11e9-89dc-6856f019bcf3.png)

