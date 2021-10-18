# ChocoBar

[![](https://www.jitpack.io/v/Pradyuman7/ChocoBar.svg)](https://www.jitpack.io/#Pradyuman7/ChocoBar)
[![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-ChocoBar-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/7415)
[![AwesomeAndroid](https://img.shields.io/badge/Awesome_Android-ChocoBar-green.svg?style=flat)](https://android.libhunt.com/chocobar-alternatives)
[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/licenses/MIT)

<p align="center">
  <img width="250" height="250" src="https://user-images.githubusercontent.com/41565823/50545792-3f2c5b80-0c1c-11e9-81e6-23b0035c7b4c.gif">
</p>

<p align="center">
  The usual Snackbar with more 🍫 and colours :tada:. Inspired by <a href="https://github.com/TonnyL/Light"> Light</a>.
</p>

## GIF

<p align="left">
  <img width="300" height="550" src="https://user-images.githubusercontent.com/41565823/54661529-e2ce2f00-4ada-11e9-9e66-3c0aecfa35b6.gif">
</p>

## AndroidPub Post

[You can read the AndroidPub post about this library, the reason of it's existence, the perks it provides and other details, here.](https://medium.com/@pradyumandixit/drop-the-toast-and-snackbar-to-replace-it-by-chocobar-ada7692fa915)

## Versions

| Version name  | Tag        | What's new                                                                                  |
|:-------------:|:----------:|:--------------------------------------------------------------------------------------------|
| Version 1.0   | V1.0       | First release of ChocoBar                                                                   |
| Version 1.1   | V1.1       | Minor bug fixes and performance improvements                                                |
| Version 1.2   | V1.2       | New good gray and bad gray ChocoBar additions and RTL languages support                     |
| Version 1.3   | V1.3       | New addition of Black ChocoBar and minor bug fixes                                          |
| Version 1.4   | V1.4       | New addition of Love ChocoBar, bug fixes and addition of github actions for master branch   |
| Version 1.5   | V1.5       | Update of in built Chocobars to have default text (editable)                                |
| Version 1.6   | V1.6       | Add even more in built ChocoBars with different functionalities                             |

## ChocoBar Kotlin
ChocoBar is now also available in Kotlin, thanks to @JamesEllerbee

## Screenshots

**Preview of Different kinds of ChocoBars you can use**

![screenshot 2018-12-31 at 4 26 25 am](https://user-images.githubusercontent.com/41565823/50554067-56b72300-0cb4-11e9-8b04-8f12b09820d9.png)
![screenshot 2018-12-31 at 4 24 32 am](https://user-images.githubusercontent.com/41565823/50554071-574fb980-0cb4-11e9-9c0d-95f0df30f72c.png)
![screenshot 2018-12-31 at 4 25 38 am](https://user-images.githubusercontent.com/41565823/50554069-574fb980-0cb4-11e9-95f5-df24d2a56a96.png)
![screenshot 2018-12-31 at 4 25 09 am](https://user-images.githubusercontent.com/41565823/50554070-574fb980-0cb4-11e9-8a7d-0ab8b061e120.png)
![screenshot 2018-12-31 at 4 26 00 am](https://user-images.githubusercontent.com/41565823/50554068-574fb980-0cb4-11e9-96f2-7802ad3a400f.png)
![screenshot 2018-12-31 at 4 26 00 am](https://user-images.githubusercontent.com/37071007/68586351-d6fb0700-04c7-11ea-8133-dd0e14fcd8c8.png)
![screenshot 2018-12-31 at 4 26 00 am](https://user-images.githubusercontent.com/37071007/68586380-e5e1b980-04c7-11ea-95eb-612167d59448.png)
![Love Chocobar](https://user-images.githubusercontent.com/35525781/96970060-c012c080-1530-11eb-926c-59edd1844413.png)
![image](https://user-images.githubusercontent.com/26584526/136639395-7a70f775-b5d3-4ad4-8b4f-d0ce91490c18.png)
![image](https://user-images.githubusercontent.com/26584526/136639381-19bfd6f0-a34e-49f9-8b7e-4e34c4e02ba7.png)
![image](https://user-images.githubusercontent.com/36191408/137777366-738ce9c7-d942-4ccb-845a-38f4891196ea.png)

## Documentation
[Find how to use the in-built Chocobars here](documentation/ReadMe.md)

## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { 
			url 'https://www.jitpack.io' 
		}
	}
}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above for the latest stable version):

```gradle
dependencies {
	implementation 'com.github.Pradyuman7:ChocoBar:V1.0'
}
```

## Pull Request

Have some new ideas or found a bug? Do not hesitate to open an `issue` and make a `pull request`.

## License

**ChocoBar** is under MIT License. See the [LICENSE](LICENSE.md) file for more info.
