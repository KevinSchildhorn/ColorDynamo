# ColorDynamo

Color Dynamo is an Android library that lets developers create styles and themes that can be changed dynamically. The library allows setting a Primary color, Secondary color, Accent Color 

In the project build.gradle:


    maven {
        url  "https://dl.bintray.com/kevinschildhorn/ColorDynamo"
    }
    
In the module build.gradle:


    compile(group: 'org.kevinschildhorn', name: 'colordynamo', version: '1.0.0', ext: 'aar', classifier: '')


To use ColorDynamo your Activities must extend `CAActivity` and your fragments must extend `CAFragment`.


# CAActivity

    setStyleDefaultDark()
    animateStyleDefaultDark(int duration)

    setStyleDefaultLight()
    animateStyleDefaultLight(int duration)

    setStyleRes(int primRes, int secRes, int accRes, int primTextRes, int secTextRes)
    setStyle(int prim, int sec,int acc, int primText, int secText)

    repaintActivity()
    repaintActivityAnimated(int duration)
    
   
# CAColors

Get Singleton

    getInstance(Context ctx)
    
    
    void saveStyle(String name)
    boolean loadStyle(String name)
    
    void removeStyle(String name)
    void removeAllStyles()
