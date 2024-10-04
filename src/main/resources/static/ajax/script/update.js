  

            //recupero il valore passato via GET
            let id = (window.location.href.split("=")[1]);             

            $.ajax({ //sarebbe da sistemare il codice
                    method: "GET",
                    url: "http://localhost:8080/api/article/all/" + id  ,
                    contentType: "application/json; charset=utf-8",
                    })
                    .done(function( msg ) {

            

            $.ajax(
                    {
                        method: "GET",
                        url: "http://localhost:8080/api/warehouse/all"   ,
                        contentType: "application/json; charset=utf-8",
                    }
                ).done( (msg)=>{

                            for(let ele of msg){

                                $("#warehouses").append($('<option>', {
                                        value: ele.id,
                                        text: ele.position
                                        }));

                            }
                            
                        });

            $.ajax(
                    {
                        method: "GET",
                        url: "http://localhost:8080/api/category"   ,
                        contentType: "application/json; charset=utf-8",
                    }
                ).done( (msg)=>{

                            for(let ele of msg){

                                $("#categories")
                                    .append($('<option>', {
                                            value: ele.id,
                                            text: ele.name
                                            }
                                        )
                                    );
                                }
                            
                        });

                $("#id").val(id);
                $("#title").val(msg.title);
                $("#description").val(msg.description);
                $("#characteristic").val(msg.characteristic);
                $("#category").val(msg.category);
                $("#quantity").val(msg.quantity);
                $("#price").val(msg.price);
                $("#unity").val(msg.unity);
                $("#code").val(msg.code);
                $("#warehouse").val(msg.warehouseId);
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
                        url: "http://localhost:8080/api/article/" + id ,
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
            
            

            
        