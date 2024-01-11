if (navigator.geolocation) {
    // La géolocalisation est prise en charge
} else {
    // La géolocalisation n'est pas prise en charge
    console.log("La géolocalisation n'est pas prise en charge par votre navigateur.");
}


// Fonction de succès pour Geolocation API
function successCallback(position) {
    const latitude = position.coords.latitude;
    const longitude = position.coords.longitude;

    // Appeler OpenWeather avec les coordonnées géographiques
    callOpenWeatherAPI(latitude, longitude);
}

// Fonction d'échec pour Geolocation API
function errorCallback(error) {
    console.error(`Erreur de géolocalisation: ${error.message}`);
}



// Fonction pour appeler OpenWeather API avec les coordonnées
function callOpenWeatherAPI(latitude, longitude) {
    const apiKey = '1640c4a6652fd98a3aee1004bff749c8';

    // Construire l'URL de l'API OpenWeather avec les coordonnées
    const apiUrl = `https://api.openweathermap.org/data/2.5/weather?lat=${latitude}&lon=${longitude}&appid=${apiKey}&units=metric`;

    // Sélectionner l'élément HTML où vous afficherez les données
    const weatherDataElement = document.getElementById('weatherData');

    // Effectuer la requête vers l'API OpenWeather
    fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            const iconCode = data.weather[0].icon;
            const iconUrl = `https://openweathermap.org/img/w/${iconCode}.png`;


            weatherDataElement.innerHTML = `
        <p>Ville: ${data.name}</p>
        <p>Température: ${data.main.temp} °C</p>
        <p>Humidité: ${data.main.humidity} %</p>
        <img src="${iconUrl}" alt="Icone météo">
      `;
        })
        .catch(error => {
            // Gérer les erreurs de la requête vers l'API OpenWeather
            console.error('Erreur lors de la requête vers l\'API OpenWeather', error);
            weatherDataElement.innerHTML = '<p>Erreur lors de la récupération des données météorologiques.</p>';
        });
}

// Options pour la Geolocation API (facultatif)
const geolocationOptions = {
    enableHighAccuracy: true,
    timeout: 5000,
    maximumAge: 0
};

// Appeler la Geolocation API avec les fonctions de rappel
navigator.geolocation.getCurrentPosition(successCallback, errorCallback, geolocationOptions);
