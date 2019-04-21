$(function(){
    function loadUserName(){
        $.ajax({
            contentType:'application/json;charset=utf-8',
            url: "user/info",
            type:"GET",
            dataType: "json",
            // data:JSON.stringify(loginObj),
            success: function(dataF){
                console.log("dataF"+dataF);
                console.log(typeof dataF);
                $(".username").html(dataF.username);
            },
            error: function(dataE){
         
                console.log(dataE); 
            }
         })
    }
    
    loadUserName();
});