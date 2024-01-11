localStorage.clear();

const buttons = document.querySelectorAll('.ajouterPanier');

buttons.forEach(button => {
    button.addEventListener('click', event => {
        const row = event.target.closest('tr');

        const nomMedicament = row.querySelector('td:nth-child(1) span').innerText;
        const prixMedicament = parseFloat(row.querySelector('td:nth-child(2) span').innerText);

        const medicamentToAdd = {
            Medi_Nom: nomMedicament,
            Medi_Prix: prixMedicament,
            quantity: 1
        };

        let panier = JSON.parse(localStorage.getItem('panier')) || [];

        const existingItem = panier.find(item => item.Medi_Nom === medicamentToAdd.Medi_Nom);

        if (existingItem) {
           existingItem.quantity++;
        } else {
             panier.push(medicamentToAdd);
        }

        localStorage.setItem('panier', JSON.stringify(panier));

        refreshPanierDisplay();
    });
});

// Fonction pour rafraîchir l'affichage du panier
function refreshPanierDisplay() {
    const panierTableBody = document.getElementById('panierBody');
    panierTableBody.innerHTML = '';

    let panier = JSON.parse(localStorage.getItem('panier')) || [];

    if (panier.length === 0) {
        panierTableBody.innerHTML = `
            <tr>
                <td colspan="4">Votre panier est vide.</td>
            </tr>
        `;
    } else {
        panier.forEach(item => {
            const totalPrice = item.Medi_Prix * item.quantity;

            panierTableBody.innerHTML += `
                <tr>
                    <td>${item.Medi_Nom}</td>
                    <td>${item.quantity}</td>
                    <td>${item.Medi_Prix}</td>
                    <td>${totalPrice}</td>
                </tr>
            `;
        });
    }
}

// Gestion de l'affichage de la Date et Heure en temps réel.
var d = new Date();


var timerRunning = false;
function runClock()
{
    var today   = new Date();
    var date = today.getFullYear()+' / '+today.getDate()+' / '+(today.getMonth()+1);
    var hours   = today.getHours();
    var minutes = today.getMinutes();
    var seconds = today.getSeconds();
    var timeValue = date + '  -  ' + hours;

    // Les deux prochaines conditions ne servent que pour l'affichage.
    // Si le nombre de minutes est inférieur à 10, alors on ajoute un 0 devant...

    timeValue += ((minutes < 10) ? ":0" : ":") + minutes;
    timeValue += ((seconds < 10) ? ":0" : ":") + seconds;
    document.getElementById("time").value = timeValue;
    timerRunning = true;
}

var timerID = setInterval(runClock,1000);