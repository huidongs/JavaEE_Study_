
//将对象转换成字符串
function o(obj) {
    var res = [];
    obj.t = new Date().getTime();
    for (var key in obj) {
        //在URL中是不可以出现中文的，如果出现了中文需要转码；
        //可以调用encodeURIComponent方法；
        //URL中只可以出现字母/数字/下划线/AXSCII码；
        res.push(encodeURIComponent(key) + "=" + encodeURIComponent(obj[key]));//[userNmae = lnj, userPwd = 123456];
    }
    return res.join("&");//userNmae=lnj&userPwd=123456

}


//封装GET方法
    function ajax(url, timeout,obj, success, error) {

        //0 将对象转换成字符串；

        var timer;
        var str = o(obj);//key=value&key=value;

        //1创建一个异步对象
        var xmlhttp = new XMLHttpRequest();
        //2设置请求方式和请求地址；
        /*
        method：请求类型：get或post
        url:文件在服务器上的位置；
        async：true（异步）或false（同步）

        //如需兼容ie6,5 则按如下写法；
                var xmlhttp;
            if (window.XMLHttpRequest)
              {// code for IE7+, Firefox, Chrome, Opera, Safari
              xmlhttp=new XMLHttpRequest();
              }
            else
              {// code for IE6, IE5
              xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");  }


         */


        //在ie浏览器中，如果通过Ajax发送get请求，那么ie浏览器认为在同一个url只有一个结果；04-ajax-get.php===abc
        //解决方法为获取随机数
        // Math().random();
        // new Date().getTime();
        xmlhttp.open("GET", url + "?" + str, true);
        //3.发送请求
        xmlhttp.send();
        //4.监听状态的变化
        xmlhttp.onreadystatechange = function (ev2) {
            /*
            0: 请求未初始化
            1: 服务器连接已建立
            2: 请求已接收
            3: 请求处理中
            4: 请求已完成，且响应已就绪
            * */

            //5处理返回的结果

            if (xmlhttp.readyState === 4) {
                clearInterval(timer);
                if (xmlhttp.status >= 200 && xmlhttp.status < 300 || xmlhttp.status === 304) {
                    // console.log("接收到服务器返回的数据");
                    success(xmlhttp);

                } else {
                    //    console.log("没有接收到服务器返回的数据");
                    error(xmlhttp);
                }
            }
        }
        //判断是否超时
        if (timeout){
            timer = setInterval(function () {
                xmlhttp.abort();
                clearInterval(timer);
            },timeout);
        }


}