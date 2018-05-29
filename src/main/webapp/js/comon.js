$(function () {
   $.ajax({
       url:'/tf/getClassBySys_userId',
       type:"POST",
       dataType:"json",
       data:{
            "id":"1"
       },
       success:function(data) {
           if (data.code == 200){
               //console.log(data.data);
               var item;
               var list = data.data;
               for (var i = 0; i < list.length ; i++){
                   item = "<option value="+list[i].classSysid+">"+list[i].className+"</option>";
                   var obj=document.getElementById('sc');
                   $("#sc").append('<option value="'+ list[i].classSysid +'">' + list[i].className + '</option>');
                   console.log(obj.innerHTML);
                   form.render('select');
                   //renderForm();
                   //$("#sc").append(item);
                   //document.getElementById("sc");
                   //console.log(list[i].classSysid);
               }
           }
       },
       error:function (data) {

       }
   });
});