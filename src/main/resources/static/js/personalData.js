$(function(){
    // 喜好标签选择
    $('.tag-like').click(function(){
        $('button').click(function(){
            var obj=$(this);
            obj.removeClass('btn-info');
            obj.addClass('btn-primary');
            console.log(obj);
        });
    });
    // 文件上传按钮控制
    // 编辑按钮设置
    var $editAndSub =$('.eidtAndSub');
    $editAndSub.click(function(){
        // alert(11);
        var $disabledInput=$('input');
        if($editAndSub.html()=='编辑'){
            $disabledInput.attr('disabled',false);
            $editAndSub.text('保存');
        }else{
            $disabledInput.attr('disabled',true);
            $editAndSub.text('编辑');
            setTimeout(function(){
                alert("更新成功");
            }, 1000);
        }
    });
});    