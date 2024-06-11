

$(function(){
    $("#tbodyId").on("change",".cBox",doChangeCheckAllState) //说明:采用on方法注册事件,允许on方法内部的元素暂时不存在
    $("thead").on("change","#checkAll",doCheckAll);
    $("#exportBtn").on("click",doGetCheckedIds);


    function doChangeCheckAllState(){
        //1.获取tbody中所有checkbox对象状态进行与操作的结果
        var flag=true;
        $("#tbodyId input[type=checkbox]")
            .each(function(){
                flag=flag&&$(this).prop("checked")
            });
        //2.将tbody中checkbox最终与状态的结果影响thead中checkbox的状态.
        $("#checkAll").prop("checked",flag);

    }
    function doCheckAll(){
        //1.获得点击对象(全选的checkbox)的checked属性值
        var flag=$(this).prop("checked");
        //2.让全选对象的状态值影响tbody中checkbox的状态值.
        /*$("#tbodyId input[type=checkbox]")
         .each(function(){
             $(this).prop("checked",flag);
         }); */
        $("#tbodyId input[type=checkbox]")
            .prop("checked",flag);
    }

    function doGetCheckedIds(){
        //1.定义数组用于存储选中的checkbox的值
        var array="";// var array=[];
        //2.迭代所有tbody中checkbox对象并获取选中的值
        $("#tbodyId input[type=checkbox]")
            .each(function(){
                if($(this).prop("checked")){
                    array= array.concat(",",$(this).val().toString())
                }
            });
        //3.返回选中的值.
        return "apiInfoPKs="+array.substr(1,array.length);
    }

});
