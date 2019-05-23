$(function(){
    function timestampToTime(timestamp) {
        var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
        var Y = date.getFullYear() + '-';
        var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
        var D = date.getDate() + ' ';
        var h = date.getHours() + ':';
        var m = date.getMinutes() + ':';
        var s = date.getSeconds();
        return Y+M+D+h+m+s;
    };
    function getUserOrder(){
        $.ajax({
            contentType:'application/json;charset=utf-8',
            url: "order/findAllAndPage?page=1",
            type:"GET",
            dataType: "json",
            // data:JSON.stringify(loginObj),
            success: function(dataF){
              
                $(".itemContainer").html("");
                // orderinfo 
                $.each(dataF.data.items,function(i,item){
                    $(".itemContainer").append(
                        '<div class="well itemS col-md-12">'+
                        '<div class="itemShead">'+
                        '<h4>'+item.orderId+'<small>marix</small></h4></div>'+
                        '<div class="itemSbody row col-sm-12"><div class="col-md-1">'+
                        '<img src="'+item.fileInfoUrl+'" class="pull-left" alt=""></div>'+
                        '<div class="col-md-11">'+
                        '<h4>'+item.carName+'<small>2018新款</small></h4>'+
                        '<p>'+item.carDescribe+'</p></div></div>'+
                        '<div class="itemSfoot"> <div class="col-md-12"><div class="foot col-md-9"><div>'+
                        ' <span><h4>起止时间：<small>'+timestampToTime(item.startDate)+'--'+timestampToTime(item.endDate)+'</small></h4></span>'+
                        '</div></div>'+
                        '<div class="foot col-md-2"><span><h4>总金额：'+item.buyerAmount+'</h4></span></div>'+
                        '<div class="btn-group col-md-1" role="group">'+
                        ' <button type="button" class="btn btn-default dropdown-toggle btn-operational" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">'+
                        ' 操作<span class="caret"></span></button>'+
                        ' <ul class="dropdown-menu"><li><li><a class="dele">删除</a></li> </ul></div></div></div></div>'
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
                            '<li class="active"><a class="pagiCtrl">'+index+'</a></li>' 
                         );
                    }else{
                        $(".pagination").append(
                            '<li><a class="pagiCtrl">'+index+'</a></li>' 
                         );
                    }
                }
                $(".pagination").append(
                    '<li><a>&raquo;</a></li>' 
                 );


                $(".pagiCtrl").click(function(){
                    var pageinfo = $(this).html();
                    changePage(pageinfo);
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
               
                $(".itemContainer").html("");
                // orderinfo 
                $.each(dataF.data.items,function(i,item){
                    $(".itemContainer").append(
                        '<div class="well itemS col-md-12">'+
                        '<div class="itemShead">'+
                        '<h4>'+item.orderId+'<small>marix</small></h4></div>'+
                        '<div class="itemSbody row col-sm-12"><div class="col-md-1"></div>'+
                        '<div class="col-md-11">'+
                        '<h4>'+item.carName+'<small>2018新款</small></h4>'+
                        '<p>'+item.carDescribe+'</p></div></div>'+
                        '<div class="itemSfoot"> <div class="col-md-12"><div class="foot col-md-9"><div>'+
                        ' <span><h4>起止时间：<small>'+timestampToTime(item.startDate)+'--'+timestampToTime(item.endDate)+'</small></h4></span>'+
                        '</div></div>'+
                        '<div class="foot col-md-2"><span><h4>总金额：'+item.buyerAmount+'</h4></span></div>'+
                        '<div class="btn-group col-md-1" role="group">'+
                        ' <button type="button" class="btn btn-default dropdown-toggle btn-operational" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">'+
                        ' 操作<span class="caret"></span></button>'+
                        ' <ul class="dropdown-menu"><li><li><a class="dele">删除</a></li> </ul></div></div></div></div>'
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
                            '<li class="active"><a class="pagiCtrl">'+index+'</a></li>' 
                         );
                    }else{
                        $(".pagination").append(
                            '<li><a class="pagiCtrl">'+index+'</a></li>' 
                         );
                    }
                }
                $(".pagination").append(
                    '<li><a>&raquo;</a></li>' 
                 );


                $(".pagiCtrl").click(function(){
                    var pageinfo = $(this).html();
                    changePage(pageinfo);
                });

                $(".repay").click(function(){
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
                            // parent.location.reload();
                            alert(dataS.data);
                            parent.location.reload();
                        },
                        error:function(dataE){
                            console.log("dataE:"+dataE);
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
                            console.log("dataS:"+dataS);
                            // parent.location.reload();
                            alert(dataS.data);
                            parent.location.reload();
                        },
                        error:function(dataE){
                            console.log("dataE:"+dataE);
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
   
    getUserOrder();
});