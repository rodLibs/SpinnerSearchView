# SpinnerSearchView
Library that performs search on the spinner.
</br>
</br>



# Requirements
SpinnerSearchView requires at minimum Android 4.0 (API level 15).
</br>
Require compileSdkVersion 29.
</br>
</br>


# Gradle Dependency

## Repository
The Gradle dependency is available via Maven. Maven is the default Maven repository used by Android Studio.
</br>

## Add repository
<pre><code>
repositories {
    maven {
            url  "https://dl.bintray.com/rod120/spinnerSearch2"
        }
}
</code></pre>



## Add dependency

#### Gradle:
<pre><code>
    implementation 'com.github.rodlibs:spinnerSearch2:1.2'
</code></pre>


#### Maven:
```xml
 <dependency>
  <groupId>com.github.rodlibs</groupId>
  <artifactId>spinnerSearch2</artifactId>
  <version>1.2</version>
  <type>pom</type>
</dependency>
```
</br>
</br>



# Sample usage

#### .XML

###### Add the component to your .xml file
```xml
 <com.github.rodlibs.mylibspinnersearch_2.SpinnerSearch
        android:id="@+id/spinner"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="16dp"/>
```


#### .kt

###### Create a string list, get the component instance in the xml.
<pre><code>
 val list = arrayListOf<String>()
 for (i in 1..20) {
    list.add("item $i")
 }
 
 val spinner = findViewById<SpinnerSearch>(R.id.spinner) 
 spinner.setPopulateRecycleView(list)
</code></pre>


















# License
<pre><code>
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
</code></pre>

