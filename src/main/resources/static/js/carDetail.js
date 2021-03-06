$(function(){
// 全局常量池
    god = {};

    function datedifference(sDate1, sDate2) {    //sDate1和sDate2是2006-12-18格式  
        var dateSpan,
            tempDate,
            iDays;
        sDate1 = Date.parse(sDate1);
        sDate2 = Date.parse(sDate2);
        dateSpan = sDate2 - sDate1;
        dateSpan = Math.abs(dateSpan);
        iDays = Math.floor(dateSpan / (24 * 3600 * 1000));
        return iDays;
    };
    $("#datetimepickerE input").blur(function(){
        var days = datedifference( $("#datetimepickerS input").val(),$("#datetimepickerE input").val());
        $(".price").html(days*god.rent);
        console.log("god:"+JSON.stringify(god));
        console.log("days*god.rent:"+days*god.rent);
    });


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
                $(".carPrice").html(
                    '<h1>'+dataF.data.rent+'元</h1>'+
                    '<div class="payment col-md-12">首付'+dataF.data.rent/3+'元起 | 月供'+dataF.data.rent/12+'元</div>'
                );
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
                
                $(".imgContainerZ").html(
                    ' <img src='+dataF.data.carImgUrl[0].url+' alt="" width="100%" height="100%">'
                );
                $(".carInfoContainerSS").html(
                    ' <p>'+dataF.data.carBrand+'---'+dataF.data.carName+'</p>'+
                    '<p>In sit amet sapien eros. Integer in tincidunt velit. Ut sapien est, molestie sit amet metussit amet, malesuada gravida ex.</p>'
                );

               $(".price").html(
                   dataF.data.rent
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
        carItem={};
        carItem.carId=getUrlParam("id");
        $.ajax({
            contentType:'application/json;charset=UTF-8',
            url: "/car/likeThisCar",
            type:"POST",
            dataType: "json",
            data:JSON.stringify(carItem),
            success: function(dataF){
                console.log(dataF);
            },
            error: function(dataE){
                console.log(dataE); 
            }
         })
    });

    $(".aliPay").click(function(){
        // 获取汽车 id  起始时间 终止时间  取车？自取 ：地址 支付
        var orderInfoObj = {};
        orderInfoObj.id = getUrlParam("id");
        var status = getSwitchStatus();

        orderInfoObj.getCar = status;
        orderInfoObj.address = $("#ZQDZ input").val();
        orderInfoObj.price = $(".price").html();
        orderInfoObj.startTime = $("#datetimepickerS input").val();
        orderInfoObj.endTime = $("#datetimepickerE input").val();
        console.log(JSON.stringify(orderInfoObj));

        $.ajax({
            contentType:'application/json;charset=UTF-8',
            url: "/order/createOrder",
            type:"POST",
            dataType: "json",
            data:JSON.stringify(orderInfoObj),
            success: function(dataF){
                    console.log(dataF);
            },
            error: function(dataE){
                if(dataE.code=="9999"){
                    console.log("网络繁忙，请重试~");
                }
                    console.log(dataE);
                    $(".carDetailMainContainer").html(dataE.responseText);
            }
         })
    });

    $(".weChatPay").click(function(){
        alert("微信支付通道正在对接中....");
    });
});