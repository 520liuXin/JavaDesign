$(function(){
    // god = {};
    // 获取用户订单信息
    function timestampToTime(timestamp) {
        var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
        var Y = date.getFullYear() + '-';
        var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
        var D = date.getDate() + ' ';
        var h = date.getHours() + ':';
        var m = date.getMinutes() + ':';
        var s = date.getSeconds();
        return Y+M+D+h+m+s;
    }

    // timestampToTime(1403058804);
    function getUserOrder(){
        $.ajax({
            contentType:'application/json;charset=utf-8',
            url: "order/findAllAndPage?page=1",
            type:"GET",
            dataType: "json",
            // data:JSON.stringify(loginObj),
            success: function(dataF){
                console.log("dataF"+dataF.data);
                console.log(typeof dataF.data);
                $(".itemContainer").html("");
                // orderinfo 
                $.each(dataF.data.items,function(i,item){
                    $(".itemContainer").append(
                        ' <div class="orderItem">'+ 
                        ' <div class="orderHead col-md-12">'+
                        '<span>订单时间:'+timestampToTime(item.createdDate)+' </span> <span>流水号'+item.orderId+'</span>'+
                        '</div>'+
                        '<div class="orderBody col-md-12">'+
                        '<div class="col-sm-6 itemDetail">'+
                        ' <div class="col-sm-4">'+
                        '<img src="../'+item.carImgUrl+'" alt="" class="img-thumbnail">'+
                        '</div>'+
                        '<div class="col-sm-8 itemDescription">'+
                        '<label for="">'+item.carName+''+item.carDescribe+'</label>'+
                        ' </div>'+
                        '</div>'+
                        '<div class="col-sm-3 itemDetailS"><label class="itemLabel" for="">'+
                        '<p>起始时间：<strong>'+timestampToTime(item.startDate)+'</strong></p>'+
                        '<p>终止时间：<strong>'+timestampToTime(item.endDate)+'</strong></p>'+
                        '</div>'+
                        '<div class="col-sm-2 itemDetailS"><label class="itemLabel" for="">￥： <span>'+item.buyerAmount+'</span>元</label></div>'+
                        '<div class="col-sm-1 itemDetail">'+
                        '<div class="optionBtn">'+
                        '<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">操作'+
                        '<span class="caret"></span>'+
                        ' </button>'+
                        '<ul class="dropdown-menu"><li><a id="'+item.orderId+'" class="repayCar" href="">还车</a></li><li><a id="'+item.orderId+'"class="dele" href="">删除</a></li></ul>'+
                        '</div></div></div></div>'
                    );
                });             
                
                // pages 
                $(".pagination").html("");
                var totalPage = dataF.data.pagemeta.totalPages;
                $(".pagination").append(
                   '<li><a>&laquo;</a></li>' 
                );
                for (var index = 1; index <= totalPage; index++) {
                    if(dataF.data.pagemeta.page == index){
                        $(".pagination").append(
                            '<li class="active"><a>'+index+'</a></li>' 
                         );
                    }else{
                        $(".pagination").append(
                            '<li><a>'+index+'</a></li>' 
                         );
                    }
                }
                $(".pagination").append(
                    '<li><a>&raquo;</a></li>' 
                 );


                 $("a").click(function(){
                    if($(this).html()!= "删除" ||$(this).html() != "还车"){
                        var pageinfo = $(this).html();
                        changePage(pageinfo);  
                    }
                });

                $(".repayCar").click(function(){
                    console.log("repay");
                    var repay = {};
                    repay.orderId = $(this).attr("id");
                    $.ajax({
                        contentType:'application/json;charset=utf-8',
                        url: "/order/repayCar",
                        type:"POST",
                        dataType: "json",
                        data:JSON.stringify(repay),
                        success:function(dataS){
                            console.log("dataS:"+dataS);
                            alert(dataS.data);
                            parent.location.reload();
                        },
                        error:function(dataE){
                            console.log("dataE:"+dataE);
                            // parent.location.reload();
                            alert("操作失败,请联系管理员");
                        }
                    });
                });
                $(".dele").click(function(){
                    console.log("Dele");
                    var dele = {};
                    dele.orderId = $(this).attr("id");
                    $.ajax({
                        contentType:'application/json;charset=utf-8',
                        url: "/order/deleteOrder",
                        type:"POST",
                        dataType: "json",
                        data:JSON.stringify(dele),
                        success:function(dataS){
                            alert(dataS.data);
                            parent.location.reload();
                        },
                        error:function(){
                            alert("删除失败");
                        }
                    });
                });

            },
            error: function(dataE){
                alert("意外错误，请刷新页面重试。");
                console.log(dataE.data); 
            }
         })
    }
    function changePage(pageinfo){
        $.ajax({
            contentType:'application/json;charset=utf-8',
            url: "order/findAllAndPage?page="+pageinfo,
            type:"GET",
            dataType: "json",
            // data:JSON.stringify(loginObj),
            success: function(dataF){
                console.log("dataF"+dataF.data);
                console.log(typeof dataF.data);
                $(".itemContainer").html("");
                // orderinfo 
                $.each(dataF.data.items,function(i,item){
                    $(".itemContainer").append(
                        ' <div class="orderItem">'+ 
                        ' <div class="orderHead col-md-12">'+
                        '<span>订单时间:'+timestampToTime(item.createdDate)+' </span> <span>流水号'+item.orderId+'</span>'+
                        '</div>'+
                        '<div class="orderBody col-md-12">'+
                        '<div class="col-sm-6 itemDetail">'+
                        ' <div class="col-sm-4">'+
                        '<img src="../'+item.carImgUrl+'" alt="" class="img-thumbnail">'+
                        '</div>'+
                        '<div class="col-sm-8 itemDescription">'+
                        '<label for="">'+item.carName+''+item.carDescribe+'</label>'+
                        ' </div>'+
                        '</div>'+
                        '<div class="col-sm-3 itemDetailS"><label class="itemLabel" for="">'+
                        '<p>起始时间：<strong>'+timestampToTime(item.startDate)+'</strong></p>'+
                        '<p>终止时间：<strong>'+timestampToTime(item.endDate)+'</strong></p>'+
                        '</div>'+
                        '<div class="col-sm-2 itemDetailS"><label class="itemLabel" for="">￥： <span>'+item.buyerAmount+'</span>元</label></div>'+
                        '<div class="col-sm-1 itemDetail">'+
                        '<div class="optionBtn">'+
                        '<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">操作'+
                        '<span class="caret"></span>'+
                        ' </button>'+
                        '<ul class="dropdown-menu"><li><a id="'+item.orderId+'" class="repayCar" href="">还车</a></li><li><a id="'+item.orderId+'"class="dele" href="">删除</a></li></ul>'+
                        '</div></div></div></div>'
                    );
                });             
                
                // pages 
                $(".pagination").html("");
                var totalPage = dataF.data.pagemeta.totalPages;
                $(".pagination").append(
                   '<li><a>&laquo;</a></li>' 
                );
                for (var index = 1; index <= totalPage; index++) {
                    if(dataF.data.pagemeta.page == index){
                        $(".pagination").append(
                            '<li class="active"><a>'+index+'</a></li>' 
                         );
                    }else{
                        $(".pagination").append(
                            '<li><a>'+index+'</a></li>' 
                         );
                    }
                }
                $(".pagination").append(
                    '<li><a>&raquo;</a></li>' 
                 );


                $("a").click(function(){
                    if($(this).html()!= "删除" ||$(this).html() != "还车"){
                        var pageinfo = $(this).html();
                        changePage(pageinfo);  
                    }
                });

                $(".repayCar").click(function(){
                    console.log("repay");
                    var repay = {};
                    repay.orderId = $(this).attr("id");
                    $.ajax({
                        contentType:'application/json;charset=utf-8',
                        url: "/order/repayCar",
                        type:"POST",
                        dataType: "json",
                        data:JSON.stringify(repay),
                        success:function(dataS){
                            console.log("dataS:"+dataS);
                            alert(dataS.data);
                            parent.location.reload();
                        },
                        error:function(dataE){
                            console.log("dataE:"+dataE);
                            // parent.location.reload();
                            alert("操作失败,请联系管理员");
                        }
                    });
                });
                $(".dele").click(function(){
                    console.log("Dele");
                    var dele = {};
                    dele.orderId = $(this).attr("id");
                    $.ajax({
                        contentType:'application/json;charset=utf-8',
                        url: "/order/deleteOrder",
                        type:"POST",
                        dataType: "json",
                        data:JSON.stringify(dele),
                        success:function(dataS){
                            alert(dataS.data);
                            parent.location.reload();
                        },
                        error:function(){
                            alert("删除失败");
                        }
                    });
                });

            },
            error: function(dataE){
                alert("意外错误，请刷新页面重试。");
                console.log(dataE.data); 
            }
         })
    }
    // Launch method
    getUserOrder();

});