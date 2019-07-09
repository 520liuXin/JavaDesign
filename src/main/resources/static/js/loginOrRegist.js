$(function(){
    // 登录、注册区分
    $("[name='my-checkbox']").bootstrapSwitch({
        onText:"LOGIN",  
        offText:"REGIST",  
        // onColor:"success",  
        offColor:"info",  
        // size:"large",  
        onSwitchChange:function(event,state){  
            if(state==true){  
                $(this).val("1");  
                console.log("LOGIN");
                $(".CP").slideUp();
            }else{  
                $(this).val("2");
                console.log("REGIST");
                $(".CP").slideDown();
            }  
        } 
    });
    // 按钮状态转换
    $('.tag-like').click(function(){
        $('button').click(function(){
            // var obj=$(this);
            // obj.removeClass('btn-info');
            // obj.addClass('btn-primary');
            // console.log(obj);
            if($(this).hasClass("btn-info")){
                $(this).removeClass('btn-info');
                $(this).addClass('btn-primary');
            }else if($(this).hasClass("btn-primary")){
                $(this).addClass('btn-info');
                $(this).removeClass('btn-primary');
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

    // 喜好标签
    var index = -1;
    var queryByCodition = [];
    $("button").click(function(){      
        // 判断class btn-primary 有就添加 btn-info 有就删除
        if($(this).hasClass("btn-info")){
            queryByCodition[index+1] = $(this).attr("name");
            index += 1;
        }
        if($(this).hasClass("btn-primary")){
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
    
    //  注册
    $(".subBtn").click(function(){
        
        var status = getSwitchStatus();
        var loginObj={};
        var inputName = $("#exampleInputEmail1").val();
        var inputPwd = $("#exampleInputPassword1").val();
        var inputCheck = $("#exampleInputPassword2").val();
        var SlidingValidation = $("#msg").html();
        loginObj.name = inputName;
        loginObj.pwd = inputPwd;
        // loginObj.check = inputCheck;
        loginObj.Usertag = $("#focusedInput").val();
        if(status=="login"){
            // 滑动校验
            if(SlidingValidation=="验证成功！"){
                // 手机号校验
                if(!(/^1[34578]\d{9}$/.test(inputName))){
                    alert("请检查您输入的手机号");
                }else{
                    $.ajax({
                        contentType:'application/json;charset=utf-8',
                        url: "/userLogin",
                        type:"POST",
                        dataType: "json",
                        data:JSON.stringify(loginObj),
                        success: function(dataF){
                            // 登录状态判断
                            // 登录身份信息验证
                            if(dataF.code == "0000"){
                                if(dataF.data.admin == "2"){
                                    window.location.href="homePageFirstPage.html";
                                }else{
                                    window.location.href="mgrcenter";
                                }
                            }else{
                                alert(dataF.data);
                               // alert("登录信息有误，请核实您的信息");
                            }
                        },
                        error: function(dataE){
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
                }  
            }else{
                alert("验证失败，为确保您的信息安全，请重新验证！");
            }
        }else if(status=="regist"){
            if(SlidingValidation=="验证成功！"){
                // 手机号校验
                if(!(/^1[34578]\d{9}$/.test(inputName))){
                    alert("请检查您输入的手机号");
                }else{
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
                }  
            }else{
                alert("验证失败，为确保您的信息安全，请重新验证！");
            }
        }
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