$(function(){
    // 获取原始密码 新密码 校验新密码
    function checkPassWord(obj){
        if(this.newPwd !=this.checkPwd){
            alert("两次新密码填写不一致");
        }
    }
    $(".eidtAndSub").click(function(){
        var pwdObj = {};
        pwdObj.oldPwd = $("#originalPassword").val();
        pwdObj.newPwd = $("#newPassword").val();
        pwdObj.checkPwd = $("#checkPassWord").val();
        checkPassWord(pwdObj);

        $.ajax({
            contentType:'application/json;charset=utf-8',
            url: "/user/updatePwd",
            type:"POST",
            dataType: "json",
            data:JSON.stringify(pwdObj),
            success:function(dataS){
                alert("修改成功");
            },
            error:function(dataType){
                alert("修改失败");
            }
        });
    });
});