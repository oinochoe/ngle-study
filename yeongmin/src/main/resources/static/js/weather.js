$(document).ready(function() {
  // geolocation enabled

  if ("geolocation" in navigator) {
    navigator.geolocation.getCurrentPosition(showcityname);

    function showcityname(position) {
      var lat = position.coords.latitude;
      var longit = position.coords.longitude;
      var altitude = position.coords.altitude;
     /* var latitude_text = document.getElementById("latitude-val");
      var altitude_text = document.getElementById("altit");*/
      var city_name;
      var temp;
      /*var pressure;
      var wind_speed;*/
      var country_name;
      var weather_icon;
      var weather_description;
      var apiKey = "9a46b463d1696e1bf1f75e295cca001d";

      /*altitude_text.innerHTML = "Altitude is " + altitude;
      latitude_text.innerHTML = "Latitude is " + lat;*/

      $.getJSON("http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + longit + "&appid=" + apiKey, function(data) {

        city_name = data["name"];
        country_name = data["sys"]["country"];
        weather = data["weather"][0]["main"];
        weather_description = data["weather"][0]["description"];
        
        weather_icon = data["weather"][0]["icon"];
        
        temp = data["main"]["temp"];
        
        
        
        /*pressure = data["main"]["pressure"];
        
        wind_speed = data["wind"]["speed"];*/
        
        // $("#cityname").html(city_name + " &#40;" + country_name + "&#41; " + "has" + weather_description);        
        
        //console.log(temp)
        temp = temp-273.15;
        temp = temp.toFixed(1) + 'ºC';
        
        $('.intro-header .site-heading').css('background-image', 'url(/image/' + weather + '.png)')

        //temp = (temp-32) / 1.8 + 'ºC';       
        $(".temp").html(temp);
        $(".temp-icon").append('<img src='+ 'http://openweathermap.org/img/w/'+  weather_icon + '.png' + '>' );
        
        
        /*$(".pressure").html(pressure + " mBar");
        $(".wind-spd").html(wind_speed + " m/s");*/

      })

    }

  }

})