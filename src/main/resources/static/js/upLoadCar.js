$(function(){
    $(".fileUpLoad").click(function(){
        $("#files").click();
    });
    $("#files").on("change",function(){
// alert(1);
        var fd = new FormData();
        for (var i = 0; i < $("#files")[0].files.length; i++) {
            fd.append("files",$("#files")[0].files[i]);
        }
// console.log(fd);
// $.ajax({
// url: "car/add",
// type:"POST",
// dataType:"json",
// data: fd,
// contentType:false,
// processData:false,
// success:function(dataS){
// console.log("dataS"+dataS);
// },
// error:function(dataE){
// console.log('dataE'+dataE);
// },
// });
    });

    $(".submitBtn").click(function(){
        var carinfoObj = {};
        carinfoObj.carBrand = $("#carBrand").val();
        carinfoObj.carName = $("#carName").val();
        carinfoObj.displacement = $("#displacement").val();
        carinfoObj.fuelConumption = $("#fuelConumption").val();
        carinfoObj.engine = $("#engine").val();
        carinfoObj.color = $("#color").val();
        carinfoObj.rent = $("#rent").val();
        carinfoObj.repair = $("#repair").val();
        carinfoObj.carDescribe = $("#carDescribe").val();
        carinfoObj.driveWay = $("input[name=optionsRadiosinline1]:checked").val();
        carinfoObj.carType = $("input[name=optionsRadiosinline2]:checked").val();
        carinfoObj.ridingNumber = $("input[name=optionsRadiosinline3]:checked").val();

        for (var key in carinfoObj) {
            if (!carinfoObj.hasOwnProperty(key)) {
                alert("请填写："+ key +"。");
            }
        }

        var formData = new FormData($("#studentAddForm")[0]);
        $.ajax({
            url: "car/add",
            type:"POST",
            data: formData,
            cache: false,
            async: false,
            processData : false, //必须false才会避开jQuery对 formdata 的默认处理
            contentType : false, //必须false才会自动加上正确的Content-Type
            success:function(dataS){
                console.log("dataS"+dataS);
                console.log(formData);
            },
            error:function(dataE){
                console.log('dataE'+dataE);
                console.log(formData);
            },
        });

    });
});