# Android PagerSlidingTabStrip (default Material Design)

Interactive paging indicator widget, compatible with the `ViewPager` from the
Android Support Library.

![PagerSlidingTabStrip Sample Material](https://raw.githubusercontent.com/jpardogo/PagerSlidingTabStrip/master/art/material_tabs.gif) ------
![PagerSlidingTabStrip Sample Material](https://raw.githubusercontent.com/jpardogo/PagerSlidingTabStrip/master/art/material_tabs_middle.gif)

# Usage

For a working implementation of this project see the `sample/` folder.

1. Include the following dependency in your `build.gradle` file.

```groovy
implementation 'com.jpardogo.materialtabstrip:library:1.1.1'
```

Or add the library as a project. I tried to send a pull request, but looks like the original developer doesn't maintain it anymore.

2. Include the `PagerSlidingTabStrip` widget in your layout. This should usually be placed above the `ViewPager` it represents.

```xml
<com.astuetz.PagerSlidingTabStrip
    android:id="@+id/tabs"
    android:layout_width="match_parent"
    android:layout_height="?attr/actionBarSize"
    android:background="?attr/colorPrimary" />
```

3. In your `onCreate` method (or `onCreateView` for a fragment), bind the widget to the `ViewPager`:

```java
// Initialize the ViewPager and set an adapter
ViewPager pager = (ViewPager) findViewById(R.id.pager);
pager.setAdapter(new TestAdapter(getSupportFragmentManager()));

// Bind the tabs to the ViewPager
PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
tabs.setViewPager(pager);
```

### That's all you need to do, but if you want to use your own tabs, then...

1. If your adapter implements the interface `CustomTabProvider` you can paste your custom tab view/s.

     - In case the the view returned contains the id `R.id.psts_tab_title`, this view should be a `TextView`  and
     will be used to placed the title and set the view state (pressed/selected/default).

     - If you don't want the library manage your TextView title for the tab, use a different id than `R.id.psts_tab_title` in your tab layout.

     - The interface provide callbacks for selection and unselection of tabs as well.

     - If your adapter doesn't implement the interface `CustomTabProvider` the default tab will be used, which is a `TextView` with id `R.id.psts_tab_title`).

2. *(Optional)* If you use an `OnPageChangeListener` with your view pager
     you should set it in the widget rather than on the pager directly.

```java
// continued from above
tabs.setOnPageChangeListener(mPageChangeListener);
```

# Customization

From theme:

 * `android:textColorPrimary` value (from your theme) will be applied automatically to the tab's text color (Selected tab with 255 alpha and non selected tabs with 150 alpha), underlineColor, dividerColor and indicatorColor, if the values are not defined on the xml layout.

Notes about some of the native attributes:

 * `android:paddingLeft` or `android:paddingRight` layout padding. If you apply both, they should be balanced. Check issue [#69](https://github.com/jpardogo/PagerSlidingTabStrip/pull/69) for more information.

Custom attributes:

 * `pstsIndicatorColor` Color of the sliding indicator. `textColorPrimary` will be it's default color value.
 * `pstsIndicatorHeight`Height of the sliding indicator.
 * `pstsUnderlineColor` Color of the full-width line on the bottom of the view. `textColorPrimary` will be it's default color value.
 * `pstsUnderlineHeight` Height of the full-width line on the bottom of the view.
 * `pstsDividerColor` Color of the dividers between tabs. `textColorPrimary` will be it's default color value.
 * `pstsDividerWidth` Stroke width of divider line, defaults to 0.
 * `pstsDividerPadding` Top and bottom padding of the dividers.
 * `pstsShouldExpand` If set to true, each tab is given the same weight, default false.
 * `pstsScrollOffset` Scroll offset of the selected tab.
 * `pstsPaddingMiddle` If true, the tabs start at the middle of the view (Like Newsstand google app).
 * `pstsTabPaddingLeftRight` Left and right padding of each tab.
 * `pstsTabBackground` Background drawable of each tab, should be a StateListDrawable.
 * `pstsTabTextSize` Tab text size (sp).
 * `pstsTabTextColor` Tab text color that can either be a color (text color won't changed) or a selector with a color per state: pressed (tab pressed), selected (tab active), default (active non active). The order of states in the selector is important. Check issue [#68](https://github.com/jpardogo/PagerSlidingTabStrip/pull/70) for more information.
 * `pstsTabTextStyle` Set the text style, default normal on API 21, bold on older APIs.
 * `pstsTabTextAllCaps` If true, all tab titles will be upper case, default true.
 * `pstsTabTextAlpha` Set the text alpha transparency for non selected tabs. Range 0..255. 150 is it's default value. It **WON'T** be used if `pstsTabTextColor` is defined in the layout. If `pstsTabTextColor` is **NOT** defined, It will be applied to the non selected tabs.
 * `pstsTabTextFontFamily` Set the font family name. Default `sans-serif-medium` on API 21, `sans-serif` on older APIs.

Almost all attributes have their respective getters and setters to change them at runtime. To change dynamically `pstsTabTextFontFamily` and  `pstsTabTextStyle` you can call:

 * `public void setTypeface(Typeface typeface, int style)`. It can be used to define custom fonts in default tabs. Otherwise you can use custom tabs with `CustomTabProvider`.

Please open an issue if you find any are missing.

# Developed By

 * Javier Pardo de Santayana Gomez - [jpardogo.com](http://www.jpardogo.com) - <jpardogo@gmail.com>
 * Andreas Stuetz - <andreas.stuetz@gmail.com>
 * And contributors.

# Contributions

 * Please, read the README file before opening an issue, thanks.
 * Please, all the Pull Request must be sent to the dev branch, thanks..

# Credits

 * [Kirill Grouchnikov](https://plus.google.com/108761828584265913206/posts) - Author of [an explanation post on Google+](https://plus.google.com/108761828584265913206/posts/Cwk7joBV3AC)

# License

    Copyright 2013 Andreas Stuetz

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
