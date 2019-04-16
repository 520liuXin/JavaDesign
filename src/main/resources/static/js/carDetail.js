$(function(){
    // loadcarInfoFromBackGround
    var loadcarInfo = function(){
        var id = getUrlParam("ID");
        $.post("car/info",JSON.stringify(id),function(data,status){
            if(status=="success"){
                
              }else{
                   
              };
        });
    }
    //获取url中的参数
    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg); //匹配目标参数
        if (r != null) return unescape(r[2]); return null; //返回参数值
       
    }


    loadcarInfo();
    // modal
    $("[name='my-checkbox']").bootstrapSwitch({
        onText:"自取",  
        offText:"送车上门",  
        onColor:"success",  
        offColor:"info",   
        onSwitchChange:function(event,state){  
            if(state==true){  
                $(this).val("1");  
                console.log("自取");
                $("#SCSM").slideUp();
                $("#ZQDZ").slideDown();
            }else{  
                $(this).val("2");
                console.log("送车上门");
                $("#SCSM").slideDown();
                $("#ZQDZ").slideUp();
            }
        } 
    });
    // dateTimePicker
    $('#datetimepickerS').datetimepicker({
        format: 'YYYY-MM-DD',
        locale: moment.locale('zh-cn')
    });
    $('#datetimepickerE').datetimepicker({
        format: 'YYYY-MM-DD',
        locale: moment.locale('zh-cn')
    });

    // redStar
    $(".glyphicon-heart").one("click",function(){
        $(this).css("color","rgb(255, 66, 29)");
        $.post("car/likeThisCar",{heat:1},function(data,success){
            console.log("+1");
        });
    });
});