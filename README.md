# EasyRecycleViewItemTouchHelperSampleApp


# LinearLayout の表示について
#### テキストビューを別のViewにinflateする際に、LinearLayoutのlayout_heightのプロパティをmatch_parentにした場合。
inflateされるViewファイルでLinearLayout内の要素が一画面分全部で表示されるようになってしまう。
例えば、テキストビューが１つしかなかった場合、一画面のデカさで一つのテキストビューだけしか表示されないと言う感じになてしまう。

#### 反対に、LinearLayout内のlayout_heightプロパティをwrap_contentにした場合。
1つのテキストビューのみが積み重なって表示されるようになることで、理想的なレイアウトを組むことができた。
