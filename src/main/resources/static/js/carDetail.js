$(function(){
    // loadcarInfoFromBackGround
    var loadcarInfo = function(){
        var ID ={};
        ID.id = getUrlParam("id");
        console.log(JSON.stringify(ID));
        // 根据id获取车辆数据
        $.ajax({
            // headers: {
            //     Accept:"application/json;charset=utf-8"
            // },
            contentType:'application/json;charset=UTF-8',
            url: "/car/info",
            type:"POST",
            dataType: "json",
            data:JSON.stringify(ID),
            success: function(dataF){      
                console.log(dataF); 
                // 主图附图呈现
                $(".img-big img").attr('src',dataF.data.carImgUrl[0].url); 
                $(".img-small").html("");
                $(".cardetailTitle h2").html(''+dataF.data.carBrand+'<h4>'+dataF.data.carDescribe+'</h4>');
                $.each(dataF.data.carImgUrl,function(i,item){
                   $(".img-small").append(
                       " <img src="+dataF.data.carImgUrl[i].url+">"
                   );
                   if(i>=3){
                        return false;
                   }
                });
                // 车源图片呈现
                $.each(dataF.data.carImgUrl,function(i,item){
                    $(".DetailedPhotosSS").append(
                        '<div class="col-md-6"><img src="'+item.url+'" alt=""></div>'
                    )
                    if(i>=5){
                        return false;
                    }
                });
                // 配置信息呈现
                for (var item in dataF.data) {
                    if (item == null || item == undefined) {
                       dataF.data[item]=="---";
                    }
                }
                $(".configInfo1").html(   
                    '<td>'+dataF.data.carBrand+'</td>'+
                    '<td>'+dataF.data.carName+'</td>'+
                    '<td>'+dataF.data.fuelConsumption+'</td>'+
                    '<td>'+dataF.data.engine+'</td>'+
                    '<td>'+dataF.data.driveWay+'</td>'
                );

                $(".configInfo2").html(
                    '<td>'+dataF.data.displacement+'</td>'+
                    '<td>'+dataF.data.ridingNumber+'</td>'+
                    '<td>---</td>'+
                    '<td>---</td>'+
                    '<td>---</td>'
                );

            },
            error: function(dataE){
               alert("请求错误");
            }
         })
    }
    //获取url中的参数
    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg); //匹配目标参数
        if (r != null) return unescape(r[2]); return null; //返回参数值
       
    }

    var getSwitchStatus = function (){
        if($("[name='my-checkbox']").val()=="on" || $("[name='my-checkbox']").val()=="1"){
            return "ziqu";
        }else{
            return "songche";
        }
        
    }
    // 点击切换主图

    //启用方法
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
        $.post("car/likeThisCar",
        {carId:getUrlParam("id")},
        function(data,success){
            console.log("+1");
        });
    });

    $(".order-submit").click(function(){
        // 获取汽车 id  起始时间 终止时间  取车？自取 ：地址 支付
        var orderInfoObj = {};
        orderInfoObj.id = getUrlParam("id");
        orderInfoObj.startTime = $("#datetimepickerS input").val(); 
        orderInfoObj.endTime = $("#datetimepickerE input").val();

        var status = getSwitchStatus();

        orderInfoObj.getCar = status;
        orderInfoObj.address = $("#ZQDZ input").val();
        orderInfoObj.price = $(".price").html();
        console.log(JSON.stringify(orderInfoObj));
        $.ajax({
            contentType:'application/json;charset=UTF-8',
            url: "/order/createOrder",
            type:"POST",
            dataType: "json",
            data:JSON.stringify(orderInfoObj),
            success: function(dataF){       
                if(dataF.code=="0000"){
                    alert("下单成功");
                }
            },
            error: function(dataE){
                if(dataE.code=="9999"){
                    alert("网络繁忙，请重试~");
                }
            }
         })
    });
});