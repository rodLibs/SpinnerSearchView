# SpinnerSearchView
Library that performs search on the spinner.
This library is 100% written in Java.
But it can be used for java or kotlin.
</br>
</br>



# Requirements
SpinnerSearchView requires at minimum Android 4.0 (API level 15).
</br>
Require compileSdkVersion 29.
</br>
</br>



# Sample Project
You can download the latest sample APK from this repo here: https://github.com/rodLibs/cam-color/blob/master/sample/cam%20color.apk
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
    implementation 'com.github.rodlibs:spinnerSearch2:1.3'
</code></pre>


#### Maven:
```xml
 <dependency>
  <groupId>com.github.rodlibs</groupId>
  <artifactId>spinnerSearch2</artifactId>
  <version>1.3</version>
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



###### Add component click event
<pre><code>
spinner.setOnItemClickSpinner { item, _ ->
    Log.i("SPINNER", item)
}
</code></pre>
</br>


###### To add a custom adapter, your adapter must extend from BaseAdapter's own library.
###### You must implement the ItemFilter class, for correct filtering to work.
###### You should call the setListener method, from your activity, through the spinner instance.
<pre><code>
class AdapterCustomized(private val listOrigi: List<String>) : BaseAdapter() {

    val mFilter: ItemFilter = ItemFilter()
    var myListener: OnItemClickSpinnerSearch? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Any> {}

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {}

    override fun getItemCount(): Int {}

    override fun setListener(listener: OnItemClickSpinnerSearch?) {}

    inner class MyViewHolder(itemView: View) : BaseViewHolder<String>(itemView){}


    override fun getFilter(): Filter {}

    inner class ItemFilter : Filter(){}
}
</code></pre>


###### To use the custom adapter, call the method: setPopulateRecycleViewANDSetAdapter
<pre><code>
  spinner.setPopulateRecycleViewANDSetAdapter(AdapterCustomized(list))
</code></pre>
</br>
</br>




# Api Methods
###### TextView
<pre><code>
  setTextTextView(String text)  -->> set text Title.
</code></pre>

<pre><code>
  setTypeFaceTextView(Typeface face)  -->> set Font Title
</code></pre>

<pre><code>
  setColorTextView(int color)  -->> set color text Title
</code></pre>

<pre><code>
  setSizeTextView(int size)  -->> set size text Title
</code></pre>

<pre><code>
  setBackgroundColorTextView(int color)  -->> set Backgroundcolor text Title
</code></pre>

<pre><code>
  setBackgroundResourceTextView(int res)  -->> set BackgroundResource text Title
</code></pre>

###### EditText
<pre><code>
  setTextHintEditText(String hint)  -->> set text hint camp search
</code></pre>

<pre><code>
  setTypeFaceEditText(Typeface face)  -->> set font camp search
</code></pre>

<pre><code>
  setColorEditText(int color)  -->> set color text camp search
</code></pre>

<pre><code>
  setColorHintEditText(int color)  -->> set color hint camp search
</code></pre>

<pre><code>
  setSizeEditText(int size)  -->> set size font camp search
</code></pre>

<pre><code>
  setBackgroundColorEditText(int color)  -->> set backgroundColor camp search
</code></pre>

<pre><code>
  setBackgroundResourceEditText(int res)  -->> set backgroundResource camp search
</code></pre>

<pre><code>
  setBackgroundTintListEditText(ColorStateList colorStateList)  -->> set backgroundTintList camp search
</code></pre>

###### ImageView
<pre><code>
  setImageResourceImageView(int res)  -->> set ImageResource ImageView
</code></pre>

<pre><code>
  setBitmapImageView(Bitmap bitmap)  -->> set ImageBitmap ImageView
</code></pre>
</br>
</br>




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

