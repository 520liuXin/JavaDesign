
$(function(){
 
  console.log("i`m in");
  // 加载页面汽车信息
      //全量加载
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
              '<div class="detailTitle"></div>'+
              '<div class="detailCarImg"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css"><img src="'+item.fileInfoUrl+'" alt=""></a></div>'+
              '<div class="priceContainer">'+
                '<span class="totalPrice">￥</span>'+
                '<span class="Installment">'+item.rent+'</span>'+
              '</div>'+
              '<div class="detailDescribe"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css"> '+item.carName+' 魅力 '+item.color+' 动力强劲 马力'+item.engine+'匹 给您最优质的服务，最享受的驾驶体验。 </a></div>'+
              
            '</div>'+
            '</li>'
          );
        });
      });
    };
     
      $("#BYBK").click(function(){
        console.log("BYBK");
        $(".WDNMD").html(" ");
        $.getJSON("car/findByVogue",function(info,status){
          console.log(info);
          $.each(info.data,function(i,item){
            // console.log(i);
            // console.log(item);
            $(".WDNMD").append(
              '<li>'+
              '<div class="carDetailContainer">'+
                '<div class="detailTitle"></div>'+
                '<div class="detailCarImg"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css"><img src="'+item.fileInfoUrl+'" alt=""></a></div>'+
                '<div class="priceContainer">'+
                  '<span class="totalPrice">￥</span>'+
                  '<span class="Installment">'+item.rent+'</span>'+
                '</div>'+
                '<div class="detailDescribe"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css"> '+item.carName+' 魅力 '+item.color+' 动力强劲 马力'+item.engine+'匹 给您最优质的服务，最享受的驾驶体验。 </a></div>'+
                
              '</div>'+
              '</li>'
            );
          });
        });
      });
      $("#ZCJX").click(function(){
        $(".WDNMD").html(" ");
        $.getJSON("car/findByInterest",function(info,status){
          console.log(info);
          $.each(info.data,function(i,item){
            // console.log(i);
            // console.log(item);
            $(".WDNMD").append(
              '<li>'+
              '<div class="carDetailContainer">'+
                '<div class="detailTitle"></div>'+
                '<div class="detailCarImg"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css"><img src="'+item.fileInfoUrl+'" alt=""></a></div>'+
                '<div class="priceContainer">'+
                  '<span class="totalPrice">￥</span>'+
                  '<span class="Installment">'+item.rent+'</span>'+
                '</div>'+
                '<div class="detailDescribe"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css"> '+item.carName+' 魅力 '+item.color+' 动力强劲 马力'+item.engine+'匹 给您最优质的服务，最享受的驾驶体验。 </a></div>'+
                
              '</div>'+
              '</li>'
            );
          });
        });
      });
      $("#DJYG").click(function(){
        $(".WDNMD").html(" ");
        $.getJSON("car/findByDifferent",function(info,status){
          console.log(info);
          $.each(info.data,function(i,item){
            // console.log(i);
            // console.log(item);
            $(".WDNMD").append(
              '<li>'+
              '<div class="carDetailContainer">'+
                '<div class="detailTitle"></div>'+
                '<div class="detailCarImg"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css"><img src="'+item.fileInfoUrl+'" alt=""></a></div>'+
                '<div class="priceContainer">'+
                  '<span class="totalPrice">￥</span>'+
                  '<span class="Installment">'+item.rent+'</span>'+
                '</div>'+
                '<div class="detailDescribe"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css"> '+item.carName+' 魅力 '+item.color+' 动力强劲 马力'+item.engine+'匹 给您最优质的服务，最享受的驾驶体验。 </a></div>'+
                
              '</div>'+
              '</li>'
            );
          });
       });
      });
      $("#MRHC").click(function(){
        $(".WDNMD").html(" ");
        $.getJSON("car/findByLatest",function(info,status){
          console.log(info);
          $.each(info.data,function(i,item){
            // console.log(i);
            // console.log(item);
            $(".WDNMD").append(
              '<li>'+
              '<div class="carDetailContainer">'+
                '<div class="detailTitle"></div>'+
                '<div class="detailCarImg"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css"><img src="'+item.fileInfoUrl+'" alt=""></a></div>'+
                '<div class="priceContainer">'+
                  '<span class="totalPrice">￥</span>'+
                  '<span class="Installment">'+item.rent+'</span>'+
                '</div>'+
                '<div class="detailDescribe"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css"> '+item.carName+' 魅力 '+item.color+' 动力强劲 马力'+item.engine+'匹 给您最优质的服务，最享受的驾驶体验。 </a></div>'+
                
              '</div>'+
              '</li>'
            );
          });
       });
      });

    // 启用方法
    loadCarAll();

    //搜索栏
    $(".btn-searchBar").click(function(){
      $(".WDNMD").html(" ");
      var searchCar={};
      var carinfoVal=$(".info-searchBar").val();
      if(carinfoVal!=''){
        searchCar.carInfo=carinfoVal;
      }else{
        alert("please input your information");
      };

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
                $(".WDNMD").html("<div><h2>抱歉！！！ 查询车辆不存在。</h2></div>");
              }else{
                $.each(info.data,function(i,item){
                  $(".WDNMD").append(
                  '<li>'+
                  '<div class="carDetailContainer">'+
                    '<div class="detailTitle"></div>'+
                    '<div class="detailCarImg"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css"><img src="'+item.fileInfoUrl+'" alt=""></a></div>'+
                    '<div class="priceContainer">'+
                      '<span class="totalPrice">￥</span>'+
                      '<span class="Installment">'+item.rent+'</span>'+
                    '</div>'+
                    '<div class="detailDescribe"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css"> '+item.carName+' 魅力 '+item.color+' 动力强劲 马力'+item.engine+'匹 给您最优质的服务，最享受的驾驶体验。 </a></div>'+
                    
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
    // 按条件查询
    // $("a").click(function(){
    //   // alert($(this).attr("name"));
    //   // 获取name属性
    //   var queryByCodition = {};
    //   if($(this).attr("name")!=undefined || $(this).attr("name")!=null){
    //     queryByCodition.codition = $(this).attr("name");
    //   }
    //   var urlStr = "/car/findCar?"+queryByCodition.codition;
    //   console.log(urlStr+"------"+decodeURI(urlStr));

    //   $.ajax({
    //     headers: {
    //             Accept:"application/json;charset=utf-8"
    //         },
    //     contentType:'application/json;charset=UTF-8',
    //     url: decodeURI(decodeURI(urlStr)),
    //     type:"GET",
    //     success:function(info,status){
    //       console.log(info);
    //       $(".ViewAllRendering").html("<div class='typeTitle col-md-12'><h3>精准查询</h3></div><ul class='fuzzyQuery'><ul>");
    //       $.each(info.data.items,function(i,item){
    //         $(".fuzzyQuery").append(
    //         '<li>'+
    //         '<div class="carDetailContainer">'+
    //           '<div class="detailTitle">'+item.carType+'</div>'+
    //           '<div class="detailCarImg"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css"><img src="'+item.fileinfoUrl+'" alt=""></a></div>'+
    //           '<div class="detailDescribe"><a href="carDetail.html?id='+item.id+'" target="_blank" class="a-css">淘车推荐 '+item.carName+' 魅力 '+item.color+' 动力强劲 马力'+item.engine+'匹 前置后驱 淘车线上专供 </a></div>'+
    //           '<div class="priceContainer">'+
    //             '<span class="totalPrice">300万</span>'+
    //             '<span class="Installment">首付60万</span>'+
    //           '</div>'+
    //           '<div class="serviceContainer">'+
    //             '<i>30天可退</i>'+
    //             '<i>免费检测</i>'+
    //             '<i>分期购车</i>'+
    //           '</div>'+
    //         '</div>'+
    //         '</li>'
    //         );
    //       });
    //     },
    //     error:function(dataE,status){
    //       console.log(dataE);
    //     }
    //   });
    // });

    $(".glyphicon-log-out").click(function(){
      $.ajax({
        contentType:'application/json;charset=utf-8',
          url: "/user/logout",
          type:"GET",  
          // dataType: "json", 
          // data:JSON.stringify(searchCar),
          success:function(data){
            console.log("loginOut:"+data);
          }
      });
    });
  });