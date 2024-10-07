$( "#load" ).on( "click", function(e){          
                
    e.preventDefault();

    $.ajax({
                
        method: "GET",
        url: "http://localhost:8080/api/warehouse/all"  ,
        contentType: "application/json; charset=utf-8",

             })
                    .done(function( msg ) {                                    
                       
                        let el = "";
                        console.log(msg);
                        

                       $.each(msg, function(a, b){
                            console.log(a,b);
                            
                            el += "<li>\n<ul class = 'dist' > \b"; 
                            el += "<li class ='red'>" + "Warehouse: " + b.position + "</li>";
                            el += "<li class ='green'>" + "quantità: " + b.amount + "</li>";
                            
                            el += "<li><input type='submit' id=" + b.id + " onclick='del(this)' value='cancella'>";
                            el += "<a href = './updateWarehouse.html?id=" + b.id + "' class='button' id=" + b.id + ">modifica </a> </li>";//passare valore id                                        
                            el += "</ul>\n</li>";
                            
                        });
                        
                        $("#list").html("");
                        $("#list").append(el);
                });                

});

let del = (e)=>{

   console.log(e.id);
   
   $.ajax({

    method: "DELETE",
    url: "http://localhost:8080/api/warehouse/" + e.id,                
    contentType: "application/json; charset=utf-8",

    })
    .done(function( msg ) {            

    console.log(msg);
    alert(" Cancellato " + e.id);
    location.reload();

});

}
