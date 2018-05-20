# OverlayProgressBar

This library provides a simple overlay effect alongside a progress bar
that can be added to xmls as a means of hiding the background content
whilst showing the progress bar.


![Alt Text](https://media.giphy.com/media/oNPsar2gSLlOXtP1kF/giphy.gif)



### Gradle

```
dependencies {
    ...
    implementation 'com.levimoreira.overlayprogressbar:overlay-progressbar:0.1.0'
}
```

The usage is very simple, we've provided some attributes that can be changed directly in the xml.

```
    <com.levimoreira.overlayprogressbar.OverlayProgressBar
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:indeterminateHeight="200dp"
        app:indeterminatePadding="50dp"
        app:indeterminateTint="#fffb00"
        app:indeterminateWidth="200dp"
        app:overlayBackgroundColor="#64000000" />
```

