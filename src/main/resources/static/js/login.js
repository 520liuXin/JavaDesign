$(function(){
      // 喜好标签
      var index = -1;
      var queryByCodition = [];
    //   $("button").click(function(){      
    //       // 判断class btn-primary 有就添加 btn-info 有就删除
    //       if($(this).hasClass("btn-info")){
    //           queryByCodition[index+1] = $(this).attr("name");
    //           index += 1;
    //       }
    //       if($(this).hasClass("btn-primary")){
    //           var theName = $(this).attr("name");
    //           $.each(queryByCodition,function(i,value){
    //               if(value == theName){
    //                   queryByCodition.splice(i,1);
    //                   $.unique(queryByCodition.sort()).filter(s => $.trim(s).length > 0);
    //                   console.log("queryByCodition"+queryByCodition);
    //               }
    //           });
    //       }
    //       console.log("index:"+index+"------"+$.unique(queryByCodition.sort())); 
    //       $("#focusedInput").val($.unique(queryByCodition.sort()).filter(s => $.trim(s).length > 0));
    //   });
      
      // 登录 / 注册
      $(".subBtn").click(function(){
          console.log(1);
        //   var status = getSwitchStatus();
          var loginObj={};
          var inputName = $("#exampleInputEmail1").val();
          var inputPwd = $("#exampleInputPassword1").val();
          var authCode =$("#authCode").val();
        //   var inputCheck = $("#exampleInputPassword2").val();
        //   var SlidingValidation = $("#msg").html();
          loginObj.name = inputName;
          loginObj.pwd = inputPwd;
          loginObj.kaptcha = authCode;
          // loginObj.check = inputCheck;
        // loginObj.Usertag = $("#focusedInput").val();
            $.ajax({
                contentType:'application/json;charset=utf-8',
                url: "/userLogin",
                type:"POST",
                dataType: "json",
                data:JSON.stringify(loginObj),
                success: function(dataF){
                    // 登录状态判断
                    // 登录身份信息验证
                    console.log('dataF'+dataF);
                    if(dataF.code == "0000"){
                        if(dataF.data.admin == "2"){
                            window.location.href="homePageFirstPage.html";
                        }else{
                            window.location.href="mgrcenter";
                        }
                    }else{
                        alert("登录信息有误，请核实您的信息");
                    }
                },
                error: function(dataE){
                    console.log('dataE'+dataE);
                    var randomNum = Math.random();
                        if(randomNum<=0.25){
                            window.location.href = "http://hackcode.ishoulu.com/scp/";
                        }else if(randomNum>0.25 & randomNum<=0.5){
                            window.location.href = "http://hackcode.ishoulu.com/combine/";
                        }else if(randomNum>0.5 & randomNum<=0.75){
                            window.location.href = "http://hackcode.ishoulu.com/blackmesa/";
                        }else{
                            window.location.href = "http://hackcode.ishoulu.com/matrix/";
                        }
                
                }
            })
      });
  // switchBtn status
      var getSwitchStatus = function (){
          if($("[name='my-checkbox']").val()=="on" || $("[name='my-checkbox']").val()=="1"){
              return "login";
          }else{
              return "regist";
          } 
      }
  
});