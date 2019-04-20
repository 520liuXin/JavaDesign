
$(function(){
 
  console.log("i`m in");
  // 加载页面汽车信息
      //全量加载
    var loadCarAll = function(){
      $.getJSON("car/findCar",function(info,status){
       if(status=="success"){
          $.each(info.data.items,function(i,item){
            $(".taochezhiyin").append(
              '<li>'+
              '<div class="carDetailContainer">'+
                '<div class="detailTitle">'+item.carType+'</div>'+
                '<div class="detailCarImg"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css"><img src="'+item.fileInfoUrl+'" alt=""></a></div>'+
                '<div class="detailDescribe"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css">淘车推荐 '+item.carName+' 魅力 '+item.color+' 动力强劲 马力'+item.rent+'匹 前置后驱 淘车线上专供</a></div>'+
                '<div class="priceContainer">'+
                  '<span class="totalPrice">300万</span>'+
                  '<span class="Installment">首付60万</span>'+
                '</div>'+
                '<div class="serviceContainer">'+
                  '<i>30天可退</i>'+
                  '<i>免费检测</i>'+
                  '<i>分期购车</i>'+
                '</div>'+
              '</div>'+
              '</li>'
            );
          });
       }else{
        $(".ViewAllRendering").html("<div><h2>We did`nt find the car you looking for.</h2></div>");
       }
      });
    };
      // 按热度加载
    var loadCarByVogue = function(){
        $.getJSON("car/findByVogue",function(info,status){
       if(status=="success"){
          $.each(info.data,function(i,item){
            $(".huorexiaoshou").append(
              '<li>'+
              '<div class="carDetailContainer">'+
                '<div class="detailTitle">'+item.carType+'</div>'+
                '<div class="detailCarImg"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css"><img src="'+item.fileInfoUrl+'" alt=""></a></div>'+
                '<div class="detailDescribe"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css">淘车推荐 '+item.carName+' 魅力 '+item.color+' 动力强劲 马力'+item.rent+'匹 前置后驱 淘车线上专供</a></div>'+
                '<div class="priceContainer">'+
                  '<span class="totalPrice">300万</span>'+
                  '<span class="Installment">首付60万</span>'+
                '</div>'+
                '<div class="serviceContainer">'+
                  '<i>30天可退</i>'+
                  '<i>免费检测</i>'+
                  '<i>分期购车</i>'+
                '</div>'+
              '</div>'+
              '</li>'
            );
          });
       }else{
        $(".ViewAllRendering").html("<div><h2>We did`nt find the car you looking for.</h2></div>");
       }
      });
    };
      // 按猜你喜欢加载
    var loadCarByInterest = function(){
        $.getJSON("car/findByInterest",function(info,status){
       if(status=="success"){
          $.each(info.data,function(i,item){
            $(".cainixihuan").append(
              '<li>'+
              '<div class="carDetailContainer">'+
                '<div class="detailTitle">'+item.carType+'</div>'+
                '<div class="detailCarImg"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css"><img src="'+item.fileInfoUrl+'" alt=""></a></div>'+
                '<div class="detailDescribe"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css">淘车推荐 '+item.carName+' 魅力 '+item.color+' 动力强劲 马力'+item.rent+'匹 前置后驱 淘车线上专供</a></div>'+
                '<div class="priceContainer">'+
                  '<span class="totalPrice">300万</span>'+
                  '<span class="Installment">首付60万</span>'+
                '</div>'+
                '<div class="serviceContainer">'+
                  '<i>30天可退</i>'+
                  '<i>免费检测</i>'+
                  '<i>分期购车</i>'+
                '</div>'+
              '</div>'+
              '</li>'
            );
          });
       }else{
        $(".ViewAllRendering").html("<div><h2>We did`nt find the car you looking for.</h2></div>");
       }
      });
    };
      // 按与众不同加载
    var loadCarByDifferent = function(){
        $.getJSON("car/findByDifferent",function(info,status){
       if(status=="success"){
          $.each(info.data,function(i,item){
            $(".yuzhongbutong").append(
              '<li>'+
              '<div class="carDetailContainer">'+
                '<div class="detailTitle">'+item.carType+'</div>'+
                '<div class="detailCarImg"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css"><img src="'+item.fileInfoUrl+'" alt=""></a></div>'+
                '<div class="detailDescribe"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css">淘车推荐 '+item.carName+' 魅力 '+item.color+' 动力强劲 马力'+item.rent+'匹 前置后驱 淘车线上专供 </a></div>'+
                '<div class="priceContainer">'+
                  '<span class="totalPrice">300万</span>'+
                  '<span class="Installment">首付60万</span>'+
                '</div>'+
                '<div class="serviceContainer">'+
                  '<i>30天可退</i>'+
                  '<i>免费检测</i>'+
                  '<i>分期购车</i>'+
                '</div>'+
              '</div>'+
              '</li>'
            );
          });
       }else{
        $(".ViewAllRendering").html("<div><h2>We did`nt find the car you looking for.</h2></div>");
       }
      });
    };
    var loadCarByLatest = function(){
      $.getJSON("car/findByLatest",function(info,status){
     if(status=="success"){
        $.each(info.data,function(i,item){
          $(".zuixinshangjia").append(
            '<li>'+
            '<div class="carDetailContainer">'+
              '<div class="detailTitle">'+item.carType+'</div>'+
              '<div class="detailCarImg"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css"><img src="'+item.fileInfoUrl+'" alt=""></a></div>'+
              '<div class="detailDescribe"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css">淘车推荐 '+item.carName+' 魅力 '+item.color+' 动力强劲 马力'+item.rent+'匹 前置后驱 淘车线上专供 </a></div>'+
              '<div class="priceContainer">'+
                '<span class="totalPrice">300万</span>'+
                '<span class="Installment">首付60万</span>'+
              '</div>'+
              '<div class="serviceContainer">'+
                '<i>30天可退</i>'+
                '<i>免费检测</i>'+
                '<i>分期购车</i>'+
              '</div>'+
            '</div>'+
            '</li>'
          );
        });
     }else{
      $(".ViewAllRendering").html("<div><h2>We did`nt find the car you looking for.</h2></div>");
     }
    });
  };

  
    // 启用方法
    loadCarAll();
    loadCarByDifferent();
    loadCarByInterest();
    loadCarByVogue();
    loadCarByLatest();
    //搜索栏
    $(".btn-searchBar").click(function(){
      var searchCar={};
      var carInfoVal=$(".info-searchBar").val();
      if(carInfoVal!=''){
        searchCar.carInfo=carInfoVal;
      }else{
        alert("please input your information");
      };

      $.ajax({
          contentType:'application/json;charset=utf-8',
          url: "car/fuzzyQuery",
          type:"POST",
          dataType: "json",
          data:JSON.stringify(searchCar),
          success: function(dataS,status){
              console.log(dataS);
              // $(".ViewAllRendering").html("");
              $(".ViewAllRendering").html("<div class='typeTitle col-md-12'><h3>筛选精品</h3></div><ul class='fuzzyQuery'><ul>");
            $.each(dataS.data,function(i,item){
              $(".fuzzyQuery").append(
              '<li>'+
              '<div class="carDetailContainer">'+
                '<div class="detailTitle">'+item.carType+'</div>'+
                '<div class="detailCarImg"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css"><img src="'+item.fileInfoUrl+'" alt=""></a></div>'+
                '<div class="detailDescribe"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css">淘车推荐 '+item.carName+' 魅力 '+item.color+' 动力强劲 马力'+item.rent+'匹 前置后驱 淘车线上专供 </a></div>'+
                '<div class="priceContainer">'+
                  '<span class="totalPrice">300万</span>'+
                  '<span class="Installment">首付60万</span>'+
                '</div>'+
                '<div class="serviceContainer">'+
                  '<i>30天可退</i>'+
                  '<i>免费检测</i>'+
                  '<i>分期购车</i>'+
                '</div>'+
              '</div>'+
              '</li>'
              );
            });
          
          },
          error: function(dataE,status){
            $(".ViewAllRendering").html("<div><h2>We did`nt find the car you looking for.</h2></div>");
          }
      })
    });
    // 按条件查询
    $("a").click(function(){
      // alert($(this).attr("name"));
      // 获取name属性
      var queryByCodition = {};
      if($(this).attr("name")!=undefined || $(this).attr("name")!=null){
        queryByCodition.codition = $(this).attr("name");
      }
      var urlStr = "/car/findCar?"+queryByCodition.codition;
      console.log(urlStr+"------"+decodeURI(urlStr));

      $.ajax({
        headers: {
                Accept:"application/json;charset=utf-8"
            },
        contentType:'application/json;charset=UTF-8',
        url: decodeURI(decodeURI(urlStr)),
        type:"GET",
        success:function(dataS,status){
          console.log(dataS);
          $(".ViewAllRendering").html("<div class='typeTitle col-md-12'><h3>精准查询</h3></div><ul class='fuzzyQuery'><ul>");
          $.each(dataS.data.items,function(i,item){
            $(".fuzzyQuery").append(
            '<li>'+
            '<div class="carDetailContainer">'+
              '<div class="detailTitle">'+item.carType+'</div>'+
              '<div class="detailCarImg"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css"><img src="'+item.fileInfoUrl+'" alt=""></a></div>'+
              '<div class="detailDescribe"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css">淘车推荐 '+item.carName+' 魅力 '+item.color+' 动力强劲 马力'+item.rent+'匹 前置后驱 淘车线上专供 </a></div>'+
              '<div class="priceContainer">'+
                '<span class="totalPrice">300万</span>'+
                '<span class="Installment">首付60万</span>'+
              '</div>'+
              '<div class="serviceContainer">'+
                '<i>30天可退</i>'+
                '<i>免费检测</i>'+
                '<i>分期购车</i>'+
              '</div>'+
            '</div>'+
            '</li>'
            );
          });
        },
        error:function(dataE,status){
          console.log(dataE);
        }
      });
    });
  });