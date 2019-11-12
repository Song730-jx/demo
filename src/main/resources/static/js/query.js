
layui.use(['table', 'layer', 'jquery', 'form', 'element', 'laypage',], function () {

    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.jquery;
    var form = layui.form;
    var element = layui.element;
    var laypage = layui.laypage;
//渲染数据表格
    var limit;
    var page;
    var curre_page;
    var tableIns = table.render({
        elem: '#test'//渲染目标
        ,id:'userTableReload'
        , url: '/getListGrade'//数据接口
        , page: true
        , even: true
        , limit: 10

        , done: function (rest, curr, count) {
            console.log(rest);//后台返回的json字符串
            console.log(curr);//当前页
            console.log(count);//数据总条数
        }
        , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        , defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
            title: '提示'
            , layEvent: 'LAYTABLE_TIPS'
            , icon: 'layui-icon-tips'
        }]
        , title: '用户数据表'//excel导出
        , cols: [[
            {type: 'checkbox', fixed: 'left'}
            , {field: 'id', title: 'ID', width: 80, fixed: 'left', unresize: true, sort: true}
            , {field: 'name', title: '姓名', width: 120, edit: 'text'}
            , {field: 'age', title: '年龄', width: 150}
            , {field: 'fraction', title: '成绩', width: 100}
            , {field: 'grade', title: '班级'}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150}
        ]],
        page: true
    });

    laypage.render({
        elem: 'demo2'
        , count: 100 //res.数据总数
        , limit: limit//
        , curre: curre_page//当前页
        , theme: '#1E9FFF'
    });
//模糊查询

    var $ = layui.$, active = {
        reload: function () {
            var name = $("#name");
            var gradeId = $("#gradeId");
            alert(gradeId);
            //执行重载
            table.reload('userTableReload', {
                 where: {
                    'name': name.val(),
                    'gradeid': gradeId.val()
                }
            }, 'data');
        }
    };
    $('.demoTable .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
        return false;
    });

    //导出点击事件
    $('#excel').click(function () {
        $.post("/excel", function (result) {
            window.open(result);
        });
    });

    //头工具栏事件
    table.on('toolbar(test)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'getCheckData':
                var data = checkStatus.data;
                layer.alert(JSON.stringify(data));
                break;
            case 'getCheckLength':
                var data = checkStatus.data;
                layer.msg('选中了：' + data.length + ' 个');
                break;
            case 'isAll':
                layer.msg(checkStatus.isAll ? '全选' : '未全选');
                break;
            case 'add':
                addStudents()
                break;

            //自定义头工具栏右侧图标 - 提示
            case 'LAYTABLE_TIPS':
                layer.alert('这是工具栏右侧自定义的一个图标按钮');
                break;
        }
    });
    //请求路径
    var url;
    //标记弹出层
    var mainIndex;

    //添加弹窗
    function addStudents() {
        mainIndex = layer.open({
            type: 1,
            title: "添加用户",
            skin: 'layui-layer-rim', //加上边框
            area: ['500px', '500px'], //设置宽高
            content: $("#updateOrDelete"),
            success: function (index) {
                //清空
                $("#dataFor")[0].reset();
                url = "";
            }
        });
    }

    //修改弹窗
    function modify(data) {
        mainIndex = layer.open({
            type: 1,
            title: "修改用户",
            skin: 'layui-layer-rim', //加上边框
            area: ['500px', '500px'], //设置宽高
            content: $("#updateOrDelete"),
            success: function (index) {
                form.val("dataForm", data);
                url = "/update"
            }
        });
    }

    //监听提交事件
    form.on("submit(formDemo)", function (obj) {
        //序列化表单提交数据
        var serialize = $("#dataFor").serialize();
        //发送ajasx请求
        var id = obj.id;
        $.post(url, serialize, function (result) {
            layer.msg("成功");
            //关闭弹出层
            layer.close(mainIndex);
            //刷新数据表格
            tableIns.reload();
        });
    });

    //监听行工具事件
    table.on('tool(test)', function (obj) {
        var data = obj.data;//获得当前行数据
        //console.log(obj)  obj.event获取lay-event 对应的值
        if (obj.event === 'del') {
            layer.confirm('真的删除行么', function (index) {
                obj.del();
                layer.close(index);//向服务端发送删除指令
                //删除事件
                $.post("/delete", {id: data.id}, function () {
                });
            });
        } else if (obj.event === 'edit') {//编辑
            modify(data);
        }
    });

    $("#but").click(function () {
        var serialize = $("#formStudent").serialize();
        $.post("/update",
            serialize,
            function () {
            })
    });
});
