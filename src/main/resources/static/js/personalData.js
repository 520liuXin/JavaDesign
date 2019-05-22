$(function(){
    // 喜好标签选择
    
    var index = -1;
      var queryByCodition = [];
      $("button").click(function(){      
          // 判断class btn-primary 有就添加 btn-default 有就删除
          if($(this).hasClass("btn-default")){
              queryByCodition[index+1] = $(this).attr("name");
              index += 1;
          }
          if($(this).hasClass("btn-warning")){
              var theName = $(this).attr("name");
              $.each(queryByCodition,function(i,value){
                  if(value == theName){
                      queryByCodition.splice(i,1);
                      $.unique(queryByCodition.sort()).filter(s => $.trim(s).length > 0);
                    //   console.log("queryByCodition"+queryByCodition);
                  }
              });
          }
        //   console.log("index:"+index+"------"+$.unique(queryByCodition.sort())); 
          $("#userLabel").val($.unique(queryByCodition.sort()).filter(s => $.trim(s).length > 0));
      });

      $('.tag-like').click(function(){
        $('button').click(function(){
            // var obj=$(this);
            // obj.removeClass('btn-default');
            // obj.addClass('btn-primary');
            // console.log(obj);
            if($(this).hasClass("btn-default")){
                $(this).removeClass('btn-default');
                $(this).addClass('btn-warning');
            }else if($(this).hasClass("btn-warning")){
                $(this).addClass('btn-default');
                $(this).removeClass('btn-warning');
            }
        });
    });

    // 文件上传按钮控制
    // 编辑按钮设置
    var $editAndSub =$('.eidtAndSub');
    $editAndSub.click(function(){
        // alert(11);
        var $disabledInput=$('input');
        if($editAndSub.html()=='编辑'){
            $disabledInput.attr('disabled',false);
            $editAndSub.text('保存');
            // updateUserInfo();
        }else{
            $disabledInput.attr('disabled',true);
            $editAndSub.text('编辑');
            updateUserInfo();
        }
    });
    //展示用户个人资料
    function loadUserInfo(){
        $.getJSON("user/info",function(info,status){
            console.log(info);
            console.log(info.name);
            if(info.name != null){
                $("#userName").attr("value",info.name);
            }
            if(info.sex != null){
                $("#userSex").attr("value",info.sex);
            }
            if(info.phone != null){
                $("#userPhone").attr("value",info.phone);
            }
            if(info.email != null){
                $("#userEmail").attr("value",info.email);
            }
            if(info.idCard != null){
                $("#userIdNum").attr("value",info.idCard);
            }
            if(info.label != null){
                $("#userLabel").attr("value",info.label);
            }
        });
    };
    // 用户更新个人资料
    function updateUserInfo (){
        // 获取更新的个人资料
        console.log("i`m in");
        var newUserInfo = {};
        newUserInfo.trueName = $("#userName").val();
        newUserInfo.userSex = $("#userSex").val();
        newUserInfo.userPhone = $("#userPhone").val();
        newUserInfo.email = $("#userEmail").val();
        newUserInfo.Usertag = $("#userLabel").val();
        newUserInfo.idNumber = $("#userIdNum").val();
        // 上传个人资料
        $.ajax({
            contentType:'application/json;charset=utf-8',
            url: "/user/update",
            type:"POST",
            dataType: "json",
            data:JSON.stringify(newUserInfo),
            success:function(dataS){
                alert("更新成功");
                console.log(dataS);
            },
            error:function(dataE){
                alert("更新出错，请重试");
                console.log(dataE);
            }
        });
    };

    loadUserInfo();
});    