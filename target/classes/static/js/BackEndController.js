async function getWeather(city){
    await Promise.resolve(axios.get('https://moraarswt2.herokuapp.com/'+city)
    .then(async function (response){            
        weather.setWeather(response.data);
    }));
}

