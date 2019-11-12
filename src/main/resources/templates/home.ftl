<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title></title>
        <link rel="stylesheet" type="text/css" href="layui/css/layui.css">
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="layui/layui.js"></script>
        <script type="text/javascript" src="js/studentAdd.js"></script>
		<style>
		    .layui-tab-item layui-show{
		        height: 100%;
		    }
		</style>
	</head>
    <body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">学生信息管理</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="/admin">首页</a></li>
            <li class="layui-nav-item"><a href="/stud">学生信息</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    贤心
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>
		<link rel="import" href="header.html" id="page1"/>
    <#--    导入左侧页面元素-->
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">学生信息</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" class="add" id="1">录入学生信息</a>
                        </dd>
                        <dd>
                            <a href="javascript:;" class="add" id="2">录入学生分数</a>
                        </dd>
                        <dd>
                            <a href="javascript:;" class="add" id="3">查看学生信息</a>
                        </dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <!-- tab选项卡 -->
		
        <div style="padding: 15px;">
			
            <div class="layui-tab" lay-filter="demo" lay-allowclose="true" >
                <ul class="layui-tab-title" ></ul>
                <div class="layui-tab-content" >
                </div>
            </div>
            <script>
                layui.use(['element', 'jquery'], function () {
                    var $ = layui.jquery,
                        element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
                    //点击左边的按钮,然后判断是否新增tab还是需要定位一个tab
                    $(".add").click(function () {
                        //获取被点击的元素id,来取得准确的元素
                        var id = $(this).attr('id');
                        //判断是否需要新增还是定位
                        if ($("[lay-id=" + id + "]").length > 0) { //存在
                            //存在的话,要给这个元素动态的追加属性data-type="tabChange"
                            $(this).attr('data-type', 'tabChange');
                            //切换到指定Tab项
                            element.tabChange('demo', id); //切换到：用户管理
                        } else { //新增
                            $(this).attr('data-type', 'tabAdd');
                            //根据id判断嵌入什么页面
							if(id=="1"){
								element.tabAdd('demo', {
									title: $(this).text(), //用于演示	,
									content: '<iframe src="/dostudentAdd" frameborder="0" height="700px" width="100%"></iframe>',
									id: id //实际使用一般是规定好的id，这里以时间戳模拟下
								});
								$(this).attr('data-type', 'tabChange');
								//切换到指定Tab项
								tabChange();
								//element.tabChange('demo', id); //切换到：用户管理
							}else if(id=="2"){
								element.tabAdd('demo', {
									title: $(this).text(), //用于演示	,
									content: '<iframe src="/dofractionAdd" frameborder="0" height="700px" width="100%"></iframe>',
									id: id //实际使用一般是规定好的id，这里以时间戳模拟下
								});
								$(this).attr('data-type', 'tabChange');
								//切换到指定Tab项
								element.tabChange('demo', id); //切换到：用户管理
							}else if(id=="3"){
                                element.tabAdd('demo', {
                                    title: $(this).text(), //用于演示	,
                                    content: '<iframe src="/doquery" frameborder="0" height="700px" width="100%"></iframe>',
                                    id: id //实际使用一般是规定好的id，这里以时间戳模拟下
                                });
                                $(this).attr('data-type', 'tabChange');
                                //切换到指定Tab项
                                element.tabChange('demo', id); //切换到：用户管理
                            }
                        }
                    });

                    $('.site-demo-active').on('click', function () {
                        var othis = $(this),
                            type = othis.data('type');
                        //active[type] ? active[type].call(this, othis) : '';
                    });

                    //Hash地址的定位
                    var layid = location.hash.replace(/^#test=/, '');
                    element.tabChange('test', layid);

                    element.on('tab(test)', function (elem) {
                        location.hash = 'test=' + $(this).attr('lay-id');
                    });
                });
            </script>
            <div class="layui-footer">
                <!-- 底部固定区域 -->
                © layui.com - 底部固定区域
            </div>
        </div>
    </div>
</div>
	</body>
</html>
