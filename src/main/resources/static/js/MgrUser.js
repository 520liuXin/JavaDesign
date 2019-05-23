$(function(){
    // find all user
    god = {};
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

    function findAll(){
       $.getJSON("/user/findAll",function(info,status){
            if(info.code == "0000"){
                $(".infoBody").html(" ");
                $.each(info.data,function(i,item){
                    $(".infoBody").append(
                        '<tr>'+ 
                        '<td>'+item.username+'</td>'+
                        '<td>******</td>'+
                        '<td>'+item.admin+'</td>'+
                        '<td>'+item.phone+'</td>'+
                        '<td>'+item.idCard+'</td>'+
                        '<td>'+timestampToTime(item.createdDate)+'</td>'+
                        '<td>'+item.email+'</td>'+
                        '<td> <button type="button" data-toggle="modal" data-target="#editUserModal" class="btn btn-default editBtn btn-sm"><span class="glyphicon editBtn glyphicon-pencil"></span></button>'+ 
                        '<button type="button" id="delBtn" class="btn btn-default delBtn btn-sm"><span class="glyphicon delBtn glyphicon-trash"></span></button></td>'+
                        '</tr>'
                    );
                });


            }
       });

       $(".delBtn").click(function(){
        alert(1);
        var delInfo = {};
        delInfo.userName = $(this).attr("id");
        // $.ajax({
        //     contentType:'application/json;charset=utf-8',
        //     url: "/user/delete",
        //     type:"POST",  
        //     dataType: "json",
        //     data:JSON.stringify(delInfo),
        //     success:function(dataS){
        //         alert(dataS.data);
        //         parent.location.reload();
        //     },
        //     error:function(dataE){
        //         alert(dataE.data);
        //     }
        // });
        });
        $(".editBtn").click(function(){
            alert(2);
            god.username = $(this).attr("id");
        });
        };

    //find user by ?
   $(".searchBtn").click(function(){
       var userInfo = {};
       if($("#userNameInfo").val() != ' ' || $("#userNameInfo").val() != null){
        userInfo.username = $("#userNameInfo").val();
       }else{
           alert("请填写查询内容");
       }
      
       $.ajax({
            contentType:'application/json;charset=utf-8',
            url: "/user/findUser?username="+$("#userNameInfo").val(),
            type:"GET",  
            // dataType: "json",
            // data:JSON.stringify(userInfo),
            success:function(dataS){
                // dataS.data.item
                if(dataS.code == "0000"){
                    $(".infoBody").html(" ");
                    $.each(dataS.data.items,function(i,item){
                        $(".infoBody").append(
                            '<tr>'+ 
                            '<td>'+item.username+'</td>'+
                            '<td>******</td>'+
                            '<td>'+item.admin+'</td>'+
                            '<td>'+item.phone+'</td>'+
                            '<td>'+item.idCard+'</td>'+
                            '<td>'+timestampToTime(item.createdDate)+'</td>'+
                            '<td>'+item.email+'</td>'+
                            '<td> <button type="button" data-toggle="modal" data-target="#editUserModal" class="btn btn-default editBtn btn-sm"><span class="glyphicon glyphicon-pencil"></span></button>'+ 
                            '<button type="button" class="btn btn-default delBtn btn-sm"><span class="glyphicon glyphicon-trash"></span></button></td>'+
                            '</tr>'
                        );
                    });
                }
            },
            error:function(){
                alert("查询出错请重试");
            },
            
        });
        $(".delBtn").click(function(){
            alert(1);
            var delInfo = {};
            delInfo.userName = $(this).attr("id");
            // $.ajax({
            //     contentType:'application/json;charset=utf-8',
            //     url: "/user/delete",
            //     type:"POST",  
            //     dataType: "json",
            //     data:JSON.stringify(delInfo),
            //     success:function(dataS){
            //         alert(dataS.data);
            //         parent.location.reload();
            //     },
            //     error:function(dataE){
            //         alert(dataE.data);
            //     }
            // });
        });
        $(".editBtn").click(function(){
            alert(2);
            god.username = $(this).attr("id");
        });

   });


    $(".btn-changePwd").click(function(){
        // 获取用户id 新密码校验
        if($("#pwdCheck").val() == $("#newPwd").val()){
            var changePwdObj = {};
            changePwdObj.userName = god.username;
            changePwdObj.newPwd =  $("#newPwd").val();
            // $.ajax({
            //     contentType:'application/json;charset=utf-8',
            //     url: "/user/updatePwd",
            //     type:"POST",  
            //     dataType: "json",
            //     data:JSON.stringify(changePwdObj),
            //     success:function(dataS){
            //         alert(dataS.data);
            //         parent.location.reload();
            //     },
            //     error:function(dataE){
            //         alert(dataE.data);
            //     }
            // });
        }else{
            alert("两次填写的密码不一致，请核实");
        }
    });

    findAll();
});