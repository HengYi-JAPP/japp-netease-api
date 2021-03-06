# 更新记录

## v 1.8.1

解决了近两周社区反馈的问题。

### 更新明细

+ 数据表格2:
  * 修复了 `responsive` 选项和 `checkbox` 选项同时启用冲突的问题[@YNZZZ](http://forum.zui.sexy/thread/417.html)）；
  * 修复了 `configs` 中的 `html` 属性和列配置的 `html` 属性设置为 `true` 时没有生效的问题（[@YNZZ](http://forum.zui.sexy/thread/422.html)）；
  * 修复了 列配置中 `valueOperator` 没有按照预期工作的问题，同时修复了值转换期函数中参数不完整的问题（[@zz](http://forum.zui.sexy/thread/419.html)）；
  * 修复了 默认的日期值转换期没有按照预期工作的问题（[@YNZZZ](http://forum.zui.sexy/thread/417.html)）；
  * 修复了 `checkByClickRow` 和 `selectable` 选项冲突的问题，当 `checkByClickRow` 被禁用时，如果开启拖拽选择，则仅可以在勾选框所在列进行拖选操作（[@YNZZZ](http://forum.zui.sexy/thread/416.html)）；
  * 修复了 Windows 上滚轮方向相反，滚动距离过小的问题，并且新增了 `mouseWheelFactor` 参数用于控制滚轮滚动速度和方向；
  * 修复了 当数据没有定义 `id` 或 `rowId` 属性时获取选中行编号为 `undefined` 的问题；
  * 修复了 `showRowIndex` 设置为 `false` 列宽混乱的问题；
  * 优化了 缓存机制，现在默认缓存大小为 `1`；
  * 优化了 行号列列宽自动计算方法，避免有时出现省略号的问题（[@徐业龙](http://forum.zui.sexy/thread/424.html)）
+ 数据表格1:
  * 修复了 启用本地存储后，排序操作方向没有安装预期顺序显示的问题，参见 issue #79；
+ 上下文菜单：
  * 修复了 `html` 选项设置为 `true` 时没有按照预期工作的问题；
+ 按钮组：
  * 修复了 垂直的按钮组右上角圆角为直角的问题；
+ 辅助类：
  * 增加了 `.no-padding` 类用于移除元素所有内边距；
+ 日期选择器：
  * 优化了 内部 `input-group-addon` 左侧边框有双倍宽度的问题；
+ 日历：
  * 将 `hideEmptyWeekends` 默认值设置为 `false`；
+ 图片浏览：
  * 增加 `setImage(image, caption)` 和 `show()` 方法用于手动控制显示和更新内容（QQ 群 @深圳市雷诺表业-it）；

感谢 [@neo20](https://github.com/easysoft/zui/pull/94)、[zora-han](https://github.com/easysoft/zui/pull/93) 提交了 Pull Request。欢迎大家反馈建议，最好是在[论坛发帖](http://forum.zui.sexy/forum/)或者[在 Github 上提交 issue](https://github.com/easysoft/zui/issues)，更欢迎有能力的同学[提交 Pull Request](https://github.com/easysoft/zui/pulls)。

## v 1.8.0

1.8 版本带来了多个新的 JS 组件，包括全新的<a href="http://zui.sexy#view/datagrid" target="_blank">数据表格2</a>、<a href="http://zui.sexy#view/tabs" target="_blank">标签页管理器</a>、<a href="http://zui.sexy#javascript/contextmenu" target="_blank">上下文菜单</a>、<a href="http://zui.sexy#javascript/searchbox" target="_blank">搜索框</a>、<a href="http://zui.sexy#component/input-control" target="_blank">输入框</a>和<a href="http://zui.sexy#javascript/pagerjs" target="_blank">分页器</a>。

### 新功能预览

* 数据表格2支持自定义数据源（包括远程数据），提供行列固定、排序、分页、搜索、行选择、自适应、跨行跨列单元格等重量级功能，并且使用灵活方便定制（旧版本数据表格将不再继续支持，将于 1.9 中淘汰）；
* 标签页管理器最大化增强了标签页控件功能，现在可以使用标签页动态加载内容，甚至是远程页码，还可以手动打开、关闭标签页，就像使用浏览器标签页一样方便；
* 上下文菜单允许你在任意位置弹出浮动在鼠标光标附近的菜单，非常方便的监听鼠标右键并屏蔽系统行为从而定制自己的右键菜单；
* 分页器提供完全自动化的分页界面控件管理，只需要给定当前页码和条目数目即可；
* 搜索框提供了常用的搜索输入框+按钮的组合界面，并且提供一个延迟触发事件用于监听搜索框文本变更事件，使用搜索框可以非常方便的定制现代话搜索交互功能；
* 输入框创建了一种将标签和图标内置到输入框的现代化形式，创建更美观的表单界面。

### 更新明细

+ 新增 <a href="http://zui.sexy#view/datagrid" target="_blank">数据表格2</a>；
+ 新增 <a href="http://zui.sexy#view/tabs" target="_blank">标签页管理器</a>；
+ 新增 <a href="http://zui.sexy#javascript/contextmenu" target="_blank">上下文菜单</a>；
+ 新增 <a href="http://zui.sexy#javascript/pagerjs" target="_blank">分页器</a>；
+ 新增 <a href="http://zui.sexy#javascript/searchbox" target="_blank">搜索框</a>；
+ 新增 <a href="http://zui.sexy#component/input-control" target="_blank">输入框</a>；
+ 工具提示：
  * 修复 触发的事件名称；
+ 图标：
  * 优化 了 `icon-check-plus` 和 `icon-check-minus` 图标，现在看起来更大些；
  * 修复 图标旋转辅助类在 IE8 中实现的问题；
+ 输入组：
  * 修复 `.fix-padding` 在 IE8 上失效的问题；
+ 文件上传：
  * 优化 对服务器返回值对支持，当服务器返回字段中包含 `name` 属性时会自动更新界面上的文件名；
  * 优化 对上传完毕的消息显示，现在会合并多个消息；
  * 优化 对静态文件（`staticFiles`）对支持，现在在提示信息中会计算静态文件的个数和大小；
  * 修复 `renameActionOnDone` 回调函数执行参数 `doRenameFile` 方法无效的问题；
  * 修复 在上传完毕返回的错误消息没有显示的问题；
  * 修复 七牛上传无法使用的问题；
  * 修复 文件上传按钮在 IE10 以下的浏览器无法点击的问题；
+ 图表：
  * 修复 曲线图调用 `addData()` 方法后当显示鼠标悬停标签出错的问题；
+ Chosen：
  * 优化 搜索策略，现在会搜索 `<option>` 上的 `value` 属性；
  * 优化 当 `drop_direction` 选项设置为 `'auto'` 时，现在弹出方向不会随着条目数目变动；
  * 修复 当用户点击一个允许用户滚动对容器内的 chosen 时自动更改父级元素滚动位置的问题；
+ 模态框：
  * 优化 `moveable` 选项，当设置为 `'inside'` 时不会允许用户将模态框移动到窗口可视区域之外；
+ 模态框触发器：
  * 修复 `className` 选项失效的问题；
  * 修复 有时当用户点击链接触发执行文本中的 JavaScript 代码的问题；
  * 修复 `broken` 事件中返回的错误文本内容没有显示的问题；
+ 拖放：
  * 优化 对拖放决策对支持，增加 `canMoveHere` 选项；
  * 优化 `move` 选项，现在可以使用一个回调函数来执行移动操作；
+ 拖放排序：
  * 优化 拖放初始化选项，增加对 `lazy`、`canMoveHere`、`nested` 选项对支持；
  * 修复 `start` 事件中获取不到事件参数 `event` 的问题；
  * 修复 `destroy` 无效的问题；
  * 修复 新增加的条目无法排序的问题；
+ 树形菜单：
  * 优化 了图标，现在看起来图标更大些；
+ 组织结构图：
  * 修复 有时连接线绘制不正确的问题；
  * 优化 图标的默认颜色；
  * 优化 节点对象结构，支持 `foldable` 属性来设置是否可以折叠该节点；
+ 日历：
  * 优化 了拖放到日期时界面响应拖放事件的区域，现在拖放到日期单元格上任意位置即可；
  * 优化 对 `dragThenDrop` 选项的支持，现在可以使用一个对象来初始化拖放插件；
  * 优化 对界面上周末的支持，使用 `hideEmptyWeekends` 选项可以折叠周末所在列；
+ 漂浮消息：
  * 修复 了 `contentClass` 选项失效的问题；
+ 表单：
  * 修复 在 Android 上复选框和单选框位置问题；
+ 设备检测辅助类：
  * 增加 对操作系统的检测功能，在 `<html>` 会自动添加 `os-win` 或 `os-mac` 等辅助类用于为不同的操作系统应用样式；
+ 主题：
  * 增加 对开关、树形菜单等组件的支持，优化了主题中按钮按下时的外观；
+ 其他：
  * 移除了 `svg` 标签 `max-width` 样式设定，避免在一些地图控件中造成冲突。


## v 1.7.0

本次更新修复了文件上传等组件等关键 bug，增加了一个新的视图：组织结构图，轻松绘制多级树形组织结构图，支持节点的动态更新和层级折叠控制。

### 更新明细

* 组织结构图：
  - 增加组织结构图视图，轻松绘制多级树形组织结构图，支持更新和折叠控制；
* 图标：
  - 增加了一些新的图标：`.icon-plus-sign-alt`，`.icon-check-plus`，`.icon-chanzhi`，，`.icon-chanzhi-pro`，，`.icon-zsite`，，`.icon-zsite-pro`；
* 文件上传：
  - 修复当启用重命名功能时，不显示删除按钮的问题；
  - 修复 `multipart_params` 选项设置无效的问题；
  - 当选项 `multipart_params` 为函数时，该回调函数会使用当前文件对象作为第一个参数，默认值作为第二个参数；
  - 文件下载按钮会使用 `download` 属性指定文件下载文件名；
  - 当禁用文件扩展名重命名时（`renameExtension` 设置为 `false`），在重命名时不显示扩展名；
  - 修复了有时重命名之后文件列表没有更新的问题；
* 辅助类：
  - 现在可以使用颜色命名的辅助类添加文本颜色、背景样式，包括（`.text-red`，`.text-green`，`.bg-yellow`，`hl-blue` 等）；
* 对话框触发器：
  - 支持使用 `className` 选项来指定生成的对话框额外添加的 CLASS 属性；
* 图表：
  - 饼状图支持设置外部文本标签的行高（使用 `scaleLineHeight` 选项）；
  - 修复了图表对 ZUI 独立组件 `colorset.js` 的依赖，现在快捷指定图表配色不需要单独引入 `colorset.js` 插件；
* 数据表格：
  - 增加 `fixCellHeight` 选项用于禁用自动调整行高（行高可以使用 CSS 设定，从而避免每次自动计算提示了性能），默认为 `true`（启用自动调整，行为与之前的版本一致）；
* 仪表盘：
  - 修复面板配置中的 `panelAttrs` 和 `colAttrs` 选项无效的问题；
* 颜色处理：
  - `$.zui.Color` 类增加类方法 `get(colorName)`，用于快速创建一个新的颜色实例；
* 拖拽、拖放、拖放选取、拖放排序：
  - 增加 `mouseButton` 选项用于指定点击哪个鼠标按键会出发拖放操作；
  - 拖放排序修复调用 `destroy()` 方法出错的问题；
* 输入组：
  - 优化输入组在紧凑表单内的圆角边框效果；
* 文档：
  - 所有独立组件相关的文档增加引入 `lib` 目录下资源的提示；
  - 文档网站所使用的 ZUI 不再单独定制的，现在使用 ZUI 标准版。

## v 1.6.0

### 更新明细

* 文件上传：
  - 新增文件上传视图，支持如下特色功能：
    + 提供多种预设的文件列表界面，包括普通列表、大号列表及网格；
    + 支持大文件分片上传；
    + 支持显示文件上传进度及上传速度等状态信息；
    + 支持自定义界面模板，灵活定制个性化的文件上传界面；
    + 支持拖拽文件上传；
    + 支持文件队列，可以自动或手动上传文件；
    + 支持七牛 js-sdk 上传文件，只需要简单配置；
    + 支持图片文件缩略图及显示文件的个性图标；
    + 支持过滤图片文件大小及格式、支持预处理图片文件（包括缩放、裁剪等）；
    + 支持 HTML5、flash、serverlight 等形式上传文件；
    + 支持对服务器结果进行识别，包括上传结果及自动为下载按钮应用下载地址；
    + 支持在文件列表显示静态文件；
* 图标：
  - 新增了一些字体图标，包括 `.icon-database`、`.icon-eraser`、`.icon-strikethrouth`、`.icon-underline`、`.icon-header`、`.icon-italic`；
  - 修复了图标旋转辅助类在低版本 IE 中无效的问题；
* 开关控件：
  - 新增开关控件 `.switch`，详情访问 http://zui.sexy/#control/switch ；
* 文档网站：
  - 修正当页面打开对话框后按 `ESC` 键导致文档页面关闭而对话框背景层还存在导致页面不可用的问题；
  - 修正了文档上一些资源的路径，现在文档支持使用网址的二级目录形式访问；
  - 文档上了示例代码都增加了语言类型提示；
* 标签页导航：
  - 新增垂直的标签页式导航，使用 `.nav.nav-tabs.nav-stacked` 实现；
* 垂直菜单：
  - 修复垂直菜单初始状态下展开折叠指示图标不正确的问题；
  - 垂直菜单已不建议使用，现在可以使用树形菜单 `.tree.tree-menu` 来实现垂直菜单的功能，详情参见文档 [视图 → 树形菜单 → 树形导航菜单](#view/tree/1)；
* 树形菜单：
  - 新增树形导航菜单外观，使用 `.tree.tree-menu` 实现；
  - 修复了 `.tree-lines` 在一些情况下连接线不连贯或超出的问题；
* 图表：
  - 更改了配置项 `multiTooltipTemplate` 的默认值，现在默认情况下会显示数据值所属的数据表名称；
  - 优化饼图上的标签显示策略，现在标签会自动选择合适的位置显示，不会重叠在一起；
* 拖拽：
  - 重做了拖拽插件，支持一次性初始化多个被拖拽元素（包括动态加入的元素），提升了性能；
* 拖放：
  - 重做了拖放插件，支持为一组元素（包括动态加入的元素）的拖放操作，提升了性能；
* 拖放排序：
  - 重构了拖放排序插件，提升了插件性能，解决了在多次调用后导致卡顿的问题；
* 拖拽选取：
  - 修复了有时 `finish` 事件没有被触发的问题；
  - 修复了在极端情况下 `mouseup` 事件没有触发导致选择框无法消失的问题；
  - 提升了拖拽选取交互过程中的性能；
* 看板：
  - 提升了性能，修复了看板上的条目在拖动时重复绑定事件的问题；
* 日历：
  - 提升了性能，修复了在某些极端情况下导致无法放置拖放的日历事件的问题；
* 仪表盘：
  - 仪表盘现在支持通过拖拽面板底部边缘来调整面板的高度，在同一行上的面板会在其中一个高度变化时自动调整高度来保持一致；
  - 提升了插件运行效率；
* 提示消息：
  - 增加了 `tipClass` 和 `tipId` 选项；
  - 增加多种颜色主题，可以通过 `tipClass` 来指定；
* 弹出面板：
  - 增加了多种颜色主题；
  - 修复了在手动调用 `$().tooltip('hide')` 之后，没有从页面移除动态生成的 `.tooltip` 元素的问题；
* 下拉菜单：
  - 增加 `.dropdown-hover` 类来实现不需要点击触发按钮只需要鼠标悬停就可以展开下拉菜单面板；
* 文字排版：
  - 有序列表增加 `.ol-pd-2`、`.ol-pd-3`、`.ol-pd-4` 特殊类来修正左侧边距，并提供了一个 JS 方法 `$().fixOlPd()` 来手动修正；
  - `<hr>` 元素增加了 `.divider` 和 `.divider-sm` 类获得不同外边距的分割线；
  - 为 MacOS 增加苹方字体；
* 漂浮消息：
  - 修复了当指定了自定义操作按钮及 `onAction` 事件回调函数时提示 `result` 未定义大问题；
  - 修复了方法名命名错误，`destory` 更正为 `destroy`；
  - 修复了使用 `new` 方法创建实例时报错的问题（issue #32）；
* 富文本编辑器：
  - 重构了打包任务，修复了在 `dist` 目录下没有包含插件资源的问题；
  - 修复了在一些浏览器上对话框上的按钮在英文界面上文字显示不全的问题；
* 日期选择器：
  - 修复了在点击清空按钮后，再次弹出日期面板上的左右切换日期按钮失效的问题；
  - 新增 `eleClass` 和 `eleId` 选项来为动态生成的日期选择面板元素指定 CLASS 和 ID 属性；
* 颜色选择器：
  - 修复了 `updateColors()` 和 `addColor()` 方法无法直接添加字符串形式的颜色值的问题；
  - 修复了在 jQuery 3.x+ 上报错的问题；
* Chosen：
  - 增加 `middle_hightlight` 选择来让打开下拉面板时选中的选项尽量列表中间位置；
* 主题：
  - 修复了在主题中为面板组和标签设置圆角值无效的问题；
* 其他：
  - `.show` 辅助类会使用 `!important` 修饰，避免在一些情况下失效；
  - 增加辅助方法 `$.zui.strCode(str)` 来将一个字符串转换为一个唯一的数值，任何字符串都对应一个唯一的整数；


## v 1.5.0

新增拖拽选取和颜色选择器插件，大量组件根据社区反馈进行了优化，修复了已发现的问题，加入支付宝和淘宝相关字体图标。
文档网站得到大幅改进，为宽屏用户增加了双栏浏览模式，大部分组件文档都得到更新，更全面的说明更多的示例和代码。

### 更新明细：

 * 文档网站：
    - 新增一些基础内容文档，一些缺失文档的组件得到更新，包括：多选和单选框、Color、拖动、拖放排序等，大量旧的文档得到更新；
    - 新增双栏浏览模式，实现在宽屏设备上同时浏览目录和页面内容，要求浏览器视窗宽度不少于 `1200px`；
    - 所有内部页面均转换为 Markdown 格式，更易于维护；
    - 修复第一次访问文档有时无法成功获取病显示 ZUI 版本号，并且无法自动打开 URL 指定的的子页面；
    - 修复加载内部页面有时出错的问题；
    - 修复内部页面顶部徽标信息不正确的问题，所有源于 Bootstrap 组件的内容在内部页面都有专门的徽标标识，源码及打包文件列表下拉菜单中不再显示压缩后（包含 `*.min.*`）的文件链接，文件链接会指向当前版本的链接而不是最新开发中的文件；
    - 修复“选择版本和定制”页面组件清单不准确的问题，增加显示组件来源信息；
    - 当使用 `file:` 协议访问文档首页时会显示部署到服务器的提示信息；
    - 修复内容页面加载失败后错误信息不显示的问题；
    - 优化文档资源（包括 JSON 文件和图片），提升加载速度；
    - 当前版本新增或得到更新的文档内容页面会在目录显示对应的徽标；
    - 增强文档搜索功能，支持 `v:` 和 `v:new` 命令来查找更新和新增的内容；
    - 完善了文档索引数据，更方便搜索内容，更准确的目录信息；
    - 优化打开日期选择插件页面后在主页面创建很多无用的元素的问题；
    - 文档网站不再为 IE8-10 提供完整支持；
    - 优化文档在移动设备上的体验；
 * 颜色选择器：
    - 新增颜色选取插件，方便用户选择预设的颜色或输入颜色值，在 `dist/colorpicker` 目录下可以找到相关文件；
 * 拖拽选取：
    - 新增拖拽选取插件，方便用户通过拖拽区域来选择区域范围内的元素，在 `dist/selectable` 目录下可以找到相关文件；
 * 图标：
    - 新增支付宝和淘宝图标；
    - 使用 `.icon` 类实现等宽图标；
 * 树形菜单：
    - `initialState` 选项新增 `preserve` 值，允许使用本地存储来还原用户上次操作后的状态；
    - 新增一系列新的选项支持动态构建和更新 DOM 节点，新增导出数据功能；
    - 优化 `.tree-lines` 选项，现在任何时候都不会显示多余的连接线；
 * 漂浮消息：
    - 现在可以通过多个消息示例在页面上同时显示多条消息；
    - 现在可以自定义消息右侧的操作按钮，可以同时显示多个操作按钮；
    - 支持通过选项来指定动态创建的消息元素的类；
    - 新增 `destory` 方法，从页面移除动态创建的元素；
 * Kindeitor：
    - 修复页面上无法加载 `kindeditor.min.css` 的问题；
    - 移除 `dist/kindeditor` 目录下的一些没有用到的文件；
    - Kindeitor 在获得焦点时会自动为编辑器容器元素添加 `.hover` 类来实现获得焦点外观效果，不再需要用户手动绑定 `afterFocus` 和 `afterBlur` 事件来实现；
 * UEditor：
    - 为 UEditor 增加主题样式表，可以在 `dist/ueditor/` 目录下找到；
 * jQuery：
    - 修复与 jQuery 2.* 及 3.* 版本一起使用时发生错误的问题；
 * 下拉菜单：
    - 优化包含子菜单的下拉菜单，可以为子菜单的 `.dropdown-menu` 添加 `.pull-left` 类来更改子菜单弹出方向；
    - 优化下拉菜单按钮中的三角图标样式；
 * 标签页：
    - 现在可以通过为触发元素添加 `[data-tab]` 属性来快捷启用标签页；
 * 折叠：
    - 优化折叠分组的实现，不仅仅是面板组，现在可以使用任何相同的父级元素来实现任意分组；
 * 栅格和布局：
    - 增加 `.container-fluid` 和 `.container-fixed-*`；
    - `.responsive-*` 可以配合 `.inline` 和 `.inline-block` 使用；
 * 文字排版：
    - 增加 `.dl-inline` 辅助类；
    - 优化引用块的外观；
 * 代码：
    - 新增对 `<kbd>` 应用外观样式；
    - 新增 `.code` 类应用等宽字体样式；
 * 滚动条：
    - 滚动条外观仅仅针对移动设备使用；
 * 进度条：
    - 优化条纹外观效果；
 * 标签和徽标：
    - 优化标签和徽标外观，优化其在导航中或配合其他组件使用时的样式；
 * 表格：
    - 新增 `.table-auto` 类实现自动宽度表格；
 * 表单：
    - 优化表单控件及视图，移除表单中对 `.control-label` 的依赖；
 * 导航和导航条：
    - 限制了 `.navbar-brand` 的水平内边距，不会出现过小的情况；
 * 本地存储：
    - 修复了本地存储不可用出现错误的问题；
    - 现在在本地存储不可用时调用相关方法也不会出现错误，这些数据会存储在内存中；
 * 工具提示：
    - 修复使用 `show` 方法更新内容失效的问题；
 * 对话框、对话框触发器：
    - 修复 iframe 对话框设定 `[data-height]` 后无法显示的问题；
    - 修复对话框触发器的 `loaded` 事件有时会调用两次的问题；
    - 重新设计了全屏对话框外观，`.modal-body` 的内容超出后允许滚动浏览；
 * 模态对话框：
    - 调整按钮顺序，现在表示积极操作的按钮会显示在前面；
 * 分页条：
    - 修复激活的条目和禁用的条目样式有时没有生效的问题；
    - 优化激活的条目的外观；
 * 日历：
    - 修复“今天”按钮不同年份也被禁止点击的错误；
    - 修复 `startDate` 选项设置无效的问题；
 * 仪表盘：
    - 新增 `data` 选项，允许通过数据来动态创建面板内容；
    - 支持通过拖拽面板边缘更改栅格尺寸功能；
    - 优化从远处更新面板内容的策略；
    - 优化操作按钮外观；
    - 新增 `.panel-loading` 应用加载中的动态图标；
 * 图片浏览：
    - 修复打开图片浏览页面发生抖动的问题；
 * Color：
    - `isColor` 现在是类方法，不需要在实例上调用；
    - 允许通过 `Color.names` 访问所有已命名的颜色；
 * 数据表格：
    - 修复固定头部时 `z-index` 过大会挡住页面其他内容的问题；
    - 支持拖拽选取行；
    - 修复点击切换选中行有时失效的问题；
    - 现在可以随时通过 `chekcs` 属性来访问行选中情况；
    - `fixedHeader` 选项默认值设置为 `false`，避免在一些情况下出现错位的问题；
 * 文章：
    - 新增 `.content` 类来取代 `.article-content`，在 `.content` 内段落等元素会应用下边距；
 * 卡片：
    - 优化卡片视图外观；
 * 图表：
    - 修复饼状图环绕文字标签有时不显示的问题；
 * 看板：
    - 可以通过 `.droppable` 选项来自行处理拖拽过程；
    - 移除对 `[data-toggle="boards"]` 的支持；
 * 图片剪切：
    - 新增 `resetImage` 方法动态设置待剪切的图片；
 * 主题：
    - 修复主题中面板颜色主题不正确的问题；
    - 修复了主题中分页控件激活的条目没有应用主题配色的问题；
 * 开发者支持：
    - 发布到了 npm；
    - 支持使用 `npm start` 命令启动本地文档网站服务器（`http-server` 实现）；
    - 优化 gulp 任务，支持更多选项，新增 `lib` 和 `minJSON` 任务；
    - 修改 `autoprefixer` 选项，现在已明确指定各浏览器版本；
    - 移除了 `navbars.fixed-left.less`、`pager.popover.less`、`auto-trigger.js`、`pager.js`；
    - 现在可以使用 `gulp lib` 来调用 `seperate` 任务；
    - 优化文档的 debug 浏览模式；
    - `boards`、`dashboard`、`sortable` 不再在标准版中提供；`bootbox`、`.colorpicker`、`colorset.js`、`dashboard`、`imgready`、`selectable`、`sortable`、`ueditor` 已加入独立组件包；
    - 通过 gulp 生成的文件模式更改为 `644`。


## v 1.4.0

本次更新了大部分文档，增加了必要的代码示例。
简单易用的[树形菜单组件](http://zui.sexy/#view/tree)加入了ZUI。
主题功能得到增强，文档中的[主题章节](http://zui.sexy/#basic/theme)提供实时预览和编译定制功能。
修复了论坛和QQ群中反馈的大部分问题。

### 更新明细

 * 完善和持续改进文档：
     - 大部分组件文档都得到更新，增加了更多的示例和示例代码；
     - 文档中的主题章节支持直接预览主题，并可以自定义修改主题配置并编译和下载主题（此功能在IE8等古老浏览器上不可用）；
     - 文档支持查看组件的源码和打包信息；
     - 文档中的示例代码支持复制；
     - 更正文档中的多个链接和拼写错误；
     - 修复滚动条文档无法加载并显示的问题；
 * 排版样式：
     - 更改字体设置；
     - 简化CSS CLASS名称，`hightlight-*`更名为`hl-*`；
 * 栅格系统：
     - 增加`.col`辅助类来方便自定义栅格大小；
 * 提示消息和提示面板：
     - 提示消息支持`tipClass`和`tipId`选项；
     - 提示消息的`show(content)`方法增加content参数来动态改变现实的内容；
 * 图标：
     - 图标名称`icon-yingyang`更正为`icon-yinyang`，`icon-check2`更正为`icon-checked`；
     - 修复图标旋转效果在非块级标签内无法生效的问题；
     - 更新图标字体，更改了字体的`base height`，现在图标和文字混合时更为自然；
 * 消息框：
     - 移除了消息框的边框，现在看起来更为扁平；
     - 增加`.alert-primary-inverse`的深色外观的使用主要配色的消息框；
 * 标签和徽标：
     - 更改标签和徽标的内边距和行高，解决在部分浏览器中的尺寸和对齐问题；
 * 按钮和按钮组：
     - 更改按钮样式，更加扁平化；
     - 链接按钮的默认背景色现在为`transparent`；
     - 更改按钮选中或激活时的外观，现在看起来更为明显；
     - 按钮的圆角边框可以在`variables.less`中单独定义；
     - 更改按钮的过渡动画时间从预设的较慢时间更改为正常时间，预设的时间参考`variables.less`中的定义；
     - 修复垂直按钮组上顶部第一个按钮圆角边框显示不正确的问题；
 * 滚动条：
      - 优化Webkit家族浏览器上滚动条的样式；
 * 表单控件：
     - 优化表单中的单选框和复选框的样式，现在与文字混合使用时在垂直方向上看起来更为居中；
     - 更改一些被禁用的表单项目样式，更改鼠标悬停时的光标；
 * 导航：
     - 修复垂直导航的圆角样式；
 * 进度条：
     - 调整进度条外观，移除阴影效果，现在看起来更为扁平；
 * 面包屑：
     - 更改面包屑激活项目的颜色，现在看起来更为明显；
 * 树形菜单：
     - 增加树形菜单视图；
 * 对话框和对话框触发器：
     - 模态框框更名为“对话框”；
     - 对话框支持全屏对话框，通过`.modal-fullscreen`实现；
     - 修复对话框触发器中的模态框大小配置没有正确应用的问题（[by @remind](https://github.com/easysoft/zui/issues/10)）；
     - 可拖拽移动的对话框开启选项名称由`draggable`更改为`moveable`；
     - 为所有类型的对话框增加`rememberPos`选项来记住用户拖拽后模态框的位置；
     - 修复了拖拽移动对话框时的一些错误；
     - 模态框框触发器更名为“对话框触发器”；
     - 远程对话框中的iframe标签增加`allowfullscreen`属性(by @YuanXu)；
     - 对话框触发器增加`iframeBodyClass`选项来定义远程对话框中的iframe标签上的CLASS；
     - 修复对话框触发器弹出的对话框有时高度不停微小浮动抖动的问题；
     - 对话框触发器增加`waittime`选项来显示远程内容加载的时间，增加`broken`事件来监听远程内容加载失败时的事件；
     - 对话框触发器增加`loadingicon`选项来自定义远程加载内容时所显示的图标；
     - 通过按钮触发的对话框触发器现在在每次触发时都会重新读取远程地址的值，意味着可以在每次弹出对话框之前通过更改地址参数来动态的通过对话框加载不同的远程内容；
 * 日期选择：
     - 日期选择插件增加`pcikerPosition`选项来控制弹出面板的弹出方向和显示位置，如果此选项指定为`auto-*`，则自动决定最合适的位置；
 * Chosen和图标选择插件：
     - 为Chosen增加`dropDirection`选项来控制弹出面板的弹出方向，如果为`auto`则自动决定最合适的位置；
     - 为Chosen增加`lang`选项来设置界面语言；
     - 优化Chosen界面样式；
     - 修复图标选择插件有时无法使用的问题；
     - 图标选择插件能选择更多的图标，包括WeChat图标；
     - 修复图标选择插件无法正确读取和应用语言设置的问题；
     - 加深了Chosen弹出面板的阴影效果，加强与其他内容的区分程度；
 * 漂浮消息：
     - 漂浮消息增加一个全局方法来隐藏所有已显示的消息；
     - 漂浮消息的圆角大小在`varuables.less`中可配置；
 * 滚动监听（scrollspy）：
     - 修复滚动监听事件名称错误；
 * 拖放排序：
     - 拖放排序组件增加`before`事件；
     - 修复`reset()`方法有时工作不正确的问题；
 * 表单：
     - 移除`<select>`在火狐浏览器中弹出时的虚线边框；
 * 代码及代码块：
     - 调整代码块中的行高，现在会显示的更为紧凑；
     - 当代码块使用prettify插件且启用显示行号时，移除底部多余的边距；
 * 数据表格：
     - 数据表格使用原生表格作为数据源时支持继承表格单元格上的`title`属性；
     - 更改数据表格中的水平滚动条鼠标光标样式；
     - 修复数据表格`load`方法通过`$().datatable('load', newData)`形式调用无法生效的问题；
     - 更改数据表格中选中行的图标；
     - 数据表格的数据增加`keepSort`属性来防止更新数据时排序发生重置的问题；
 * 看板视图：
     - 增加对`before`事件的支持；
 * 图表：
     - 优化chartjs，环状图表新增`showLable`选项来显示或隐藏标签；
     - 柱状图增加`showLable`和`scaleValuePlacement`选项来在柱形上指定位置显示标签；
     - 柱状图和条状图增加`scaleShowBeyondLine`选项来控制坐标轴样式；
 * 日历：
     - 修复日历中更新事件时发生错误的问题；
 * Bootbox：
     - 更改Bootbox中的事件名称，与ZUI其他组件中的事件名称保持一致。
     - Bootbox升级到4.4.0版本；
 * 图片浏览 (Lightbox)：
     - 更改图片浏览插件的样式，现在看起来更为扁平；
     - 修复图片浏览插件中的图片描述有时显示内容不正确的问题；
 * 图片裁剪：
     - 更改图片裁剪的API，增加更多事件，提交事件中包含更多的图片信息；
 * Kindeditor:
     - 修复Kindeditor在微软Edge浏览器和IE8中无法使用的问题；
 * 主题：
     - 大幅优化默认主题样式，修复部分第三方组件没有正确应用主题的问题；
     - 主题增加对圆角设置的支持；
 * 打包和编译：
     - 使用Gulp取代Grunt，移除项目对Gruntjs的依赖，重构其中的大部分编译和打包任务；
     - 数据表格从标准版中移除，已加入独立组件；
     - 图标选择插件（chosenicons）、代码美化高亮插件（prettify）和拖拽排序插件加入独立组件打包中；
     - 优化 代码和编译流程，减小标准版CSS文件大小（约减少3%）；
     - 支持 从`src/less/basic/setting.less`中读取LESS配置；
     - 重构`package.json`中的`lib`和`builds`数据，现在使用`zui.json`来单独管理这些数据；
 * 其他：
     - ZUI中的大部分组件动画过渡时间由原来的0.3s减少为0.2s，动画过渡效果会更快；
     - browser.js增加`.tip(content)`方法允许用户自定义浏览器低版本提示信息；
     - 更新excanvas.js；
     - 修复migrate 1.2中的错误；
     - 增加对bower的支持；
     - 优化代码结构和代码格式；
     - 为一些第三方组件增加版权声明信息。

## v 1.3.1

本次更新优化了文档网站体验，修复了一些bug。

### 更新明细

 * 更改 文档UI大量更改，更加紧凑易用，不再在新窗口中打开，网站增加favicon；
 * 修复 排序组件在配置为逆序排序时发生错误的问题；
 * 修复 预编译标准版可能出现zui属性未定义的问题。

## v 1.3

全新的文档网站来了！键盘侠新福利：使用搜索来查找内容，并支持快捷键操作。
增加图表视图组件，支持对饼图、柱状图和曲线图的展示。
另外微调了默认配色，对多个组件UI细节进行了优化，修复大量了问题。

### 更新明细
 * 全新 的文档网站，支持搜索和快捷键，按需使用Ajax获取文档内容，支持直接显示markdown格式的文档内容，多个组件的文档进行了完善；
 * 新增 了一组深色背景的消息框样式；
 * 新增 图标组件（基于ChartJS定制），支持展示曲线图、条状图和饼图，并且饼图支持直接显示数据标签，简化了该组件配色，为所有图表类型的数据集都增加了color属性，可以直接使用ZUI中的配色名称或者CSS颜色值来指定配色；
 * 新增 了一个辅助使用配色的javascript插件，方便在javascript使用ZUI的默认配色；
 * 新增 了缩放效果的动画辅助类；
 * 更改 了多个组件在就jQuery对象和window对象上的绑定，现在提供$.zui作为共享对象。
 * 更改 了轮播组件样式，降低了左右切换按钮的背景透明度，修复了切换按钮上的图标尺寸过小的问题；
 * 更改 了图标字体，增加了wechat等一些新的图标；
 * 更改 了模态框，增加了一个选项来使得模态框可以拖拽头部实时更改展示位置；
 * 更改 了仪表盘视图，增加一个新的选项来更改拖动时面板的形状，增强了仪表盘拖拽时的体验，增加了深色背景样式；
 * 更改 了拖放组件判断放置区域的逻辑，在拖拽点击事件开始时会阻止浏览器默认行为，现在更易于使用；
 * 更改 了模块框尺寸选项，现在可以设置模态框尺寸为全屏；
 * 更改 了默认配色，新的配色更有生命活力，；
 * 更改 了按钮外观，移除了按钮阴影；
 * 更改 了部分组件公开的事件名称；
 * 更改 卡片中的链接颜色，不再使用前景色而是一般链接颜色，鼠标悬停外观效果与普通链接一致；
 * 更改 了内置jQuery版本至1.11；
 * 更改 了工具提示和面板插件，增加了选项来设置动态生成的DOM的ID和css class属性，方便用户对特定的工具提示消息和面板来自定义样式；
 * 更改 了拖放和排序插件，增加绑定always事件，重构了内部实现逻辑；
 * 更改 了日历组件，修复了一些错误，调整了月视图样式，增加对跨天事件的支持，现在支持英文和繁体中文界面，修复了在IE上的兼容性问题，点击日期和事件回调的参数中会包含所点击的标签对象本身；
 * 更改 了看板视图，拖放事件可以监听，并取消本次拖放操作；
 * 更改 了Chosen组件，支持自定义动态生成的DOM的css class属性；调整了多选的界面，增加搜索图标；
 * 更改 了代码块的样式，修复了带行号的代码的样式问题；
 * 更改 了文章视图中的分页条样式，更加协调美观；
 * 更改 了垂直菜单的事件绑定对象，修复了特殊情况下展开和折叠失效的问题；
 * 修复 datatable全选按钮在reload之后失效的问题；
 * 修复 了模态框触发器中调用公开方法可能会出错的问题；
 * 修复 了自定义构建时消息框支持关闭的JS插件没有包含导致消息框关闭特性不可用的问题；
 * 修复 了仪表盘面板中的刷新按钮点击事件无效的问题；
 * 修复 了模态框触发器调用closeModal可能会出错的问题，更改了closeModal方法参数顺序；
 * 修复 了模态框触发器加载跨域远程内容时出错的问题；
 * 修复 了jQuery扩展辅助方法中的一些错误；
 * 修复 了数据表格有时排序失效的问题，修复了在IE浏览器上计算行高度错误的问题；
 * 修复 使用hsl值构建Color对象无效的问题；
 * 移除 了自动触发器插件，因为其使用的场景并不多见；
 * 新增 了migrate组件来解决1.2以下的版本升级到1.3版本可能遇到的兼容性问题。

## v 1.2

ZUI1.2正式版终于发布了！
此版本增加了很多新特性，同时修复了大量问题，文档也得到大幅完善。欢迎大家使用并反馈问题。

### 更新明细
 * 新增 日历视图组件，方便实现日程的展示；
 * 新增 数据表格视图组件，更轻松实现复杂数据的展示，移除table.data.js；
 * 重新实现的模态框触发器，模态框触发器同时支持加载远程内容和实时内容，实时根据自身内容调整位置和尺寸，重新设计了调用接口，使用更加方便，消除了模态框触发器于一般模态框发生冲突的隐患；
 * package.json增加组件及其依赖关系的配置，重新实现了Grunt任务，编译单独组件更加方便，并支持任意组件集合的打包编译，grunt任务将自动管理组件之间的依赖关系；
 * 大幅更新文档部分章节内容，并对文档整理样式进行了调整，在文档中可以查看每个组件属性，并给出第三方组件版本及用户支持信息，文档支持IE8，优化文档在小屏幕上的表现；
 * 重新实现了漂浮消息组件，调用更方便，更好的动画效果；
 * 新增新的第三方组件chartjs，能够绘制简单图表；
 * 增加browser.js，为IE系列的浏览器增加版本提示辅助类；
 * 新增 'store.js'，实现本地存储通用接口，并增加单独页面范围的独立存储机制，beta版本中的页面标识有时不正确的bug已得到修复；
 * 新增 'jquery.extensions.js'，增加一些实用的jQuery扩展方法，便于进行其他组件的开发，移除原'unities.js'；
 * 增加array.js，提供一些操作数组的实用方法；
 * 调整了dist目录结构，第三方组件和适合单独调用的组件将直接包含在lib目录中；
 * Chosen选项及分组支持title属性，Chosen弹出列表支持自定义宽度，调整多选Chosen中选项的样式；
 * 修复Chosen中特定情况下placeholder无法显示的问题；
 * 日期时间选择器将能够自动从html标签中获取页面语言设置并应用语言设置；
 * 调整左侧固定导航样式；
 * 在date.js中增加一些实用方法来帮助进行日期计算；
 * 模态框支持额外的两种默认尺寸，修复某些时候模态框弹出时滚动条闪动的问题；
 * 修复代码段第一行出现错位的样式问题；
 * 一些组件的额外组成部分其对应的文件被重新命名；
 * 修复特定情况下kindeditor图标无法显示的问题；
 * 优化区块面板视图动作按钮事件监听机制；
 * 修复color.js中增加命名颜色支持；
 * 优化bootbox中的语言文本；
 * 表格支持固定布局样式；
 * 弹出框增加新的选项能够制定JS生成DOM的id属性，便于自定义样式；
 * 大幅优化代码，修复一些在Javascript代码中的错误，完善关键代码注释，增强部分代码文件与requierejs的兼容性。


## v 1.2 beta

### 版本亮点
 * 新增日历视图组件，方便进行日常展示；
 * 新增数据表格组件，轻松实现复杂数据展示；
 * 全新实现的模态框触发器，同时支持加载远程内容和实时内容，更好的兼容性；
 * 重新实现了Grunt任务配置，定制编译将更加方便。
 * 大量组件细节优化，文档更新。

### 更新明细
 * 新增 日历视图组件，方便实现日程的展示；
 * 新增 数据表格视图组件，更轻松实现复杂数据的展示，移除table.data.js；
 * 重新实现的模态框触发器，模态框触发器同时支持加载远程内容和实时内容，实时根据自身内容调整位置和尺寸，重新设计了调用接口，使用更加方便，消除了模态框触发器于一般模态框发生冲突的隐患；
 * package.json增加组件及其依赖关系的配置，重新实现了Grunt任务，编译单独组件更加方便，并支持任意组件集合的打包编译，grunt任务将自动管理组件之间的依赖关系；
 * 大幅更新文档部分章节内容，并对文档整理样式进行了调整，在文档中可以查看每个组件属性，并给出第三方组件版本及用户支持信息，文档支持IE8，优化文档在小屏幕上的表现；
 * 新增新的第三方组件chartjs，能够绘制简单图表；
 * 增加browser.js，为IE系列的浏览器增加版本提示辅助类；
 * 新增 'store.js'，实现本地存储通用接口，并增加单独页面范围的独立存储机制；
 * 新增 'jquery.extensions.js'，增加一些实用的jQuery扩展方法，便于进行其他组件的开发，移除原'unities.js'；
 * 增加array.js，提供一些操作数组的实用方法；
 * 调整了dist目录结构，第三方组件和适合单独调用的组件将直接包含在lib目录中；
 * Chosen选项及分组支持title属性，Chosen弹出列表支持自定义宽度，调整多选Chosen中选项的样式；
 * 修复Chosen中特定情况下placeholder无法显示的问题；
 * 日期时间选择器将能够自动从html标签中获取页面语言设置并应用语言设置；
 * 调整左侧固定导航样式；
 * 在date.js中增加一些实用方法来帮助进行日期计算；
 * 模态框支持额外的两种默认尺寸，修复某些时候模态框弹出时滚动条闪动的问题；
 * 修复代码段第一行出现错位的样式问题；
 * 一些组件的额外组成部分其对应的文件被重新命名；
 * 修复特定情况下kindeditor图标无法显示的问题；
 * 优化区块面板视图动作按钮事件监听机制；
 * 修复color.js中增加命名颜色支持；
 * 优化bootbox中的语言文本；
 * 表格支持固定布局样式；
 * 大幅优化代码，修复一些在Javascript代码中的错误，完善关键代码注释，增强部分代码文件与requierejs的兼容性。


## v 1.1
 * 新增 拖动排序插件，通过拖拽来重新给DOM节点排序；
 * 增强 Chosen组件支持为待选列表添加额外的数据用来索引；
 * 增强 拖放插件增加触发选择器参数，可以自定义拖拽事件触发的内容，此参数支持函数来动态获取值；
 * 修复 Lightbox在小屏幕上显示问题；
 * 修复 轮播在触摸屏幕上无法点击链接的问题
 * 项目网站更改为 [http://zui.sexy](http://zui.sexy)
