var map;
var arraymarker = new Array();
var arraymarker2 = new Array();
function iniciarMap() {
    var coord = {lat: -11.0886694, lng: -77.6253523};
    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 15,
        center: coord,
        mapTypeId: 'hybrid'
    });

}
function addMarker(coordinates, dato) {
    for (var i = 0; i < this.arraymarker.length; i++) {
        this.arraymarker[i].setMap(null);
    }
    this.arraymarker = new Array();

    var marker = new google.maps.Marker({
        position: coordinates, // Passing the coordinates
        map: map, //Map that we need to add
        draggarble: false, // If set to true you can drag the marker
        title: dato,
        icon: 'img/carrorojo1.png'
    });
    var infowindow = new google.maps.InfoWindow({
        content: dato});
    google.maps.event.addListener(marker, 'click', function () {
        infowindow.open(map, marker);
    });
    arraymarker.push(marker);

}


function  agregarSegundoMapa(coordenada, dato) {
    for (var i = 0; i < this.arraymarker2.length; i++) {
        this.arraymarker2[i].setMap(null);
    }
    this.arraymarker2 = new Array();

    var marker2 = new google.maps.Marker({
        position: coordenada,
        map: map,
        title: dato,
        icon: 'img/azul48.png'
    });

    var infowindow = new google.maps.InfoWindow({
        content: dato});
    google.maps.event.addListener(marker2, 'click', function () {
        infowindow.open(map, marker2);
    });

    arraymarker2.push(marker2);
}



$(function () {
    const verificarCambio = () => {
        $.get("obtenerUbic.jsp", function (data) {
            ubic = JSON.parse(data.trim());
            let dato = ubic.dato;
            addMarker(ubic, dato);


            var myLatlng = new google.maps.LatLng(ubic.lat, ubic.lng);
            map.panTo(myLatlng);
        });
        setTimeout(verificarCambio, 3000);
    };
    setTimeout(verificarCambio(), 3000);

});


$(function () {
    const verificarCambio2 = () => {
        $.get("obtenerUbic.jsp", function (data) {
            ubic2 = JSON.parse(data.trim());
            let dato = ubic.dato;
            agregarSegundoMapa(ubic2, dato);


            var myLatlng = new google.maps.LatLng(ubic2.lat, ubic2.lng);
            map.panTo(myLatlng);
        });
        setTimeout(verificarCambio2, 4000);
    };
    setTimeout(verificarCambio2(), 4000);

});
