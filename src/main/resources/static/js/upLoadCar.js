$(function(){
    $(".fileUpLoad").click(function(){
        $("#files").click(); 
    });
    $(".fileUpLoad").blur(function(){
        var fd = new FormData();
        for (var i = 0; i < $("#files")[0].files.length; i++) {
            fd.append("files",$("#files")[0].files[i]);
        }
        console.log(fd);
        $.ajax({
            url: "car/add",
            type:"POST",
            data: fd,
            success:function(dataS){
                alert("dataS"+dataS);
            },
            error:function(dataE){
                alert('dataE'+dataE);
            },
        });
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
         $.ajax({
                url: "car/add",
                type:"POST",
                dataType: "json",
                data: JSON.stringify(carinfoObj),
                success:function(dataS){
                    alert("dataS"+dataS);
                },
                error:function(dataE){
                    alert('dataE'+dataE);
                },
            });

    });
});