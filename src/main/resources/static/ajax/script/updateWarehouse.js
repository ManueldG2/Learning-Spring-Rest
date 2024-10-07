  

            //recupero il valore passato via GET
            let id = (window.location.href.split("=")[1]);             

            $.ajax({ //sarebbe da sistemare il codice
                    method: "GET",
                    url: "http://localhost:8080/api/warehouse/all/" + id  ,
                    contentType: "application/json; charset=utf-8",
                    })
                    .done(function( msg ) {

                $("#id").val(id);
                $("#position").val(msg.position);
                $("#amount").val(msg.amount);
                console.log(msg);
                
                // immettere valori nel form                        
                                    
                })
            
            //fare un get dei dati per poi fare la modifica

            $( "#submit" ).on( "click", function(e) {

                e.preventDefault();

                let article = [];             
          
                let form = $(".form")[0];

                let formData = {};

                for (let i = 0; i < form.elements.length; i++) {

                    let element = form.elements[i];
                
                    if (!(element.type == "submit" || element.type == ""  )) {     
                        
                        formData[element.name] = element.value;

                    }

            }

            let data = JSON.stringify(formData);
                

            $.ajax(
                    {
                        method: "PUT",
                        url: "http://localhost:8080/api/warehouse/" + id ,
                        data,
                        contentType: "application/json; charset=utf-8",
                    }
                )
                .done(function( msg ) {

                        if(msg)
                            $("#message").html("ok");
                            
                    }
                );

            }
        );
            
            

            
        