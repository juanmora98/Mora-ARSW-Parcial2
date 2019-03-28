var weather = (function(){
	var weather;	
	return{
		setweather : function(tiempo){                    
                    weather = tiempo;
		},
                getweather : function(){
                    return weather;
                },
		resetAll : function(){
			weather = 0;
		}
	}
})();

async function inicio(){
    await getWeather(document.getElementById("ciudad").value);
    setInfo();
    initialize(document.getElementById("ciudad").value);
}

function setInfo(){
    var m = "";
    m += "Las coordenadas son: latitud " + clima.getClima().coord.lat+" Longitud "+clima.getClima().coord.lon;
    m += " Clima: " + clima.getClima().weather[0].main + " description: " + clima.getClima().weather[0].description;
    m +=  " Temperatura: " + clima.getClima().main.temp + " Presion: " + clima.getClima().main.pressure + " Humedad: " + clima.getClima().main.humidity; 
    document.getElementById("orders").innerHTML = m;
}

