$(function(){
      // 喜好标签
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
                      console.log("queryByCodition"+queryByCodition);
                  }
              });
          }
          console.log("index:"+index+"------"+$.unique(queryByCodition.sort())); 
          $("#focusedInput").val($.unique(queryByCodition.sort()).filter(s => $.trim(s).length > 0));
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

     // 确认密码校验
        $("#exampleInputPassword2").blur(function(){
            if($("#exampleInputPassword2").val() != $("#exampleInputPassword1").val()){
                // $("#exampleInputPassword2").val("");
                alert("两次密码不匹配，请核查");
            }
            // console.log($("#exampleInputPassword2").val()+"--------"+$("#exampleInputPassword1").val());
        });

     //  注册
     $(".subBtn").click(function(){
        
        // var status = getSwitchStatus();
        var loginObj={};
        loginObj.Name = $("#exampleInputEmail1").val();
        loginObj.Pwd = $("#exampleInputPassword1").val();
        loginObj.trueName = $("#trueName2").val();
        loginObj.idNumber = $("#idNumber").val();
        loginObj.Usertag = $("#focusedInput").val();
        loginObj.kaptcha = $("#authCode").val();
        $.ajax({
            contentType:'application/json;charset=utf-8',
            url: "user/add",
            type:"POST",
            dataType: "json",
            data:JSON.stringify(loginObj),
            success: function(dataF){
                console.log(dataF);
                if(dataF.code == "0000"){
                    alert("注册成功！");
                        window.location.href="homePageFirstPage.html";               
                }else if(dataF.code == "9999"){
                    alert("注册失败，该用户名已注册。");
                }else{
                    alert("意外错误，请刷新页面重试。");
                }
            },
            error: function(dataE){
                alert("意外错误，请刷新页面重试。");
                console.log(loginObj);
                console.log(dataE); 
            }
         })
    });
});