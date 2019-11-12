layui.use('table', function(){
    var table = layui.table;

    table.render({
        elem: '#test'
        ,url:'/getListFraction'
        ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        ,defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
            title: '提示'
            ,layEvent: 'LAYTABLE_TIPS'
            ,icon: 'layui-icon-tips'
        }]
        ,title: '用户数据表'
        ,cols: [[
            {type: 'checkbox', fixed: 'left'}
            ,{field:'id', title:'学号', width:80, fixed: 'left', unresize: true, sort: true}
            ,{field:'name', title:'姓名', width:100, edit: 'text'}
            ,{field:'age', title:'年龄', width:150}
            ,{field:'fraction', title:'分数', width:100, edit: 'text'}
        ]]
        ,page: true
    });

    //头工具栏事件
    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        switch(obj.event){
            case 'getCheckData':
                var data = checkStatus.data;
                layer.alert(JSON.stringify(data));
                break;
            case 'getCheckLength':
                var data = checkStatus.data;
                layer.msg('选中了：'+ data.length + ' 个');
                break;
            case 'isAll':
                layer.msg(checkStatus.isAll ? '全选': '未全选');
                break;

            //自定义头工具栏右侧图标 - 提示
            case 'LAYTABLE_TIPS':
                layer.alert('这是工具栏右侧自定义的一个图标按钮');
                break;
        };
    });

    //监听行工具事件
    table.on('tool(test)', function(obj){
        var data = obj.data;
        //console.log(obj)
        if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                obj.del();
                layer.close(index);
            });
        } else if(obj.event === 'edit'){
            layer.prompt({
                formType: 2
                ,value: data.email
            }, function(value, index){
                obj.update({
                    email: value
                });
                layer.close(index);
            });
        }
    });
    var form = layui.form;
    var layer = layui.layer;
    var add = ' <div class="layui-form-item">'+
        '<label class="layui-form-label">学生姓名</label>'+
        '<div class="layui-input-inline">'+
        '<input type="text" name="title" required  lay-verify="required" placeholder="请输入学生姓名" autocomplete="off" class="layui-input" id="xname">'+
        '</div>'+
        '</div>'+
        '<div class="layui-form-item">'+
        '<label class="layui-form-label">学生分数</label>'+
        '<div class="layui-input-inline">'+
        ' <input type="text" name="title" required  lay-verify="required" placeholder="请输入学生分数" autocomplete="off" class="layui-input" id="fraction">'+
        '</div>'+
        '</div>'+
        '<div class="layui-form-item">'+
        '<div class="layui-input-block">'+
        '<button class="layui-btn" lay-submit lay-filter="formDemo" id="shangpinSave">立即提交</button>'+
        '</div></div>';

    $ = layui.jquery;

    $("#add").on('click', function() {
        layer.open({
            type : 1,
            title : "学生录入",
            skin : "myclass", // 自定样式
            area : [ "350px", "300px" ],
            content : add,

            success : function(layero, index) {
            },
            yes : function() {
            }
        });

        $('#shangpinSave').click(function() {
            var xname=$('#xname').val();
            var fraction=$('#fraction').val();
            $.post('/getListGrade', {
                name : xname,
                fraction : fraction
            }, function(result) {
                alert(result);
            });
        });
        form.render(); // 动态渲染

    });

});