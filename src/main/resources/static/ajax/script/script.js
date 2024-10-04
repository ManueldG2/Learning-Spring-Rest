$( "#submit" ).on( "click", function(e){          
                
    e.preventDefault();

    $.ajax({
                
        method: "GET",
        url: "http://localhost:8080/api/article"  ,
        contentType: "application/json; charset=utf-8",

             })
                    .done(function( msg ) {                                    
                       
                        let el = "";
                        console.log(msg);
                        

                       $.each(msg, function(a, b){

                            el += "<li>\n<ul class = 'dist' > \b"; 
                            el += "<li class ='red'>" + "Titolo: " + b.title + "</li>";
                            el += "<li class ='green'>" + "Descrizione: " + b.description + "</li>";
                            el += "<li class ='red'>" + "Caratteristiche: " + b.characteristic + "</li>";
                            el += "<li class ='green'>" + "Categoria: " + b.Categoria + "</li>";
                            el += "<li class ='red'> Costo per confezione"+ b.cost_per_package + "</li>";
                            el += "<li class ='green'> id: " + b.id + "</li>";
                            el += "<li class ='red'>" + b.position + "</li>";
                            el += "<li class ='green'>" + b.price + "</li>";
                            el += "<li class ='red'>" + b.description + "</li>";
                            el += "<li class ='green'>" + b.quantita_per_pacchetto + "</li>";    
                            el += "<li class ='red'>" + b.quantita_totale + "</li>";
                            el += "<li class ='green'>" + b.unity + "</li>";
                            el += "<li><input type='submit' id=" + b.id + " onclick='del(this)' value='cancella'>";
                            el += "<a href = './updateJson.html?id=" + b.id + "' class='button' id=" + b.id + ">modifica </a> </li>";//passare valore id                                        
                            el += "</ul>\n</li>";
                            
                        });
                        
                        $("#list").append(el);
                });                

});

let del = (e)=>{

   console.log(e.id);
   
   $.ajax({

    method: "DELETE",
    url: "http://localhost:8080/api/article/" + e.id,                
    contentType: "application/json; charset=utf-8",

    })
    .done(function( msg ) {            

    console.log(msg);
    alert(" Cancellato " + e.id);
    location.reload();

});

}
