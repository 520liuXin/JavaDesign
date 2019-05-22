$(function(){

    // load All car
    var loadCarAll = function(){
        $(".WDNMD").html(" ");
        $.getJSON("car/findCar",function(info,status){
          console.log(info);
          $.each(info.data.items,function(i,item){
            // console.log(i);
            // console.log(item);
            $(".WDNMD").append(
              '<li>'+
              '<div class="carDetailContainer">'+
                
                '<div class="detailCarImg"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css"><img src="'+item.fileInfoUrl+'" alt=""></a></div>'+
                '<div class="detailDescribe"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css"> '+item.carName+' 魅力 '+item.color+' 动力强劲 马力'+item.engine+'匹 给您最优质的服务，最享受的驾驶体验。 </a></div>'+
                '<div class="priceContainer">'+
                  '<span class="totalPrice">租金：'+item.rent+'￥</span>'+      
                '</div>'+
              '</div>'+
              '</li>'
            );
          });
        });
      };

      loadCarAll();
});