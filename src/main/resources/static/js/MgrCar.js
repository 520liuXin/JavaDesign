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

      $(".btn-searchBar").click(function(){
        $(".WDNMD").html(" ");
        var searchCar={};
        searchCar.carInfo = $("#info-searchBar").val();
        $.ajax({
            contentType:'application/json;charset=utf-8',
            url: "car/fuzzyQuery",
            type:"POST",  
            dataType: "json",
            data:JSON.stringify(searchCar),
            success: function(info,status){
                console.log(info);
                // // $(".ViewAllRendering").html("");
                // $(".ViewAllRendering").html("<div class='typeTitle col-md-12'><h3>筛选精品</h3></div><ul class='fuzzyQuery'><ul>");
                $(".WDNMD").html("");
                if(info.code == "9999"){
                  $(".WDNMD").html("<div><h2>We did`nt find the car you looking for.</h2></div>");
                }else{
                  $.each(info.data,function(i,item){
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
                }
            },
            error: function(dataE,status){
              $(".persentLabel").html("<div><h2>We did`nt find the car you looking for.</h2></div>");
            }
        })
      });
      loadCarAll();
});