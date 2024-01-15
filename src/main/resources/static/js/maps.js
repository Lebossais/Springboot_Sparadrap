const MapsElement = document.getElementById('map')

let center = [4, 44.4]
const map = tt.map({
    key : "AStjNe5G4GbXyt7MFGIANXrmBrAPEzh7",
    container: "map",
    center:center,
    zoom: 10
})
map.on('load', () => {
    new tt.Marker().setLngLat(center).addTo(map)
})
