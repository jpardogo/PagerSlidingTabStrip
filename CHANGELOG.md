Change Log
==========

Version 1.1.0 *(01-06-215)*
---------------------------------
* Bug fixes
* Allow create custom animation for the tab indicator line #155

Version 1.1.0 *(01-06-215)*
---------------------------------
* Bug fixes
* Rename some custom attributes.
* Default ripple effect selector in 21+
* Default sans-serif-medium tab's text in API 21+
* app:pstsTextFontFamily for overriding the typeface from the XML. The attribute works exactly like android:fontFamily for TextViews.
* Remove custom attire `pstsTextColorSelected ` and `pstsTextSelectedStyle`.
* `pstsTabTextColor` will handle the tab text color states.
* `pstsTabTextSize` will handle the tab text size.
* Callbacks for selection/deselection of tabs passing the tab view as parameter when custom tabs are use.

Version 1.0.9 *(22-02-2015)*
---------------------------------
* Bug fixes
* Add parsing of independent padding attributes (#69)
* pstsTextAlpha value range change from 0..1 to 0..255.
* New attr pstsTextColorSelected
* R.id.tab_title changed to R.id.psts_tab_title
* R.layout.tab changed to R.layout.psts_tab
* R.drawable.background_tab changed to R.drawable.psts_background_tab


Version 1.0.8 *(14-01-2015)*
----------------------------
* Bug fixes
* Ability to build the library using maven
* Update support-v4 library to v21.0.3

Version 1.0.7 *(08-01-2015)*
----------------------------
* Bug fixes
* OnTabReselectedListener

Version 1.0.6 *(21-11-2014)*
----------------------------
* Update support-v4 library to v21.0.2
* Bug fixes

Version 1.0.5 *(19-11-2014)*
----------------------------
* android:textColorPrimary value (from your theme) will be applied automatically to tab's text color , underlineColor, dividerColor and indicatorColor, if any of these values are define in the xml layout.
* Bug fixes

Version 1.0.4 *(18-11-2014)*
----------------------------
* Bug fixes

Version 1.0.3 *(11-11-2014)*
----------------------------

* Fix issues #7
* Add support for colour state lists.
* Add support for  custom text style.
* Add support for  custom alpha values.

Version 1.0.2 *(05-11-2014)*
----------------------------
* MinSDK 10

* Change the default parameters of the tabs layout to make
it look like more material.

* The indicator is center by default while swiping tabs and paddingMiddle attr
has the possibility to start the tabs in the middle like newsstand google app.

* The alpha value of the titles change depending the selected position.

* Ability to change the divider width (No material change).

* Ability to pass customTabs implementing the interface
'CustomTabProvider' in your adapter.