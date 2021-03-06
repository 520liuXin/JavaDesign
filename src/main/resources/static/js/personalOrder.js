$(function(){
    // god = {};

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
    // 获取用户订单信息
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
                        '<div class="orderBody">'+
                        '<div class="col-sm-6 itemDetail">'+
                        ' <div class="col-sm-4">'+
                        '<img src="../'+item.carImgUrl+'" alt="" class="img-thumbnail">'+
                        '</div>'+
                        '<div class="col-sm-8 itemDescription">'+
                        '<label for="">'+item.carName+''+item.carDescribe+'</label>'+
                        ' </div>'+
                        '</div>'+
                        '<div class="col-sm-2 itemDetail"><label class="itemLabel" for=""><span class="glyphicon glyphicon-user"></span> '+item.userName+'</label></div>'+
                        '<div class="col-sm-2 itemDetail"><label class="itemLabel" for="">￥： <span>'+item.buyerAmount+'</span>元</label></div>'+
                        '<div class="col-sm-2 btn-group itemDetail">'+
                        '<button type="button" class="btn btn-default dele btn-md"><span class="glyphicon glyphicon-trash"></span></button>'+
                        '</div></div></div>'
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
                console.log("dataF"+dataF.data);
                console.log(typeof dataF.data);
                $(".itemContainer").html("");
                // orderinfo 
                $.each(dataF.data.items,function(i,item){
                    $(".itemContainer").append(
                        ' <div class="orderItem">'+ 
                        ' <div class="orderHead col-md-12">'+
                        '<span>订单时间:'+timestampToTime(item.startDate)+' </span> <span>流水号'+item.orderId+'</span>'+
                        '</div>'+
                        '<div class="orderBody">'+
                        '<div class="col-sm-6 itemDetail">'+
                        ' <div class="col-sm-4">'+
                        '<img src="../'+item.carImgUrl+'" alt="" class="img-thumbnail">'+
                        '</div>'+
                        '<div class="col-sm-8 itemDescription">'+
                        '<label for="">'+item.carName+''+item.carDescribe+'</label>'+
                        ' </div>'+
                        '</div>'+
                        '<div class="col-sm-2 itemDetail"><label class="itemLabel" for=""><span class="glyphicon glyphicon-user"></span> '+item.userName+'</label></div>'+
                        '<div class="col-sm-2 itemDetail"><label class="itemLabel" for="">￥： <span>'+item.buyerAmount+'</span>元</label></div>'+
                        '<div class="col-sm-2 btn-group itemDetail">'+
                        '<button type="button" class="btn btn-default dele btn-md"><span class="glyphicon glyphicon-trash"></span></button>'+
                        '</div></div></div>'
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
    // Launch method
    getUserOrder();

});