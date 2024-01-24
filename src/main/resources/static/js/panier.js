localStorage.clear();

const buttons = document.querySelectorAll('.ajouterPanier');

buttons.forEach(button => {
    button.addEventListener('click', event => {
        event.preventDefault()
        const row = event.target.closest('tr');

        const idMedicament = parseFloat(row.querySelector('td:nth-child(1)').innerText);
        const nomMedicament = row.querySelector('td:nth-child(2) span').innerText;
        const prixMedicament = parseFloat(row.querySelector('td:nth-child(3) span').innerText);

        const medicamentToAdd = {
            Medi_ID: idMedicament,
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
    var timeValue = date + ' - ' + hours;

    // Les deux prochaines conditions ne servent que pour l'affichage.
    // Si le nombre de minutes est inférieur à 10, alors on ajoute un 0 devant...

    timeValue += ((minutes < 10) ? ":0" : ":") + minutes;
    timeValue += ((seconds < 10) ? ":0" : ":") + seconds;
    document.getElementById("time").value = timeValue;
    timerRunning = true;
}

var timerID = setInterval(runClock,1000);


// Gestion de l'Achat

 var validbutton = document.getElementById('validbutton');
 validbutton.addEventListener('click', event =>  {
     function validateForms() {
         var achatForm = document.getElementById('achatForm');
         var panierForm = document.getElementById('panierForm');

         if (validateAchatForm()) {
         achatForm.submit();
    }

        if (validatePanierForm()) {
        panierForm.submit();
        }
    }

        function validateAchatForm() {
            var clientSelect = document.getElementById('clientSelect');

            if (clientSelect.value === "") {
                alert("Veuillez sélectionner un client.");
                return false;
            }

        return true;
    }

        function validatePanierForm() {

        var panierBody = document.getElementById('panierBody');
            var rows = panierBody.getElementsByTagName('tr');

            if (rows.length <= 1) {
                alert("Votre panier est vide.");
                return false;
            }

            return true;
    }

 })

document.addEventListener('DOMContentLoaded', function() {
    let today = new Date().toISOString().slice(0, 10);
    let dateInput = document.getElementById('dateInput');

    dateInput.value = today;
});