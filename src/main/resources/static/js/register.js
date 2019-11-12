$(function() {
    $("#register").click(function() {
        var a=$("#name").val();
        var b=$("#password").val();
        if (a==""||b==""){
            alert("请输入用户名和密码");
        }else {
            $.get('/register2', {
                number : a,
                password :b
            }, function(result) {
                alert(result);
                window.location.href='/';
            });
        }
    });

});