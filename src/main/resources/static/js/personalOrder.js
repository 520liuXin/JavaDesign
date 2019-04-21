$(function(){
    // 获取用户订单信息
    function getUserOrder(){
        $.ajax({
            contentType:'application/json;charset=utf-8',
            url: "order/findAllAndPage",
            type:"GET",
            // dataType: "json",
            // data:JSON.stringify(loginObj),
            success: function(dataF){
                console.log(dataF);
                $(".itemContainer").html("");
                if(dataF.code == "0000"){
                     $.each(dataF.data,function(i,item){
                    ' <div class="orderItem">'+ 
                    ' <div class="orderHead col-md-12">'+
                    '<span>订单时间:'+item.createdDate+' </span> <span>流水号'+item.orderId+'</span>'+
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
                    '<button type="button" class="btn btn-default btn-md"><span class="glyphicon glyphicon-trash"></span></button>'
                    '</div></div></div>'
                });             
                }else{
                    
                }
            },
            error: function(dataE){
                alert("意外错误，请刷新页面重试。");
                console.log(dataE); 
            }
         })
    }
});