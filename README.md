

> 栗子——TabLayout+ViewPager滑动吸顶悬停

---


> ### 栗子惯例，先上GIF

![栗子.gif](http://upload-images.jianshu.io/upload_images/2071764-5ec5a5da460bb07c.gif)

---

> ### 使用到的控件

使用前需要在Gradle加入Support Design Library：
**compile 'com.android.support:design:25.0.1'**

#### CoordinatorLayout
`CoordinatorLayout`通过协调子布局的形式，产生联动效果。通过设置子View的Behaviors来协调子View。

#### AppBarLayout
`AppBarLayout`中的一个属性`android:fitsSystemWindows="true"`，是为了调整系统窗口布局以适应布局。
`AppBarLayout`里面的View，是通过`app:layout_scrollFlags`属性来控制，其中有4种Flag的类型：

 - `Scroll`：向下滚动时,被指定了这个属性的View会被滚出屏幕范围直到完全不可见的位置。
 - `enterAlways`：向上滚动时,这个View会随着滚动手势出现,直到恢复原来的位置。
 - `enterAlwaysCollapsed`： 当视图已经设置minHeight属性又使用此标志时，视图只能以最小高度进入，只有当滚动视图到达顶部时才扩大到完整高度。
 - `exitUntilCollapsed`： 滚动退出屏幕，最后折叠在顶端。

#### CollapsingToolbarLayout
用来协调`AppBarLayout`来实现滚动隐藏`ToolBar`的效果。

#### Toolbar
Toolbar在v7包中，设置`layout_collapseMode`协调`CollapsingToolbarLayout`达到滑动视图的视觉差效果：

 - `pin`：固定模式，在折叠的时候最后固定在顶端。
 - `parallax`：视差模式，在折叠的时候会有个视差折叠的效果。

---

> ### main.xml
```
<?xml version="1.0" encoding="utf-8"?>
<android.support.design.widget.CoordinatorLayout
	xmlns:android="http://schemas.android.com/apk/res/android"
	xmlns:app="http://schemas.android.com/apk/res-auto"
	android:layout_width="match_parent"
	android:layout_height="match_parent">
	<android.support.design.widget.AppBarLayout
		android:id="@+id/appbar"
		android:layout_width="match_parent"
		android:layout_height="wrap_content"
		app:theme="@style/ToolbarTheme"
		android:fitsSystemWindows="true">
		<!--app:layout_scrollFlags="scroll|enterAlways"-->
		<android.support.design.widget.CollapsingToolbarLayout
			android:id="@+id/collapsingToolbar"
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			app:contentScrim="?attr/colorPrimary"
			app:navigationIcon="@mipmap/back"
			app:layout_scrollFlags="scroll|exitUntilCollapsed">
			<LinearLayout
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:scaleType="centerInside"
				app:layout_collapseMode="parallax"
				android:fitsSystemWindows="true"
				android:orientation="vertical">
				<ImageView
					android:background="@mipmap/image"
					android:layout_width="match_parent"
					android:layout_height="200dp" />
			</LinearLayout>
		<android.support.v7.widget.Toolbar
			android:id="@+id/toolbar"
			android:layout_width="match_parent"
			android:layout_height="?attr/actionBarSize"
			app:titleTextColor="#ffffff"
			app:theme="@style/ToolbarTheme"
			android:gravity="center_vertical"
			android:background="#00ffffff"
			app:navigationIcon="@mipmap/back"
			app:layout_collapseMode="pin"
			app:popupTheme="@style/AppTheme.PopupOverlay" />
	</android.support.design.widget.CollapsingToolbarLayout>
	<android.support.design.widget.TabLayout
		android:id="@+id/tabLayout"
		android:layout_width="match_parent"
		android:layout_height="wrap_content"
		android:background="@drawable/selector_list_item"
		app:tabIndicatorColor="#666666"
		app:tabSelectedTextColor="#4D4D4D"
		app:tabTextColor="#A7A7A7" />
	</android.support.design.widget.AppBarLayout>
	<android.support.v4.view.ViewPager
		android:id="@+id/viewpager"
		android:layout_width="match_parent"
		android:layout_height="wrap_content"
		app:layout_behavior="@string/appbar_scrolling_view_behavior" />
</android.support.design.widget.CoordinatorLayout>
```

---

> ### 注意事项

在xml中为`AppBarLayout`设置属性`android:fitsSystemWindows="true"`

在xml中为`CollapsingToolbarLayout`设置属性`app:layout_scrollFlags="scroll | exitUntilCollapsed`

在xml中为`Toolbar`设置属性`app:layout_collapseMode="pin"`

在xml中为`ViewPager`设置属性`app:layout_behavior="@string/appbar_scrolling_view_behavior"`

在使用的`ViewPager`时候需要用`RecyclerView`做为列表


> ### 总结

> **这是Android提供的一种炫酷组合控件~顶部的图片可以换成任意的View，比如Banner图等。**

---



> **个人博客：[WWW.FJ917.COM](http://www.fj917.com)**</br>
> **简书：[www.jianshu.com/u/3d2770e6e489](http://www.jianshu.com/u/3d2770e6e489)**</br>
> **CSDN：[blog.csdn.net/fj917](http://blog.csdn.net/fj917)**


|欢迎加入QQ交流群657206000[点我加入](http://shang.qq.com/wpa/qunwpa?idkey=9b454a6f01bd94d97e4c3f2771447a989ec77794eb5a563422263153c00f700d)|
|:---:|
|![QQ交流群：657206000](http://upload-images.jianshu.io/upload_images/2071764-bce605159bbceb2a.png)|