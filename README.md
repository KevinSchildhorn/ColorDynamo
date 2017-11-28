# ColorDynamo

Color Dynamo is an Android library that lets developers create styles and themes that can be changed dynamically. The library allows setting both background colors and text colors dynamically, as well as saving and loading "styles". The library includes two styles by default, dark and light.

_Note: These are not standard Android styles and themes._

Backgound colors include:
* Primary color
* Secondary color
* Accent Color
* Navigation Bar Color
* Button Color
* Selected color

Text colors include: 
* Primary Text color
* Secondary Text color
* Navigation Item Color
* Button Text Color.


## Installation
#### To include the library in your project, add these lines of code.

In the project build.gradle:

    maven {
        url  "https://dl.bintray.com/kevinschildhorn/ColorDynamo"
    }
    
In the module build.gradle:

    compile(group: 'org.kevinschildhorn', name: 'colordynamo', version: '1.0.0', ext: 'aar', classifier: '')




To use ColorDynamo your Activities must extend `CAActivity` and your fragments must extend `CAFragment`.


### CAActivity

Here is where you can set styles. There are also animated versions of these functions that will change the current style to the new style over the time duration.

To set the style to dark

    setStyleDefaultDark()
    animateStyleDefaultDark(int duration)

To set the style to light

    setStyleDefaultLight()
    animateStyleDefaultLight(int duration)

To set a custom style

    setStyleRes(int primRes, int secRes, int accRes, int primTextRes, int secTextRes)
    setStyle(int prim, int sec,int acc, int primText, int secText)


To refresh the activity (note this should be done automatically when entering the activity. Use this when loading or changing a style)

    repaintActivity()
    repaintActivityAnimated(int duration)
    
   
### CAColors

Get Singleton

    getInstance(Context ctx)
    
    
    void saveStyle(String name)
    boolean loadStyle(String name)
    
    void removeStyle(String name)
    void removeAllStyles()
