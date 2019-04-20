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

    $('.tag-like').click(function(){
        $('button').click(function(){
            var obj=$(this);
            obj.removeClass('btn-info');
            obj.addClass('btn-primary');
            console.log(obj);
        });
    });
    
    // 登录 / 注册
    $(".subBtn").click(function(){
        var status = getSwitchStatus();
        if(status=="login"){
            var loginObj={};
            var inputName = $("#exampleInputEmail1").val();
            var inputPwd = $("#exampleInputPassword1").val();
            var SlidingValidation = $("#msg").html();
            loginObj.name = inputName;
            loginObj.pwd = inputPwd;
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
                                alert("登录信息有误，请核实您的信息");
                            }
                        },
                        error: function(dataE){
                            alert("error"+dataE);
                            console.log("dataE"+dataE);
                           
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
                    $.post("user/regist",JSON.stringify(loginObj),function(data,status){
                        if(status=="success"){
                            if(data=="注册成功"){
                                alert("注册成功！");
                                window.location.href = "homePageFirstPage.html"; 
                            }else{
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
                        }else{
                            console.log("请求服务器出错");
                        }
                    });
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