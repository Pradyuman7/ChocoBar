# Kotlin usage

Chocobar has several built-in types which specifies color, icon, text, and text color.

Each method always returns a Snackbar object, so you can customize the Snackbar further and much more.

Check out the following examples:

- To display a default ChocoBar that provides an action:

```
ChocoBar.builder()
        .setView(it)
        .setActionText("ACTION")
        .setActionClickListener {
            Toast.makeText(this, "You clicked ACTION", Toast.LENGTH_LONG).show()
        }
        .setText("Default ChocoBar")
        .setDuration(ChocoBar.LENGTH_INDEFINITE)
        .build()
        .show()
```

This is all very same as it's done in the Java version. You can check out other Java examples [here](documentation-java.md) or you can also check the [SecondaryActivity.kt file](../app/src/main/java/com/pd/snickers/SecondaryActivity.kt) for more Kotlin examples.
