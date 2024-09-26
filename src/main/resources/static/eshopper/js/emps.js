/*
 * empService 
 * 모듈 구성하기
 *    
 * 모듈 패턴은 쉽게 말해서 Java의 클래스처럼 JavaScript를 이용해서 메서드를 가지는 객체를 구성한다. 
 * 모듈 패턴은 JavaScript의 즉시 실행함수와 '{}'를 이용해서 객체를 구성한다. 
 *  
 * 
 * */

console.log("emps 모듈..");

let empService = function(){
   //console.log("안녕하세요");
  
   function list(callback){
      
      $.ajax({
         type:"GET",
         url: "/emps/list",
         success : function(result) {
            console.log(result);
            
            if(callback){
               callback(result);
            }
            
         },
         error:function(e){
            console.log(e);
         }
         
      });      
   } //list()
   
	function del(bid){          

		$.ajax({
               type:"DELETE",
               url: "/emps/" + bid,
               success : function(result) {
                 
               console.log("삭제된 갯수" + result)
                 

               },
               error:function(e){
                  console.log(e);
               }
               
            });      
       }
   
	function insert(emp){          

       $.ajax({
			type:"POST",
			url: "/emps/",
			contentType:'application/json; charset=utf-8',
            data:JSON.stringify(emp),
             success : function(result) {
               
               if(result == "SUCCESS")
                   console.log(result);

             },
             error:function(e){
                console.log(e);
             }
             
          });      
     }
     

	return {
		list : list,
		del : del,
		insert : insert
	}
};