<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="layui/layui.js"></script>
    <script type="text/javascript" src="js/fractionAdd.js"></script>
</head>
<body >
        <!-- 内容主体区域 -->
            <table class="layui-hide" id="test" lay-filter="test"></table>
            <div class="layui-btn-container">
                <table class="layui-hide" id="test" lay-filter="test"></table>
            <br><br>
        </div>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
<script id="toolbarDemo" type="text/html">
    <div class="layui-btn-container">
        <button id="add" class="layui-btn layui-btn-sm">添加</button>
    </div>
</script>

</body>
</html>
