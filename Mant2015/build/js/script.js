
var valorNombres = 0;   
$(document).on('ready',function() {
	
$('#ciudadBuscar').on('keyup',function(){
	
var valor=$('#ciudadBuscar').val();
//alert(valor);
 
$.ajax({
      type: "post",
      url: 'http://localhost:8080/LAGYv0.1/solicitarListarCiudadesBuscar.do?ciudadBuscar='+valor,
	  //$.post("http://localhost:8080/LAGYv0.1/procesarRegistroGenteCiudades.do", { ciudadBuscar: busqueda })
      dataType: "html",
      success: function(data){
        $('#buscar').html(data); 
        $('#buscar').css('display','block');		       	
},

error: function() {
      alert("An error occurred while processing data.");
    }
    });
});

	$( "#nombres" ).click(function() {		
		$.post("http://localhost:8080/LAGYv0.1/procesarListadoGenteOrd.do", { ordenar: "nombres", tipo: valorNombres })
		.done(function(data) {		  	
		  	if(valorNombres==0) {
				$('#tablecontent').html(data);
		  		valorNombres=1; 
		  	} else {
				$('#tablecontent').html(data);
		  		valorNombres=0; 
		  	}
			
		})
		.fail(function(e) {
		    console.log(e);
	  	});
	});
	var valorApellidos = 0;
	$( "#apellidos" ).click(function() {
		$.post("http://localhost:8080/LAGYv0.1/procesarListadoGenteOrd.do", { ordenar: "apellidos", tipo: valorApellidos })
		.done(function(data) {
		  	$('#tablecontent').html(data);
		  	if(valorApellidos==0) {
		  		valorApellidos=1;
		  	} else {
		  		valorApellidos=0;
		  	}
		})
		.fail(function(e) {
		    console.log(e);
	  	});
	});
	var valorDireccion = 0;
	$( "#direccion" ).click(function() {
		$.post("http://localhost:8080/LAGYv0.1/procesarListadoGenteOrd.do", { ordenar: "direccion", tipo: valorDireccion })
		.done(function(data) {
			console.log(data);
		  	$('#tablecontent').html(data);
		  	if(valorDireccion==0) {
		  		valorDireccion=1;
		  	} else {
		  		valorDireccion=0;
		  	}
		})
		.fail(function(e) {
		    console.log(e);
	  	});
	});
	var valorTelefono = 0;
	$( "#telefono" ).click(function() {
		$.post("http://localhost:8080/LAGYv0.1/procesarListadoGenteOrd.do", { ordenar: "telefono", tipo: valorTelefono })
		.done(function(data) {
		  	$('#tablecontent').html(data);
		  	if(valorTelefono==0) {
		  		valorTelefono=1;
		  	} else {
		  		valorTelefono=0;
		  	}
		})
		.fail(function(e) {
		    console.log(e);
	  	});
	});
	var valorCiudad = 0;
	$( "#ciudad" ).click(function() {
		$.post("http://localhost:8080/LAGYv0.1/procesarListadoGenteOrd.do", { ordenar: "ciudad", tipo: valorCiudad })
		.done(function(data) {
		  	$('#tablecontent').html(data);
		  	if(valorCiudad==0) {
		  		valorCiudad=1;
		  	} else {
		  		valorCiudad=0;
		  	}
		})
		.fail(function(e) {
		    console.log(e);
	  	});
	});

});

function seleccionarCiudad(id, ciudad, estado) {
	//alert("Resultado: "+id+" "+estado+" "+ciudad);
	//a="hola";    
	$('#buscar').css('display','none');	
	//$("#ciudadBuscar").html(ciudad);
	document.getElementById("ciudadBuscar").value=ciudad; 
	$("#estadoNombre").html(estado);
	//$("#idCiudad").html(id);
	document.getElementById("idCiudad").value=id; 
	
}



/*

$('body').on('click','.ciudad',function(){
$('#buscar').css('display','none');
$('#ciudadBuscar').val($(this).html());
//$("#ciudadBuscar").val(ciudad);
//$("#estadoNombre").html(estado);

});


	$('#ciudadBuscar').keyup(function() {
	  	$('.buscar').css('display','block');
	  	var busqueda = $("#ciudadBuscar").val();
	  	$.post("http://localhost:8080/LAGYv0.1/procesarRegistroGenteCiudades.do", { ciudadBuscar: busqueda })
		.done(function(data) {
		  	$('.buscar ul').html(data);
		})
		.fail(function(e) {
		    console.log(e);
	  	});
	});
	
	
	var valorNombres = 0;
	$( "#nombres" ).click(function() {
		$.post("http://localhost:8080/LAGYv0.1/procesarListadoGenteOrd.do", { ordenar: "nombres", tipo: valorNombres })
		.done(function(data) {
		  	$('#tablecontent').html(data);
		  	if(valorNombres==0) {
		  		valorNombres=1;
		  	} else {
		  		valorNombres=0;
		  	}
		})
		.fail(function(e) {
		    console.log(e);
	  	});
	});
	var valorApellidos = 0;
	$( "#apellidos" ).click(function() {
		$.post("http://localhost:8080/LAGYv0.1/procesarListadoGenteOrd.do", { ordenar: "apellidos", tipo: valorApellidos })
		.done(function(data) {
		  	$('#tablecontent').html(data);
		  	if(valorApellidos==0) {
		  		valorApellidos=1;
		  	} else {
		  		valorApellidos=0;
		  	}
		})
		.fail(function(e) {
		    console.log(e);
	  	});
	});
	var valorDireccion = 0;
	$( "#direccion" ).click(function() {
		$.post("http://localhost:8080/LAGYv0.1/procesarListadoGenteOrd.do", { ordenar: "direccion", tipo: valorDireccion })
		.done(function(data) {
			console.log(data);
		  	$('#tablecontent').html(data);
		  	if(valorDireccion==0) {
		  		valorDireccion=1;
		  	} else {
		  		valorDireccion=0;
		  	}
		})
		.fail(function(e) {
		    console.log(e);
	  	});
	});
	var valorTelefono = 0;
	$( "#telefono" ).click(function() {
		$.post("http://localhost:8080/LAGYv0.1/procesarListadoGenteOrd.do", { ordenar: "telefono", tipo: valorTelefono })
		.done(function(data) {
		  	$('#tablecontent').html(data);
		  	if(valorTelefono==0) {
		  		valorTelefono=1;
		  	} else {
		  		valorTelefono=0;
		  	}
		})
		.fail(function(e) {
		    console.log(e);
	  	});
	});
	var valorCiudad = 0;
	$( "#ciudad" ).click(function() {
		$.post("http://localhost:8080/LAGYv0.1/procesarListadoGenteOrd.do", { ordenar: "ciudad", tipo: valorCiudad })
		.done(function(data) {
		  	$('#tablecontent').html(data);
		  	if(valorCiudad==0) {
		  		valorCiudad=1;
		  	} else {
		  		valorCiudad=0;
		  	}
		})
		.fail(function(e) {
		    console.log(e);
	  	});
	});
});

function seleccionarCiudad(id, ciudad, estado) {
	$('.buscar').css('display','none');
	$("#idCiudad").val(id);
	$("#ciudadBuscar").val(ciudad);
	$("#estadoNombre").html(estado);
}
*/