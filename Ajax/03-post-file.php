<?php
/**
 * Created by IntelliJ IDEA.
 * User: 28042
 * Date: 2018/12/7
 * Time: 16:25
 */

print_r($_FILES);
//print_r("<br>");
//print_r($_POST);


//1获取上传文件对应字典
$fileInfo=$_FILES["upFile"];
//2.获取上环文件的名称
$fileName = $fileInfo["name"];
//3.获取上传文件保存的临时路径；
$filePath = $fileInfo["tmp_name"];


//4.移动文件
move_uploaded_file($filePath,"./source/".$fileName);

?>