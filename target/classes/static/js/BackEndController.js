async function getWeather(city){
    await Promise.resolve(axios.getData('https://moraarswt2.herokuapp.com/weather/'+city)
    .then(async function (response){            
        weather.setWeather(response.data);
    }));
}

