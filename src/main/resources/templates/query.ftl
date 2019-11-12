<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css">
<#--
    <script type="text/javascript" src="js/jquery.js"></script>
-->
    <script type="text/javascript" src="layui/layui.js"></script>
    <script type="text/javascript" src="js/query.js"></script>
</head>
<body >
            <table class="layui-hide" id="test" lay-filter="test"></table>
            <div class="layui-btn-container">
                <table class="layui-hide" id="test" lay-filter="test"></table>
            </div>
            <br><br>

    <div style="display: none" id="updateOrDelete">
        <form class="layui-form" lay-filter="dataForm" id="dataFor">
            <div class="layui-form-item" style="display: none">
                <label class="layui-form-label">n</label>
                <div class="layui-input-block">
                    <input type="text" name="id" required lay-verify="required" placeholder="id" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">姓名</label>
                <div class="layui-input-inline">
                    <input type="text" name="name" required lay-verify="required" placeholder="请输入姓名" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">年龄</label>
                <div class="layui-input-inline">
                    <input type="text" name="age" required lay-verify="required" placeholder="请输入年龄" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">成绩</label>
                <div class="layui-input-inline">
                    <input type="text" name="fraction" required lay-verify="required" placeholder="请输成绩" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item" style="width: 50%">
                <label class="layui-form-label">年级</label>
                <div class="layui-input-block">
                    <select name="gradeId" lay-verify="required">
                        <option value="1">一年级</option>
                        <option value="2">二年级</option>
                        <option value="3">三年级</option>
                        <option value="4">四年级</option>
                        <option value="5">五年级</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo" id="but">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>

<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
    });
</script>
<script id="toolbarDemo" type="text/html">
    <div class="demoTable">
        <div class="layui-form-item">
            <div class="layui-inline">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input  type="text"  placeholder="请输入学生姓名" class="layui-input" id="name">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label" >年级</label>
            <div class="layui-input-block">
                <select  lay-filter="aihao" id="gradeId">
                    <option value="0">请选择年级</option>
                    <option value="1">一年级</option>
                    <option value="2">二年级</option>
                    <option value="3">三年级</option>
                    <option value="4">四年级</option>
                    <option value="5">五年级</option>
                </select>
            </div>
        </div>
            <button class="layui-btn" data-type="reload">查询</button>
            <button class="layui-btn" lay-submit lay-filter="formDemo" id="excel">导出</button>
        </div>
    </div>
</script>

<script id="barDemo" type="text/html">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

</body>
</html>
