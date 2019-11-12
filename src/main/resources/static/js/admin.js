$(function () {
    $("#land").click(function () {
        $.post('/land1', {
            number: $("#name").val(),
            password: $("#password").val()
        }, function (result) {
            if (result.success == true) {
                window.location.href = "/dohome";
            } else if (result.success == false) {
                $('.error').css("display", "");
                $('.error').text(result.msg);
            }
        });
    });

});