
$(function(){
 
// alert("i`m in");
// 加载页面汽车信息
    //全量加载
  var loadCarAll = function(){
    $.getJSON("car/findCar",function(data,status){
     if(status=="success"){
        $.each(data,function(i,item){
          $(".taochezhiyin").append(
            '<li>'+
            '<div class="carDetailContainer">'+
              '<div class="detailTitle">'+item.carType+'</div>'+
              '<div class="detailCarImg"><a href="carDetail.html?carId='+item.carId+'" target="_blank" class="a-css"><img src="'+item.carImgUrl+'" alt=""></a></div>'+
              '<div class="detailDescribe"><a href="carDetail.html?carId='+item.carId+'" target="_blank" class="a-css">'+item.carName+item.color+item.carType+'</a></div>'+
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
      $.getJSON("car/findCarByVogue",function(data,status){
     if(status=="success"){
        $.each(data,function(i,item){
          $(".huorexiaoshou").append(
            '<li>'+
            '<div class="carDetailContainer">'+
              '<div class="detailTitle">'+item.carType+'</div>'+
              '<div class="detailCarImg"><a href="carDetail.html?carId='+item.carId+'" target="_blank" class="a-css"><img src="'+item.carImgUrl+'" alt=""></a></div>'+
              '<div class="detailDescribe"><a href="carDetail.html?carId='+item.carId+'" target="_blank" class="a-css">'+item.carName+item.color+item.carType+'</a></div>'+
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
      $.getJSON("car/findByInterest",function(data,status){
     if(status=="success"){
        $.each(data,function(i,item){
          $(".cainixihuan").append(
            '<li>'+
            '<div class="carDetailContainer">'+
              '<div class="detailTitle">'+item.carType+'</div>'+
              '<div class="detailCarImg"><a href="carDetail.html?carId='+item.carId+'" target="_blank" class="a-css"><img src="'+item.carImgUrl+'" alt=""></a></div>'+
              '<div class="detailDescribe"><a href="carDetail.html?carId='+item.carId+'" target="_blank" class="a-css">'+item.carName+item.color+item.carType+'</a></div>'+
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
      $.getJSON("car/findByDifferent",function(data,status){
     if(status=="success"){
        $.each(data,function(i,item){
          $(".yuzhongbutong").append(
            '<li>'+
            '<div class="carDetailContainer">'+
              '<div class="detailTitle">'+item.carType+'</div>'+
              '<div class="detailCarImg"><a href="carDetail.html?carId='+item.carId+'" target="_blank" class="a-css"><img src="'+item.carImgUrl+'" alt=""></a></div>'+
              '<div class="detailDescribe"><a href="carDetail.html?carId='+item.carId+'" target="_blank" class="a-css">'+item.carName+item.color+item.carType+'</a></div>'+
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

  //登录
    // 登录模态框控制
  // var userSignIn =function(){
  //   $('#myModal').modal({
  //       show: true,
  //       backdrop:'static'
  //   })
  // };
  //   // 登录信息post
  // $(".btn-userlogin").click(function(){
  //   var userInfo={};
  //   userInfo.username=$(".userLogin-username").val();
  //   userInfo.userpwd=$(".userLogin-userpwd").val();         
    
  //   $.post("user/login",JSON.stringify(userInfo),function(data,status){
  //     if(status=="success"){
  //       console.log("login success");
  //     }else{
  //       alert("login fail, please check your username or pwd.");
  //     };
  //   });
  // });

  // 个人中心
    // 登录判断

    // 传值跳转

  //搜索栏
  $(".btn-searchBar").click(function(){
    var searchCar={};
    var carInfoVal=$(".info-searchBar").val();
    if(carInfoVal!=''){
      searchCar.carInfo=carInfoVal;
    }else{
      alert("please input your information");
    };
    $.post("car/findCarByCarInfo",JSON.stringify(searchCar),function(data,status){
      if(status=="success"){
        if(data){
            $(".ViewAllRendering").html("");
          $.each(data,function(i,item){
            $(".ViewAllRendering").append(
              '<div class="carDetailContainer">'+
                '<div class="detailTitle">'+item.carType+'</div>'+
                '<div class="detailCarImg"><a href="carDetail.html?carId='+item.carId+'" target="_blank" class="a-css"><img src="'+item.carImgUrl+'" alt=""></a></div>'+
                '<div class="detailDescribe"><a href="carDetail.html?carId='+item.carId+'" target="_blank" class="a-css">'+item.carName+item.color+item.carType+'</a></div>'+
                '<div class="priceContainer">'+
                  '<span class="totalPrice">300万</span>'+
                  '<span class="Installment">首付60万</span>'+
                '</div>'+
                '<div class="serviceContainer">'+
                  '<i>30天可退</i>'+
                  '<i>免费检测</i>'+
                  '<i>分期购车</i>'+
                '</div>'+
              '</div>' 
            );
          });
        }
      }else{
           $(".ViewAllRendering").html("<div><h2>We did`nt find the car you looking for.</h2></div>");
      };
    });
  });

});