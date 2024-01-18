const MapsElement = document.getElementById('map')

let center = [4, 44.4]
const map = tt.map({
    key : "",
    container: "map",
    center:center,
    zoom: 10
})
map.on('load', () => {
    new tt.Marker().setLngLat(center).addTo(map)
})
