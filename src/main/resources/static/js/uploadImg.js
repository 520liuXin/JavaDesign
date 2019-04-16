var imgSrc = [];  //存放图片路径
var imgFile = []; //存放文件流
var imgName = []; //存放图片名字
//选择图片的操作
function imgUpload(obj) {
	var oInput = '#' + obj.inputId;
	var imgBox = '#' + obj.imgBox;
	var btn = '#' + obj.buttonId;
	//用on是因为它可以动态的绑定事件
	$(oInput).on("change", function() {
		//获取type=file的input
		var fileImg = $(oInput)[0];
		//得到所有的图片列表
		var fileList = fileImg.files;
		for(var i = 0; i < fileList.length; i++) {
			//得到每个图片的路径
			var imgSrcI = getObjectURL(fileList[i]);
			//向文件名的数组末尾添加此文件名
			imgName.push(fileList[i].name);
			//向路径的数组末尾添加路径
			imgSrc.push(imgSrcI);
			//在文件流数组的末尾添加文件
			imgFile.push(fileList[i]);
		}
		//将图片展示出去
		addNewContent(imgBox);
	})
	
	$(btn).on('click', function() {
		if(!limitNum(obj.num)){
		  	alert("最多只能上传"+obj.num+"张照片!");
		  	return false;
		}
		
		//用FormData对象上传
		var fd = new FormData($('#upBox')[0]);
		//由于fd对象中已经包含<input type='file'>的input标签，如果不删除，就会造成重复上传
		fd.delete("file");
		//将文件流循环添加到FormData对象中
		for(var i=0;i<imgFile.length;i++){
			fd.append(obj.data,imgFile[i]);
		}
		//上传所有的图片
		submitPicture(obj.upUrl, fd);
	})
}
//图片展示
function addNewContent(obj) {
	$(imgBox).html("");
	for(var a = 0; a < imgSrc.length; a++) {
		var oldBox = $(obj).html();
		$(obj).html(oldBox + '<div class="imgContainer"><img title=' + imgName[a] + ' alt=' + imgName[a] + ' src=' + imgSrc[a] + ' onclick="imgDisplay(this)"><p onclick="removeImg(this,' + a + ')" class="imgDelete">删除</p></div>');
	}
}
//删除
function removeImg(obj, index) {
	//向数组中删除元素
	imgSrc.splice(index, 1);
	imgFile.splice(index, 1);
	imgName.splice(index, 1);
	var boxId = "#" + $(obj).parent('.imgContainer').parent().attr("id");
	addNewContent(boxId);
}
//限制图片个数
function limitNum(num){
	if(!num){
		return true;
	}else if(imgFile.length>num){
		return false;
	}else{
		return true;
	}
}
 
//上传(将文件流数组传到后台)
function submitPicture(url,data) {
    for (var p of data) {
	  	console.log(p);
	}
	if(url&&data){
		$.ajax({
			type: "post",
			url: url,
			async: true,
			data: data,
			//下面这两个要写成false，要不然上传不了。
			processData: false,
			contentType: false,
			success: function(dat) {
				console.log(dat);
			}
		});
	}else{
	  alert('数据格式不正确!');
	}
}
//当鼠标移到图片上时，显示x删除
function imgDisplay(obj) {
	var src = $(obj).attr("src");
	var imgHtml = '<div style="width: 100%;height: 100vh;overflow: auto;background: rgba(0,0,0,0.5);text-align: center;position: fixed;top: 0;left: 0;z-index: 1000;"><img src=' + src + ' style="margin-top: 100px;width: 70%;margin-bottom: 100px;"/><p style="font-size: 50px;position: fixed;top: 30px;right: 30px;color: white;cursor: pointer;" onclick="closePicture(this)">×</p></div>'
	$('body').append(imgHtml);
}
//关闭
function closePicture(obj) {
	$(obj).parent("div").remove();
}
//图片预览路径
function getObjectURL(file) {
	var url = null;
	if(window.createObjectURL != undefined) { // basic
		url = window.createObjectURL(file);
	} else if(window.URL != undefined) { // mozilla(firefox)
		url = window.URL.createObjectURL(file);
	} else if(window.webkitURL != undefined) { // webkit or chrome
		url = window.webkitURL.createObjectURL(file);
	}
	return url;
}
