# Java usage

Chocobar has several built-in types which specifies color, icon, text, and text color. 

Each method always returns a `Snackbar` object, so you can customize the Snackbar further and much more. 

Check out the following examples:

- To display a `green` ChocoBar:

``` java
ChocoBar.builder().setActivity(v)
        .setText("GREEN")
        .setDuration(ChocoBar.LENGTH_SHORT)
        .green() // built-in green ChocoBar
        .show();
```

- To display an `orange` Chocobar

``` java 
ChocoBar.builder().setActivity(v)
        .setText("ORANGE")
        .setDuration(ChocoBar.LENGTH_SHORT)
        .orange() // built-in orange ChocoBar
        .show();
```
- To display a `red` ChocoBar:

``` java
ChocoBar.builder().setView(v)
        .setText("RED")
        .setDuration(ChocoBar.LENGTH_INDEFINITE)
        .setActionText(android.R.string.ok)
        .red() // built-in red ChocoBar
        .show();
```

- To display a `cyan` Chocobar:

``` java
ChocoBar.builder().setView(v)
        .setText("CYAN")
        .setDuration(ChocoBar.LENGTH_INDEFINITE)
        .setActionText(android.R.string.ok)
        .cyan() // built-in cyan ChocoBar
        .show();
```

- To display a `gray` ChocoBar:

``` java
ChocoBar.builder().setView(v)
                .setText("GRAY_GOOD")
        .centerText()
        .setDuration(ChocoBar.LENGTH_LONG)
        .good()
        .show();
		  
ChocoBar.builder().setView(v)
            .setText("GRAY_BAD")
        .centerText()
        .setDuration(ChocoBar.LENGTH_LONG)
        .bad()
        .show();
```  

- To display a `love` ChocoBar:

``` java
ChocoBar.builder().setView(v)
        .setText("Love")
        .setDuration(ChocoBar.LENGTH_INDEFINITE)
        .setActionText(android.R.string.ok)
        .love() // built-in red ChocoBar
        .show();
```   

- To display a `default` ChocoBar that provides an action:

``` java
ChocoBar.builder().setActivity(v)
        .setActionText("ACTION")
        .setActionClickListener(v1 ->
            Toast.makeText(MainActivity.this,"You clicked",Toast.LENGTH_LONG).show();)
        .setText("This is a default ChocoBar")
        .setDuration(ChocoBar.LENGTH_INDEFINITE)
        .build()
        .show();
```

- To display a `black` ChocoBar:

```java
ChocoBar.builder()
        .setView(v)
        .centerText()
        .setDuration(ChocoBar.LENGTH_LONG)
        .black() // built-in black ChocoBar
        .show());
```

- To display a `notifications on` Chocobar:

```java
ChocoBar.builder()
        .setView(v)
        .centerText()
        .setDuration(ChocoBar.LENGTH_LONG)
        .notificationsOn() // built-in notifications on ChocoBar
        .show());
```

- To display a `blocked` Chocobar:

```java
ChocoBar.builder()
        .setView(v)
        .centerText()
        .setDuration(ChocoBar.LENGTH_LONG)
        .blocked() // built-in blocked on ChocoBar
        .show());
```

- You can also create highly customized ChocoBars:

``` java
ChocoBar.builder().setBackgroundColor(Color.parseColor("#00bfff"))
        .setTextSize(18)
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
        .setDuration(ChocoBar.LENGTH_INDEFINITE)
        .build()
        .show();
```
